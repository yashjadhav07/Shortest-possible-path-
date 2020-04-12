
package gmapsfx.javascript;

import netscape.javascript.JSObject;


public class JavascriptRuntime implements IJavascriptRuntime {

    protected static IJavascriptRuntime runtime = null;

    public static IWebEngine engine;

    
    public static IJavascriptRuntime getInstance() {
        if (runtime == null) {
            runtime = new JavascriptRuntime();
        }
        return runtime;
    }

    
    public static void setDefaultWebEngine(IWebEngine e) {
        engine = e;
    }

    
    @Override
    public JSObject execute(String command) {
        Object returnValue = engine.executeScript(command);
        if (returnValue instanceof JSObject) {
            return (JSObject) returnValue;
        }

        return null;
    }

    
    @Override
    public String getConstructor(String javascriptObjectType, Object... args) {
        return getFunction("new " + javascriptObjectType, args);
    }

    
    @Override
    public String getArrayConstructor(String javascriptObjectType, Object[] ary) {
        String fn = getArrayFunction("new " + javascriptObjectType, ary);
        return fn;
    }

    
    @Override
    public String getFunction(String variable, String function, Object... args) {
        return getFunction(variable + "." + function, args);
    }

    
    @Override
    public String getFunction(String function, Object... args) {
        if (args == null) {
            return function + "();";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(function).append("(");
        for (Object arg : args) {
            sb.append(getArgString(arg)).append(",");
        }
        sb.replace(sb.length() - 1, sb.length(), ")");

        return sb.toString();
    }

   
    @Override
    public String getArrayFunction(String function, Object[] ary) {
        if (ary == null || ary.length == 0) {
            return function + "([]);";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(function).append("([");
        for (Object arg : ary) {
            if (arg instanceof JavascriptObject) {
                sb.append(((JavascriptObject) arg).getVariableName()).append(",");
            } else {
                sb.append(getArgString(arg)).append(",");
            }
        }
        sb.replace(sb.length() - 1, sb.length(), "]").append(")");

        return sb.toString();
    }

    
    protected String getArgString(Object arg) {
        //if (arg instanceof LatLong) {
        //    return ((LatLong) arg).getVariableName();
        //} else 
        if (arg instanceof JavascriptObject) {
             return ((JavascriptObject) arg).getVariableName();
           // return ((JavascriptObject) arg).getPropertiesAsString();
        } else if( arg instanceof JavascriptEnum ) {
            return ((JavascriptEnum) arg).getEnumValue().toString();
        } else {
            return arg.toString();
        }
    }
}

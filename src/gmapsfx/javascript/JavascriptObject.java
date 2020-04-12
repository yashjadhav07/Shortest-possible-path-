
package gmapsfx.javascript;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.WeakHashMap;

import netscape.javascript.JSObject;


public class JavascriptObject {

    protected static Map<JSObject,JavascriptObject> peerRegistry = new WeakHashMap<>();
    protected IJavascriptRuntime runtime;
    protected JSObject jsObject;
    protected static int objectCounter = 0;
    protected String variableName;

    
    protected JavascriptObject() {
        runtime = JavascriptRuntime.getInstance();
        variableName = getNextVariableName();
    }

    
    protected JavascriptObject(String type) {
        this(type, (Object[]) null);
    }


    
    protected JavascriptObject( String type, String stringRepresentation ) {
        runtime = JavascriptRuntime.getInstance();
        variableName = getNextVariableName();
        runtime.execute( "var " + variableName + " = " + stringRepresentation );
        jsObject = runtime.execute(variableName);
        peerRegistry.put(jsObject, this);
    }

    
    protected JavascriptObject(String type, Object... args) {
        runtime = JavascriptRuntime.getInstance();
        variableName = getNextVariableName();
        runtime.execute("var " + variableName + " = " + runtime.getConstructor(type, args));
        jsObject = runtime.execute(variableName);
        peerRegistry.put(jsObject, this);
    }

    
    protected JavascriptObject(String type, Object[] ary, boolean isArray) {
        runtime = JavascriptRuntime.getInstance();
        variableName = getNextVariableName();
        runtime.execute("var " + variableName + " = " + runtime.getArrayConstructor(type, ary));
        jsObject = runtime.execute(variableName);
        peerRegistry.put(jsObject, this);
    }


    
    protected JavascriptObject(String type, JSObject jsObject) {
        runtime = JavascriptRuntime.getInstance();
        variableName = getNextVariableName();
        this.jsObject = jsObject;
        peerRegistry.put(jsObject, this);
    }

    
    protected JSObject getJSObject() {
        return jsObject;
    }

    
    protected final String getNextVariableName() {
        return getClass().getSimpleName() + (objectCounter++);
    }

   
    public String getVariableName() {

        return variableName;
    }

    
    protected void setProperty(String propertyName, Object propertyValue) {
        jsObject.setMember(propertyName, propertyValue);
    }

    
    protected void setProperty(String propertyName, JavascriptObject propertyValue) {
        jsObject.setMember(propertyName, propertyValue.getJSObject());
    }

    
    protected void setProperty(String propertyName, JavascriptEnum propertyValue) {
        jsObject.setMember(propertyName, propertyValue.getEnumValue());
    }


    /**
     * Get the specified property for this object.
     *
     * @param key The property name
     * @return The value of the property
     */
    protected Object getProperty(String key) {
        return checkUndefined(jsObject.getMember(key));
    }

    
    protected <T> T getProperty(String key, Class<T> type) {
        Object returnValue = getProperty(key);
        if (returnValue != null) {
            return (T) returnValue;
        } else {
            return null;
        }
    }


    
    protected Object invokeJavascript(String function) {
        return checkUndefined(jsObject.call(function));
    }

    
    protected Object invokeJavascript(String function, Object... args) {
    	
    	Object[] jsArgs = new Object[args.length];
        for (int i = 0; i < jsArgs.length; i++) {
            if (args[i] instanceof JavascriptObject) {
                jsArgs[i] = ((JavascriptObject) args[i]).getJSObject();
            } else if (args[i] instanceof JavascriptEnum) {
                jsArgs[i] = ((JavascriptEnum) args[i]).getEnumValue();
            } else {
                jsArgs[i] = args[i];
            }
        }
        return checkUndefined(jsObject.call(function, (Object[]) jsArgs));
    }

    
    protected <T> T invokeJavascriptReturnValue(String function, Class<T> returnType) {
    	Object returnObject = invokeJavascript(function);
        if (returnObject instanceof JSObject) {
            try {
                Constructor<T> constructor = returnType.getConstructor(JSObject.class);
                return constructor.newInstance((JSObject) returnObject);
            } catch (Exception ex) {
                throw new IllegalStateException(ex);
            }
        } else {
            return (T) returnObject;
        }
    }

   
    protected <T> T invokeJavascriptReturnValue(String function, Class<T> returnType, Object... args) {
    	
    	Object returnObject = invokeJavascript(function, args);
        if (returnObject != null) {
            return (T) returnObject;
        } else {
            return null;
        }
    }


    protected boolean isMemberDefined(String member) {
        Object res = jsObject.getMember(member);
        return (res instanceof String && ! ((String) res).equals("undefined"));

    }

   
    protected Object checkUndefined(Object val) {
        if (val instanceof String && ((String) val).equals("undefined")) {
            return null;
        }
        return val;
    }

    
    protected Boolean checkBoolean(Object val, Boolean def) {
        return (val == null) ? def : (Boolean) val;
    }

    protected Integer checkInteger(Object val, Integer def) {
        return (val == null) ? def : (Integer) val;
    }
}

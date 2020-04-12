

package gmapsfx.javascript;

import java.util.List;

import netscape.javascript.JSObject;


public class JavascriptFunctionLine {
    
    protected JSObject jsObject;
    protected JavascriptObject object;
    protected String method;
    protected List<Object> args;

    public JavascriptFunctionLine(JavascriptObject object, String method, List<Object> args) {
        this.object = object;
        this.method = method;
        this.args = args;
    }
    
    
    public String getFunctionLine() {
        StringBuilder sb = new StringBuilder();
        sb.append( object.getVariableName() ).append(".").append(method);
        sb.append("(");
        for( Object arg : args ) {
            if( arg instanceof JavascriptObject) {
                sb.append( ((JavascriptObject) arg).getVariableName() );
            } else {
                sb.append( arg.toString() );
            }
            sb.append(",");
        }
        sb.deleteCharAt( sb.length()-1);
        sb.append(");\n");
        
        return sb.toString();
    }
    
}

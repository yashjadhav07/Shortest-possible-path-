
package gmapsfx.javascript;

import java.util.List;


public class JavascriptFunction extends JavascriptObject {

    
    protected String functionName;
    protected List<String> args;
    protected List<JavascriptFunctionLine> functionLines;

    public JavascriptFunction(String functionName, List<String> args, List<JavascriptFunctionLine> functionLines) {
        this.functionName = functionName;
        this.args = args;
        this.functionLines = functionLines;
    }

    public String getFunctionAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append(functionName).append("(");
        if (args.isEmpty()) {
            sb.append(")");
        } else {
            for (String arg : args) {
                sb.append(arg).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
        }
        sb.append("{\n");
        for( JavascriptFunctionLine line : functionLines ) {
            sb.append( line.getFunctionLine() );
        }
        sb.append("}");
        
        return sb.toString();
    }

}

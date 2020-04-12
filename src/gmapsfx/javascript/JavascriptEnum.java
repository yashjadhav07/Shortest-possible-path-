
package gmapsfx.javascript;

import netscape.javascript.JSObject;


public class JavascriptEnum  {

    protected IJavascriptRuntime runtime;
    protected String type;
    protected String name;
    protected Object value;

    
    protected JavascriptEnum(String type, String name) {
        this.type = type;
        this.name = name;
        runtime = JavascriptRuntime.getInstance();

    }

    public Object getEnumValue() {
        if (value == null) {
            JSObject jsObject = runtime.execute(type);
            value = jsObject.getMember(name);
        }
        return value;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
    
}

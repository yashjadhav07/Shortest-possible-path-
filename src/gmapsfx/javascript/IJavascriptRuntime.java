
package gmapsfx.javascript;

import netscape.javascript.JSObject;


public interface IJavascriptRuntime {

    
    JSObject execute(String command);

   
    String getConstructor(String javascriptObjectType, Object... args);

    
    String getArrayConstructor(String javascriptObjectType, Object[] ary);

    String getFunction(String variable, String function, Object... args);
    
    
    
    String getFunction(String function, Object... args);
    
    
    
    String getArrayFunction(String function, Object[] ary);

}

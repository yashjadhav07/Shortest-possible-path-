
package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptObject;
import netscape.javascript.JSObject;


public class MVCArray extends JavascriptObject {

    public MVCArray() {
        this(new Object[]{});
    }

    public MVCArray(Object[] ary) {
        super(GMapObjectType.MVC_ARRAY, ary, true);
    }

    public MVCArray(JSObject obj) {
        super(GMapObjectType.MVC_ARRAY, obj);
    }

    
    public void clear() {
        invokeJavascript("clear");
    }

    
    public void forEach(String func) {
        invokeJavascript("forEach", func);
    }

    
    public JSObject getArray() {
        return (JSObject) invokeJavascript("getArray");
    }

    
    public JSObject getAt(int idx) {
        return (JSObject) invokeJavascript("getAt", idx);
    }

    
    public int getLength() {
        return (int) invokeJavascript("getLength");
    }

    
    public void insertAt(int idx, JavascriptObject elem) {
        invokeJavascript("insertAt", idx, elem);
    }

    
    public JSObject pop() {
        return (JSObject) invokeJavascript("pop");
    }

    
    public int push(JavascriptObject obj) {
        return (int) invokeJavascript("push", obj);
    }

   
    public void removeAt(int idx) {
        invokeJavascript("removeAt", idx);
    }

    
    public void setAt(int idx, JavascriptObject obj) {
        invokeJavascript("setAt", idx, obj);
    }

}

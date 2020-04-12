

package gmapsfx.shapes;

import gmapsfx.javascript.object.GMapObjectType;
import gmapsfx.javascript.object.MVCArray;
import gmapsfx.javascript.object.MapShape;
import netscape.javascript.JSObject;


public class Polyline extends MapShape {
    
    public Polyline() {
        super(GMapObjectType.POLYLINE);
    }
    
    public Polyline(PolylineOptions opts) {
        super(GMapObjectType.POLYLINE, opts);
    }
    
    public MVCArray getPath() {
        return new MVCArray((JSObject) invokeJavascript("getPath"));
    }
    
    public void setPath(MVCArray path) {
        invokeJavascript("setPath", path);
    }
    
}

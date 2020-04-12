

package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptObject;
import netscape.javascript.JSObject;


public class Projection extends JavascriptObject {
    
    public Projection(JSObject obj) {
        super(GMapObjectType.PROJECTION, obj);
    }
    
    public GMapPoint fromLatLngToPoint(LatLong loc) {
//        System.out.println("Projection.fromLatLngToPoint: " + loc);
        Object res = invokeJavascript("fromLatLngToPoint", loc);
//        System.out.println("Projection.fromLatLngToPoint.res: " + res);
        if (res != null && res instanceof JSObject) {
            return new GMapPoint((JSObject) res);
        }
        return null;
    }
    
}

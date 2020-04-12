

package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptObject;
import netscape.javascript.JSObject;


public class LatLongBounds extends JavascriptObject {

    public LatLongBounds() {
        super(GMapObjectType.LAT_LNG_BOUNDS);
    }

    public LatLongBounds(LatLong sw, LatLong ne) {
        super(GMapObjectType.LAT_LNG_BOUNDS, sw, ne);
    }

    public LatLongBounds(JSObject obj) {
        super(GMapObjectType.LAT_LNG_BOUNDS, obj);
    }

    public LatLongBounds extend(LatLong point) {
    	Object obj = invokeJavascript("extend", point);
    	return new LatLongBounds((JSObject)obj);
    }

    public LatLong getNorthEast() {
        Object obj = invokeJavascript("getNorthEast");
        return new LatLong((JSObject) obj);
    }

    public LatLong getSouthWest() {
        Object obj = invokeJavascript("getSouthWest");
        return new LatLong((JSObject) obj);
    }

    @Override
    public String toString() {
        return "LatLongBounds[NE:" + getNorthEast() + ", SW:" + getSouthWest() + "]";
    }
}

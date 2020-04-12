

package gmapsfx.service.elevation;

import gmapsfx.javascript.JavascriptObject;
import gmapsfx.javascript.object.GMapObjectType;
import gmapsfx.javascript.object.LatLong;
import netscape.javascript.JSObject;


public class ElevationResult extends JavascriptObject {
    
    private LatLong location;
    
    public ElevationResult(JSObject jsObject) {
        super(GMapObjectType.ELEVATION_RESULT, jsObject);
    }
    
    
    public double getElevation() {
        return (double) getJSObject().getMember("elevation");
    }
    
   
    public LatLong getLocation() {
        if (location == null) {
            location = new LatLong((JSObject) (getJSObject().getMember("location")));
        }
        return location;
    }
    
    
    public double getResolution() {
        return (double) getJSObject().getMember("resolution");
    }
    
}

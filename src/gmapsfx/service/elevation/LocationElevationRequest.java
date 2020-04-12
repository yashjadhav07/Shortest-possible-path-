

package gmapsfx.service.elevation;

import gmapsfx.javascript.JavascriptObject;
import gmapsfx.javascript.object.GMapObjectType;
import gmapsfx.javascript.object.LatLong;


public class LocationElevationRequest extends JavascriptObject {
    
    public LocationElevationRequest() {
        super(GMapObjectType.OBJECT);
    }
    
    public LocationElevationRequest(LatLong[] locations) {
        super(GMapObjectType.OBJECT);
        getJSObject().setMember("locations", getJSObject().eval("[]"));
        for (int i = 0; i < locations.length; i++) {
            getJSObject().eval(getVariableName()+".locations.push("+locations[i].getVariableName()+")");
        }
    }
    
}

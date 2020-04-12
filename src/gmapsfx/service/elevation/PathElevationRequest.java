

package gmapsfx.service.elevation;

import gmapsfx.javascript.JavascriptObject;
import gmapsfx.javascript.object.GMapObjectType;
import gmapsfx.javascript.object.LatLong;


public class PathElevationRequest extends JavascriptObject {
    
    public PathElevationRequest() {
        super(GMapObjectType.OBJECT);
    }
    
    public PathElevationRequest(LatLong[] path, int samples) {
        super(GMapObjectType.OBJECT);
        getJSObject().setMember("path", getJSObject().eval("[]"));
        for (int i = 0; i < path.length; i++) {
            getJSObject().eval(getVariableName()+".path.push("+path[i].getVariableName()+")");
        }
        getJSObject().setMember("samples", samples);
    }
    
}

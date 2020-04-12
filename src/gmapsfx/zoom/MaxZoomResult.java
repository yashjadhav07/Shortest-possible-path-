

package gmapsfx.zoom;

import gmapsfx.javascript.JavascriptObject;
import gmapsfx.javascript.object.GMapObjectType;
import netscape.javascript.JSObject;


public class MaxZoomResult extends JavascriptObject {
	
    private MaxZoomStatus status;
    
    public MaxZoomResult() {
        super(GMapObjectType.MAX_ZOOM_RESULT);
    }
    
    public MaxZoomResult(JSObject obj) {
        super(GMapObjectType.MAX_ZOOM_RESULT, obj);
    }
    
    public MaxZoomResult(MaxZoomStatus status) {
        super(GMapObjectType.MAX_ZOOM_RESULT);
        this.status = status;
    }
    
    public MaxZoomStatus getStatus() {
        if (status == null) {
            status = MaxZoomStatus.valueOf((String) getJSObject().getMember("status"));
        }
        return status;
    }
    
    public int getMaxZoom() {
        return (int) getJSObject().getMember("zoom");
    }
    
}

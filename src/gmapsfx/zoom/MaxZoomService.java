

package gmapsfx.zoom;

import gmapsfx.javascript.JavascriptObject;
import gmapsfx.javascript.object.GMapObjectType;
import gmapsfx.javascript.object.LatLong;
import netscape.javascript.JSObject;


public class MaxZoomService extends JavascriptObject {
    
    private MaxZoomServiceCallback callback;
    
    public MaxZoomService() {
        super(GMapObjectType.MAX_ZOOM_SERVICE);
    }
    
    public void getMaxZoomAtLatLng(LatLong loc, MaxZoomServiceCallback callback) {
        
        this.callback = callback;
        
        JSObject doc = (JSObject) getJSObject().eval("document");
        doc.setMember(getVariableName(), this);
        
        StringBuilder r = new StringBuilder(getVariableName())
              .append(".")
              .append("getMaxZoomAtLatLng(")
              .append(loc.getVariableName())
              .append(", ")
              .append("function(result) {document.")
              .append(getVariableName())
              .append(".processResponse(result);});");
        
//        System.out.println("MaxZoomService direct call: " + r.toString());
        
        getJSObject().eval(r.toString());
        
    }
    
    
    public void processResponse(Object result) {
        if (result instanceof JSObject) {
            MaxZoomResult mzr = new MaxZoomResult((JSObject) result);
            callback.maxZoomReceived(mzr);
        }
    }
    
}

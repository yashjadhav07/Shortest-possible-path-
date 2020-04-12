

package gmapsfx.service.elevation;

import gmapsfx.javascript.JavascriptObject;
import gmapsfx.javascript.object.GMapObjectType;
import netscape.javascript.JSObject;


public class ElevationService extends JavascriptObject {
    
    private ElevationServiceCallback callback;
    
    public ElevationService() {
        super(GMapObjectType.ELEVATION_SERVICE);
    }
    
    
    public void getElevationForLocations(LocationElevationRequest req, ElevationServiceCallback callback) {
        
        this.callback = callback;
        
        JSObject doc = (JSObject) getJSObject().eval("document");
        doc.setMember(getVariableName(), this);
        
        StringBuilder r = new StringBuilder(getVariableName())
              .append(".")
              .append("getElevationForLocations(")
              .append(req.getVariableName())
              .append(", ")
              .append("function(results, status) {alert('rec:'+status);\ndocument.")
              .append(getVariableName())
              .append(".processResponse(results, status);});");
        
//        System.out.println("ElevationService direct call: " + r.toString());
        
        getJSObject().eval(r.toString());
        
    }

    
    public void getElevationAlongPath(PathElevationRequest req, ElevationServiceCallback callback) {
        
        this.callback = callback;
        
        JSObject doc = (JSObject) getJSObject().eval("document");
        doc.setMember(getVariableName(), this);
        
        StringBuilder r = new StringBuilder(getVariableName())
              .append(".")
              .append("getElevationAlongPath(")
              .append(req.getVariableName())
              .append(", ")
              .append("function(results, status) {document.")
              .append(getVariableName())
              .append(".processResponse(results, status);});");
        
        getJSObject().eval(r.toString());
        
    }
    
    
    public void processResponse(Object results, Object status) {
        ElevationStatus pStatus = ElevationStatus.UNKNOWN_ERROR;
        
        if (status instanceof String && results instanceof JSObject) {
            pStatus = ElevationStatus.valueOf((String) status);
            if (ElevationStatus.OK.equals(pStatus)) {
                JSObject jsres = (JSObject) results;
                Object len = jsres.getMember("length");
                if (len instanceof Number) {
                    int n = ((Number)len).intValue();
//                    System.out.println("n: " + n);
                    ElevationResult[] ers = new ElevationResult[n];
                    for (int i = 0; i < n; i++) {
                        Object obj = jsres.getSlot(i);
                        if (obj instanceof JSObject) {
                            ers[i] = new ElevationResult((JSObject) obj);
                        }
                    }
                    callback.elevationsReceived(ers, pStatus);
                    return;
                }
            }
        }
        callback.elevationsReceived(new ElevationResult[]{}, pStatus);
    }
}



package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptObject;


public class Polyline extends JavascriptObject {
    
    public Polyline() {
        super(GMapObjectType.POLYLINE);
    }
    
    public Polyline(PolylineOptions opts) {
        super(GMapObjectType.POLYLINE, opts);
    }
    
    
    protected void setMap(GoogleMap map) {
        invokeJavascript("setMap", map);
    }
    
}

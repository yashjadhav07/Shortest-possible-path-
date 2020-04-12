

package gmapsfx.shapes;

import gmapsfx.javascript.object.GMapObjectType;
import gmapsfx.javascript.object.MVCArray;
import gmapsfx.javascript.object.MapShape;
import netscape.javascript.JSObject;


public class Polygon extends MapShape {
    
    public Polygon() {
        super(GMapObjectType.POLYGON);
    }
    
    public Polygon(PolygonOptions opts) {
        super(GMapObjectType.POLYGON, opts);
    }
    
    public MVCArray getPath() {
        return new MVCArray((JSObject) invokeJavascript("getPath"));
    }
    
    public MVCArray getPaths() {
        return new MVCArray((JSObject) invokeJavascript("getPaths"));
    }
    
    public void setPath(MVCArray path) {
        invokeJavascript("setPath", path);
    }
    
    public void setPaths(MVCArray paths) {
        invokeJavascript("setPaths", paths);
    }
    
}

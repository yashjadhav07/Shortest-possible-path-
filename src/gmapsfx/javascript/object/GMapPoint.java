

package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptObject;
import netscape.javascript.JSObject;


public class GMapPoint extends JavascriptObject {
    
    public GMapPoint(JSObject obj) {
        super(GMapObjectType.POINT, obj);
    }
    
    public double getX() {
        return getProperty("x", Double.class );
    }

    public double getY() {
        return getProperty("y", Double.class );
    }
    
    @Override
    public String toString() {
        return "GMapPoint[" + getX() + ", " + getY() + "]";
    }
    
}

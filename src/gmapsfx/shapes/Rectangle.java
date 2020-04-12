

package gmapsfx.shapes;

import gmapsfx.javascript.object.GMapObjectType;
import gmapsfx.javascript.object.LatLongBounds;
import gmapsfx.javascript.object.MapShape;


public class Rectangle extends MapShape {
    
    public Rectangle() {
        super(GMapObjectType.RECTANGLE);
    }
    
    public Rectangle(RectangleOptions opts) {
        super(GMapObjectType.RECTANGLE, opts);
    }
    
    //setBounds
    public void setBounds(LatLongBounds bounds) {
        invokeJavascript("setBounds", bounds);
    }
    
}

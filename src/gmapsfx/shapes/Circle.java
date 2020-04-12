

package gmapsfx.shapes;

import gmapsfx.javascript.object.GMapObjectType;
import gmapsfx.javascript.object.LatLong;
import gmapsfx.javascript.object.MapShape;
import netscape.javascript.JSObject;


public class Circle extends MapShape {
    
    public Circle() {
        super(GMapObjectType.CIRCLE);
    }
    
    public Circle(CircleOptions opts) {
        super(GMapObjectType.CIRCLE, opts);
    }
    
    //getCenter
    public LatLong getCenter() {
        return new LatLong((JSObject) invokeJavascript("getCenter"));
    }
    
    //getRadius
    public double getRadius() {
        return (double) invokeJavascript("getRadius");
    }
    
    //setCenter
    public void setCenter(LatLong center) {
        invokeJavascript("setCenter", center);
    }
    
    //setRadius
    public void setRadius(double radius) {
        invokeJavascript("setRadius", radius);
    }
    
}

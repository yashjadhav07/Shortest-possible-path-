

package gmapsfx.shapes;

import gmapsfx.javascript.object.LatLong;


public class CircleOptions extends FillableMapShapeOptions<CircleOptions> {
    
    private LatLong center;
    private double radius;// in metres
    
    
    public CircleOptions center(LatLong center) {
        setProperty("center", center);
        this.center = center;
        return this;
    }
    
    public CircleOptions radius(double radius) {
        setProperty("radius", radius);
        this.radius = radius;
        return this;
    }

    @Override
    protected CircleOptions getMe() {
        return this;
    }
       
}



package gmapsfx.shapes;

import gmapsfx.javascript.object.LatLongBounds;


public class RectangleOptions extends FillableMapShapeOptions<RectangleOptions> {
    
    private LatLongBounds bounds;
    
    public RectangleOptions bounds(LatLongBounds bounds) {
        setProperty("bounds", bounds);
        this.bounds = bounds;
        return this;
    }

    @Override
    protected RectangleOptions getMe() {
        return this;
    }
    
}

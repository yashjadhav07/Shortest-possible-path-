

package gmapsfx.shapes;

import gmapsfx.javascript.object.MVCArray;


public class PolylineOptions extends MapShapeOptions<PolylineOptions> {
    
    
    
    private MVCArray path;
    
    public PolylineOptions() {
    }
    
    public PolylineOptions path(MVCArray path) {
        setProperty("path", path);
        this.path = path;
        return this;
    }

    @Override
    protected PolylineOptions getMe() {
        return this;
    }
    
}

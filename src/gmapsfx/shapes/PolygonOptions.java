

package gmapsfx.shapes;

import gmapsfx.javascript.object.MVCArray;


public class PolygonOptions extends FillableMapShapeOptions<PolygonOptions> {
    
    private MVCArray paths;
    
    public PolygonOptions() {
    }
    
    public PolygonOptions paths(MVCArray paths) {
        setProperty("path", paths);
        this.paths = paths;
        return this;
    }
    
    @Override
    protected PolygonOptions getMe() {
        return this;
    }
    
}

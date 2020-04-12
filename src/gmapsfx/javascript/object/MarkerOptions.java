

package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptObject;


public class MarkerOptions extends JavascriptObject {
    
    protected LatLong position;
    protected String title;
    protected boolean visible = true;
    protected String icon;
    protected Animation animation;
    
    
    
    public MarkerOptions() {
        super(GMapObjectType.OBJECT);
    }
    
    public MarkerOptions title( String title ) {
        setProperty("title", title);
        this.title = title;
        return this;
    }
    
    public MarkerOptions visible( Boolean visible ) {
        setProperty( "visible", visible );
        this.visible = visible;
        return this;
    }
    
    
    public MarkerOptions position( LatLong latLong ) {
        setProperty("position", latLong);
        position = latLong;
        return this;
    }
    
    
    public MarkerOptions icon( String iconPath ) {
        setProperty("icon", iconPath);
        return this;
    }
    
    public MarkerOptions animation( Animation animation ) {
        setProperty("animation", animation);
        return this;
    }
    
    
    
}

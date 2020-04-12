

package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptObject;


public class InfoWindowOptions extends JavascriptObject {

    
    public InfoWindowOptions() {
        super(GMapObjectType.OBJECT);
    }
    
    
    public InfoWindowOptions content( String content ) {
        setProperty("content", content);
        return this;
    }
    
    
    public InfoWindowOptions disableAutoPan( boolean disabled ) {
        setProperty("disableAutoPan", disabled);
        return this;
    }
    
    
    public InfoWindowOptions maxWidth( int width ) {
        setProperty( "maxWidth", width );
        return this;
    }
    
    

    
    public InfoWindowOptions pixelOffset( Size size ) {
        setProperty( "pixelOffset", size );
        return this;
    }
    
    
   
    public InfoWindowOptions position( LatLong latlong ) {
        setProperty( "position", latlong );
        return this;
    }
    
    
    public InfoWindowOptions zIndex( int index ) {
        setProperty( "zIndex", index );
        return this;
    }
    
    
}

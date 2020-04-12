

package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptObject;


public class InfoWindow extends JavascriptObject {

    public static final String INFO_WINDOW_TYPE = "google.maps.InfoWindow";
    
    public InfoWindow() {
        super(INFO_WINDOW_TYPE);
    }
    
    
    public InfoWindow( InfoWindowOptions options ) {
        super(GMapObjectType.INFO_WINDOW, options);
    }
    
    
    public void close() {
        invokeJavascript("close");
    }
    
    public String getContent() {
        return invokeJavascriptReturnValue("getContent", String.class );
    }
    
    public LatLong getPosition() {
        return invokeJavascriptReturnValue("getPosition", LatLong.class );
    }
    
    public int getZIndex() {
        return invokeJavascriptReturnValue("getZIndex", Integer.class );
    }
    
    public void open( GoogleMap map ) {
        invokeJavascript("open", map);
    }
    
    public void open( GoogleMap map, Marker marker ){
        invokeJavascript( "open", map, marker );
    }
    
    public void setContent( String content ) {
        invokeJavascript("setContent", content);
    }
    
    public void setOptions( InfoWindowOptions options ) {
        invokeJavascript("setOptions", options);
    }
    
    public void setPosition( LatLong position ){
        invokeJavascript( "setPosition", position );
    }
    
    public void setZIndex( int index ) {
        invokeJavascript( "setZIndex", index );
    }
    
    
}

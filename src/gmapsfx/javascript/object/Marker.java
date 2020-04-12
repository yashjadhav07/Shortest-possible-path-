

package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptObject;


public class Marker extends JavascriptObject {


    protected String title;
    protected MarkerOptions markerOptions;


    
    public Marker(MarkerOptions markerOptions) {
        super(GMapObjectType.MARKER, markerOptions);
        this.markerOptions = markerOptions;
    }


    
    public void setTitle( String title ) {
        invokeJavascript("setTitle", title);
        this.title = title;
    }




    
    public void setIcon( String icon ) {
        invokeJavascript("setIcon", icon);
        getMarkerOptions().icon = icon;
    }
    
    protected void setMap( GoogleMap map ) {
        invokeJavascript("setMap", map);
    }


    
    public void setAnimation( Animation animation ) {
        invokeJavascript("setAnimation", animation);
    }

    public void setZIndex(double index) {
    	invokeJavascript("setZIndex", index);
    }

    public void setPosition( LatLong latLong ) {
        invokeJavascript( "setPosition", latLong );
    }

	public void setOptions(MarkerOptions markerOptions2) {
		invokeJavascript("setOptions", markerOptions2);
	}

	public void setVisible(boolean visible) {
		invokeJavascript("setVisible", visible);
	}

	public boolean getVisible() {
		return invokeJavascriptReturnValue("getVisible", Boolean.class );
	}

	public MarkerOptions getMarkerOptions() {
		return this.markerOptions;
	}

}

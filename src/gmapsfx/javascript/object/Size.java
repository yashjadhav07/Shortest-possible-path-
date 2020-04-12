

package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptObject;


public class Size extends JavascriptObject {

    protected int width;
    protected int height;
    protected String widthUnit;
    protected String heightUnit;
    
    
    
    
    public Size(int width, int height) {
        super(GMapObjectType.SIZE, width, height);
    }
    
   
    public Size( int width, int height, String widthUnit, String heightUnit ) {
        super( GMapObjectType.SIZE, width, height, widthUnit, heightUnit );
    }

    public int getWidth() {
        return getProperty("width", Integer.class);
    }

    public int getHeight() {
        return getProperty("height", Integer.class);
    }

    public String getWidthUnit() {
        return widthUnit;
    }

    public String getHeightUnit() {
        return heightUnit;
    }
    
    public boolean equals( Size other ) {
        return invokeJavascriptReturnValue("equals", Boolean.class, other);
    }
    
    
    @Override
    public String toString() {
        return invokeJavascriptReturnValue("toString", String.class, (Object)null);
    }
    
}

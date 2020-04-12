

package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptObject;
import gmapsfx.shapes.MapShapeOptions;
import netscape.javascript.JSObject;


public abstract class MapShape extends JavascriptObject {
    
    public MapShape(String type) {
        super(type);
    }
    
    public MapShape(String type, MapShapeOptions opts) {
        super(type, opts);
    }
    
    
    protected void setMap(GoogleMap map) {
        invokeJavascript("setMap", map);
    }
    
    // LatLngBounds Gets the LatLngBounds of this Circle.
    public LatLongBounds getBounds() {
        return new LatLongBounds((JSObject) invokeJavascript("getBounds"));
    }
    
    // Returns whether this circle can be dragged by the user.
    public boolean getDraggable() {
        return checkBoolean(invokeJavascript("getDraggable"), Boolean.FALSE);
    }
    
    // Returns whether this circle can be edited by the user.
    public boolean getEditable() {
        return checkBoolean(invokeJavascript("getEditable"), Boolean.FALSE);
    }
    
    //Returns whether this circle is visible on the map.
    public boolean getVisible() {
        return checkBoolean(invokeJavascript("getVisible"), Boolean.FALSE);
    }
    
    //If set to true, the user can drag this circle over the map.
    public void setDraggable(boolean draggable) {
        invokeJavascript("setDraggable", draggable);
    }
    
    //If set to true, the user can edit this circle by dragging the control points shown at the center and around the circumference of the circle.
    public void setEditable(boolean editable) {
        invokeJavascript("setEditable", editable);
    }
    
    //Hides this circle if set to false.
    public void setVisible(boolean visible) {
        invokeJavascript("setVisible", visible);
    }
    
    
}


package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptObject;
import gmapsfx.javascript.event.EventHandlers;
import gmapsfx.javascript.event.GFXEventHandler;
import gmapsfx.javascript.event.MapStateEventType;
import gmapsfx.javascript.event.StateEventHandler;
import gmapsfx.javascript.event.UIEventHandler;
import gmapsfx.javascript.event.UIEventType;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import netscape.javascript.JSObject;


public class GoogleMap extends JavascriptObject {

    private boolean userPromptedZoomChange;
    private boolean mapPromptedZoomChange;
    protected MapOptions options;
    protected static String divArg = "document.getElementById('map')";

    private ReadOnlyObjectWrapper<LatLong> center;
    private IntegerProperty zoom;

    private final EventHandlers jsHandlers = new EventHandlers();
    private boolean registeredOnJS;

    public GoogleMap() {
        super(GMapObjectType.MAP, divArg);
    }

    public GoogleMap(MapOptions mapOptions) {
        super(GMapObjectType.MAP, new Object[]{divArg, mapOptions});
    }

    public void setZoom(int zoom) {
        zoomProperty().set(zoom);
    }

    public int getZoom() {
        return zoomProperty().get();
    }

    private int internalGetZoom() {
        return (int) invokeJavascript("getZoom");
    }

    private void internalSetZoom(int zoom) {
        invokeJavascript("setZoom", zoom);
    }

    public IntegerProperty zoomProperty() {
        if (zoom == null) {
            zoom = new SimpleIntegerProperty(internalGetZoom());
            addStateEventHandler(MapStateEventType.zoom_changed, () -> {
                if (!userPromptedZoomChange) {
                    mapPromptedZoomChange = true;
                    zoom.set(internalGetZoom());
                    mapPromptedZoomChange = false;
                }
            });
            zoom.addListener((ObservableValue<? extends Number> obs, Number o, Number n) -> {
                if (!mapPromptedZoomChange) {
                    userPromptedZoomChange = true;
                    internalSetZoom(n.intValue());
                    userPromptedZoomChange = false;
                }
            });
        }
        return zoom;
    }

    public void setCenter(LatLong latLong) {
        invokeJavascript("setCenter", latLong);
    }

    public LatLong getLatLong() {
        return getProperty("setCenter", LatLong.class);
    }

    public void fitBounds( LatLongBounds bounds ) {
        invokeJavascript("fitBounds", bounds );
    }


    public final ReadOnlyObjectProperty<LatLong> centerProperty() {
        if (center == null) {
            center = new ReadOnlyObjectWrapper<>(getCenter());
            addStateEventHandler(MapStateEventType.center_changed, () -> {
                center.set(getCenter());
            });
        }
        return center.getReadOnlyProperty();
    }

    public LatLong getCenter() {
        return new LatLong((JSObject) invokeJavascript("getCenter"));
    }


    public void setHeading( double heading ) {
        invokeJavascript("setHeading", heading);
    }

    public double getHeading() {
        return invokeJavascriptReturnValue("getHeading", Double.class );
    }

    public void addMarker(Marker marker) {
        marker.setMap(this);
    }

    public void removeMarker(Marker marker) {
        marker.setMap(null);
    }

    public void setMapType(MapTypeIdEnum type) {
        invokeJavascript("setMapTypeId", type);
    }

    public void addMapShape(MapShape shape) {
        shape.setMap(this);
    }

    public void removeMapShape(MapShape shape) {
        shape.setMap(null);
    }

    public Projection getProjection() {
        Object obj = invokeJavascript("getProjection");
        return (obj == null) ? null : new Projection((JSObject) obj);
    }

    
    public LatLongBounds getBounds() {
        return invokeJavascriptReturnValue("getBounds", LatLongBounds.class);
    }

    
    public Point2D fromLatLngToPoint(LatLong loc) {
//        System.out.println("GoogleMap.fromLatLngToPoint loc: " + loc);
        Projection proj = getProjection();
        //System.out.println("map.fromLatLngToPoint Projection: " + proj);
        LatLongBounds llb = getBounds();
//        System.out.println("GoogleMap.fromLatLngToPoint Bounds: " + llb);

        GMapPoint topRight = proj.fromLatLngToPoint(llb.getNorthEast());
//        System.out.println("GoogleMap.fromLatLngToPoint topRight: " + topRight);
        GMapPoint bottomLeft = proj.fromLatLngToPoint(llb.getSouthWest());
//        System.out.println("GoogleMap.fromLatLngToPoint bottomLeft: " + bottomLeft);

        double scale = Math.pow(2, getZoom());
        GMapPoint worldPoint = proj.fromLatLngToPoint(loc);
//        System.out.println("GoogleMap.fromLatLngToPoint worldPoint: " + worldPoint);

        double x = (worldPoint.getX() - bottomLeft.getX()) * scale;
        double y = (worldPoint.getY() - topRight.getY()) * scale;

//        System.out.println("GoogleMap.fromLatLngToPoint x: " + x + " y: " + y);
        return new Point2D(x, y);
    }

    
    public void panBy(double x, double y) {
//        System.out.println("panBy x: " + x + ", y: " + y);
        invokeJavascript("panBy", new Object[]{x, y});
    }

    
    private String registerEventHandler(GFXEventHandler h) {
        //checkInitialized();
        if (!registeredOnJS) {
            JSObject doc = (JSObject) runtime.execute("document");
            doc.setMember("jsHandlers", jsHandlers);
            registeredOnJS = true;
        }
        return jsHandlers.registerHandler(h);
    }

    
    public void addUIEventHandler(UIEventType type, UIEventHandler h) {
        this.addUIEventHandler(this, type, h);
    }

    
    public void addUIEventHandler(JavascriptObject obj, UIEventType type, UIEventHandler h) {
        String key = registerEventHandler(h);
        String mcall = "google.maps.event.addListener(" + obj.getVariableName() + ", '" + type.name() + "', "
                + "function(event) {document.jsHandlers.handleUIEvent('" + key + "', event);});";//.latLng
        //System.out.println("addUIEventHandler mcall: " + mcall);
        runtime.execute(mcall);
    }

    
    public void addStateEventHandler(MapStateEventType type, StateEventHandler h) {
        String key = registerEventHandler(h);
        String mcall = "google.maps.event.addListener(" + getVariableName() + ", '" + type.name() + "', "
                + "function() {document.jsHandlers.handleStateEvent('" + key + "');});";
        //System.out.println("addStateEventHandler mcall: " + mcall);
        runtime.execute(mcall);

    }

}

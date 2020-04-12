

package gmapsfx.shapes;


public abstract class FillableMapShapeOptions<T extends FillableMapShapeOptions> extends MapShapeOptions<T> {
    
    private String fillColor;
    private double fillOpacity;
    private StrokePosition strokePosition;
    
    public FillableMapShapeOptions() {
    }
    
    public T fillColor(String fillColor) {
        setProperty("fillColor", fillColor);
        this.fillColor = fillColor;
        return getMe();
    }
    
    public T fillOpacity(double fillOpacity) {
        setProperty("fillOpacity", fillOpacity);
        this.fillOpacity = fillOpacity;
        return getMe();
    }
    
    public T strokePosition(StrokePosition strokePosition) {
        setProperty("strokePosition", strokePosition.name());
        this.strokePosition = strokePosition;
        return getMe();
    }
    
}

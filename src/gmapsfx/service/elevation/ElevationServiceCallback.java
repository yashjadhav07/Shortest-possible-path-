

package gmapsfx.service.elevation;


public interface ElevationServiceCallback {
    
    public void elevationsReceived(ElevationResult[] results, ElevationStatus status);
    
}

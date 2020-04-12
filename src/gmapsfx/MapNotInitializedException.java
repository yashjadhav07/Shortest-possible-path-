

package gmapsfx;


public class MapNotInitializedException extends RuntimeException {

    public MapNotInitializedException() {
        super( "Map has not yet been initialized");
    }
    
}

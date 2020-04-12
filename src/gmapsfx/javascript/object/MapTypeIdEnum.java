
package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptEnum;


public class MapTypeIdEnum extends JavascriptEnum {

    public static final String MAP_ENUM = "google.maps.MapTypeId";

    public static final MapTypeIdEnum TERRAIN = new MapTypeIdEnum("TERRAIN");
    public static final MapTypeIdEnum ROADMAP = new MapTypeIdEnum("ROADMAP");
    public static final MapTypeIdEnum SATELLITE = new MapTypeIdEnum("SATELLITE");
    public static final MapTypeIdEnum HYBRID = new MapTypeIdEnum("HYBRID");
    
    public static final MapTypeIdEnum[] ALL = { TERRAIN, ROADMAP, SATELLITE, HYBRID };

    protected MapTypeIdEnum(String value) {
        super(MAP_ENUM, value);
    }

    @Override
    public String toString() {
        return getName();
    }
    
    
    
}

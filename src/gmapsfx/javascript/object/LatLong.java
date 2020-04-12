
package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptObject;
import netscape.javascript.JSObject;


public class LatLong extends JavascriptObject {

    public static final double EarthRadiusMeters = 6378137.0; // meters


    public LatLong(double latitude, double longitude) {
        super(GMapObjectType.LAT_LNG, latitude, longitude);
    }

    public LatLong(JSObject jsObject) {
        super(GMapObjectType.LAT_LNG, jsObject);
    }

    public double getLatitude() {
        return invokeJavascriptReturnValue("lat", Number.class ).doubleValue();
    }

    public double getLongitude() {
        return invokeJavascriptReturnValue("lng", Number.class ).doubleValue();
    }

    
    public double distanceFrom(LatLong end) {

        double dLat = (end.getLatitude() - getLatitude()) * Math.PI / 180;
        double dLon = (end.getLongitude() - getLongitude()) * Math.PI / 180;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(getLatitude() * Math.PI / 180)
                * Math.cos(end.getLatitude() * Math.PI / 180)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = EarthRadiusMeters * c;
        return d;
    }

    
    public double latToRadians() {
        return Math.toRadians(getLatitude());
    }

    
    public double longToRadians() {
        return Math.toRadians(getLongitude());
    }

    
    public LatLong getDestinationPoint(double bearing, double distance) {

        double brng = Math.toRadians(bearing);

        double lat1 = latToRadians();
        double lon1 = longToRadians();

        double lat2 = Math.asin(Math.sin(lat1)
                * Math.cos(distance / EarthRadiusMeters)
                + Math.cos(lat1) * Math.sin(distance / EarthRadiusMeters)
                * Math.cos(brng));

        double lon2 = lon1 + Math.atan2(Math.sin(brng)
                * Math.sin(distance / EarthRadiusMeters) * Math.cos(lat1),
                Math.cos(distance / EarthRadiusMeters)
                - Math.sin(lat1) * Math.sin(lat2));

        return new LatLong(Math.toDegrees(lat2), Math.toDegrees(lon2));

    }

    
    public double getBearing(LatLong end) {
        if (this.equals(end)) {
            return 0;
        }

        double lat1 = latToRadians();
        double lon1 = longToRadians();
        double lat2 = end.latToRadians();
        double lon2 = end.longToRadians();

        double angle = -Math.atan2(Math.sin(lon1 - lon2) * Math.cos(lat2),
                Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1)
                * Math.cos(lat2) * Math.cos(lon1 - lon2));

        if (angle < 0.0) {
            angle += Math.PI * 2.0;
        }
        if (angle > Math.PI) {
            angle -= Math.PI * 2.0;
        }

        return Math.toDegrees(angle);
    }

    
    

    @Override
    public String toString() {
        return "lat: " + String.format("%.8G", getLatitude()) + " lng: " + String.format("%.8G", getLongitude());
    }

}

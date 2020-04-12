
package gmapsfx.shapes;

import gmapsfx.javascript.object.LatLong;
import gmapsfx.javascript.object.MVCArray;
import javafx.scene.shape.ArcType;


public class ArcBuilder {

    private static final int DEFAULT_ARC_POINTS = 32;

    
    public static final PolygonOptions buildClosedArc(LatLong center, LatLong start, LatLong end, ArcType arcType) {
        MVCArray res = buildArcPoints(center, start, end);
        if (ArcType.ROUND.equals(arcType)) {
            res.push(center);
        }
        return new PolygonOptions().paths(res);
    }

    
    public static final PolylineOptions buildOpenArc(LatLong center, LatLong start, LatLong end) {
        MVCArray res = buildArcPoints(center, start, end);
        return new PolylineOptions().path(res);
    }

    public static final MVCArray buildArcPoints(LatLong center, LatLong start, LatLong end) {
        return buildArcPoints(center, center.getBearing(start), center.getBearing(end), center.distanceFrom(start));
    }

    
    public static final MVCArray buildArcPoints(LatLong center, double startBearing, double endBearing, double radius) {
        int points = DEFAULT_ARC_POINTS;

        MVCArray res = new MVCArray();

        if (startBearing > endBearing) {
            endBearing += 360.0;
        }
        double deltaBearing = endBearing - startBearing;
        deltaBearing = deltaBearing / points;
        for (int i = 0; (i < points + 1); i++) {
            res.push(center.getDestinationPoint(startBearing + i * deltaBearing, radius));
        }

        return res;

    }

}

package Earthquake;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vicentem on 12/11/16.
 */
public class EarthquakeCityMap extends PApplet{
    private UnfoldingMap map;

    public void setup(){
        size(1200, 800, OPENGL);
        List<PointFeature> bigEarthquakes = new ArrayList<>();
        List<Location> loc = new ArrayList<>();
        List<Marker> markers = new ArrayList<>();

        loc.add(new Location(-38.29f, -73.05f));
        loc.add(new Location(61.02f, -147.65));
        loc.add(new Location(3.30f, 95.78f));
        loc.add(new Location(38.322f, 142.36f));
        loc.add(new Location(52.76, 160.06));

        for(Location lo: loc){
            bigEarthquakes.add(new PointFeature(lo));
        }

//        map = new UnfoldingMap(this, 100, 50, 900, 700, new Google.GoogleMapProvider());
        map = new UnfoldingMap(this, 100, 50, 900, 700, new Microsoft.AerialProvider());
        map.zoomToLevel(2);
        // allows the map to be moved around, drag, zoom etc
        MapUtils.createDefaultEventDispatcher(this, map);

        // Add markers to our map
        for (PointFeature eq: bigEarthquakes){
            markers.add(new SimplePointMarker(eq.getLocation(),
                    eq.getProperties()));
            
        }
        for (Marker mk: markers){
            mk.setColor(color(255, 0, 0));
        }
        
        map.addMarkers(markers);

    }

    public void draw(){
        background(200, 200, 200);
        map.draw();
        //addKey();

    }
}

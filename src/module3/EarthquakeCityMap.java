package module3;


import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.providers.Microsoft;
import parsing.ParseFeed;
import processing.core.PApplet;


import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.utils.MapUtils;


//Java utilities libraries
//import java.util.Collections;
//import java.util.Comparator;


/**
 * EarthquakeCityMap
 * An application with an interactive map displaying earthquake data.
 * Author: UC San Diego Intermediate Software Development MOOC team
 *
 * @author Vicente Miranda
 *         Date: December 16, 2016
 */
public class EarthquakeCityMap extends PApplet {

    // You can ignore this.  It's to keep eclipse from generating a warning.
    private static final long serialVersionUID = 1L;

    // Less than this threshold is a light earthquake
    public static final float THRESHOLD_MODERATE = 5;
    // Less than this threshold is a minor earthquake
    public static final float THRESHOLD_LIGHT = 4;

    /**
     * This is where to find the local tiles, for working without an
     * Internet connection
     */
    public static String mbTilesString = "blankLight-1-3.mbtiles";

    // The map
    private UnfoldingMap map;

    //feed with magnitude 2.5+ Earthquakes
    private String earthquakesURL = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";


    public void setup() {
        size(1200, 800, OPENGL);

        map = new UnfoldingMap(
                this,
                300,
                50,
                800,
                600,
                new Microsoft.AerialProvider());

        map.zoomToLevel(2);
        MapUtils.createDefaultEventDispatcher(this, map);

        // The List you will populate with new SimplePointMarkers
        List<Marker> markers = new ArrayList<>();

        //Use provided parser to collect properties for each earthquake
        //PointFeatures have a getLocation method
        List<PointFeature> earthquakes = ParseFeed.parseEarthquake(
                this,
                earthquakesURL);

        // These print statements show you (1) all of the relevant properties
        // in the features, and (2) how to get one property and use it
        if (earthquakes.size() > 0) {
            for(int i =0; i< earthquakes.size(); i++) {
                PointFeature f = earthquakes.get(i);
                markers.add(this.createMarker(f));
                float magnitude = this.getMagnitude(f);
                int color = this.getColor(magnitude);
                Marker marker = markers.get(i);
                marker.setColor(color);
                if (magnitude>5.0){

                    marker.setStrokeColor(color(250, 0, 0));
                    // cast marker with SimplePointMarker allows us to change property, check
                    // if there is an easier way
                    ((SimplePointMarker) marker).setRadius(15);
                    System.out.println(f.getProperties());
                }
            }
        }
        map.addMarkers(markers);
        //TODO: Add code here as appropriate
    }

    // A suggested helper method that takes in an earthquake feature and
    // returns a SimplePointMarker for that earthquake
    // Implement this method and call it from setUp, if it helps
    private SimplePointMarker createMarker(PointFeature feature) {
        // finish implementing and use this method, if it helps.
        return new SimplePointMarker(feature.getLocation());
    }

    private float getMagnitude(PointFeature feature){
        Object magObj = feature.getProperty("magnitude");
        return Float.parseFloat(magObj.toString());
    }

    private int getColor(float magnitude){
        int hue;
        if (magnitude < 4.0){
            hue = color(0, 0, 255);
        }
        else if(magnitude>4.0 && magnitude < 4.9){
            hue = color(255, 255, 0);
        }
        else if(magnitude>5.0){

            hue = color(255, 0, 0);
        }
        else{
            hue = color(200, 200, 200);
        }
        return hue;
    }

    public void draw() {
        background(10);
        map.draw();
        addKey();
    }

    // helper method to draw key in GUI
    // TODO: Implement this method to draw the key
    private void addKey() {
        // Remember you can use Processing's graphics methods here
        fill(160);
        rect(25, 50, 200, 300);
        textSize(18);
        fill(0);
        text("Earthquake key", 30, 80);

        line(25, 110, 200, 110);

        fill(255, 0, 0);
        ellipse(40, 140, 25, 25);
        textSize(16);
        fill(0);
        text("5.0+ Magnitude", 70, 150);

        fill(255, 255, 0);
        ellipse(40, 180, 15, 15);
        textSize(16);
        fill(0);
        text("4.0+ Magnitude", 70, 190);

        fill(0, 0, 255);
        ellipse(40, 220, 10, 10);
        textSize(16);
        fill(0);
        text("Below 4.0", 70, 230);




    }
}

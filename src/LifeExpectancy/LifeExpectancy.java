package LifeExpectancy;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vicentem on 12/13/16.
 */
public class LifeExpectancy extends PApplet {
    UnfoldingMap map;
    Map<String, Float> lifeExpByCountry;
    List<Feature> countries;
    List<Marker> countryMarkers;


    public void setup(){
        size(800, 600, OPENGL);
        map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
        MapUtils.createDefaultEventDispatcher(this, map);
    }

    public void draw() {

        map.draw();
    }

//    private Map<String, Float> loadlifeExpFromCSV(String fileName){
//        // construct object
//        Map<String, Float> lifeExpMap = new HashMap<String, Float>();
//
//
//    }
}

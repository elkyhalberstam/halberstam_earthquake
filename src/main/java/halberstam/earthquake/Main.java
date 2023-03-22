package halberstam.earthquake;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson");        URLConnection urlConnection = url.openConnection();
        InputStream inStream = urlConnection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
        Gson gson = new Gson();
        FeatureCollection featureCollection = gson.fromJson(reader, FeatureCollection.class);
        System.out.println(featureCollection.features[0].properties.place);

        EathquakeFrame earthquakeFrame = new EathquakeFrame(featureCollection);
    }
}

package com.example.journiappdemo;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class LoadJsonData extends AsyncTask<String, Void, JSONObject> {

    //Constants
    private final String TAG = "LoadJsonData";

    //References
    @SuppressLint("StaticFieldLeak")
    private MainActivity activity;

    LoadJsonData(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected JSONObject doInBackground(String... strings) {
        JSONObject jsonObject = null;
        try {

            // create an empty string to get json data through InputStream.
            String jsonString;
            InputStream is = activity.getAssets().open("countries_small.geojson");

            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            // close the inputStream once it's work is finished
            is.close();

            jsonString = new String(buffer, StandardCharsets.UTF_8);
            // put the string value to our jsonObject to parse it.
            jsonObject = new JSONObject(jsonString);

            Log.d("MainActivity Json", "loadJSONFromAsset: " + jsonObject.length());

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        try {

            // get the features object from JSON
            JSONArray getJsonArray = jsonObject
                    .getJSONArray("features");
            Log.d(TAG, "Json Array length: " + getJsonArray.length());

            // loop through features's length to get all polygon and multiPolygon values
            for (int i = 0; i < getJsonArray.length(); i++) {
                // outer loop to get geometry data
                JSONObject geometryObject = getJsonArray.getJSONObject(i)
                        .getJSONObject("geometry");
                List<Double[]> polygonCoordinators = new ArrayList<>();

                // check whether the type is polygon or multiPolygon
                if (geometryObject
                        .getString("type").equals("Polygon")) {

                    JSONArray getCoordinatesArray = geometryObject
                            .getJSONArray("coordinates").getJSONArray(0);

                    Log.d(TAG, "getCoordinatesArray length: " + getCoordinatesArray.length());

                    // inner loop to get the polygon coordinator data
                    for (int j = 0; j < getCoordinatesArray.length(); j++) {

                        Log.d(TAG, "getCoordinatesArray inner length: " +
                                getCoordinatesArray.getJSONArray(j).length());

                        double lat = getCoordinatesArray
                                .getJSONArray(j)
                                .getDouble(0);
                        double lng = getCoordinatesArray
                                .getJSONArray(j)
                                .getDouble(1);

                        // creating a list of lat and lng values after the scaling
                        polygonCoordinators.add(new Double[]{scaleLat(lat), scaleLng(lng)});
                    }
                    // call mainActivity to pass the coordination value
                    activity.getCoordinationValues
                            (new AbstractMap.SimpleEntry<>("Region", polygonCoordinators));
                } else if (geometryObject
                        .getString("type").equals("MultiPolygon")) {

                    Log.d(TAG, "MultiPolygon at: " + i + " is " + geometryObject
                            .getJSONArray("coordinates").length());

                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // logic to scale the Latitude of coordinator
    private double scaleLat(double actualLat) {
        double rMin = -20037507.161367;
        double rMax = 20037508.342789;
        double tMin = -1;
        double tMax = 1;

        double part1 = (actualLat - rMin) / (rMax - rMin);
        double part2 = (tMax - tMin);

        return (part1 * part2) + tMin;
    }

    // logic to scale the Longitude of coordinator
    private double scaleLng(double actualLng) {
        double rMin = -20037508.342789;
        double rMax = 18394375.282232;
        double tMin = -1;
        double tMax = 1;

        double part1 = (actualLng - rMin) / (rMax - rMin);
        double part2 = (tMax - tMin);

        return (part1 * part2) + tMin;
    }
}

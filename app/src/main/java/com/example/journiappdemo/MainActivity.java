package com.example.journiappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ScaleGestureDetector;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    // Constants
    private final String TAG = "MainActivity";

    // References
    private LoadJsonData loadJsonData;
    private MySurfaceView gLView;
    private MyGLRenderer renderer;
    private ScaleGestureDetector mScaleDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gLView = new MySurfaceView(this);
        renderer = new MyGLRenderer(new MyGLRenderer.GLListener() {
            @Override
            public void onSurfaceCreated() {

                Map.Entry<String, List<Double[]>> afg = getAfg();

                renderer.addRegion(afg.getKey(), afg.getValue());
            }
        });

        // Set the Renderer for drawing on the GLSurfaceView
        setContentView(gLView);

        gLView.setRenderer(renderer);

        // Gestures for pinch zoom
        mScaleDetector = new ScaleGestureDetector(gLView.getContext(), new ScaleGestureDetector.OnScaleGestureListener() {
            @Override
            public void onScaleEnd(ScaleGestureDetector detector) {
            }

            @Override
            public boolean onScaleBegin(ScaleGestureDetector detector) {
                return true;
            }

            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                Log.d(TAG, "zoom ongoing, scale: " + detector.getScaleFactor());
                renderer.setScale(detector.getScaleFactor());
                return false;
            }
        });
        gLView.setScaleDetector(mScaleDetector);

        // call Asynctask class to load our Json data
        loadJsonData = new LoadJsonData(this);
        loadJsonData.execute("");
    }

    public void getCoordinationValues(Map.Entry<String, List<Double[]>> coord) {
//        renderer.addRegion(coord.getKey(), coord.getValue());

        Log.d(TAG, "getCoordinationValues: getKey =  " + coord.getKey() + "getValue =" + coord.getValue());
    }

    private Map.Entry<String, List<Double[]>> getAfg() {
        List<Double[]> list = new ArrayList<>();
        list.add(new Double[]{
                8336864.24377,
                4471442.325051
        });
        list.add(new Double[]{
                8297907.67633,
                4442199.536361
        });
        list.add(new Double[]{
                8084336.866707,
                4415379.943115
        });
        list.add(new Double[]{
                7972753.798391,
                4360848.347458
        });
        list.add(new Double[]{
                7924288.192857,
                4306417.960343
        });
        list.add(new Double[]{
                7972753.798391,
                4188780.830448
        });
        list.add(new Double[]{
                7899856.925592,
                4100242.476941
        });
        list.add(new Double[]{
                7909429.242222,
                4035481.605779
        });
        list.add(new Double[]{
                7777677.578891,
                4015066.785
        });
        list.add(new Double[]{
                7823997.466816,
                3944392.092735
        });
        list.add(new Double[]{
                7736880.18133,
                3897965.83201
        });
        list.add(new Double[]{
                7712138.273983,
                3755018.893473
        });
        list.add(new Double[]{
                7666462.6766,
                3715394.791367
        });
        list.add(new Double[]{
                7587652.137037,
                3737474.89881
        });
        list.add(new Double[]{
                7490387.275508,
                3661071.779586
        });
        list.add(new Double[]{
                7449981.054347,
                3672505.559543
        });
        list.add(new Double[]{
                7391298.84164,
                3621351.384733
        });
        list.add(new Double[]{
                7366798.543246,
                3482434.596045
        });
        list.add(new Double[]{
                7135440.712576,
                3425628.088095
        });
        list.add(new Double[]{
                6954855.277686,
                3427721.230908
        });
        list.add(new Double[]{
                6773056.045436,
                3485399.248292
        });
        list.add(new Double[]{
                6802083.635409,
                3520064.377123
        });
        list.add(new Double[]{
                6877787.774144,
                3610939.527181
        });
        list.add(new Double[]{
                6863981.548235,
                3682514.648578
        });
        list.add(new Double[]{
                6770536.409207,
                3697226.553445
        });
        list.add(new Double[]{
                6771491.339833,
                3796093.138029
        });
        list.add(new Double[]{
                6733248.094065,
                4041537.467926
        });
        list.add(new Double[]{
                6785050.204194,
                4116940.225247
        });
        list.add(new Double[]{
                6819657.810473,
                4248402.078321
        });
        list.add(new Double[]{
                6936078.81045,
                4187112.855479
        });
        list.add(new Double[]{
                7019428.146782,
                4224632.73155
        });
        list.add(new Double[]{
                7025215.256475,
                4275702.336937
        });
        list.add(new Double[]{
                7181334.908535,
                4347599.71098
        });
        list.add(new Double[]{
                7215321.234648,
                4457535.956413
        });
        list.add(new Double[]{
                7297543.06253,
                4474173.765871
        });
        list.add(new Double[]{
                7320927.357663,
                4518735.638996
        });
        list.add(new Double[]{
                7405225.872026,
                4487794.571036
        });
        list.add(new Double[]{
                7542896.954715,
                4463140.343683
        });
        list.add(new Double[]{
                7577274.457228,
                4432113.55089
        });
        list.add(new Double[]{
                7735827.456605,
                4516478.734441
        });
        list.add(new Double[]{
                7820356.074733,
                4532094.730388
        });
        list.add(new Double[]{
                7816260.227713,
                4568755.748143
        });
        list.add(new Double[]{
                7827236.177311,
                4577280.698079
        });
        list.add(new Double[]{
                7874286.64469,
                4639293.209391
        });
        list.add(new Double[]{
                7965125.858577,
                4569984.63044
        });
        list.add(new Double[]{
                7951871.881704,
                4456901.004127
        });
        list.add(new Double[]{
                7985363.484721,
                4395153.514027
        });
        list.add(new Double[]{
                8149830.150862,
                4496202.930173
        });
        list.add(new Double[]{
                8266550.285735,
                4497173.419465
        });
        list.add(new Double[]{
                8336864.24377,
                4471442.325051
        });

        List<Double[]> scaled = new ArrayList<>();
        for (Double[] coord : list) {
            Double[] scaledLatLng = new Double[]{scaleLat(coord[0]), scaleLng(coord[1])};
            scaled.add(scaledLatLng);
        }

        return new AbstractMap.SimpleEntry<>("AFG", scaled);
    }

    private double scaleLat(double actualLat) {
        double m = actualLat;
        double rMin = -20037507.161367;
        double rMax = 20037508.342789;
        double tMin = -1;
        double tMax = 1;


        double test = (m - rMin) / (rMax - rMin);
        double test1 = (tMax - tMin);
        double result = (test * test1) + tMin;

        return result;
    }

    private double scaleLng(double actualLng) {

        double m = actualLng;
        double rMin = -20037508.342789;
        double rMax = 18394375.282232;
        double tMin = -1;
        double tMax = 1;

        double test = (m - rMin) / (rMax - rMin);
        double test1 = (tMax - tMin);
        double result = (test * test1) + tMin;

        return result;
    }

}

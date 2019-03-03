package com.example.journiappdemo;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public class MySurfaceView extends GLSurfaceView {

    // References
    private ScaleGestureDetector scaleDetector;

    public MySurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

    }

    public void setScaleDetector(ScaleGestureDetector scaleDetector) {
        this.scaleDetector = scaleDetector;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (scaleDetector != null) {
            return scaleDetector.onTouchEvent(event);
        }
        return true;
    }
}

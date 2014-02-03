package com.example.notminecraft;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.widget.Toast;

public class MySurfaceView extends GLSurfaceView {

	private final static float ROTATION_SPEED = 0.5f;
	
	private MyRenderer renderer;
	
	private float touchedX = 0;
	private float touchedY = 0;
	
	Context context; // Remove
	
	public MySurfaceView(Context context) {
		super(context);
		this.context = context; // Remove
		
		setEGLContextClientVersion(2); // Move to manifest
		setRenderer(renderer = new MyRenderer(this));
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			touchedX = event.getX();
			touchedY = event.getY();
			
			Toast.makeText(context, "Touched!", Toast.LENGTH_SHORT).show(); // Remove
			
			return true;
		} else if (event.getAction() == MotionEvent.ACTION_MOVE) {
			renderer.xAngle += (touchedX - event.getX()) * ROTATION_SPEED; // Add delta to speed
			renderer.yAngle += (touchedY - event.getY()) * ROTATION_SPEED; // Add delta to speed
			
			touchedX = event.getX();
			touchedY = event.getY();
			
			Toast.makeText(context, "Moved!", Toast.LENGTH_SHORT).show(); // Remove
			
			return true;
		}
		
		return false;
	}

}

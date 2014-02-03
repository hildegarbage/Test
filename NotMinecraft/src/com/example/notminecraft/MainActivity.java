package com.example.notminecraft;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

	private GLSurfaceView glSurface;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		glSurface = new MySurfaceView(this);
		setContentView(glSurface);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		glSurface.onResume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		glSurface.onPause();
	}

}

package com.example.backgroundfade;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ViewSwitcher;

public class SecondActivity extends BaseActivity
{	
	Button btnGoPrev;
	ViewSwitcher switcher;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);
		
		initControls();
		setListeners();
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		
		// Wait a second to display properly 
		// the "fade" effect
		Handler handlerUI = new Handler();
		handlerUI.postDelayed(new Runnable() 
		{
            @Override
            public void run() 
            {
            	// From Blue to Green 
        		switcher.showPrevious();
            }
        }, 1000);
		
	}
	
	/**
	 * Init activity controls
	 */
	private void initControls()
	{
		btnGoPrev = (Button)findViewById(R.id.btnWindowAnimation);
		switcher = (ViewSwitcher) findViewById(R.id.switcher);
	}
	
	/**
	 * Define all the listeners we will use
	 */
	private void setListeners()
	{
		btnGoPrev.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				/**
				 * finish() will go back to the prev. screen.
				 * If you need to continue calling activities,
				 * you may just start them here.
				 */
				finish();
			}
		});
	}
	
	
}

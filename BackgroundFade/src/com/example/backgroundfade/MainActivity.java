package com.example.backgroundfade;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ViewSwitcher;

public class MainActivity extends BaseActivity
{
	/**
	 * Button for moving to the next screen
	 */
	Button btnGoForward;
	
	/**
	 * For the "fade" effect
	 */
	ViewSwitcher switcher;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
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
            	// From Green to Blue
        		switcher.showPrevious();
            }
            
        }, 1000);
		
	}
	
	/**
	 * Init activity controls
	 */
	private void initControls()
	{
		btnGoForward = (Button)findViewById(R.id.btnWindowAnimation);
		switcher = (ViewSwitcher) findViewById(R.id.switcher);
	}
	
	/**
	 * Define all the listeners we will use
	 */
	private void setListeners()
	{
		btnGoForward.setOnClickListener(new View.OnClickListener() 
        {
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            	
                // After hiding this Activity, 
                // change from Blue to green for next time
                switcher.showNext();
			}
		});
	}
	
	
}

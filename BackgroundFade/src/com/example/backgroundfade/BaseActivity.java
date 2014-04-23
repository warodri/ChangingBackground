package com.example.backgroundfade;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity
{
	/**
	 * Flag for defining next animation:
	 * from left-to-right or from right-to-left
	 */
	int onStartCount = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		onStartCount = 1;
		
		if (savedInstanceState == null)
		{
			// First time creating this child activity. 
			// Next animation will be from left-to-right
			this.overridePendingTransition(R.anim.anim_slide_in_left,
					R.anim.anim_slide_out_left);
		}
		else
		{
			// Next time we will animate from left-to-right
			onStartCount = 2;
		}
	}
	
	@Override
	protected void onStart()
	{
		super.onStart();
		
		if (onStartCount > 1)
		{
			// This activity was already created.
			// Next animation will be from right to left.
			this.overridePendingTransition(R.anim.anim_slide_in_right,
					R.anim.anim_slide_out_right);
			
		}
		else if (onStartCount == 1)
		{
			// If this activity was already created,
			// next time will be > 1 (so, animation will go from right-to-left)
			onStartCount++;
		}
	}
}

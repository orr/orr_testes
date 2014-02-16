package course.labs.activitylab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.mtp.MtpConstants;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	// TODO:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
	private int mCreate ;
	private int mResume;
	private int mRestart;
	private int mStart;


	// TODO: Create variables for each of the TextViews, called
        // mTvCreate, etc.
	
	private TextView mTvCreate;
	private TextView mTvRestart;
	private TextView mTvStart;
	private TextView mTvResume;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mCreate++;
		setContentView(R.layout.activity_two);

		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		 mTvCreate = (TextView) findViewById(R.id.create);
		 mTvRestart = (TextView) findViewById(R.id.restart);
		 mTvResume = (TextView) findViewById(R.id.resume);
		 mTvStart = (TextView) findViewById(R.id.start);
		 System.out.println("criado intent 2");


		Log.i(TAG,"oncreate 2");
		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO:
				// This function closes Activity Two
				// Hint: use Context's finish() method
//				Intent i2 = new Intent(ActivityTwo.this, ActivityOne.class);
//				i2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				// Launch the Activity using the intent
//				Context applicationContext = getApplicationContext();
//				applicationContext.startActivity(i2);
				finish();
			
			}
		});
		System.out.println("check instances");
		Log.i(TAG, "before saving 2");
		// Check for previously saved state
		
		if (savedInstanceState != null) {
			Log.i(TAG, "on saving instance 2");
			System.out.println("recuperando state");
			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			mCreate = savedInstanceState.getInt("mCreate");
			mResume = savedInstanceState.getInt("mResume");
			mStart = savedInstanceState.getInt("mStart");
			mRestart = savedInstanceState.getInt("mRestart");


		}
		Log.i(TAG,"after save instance 2");
		mCreate++;
		// TODO: Emit LogCat message
		displayCounts();


		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method




	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		// TODO: Emit LogCat message
		Log.i(TAG,"on start 2");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		mStart++;
		displayCounts();


	}

	@Override
	public void onResume() {
		super.onResume();
		Log.i(TAG,"onresume 2");
		// TODO: Emit LogCat message

		mResume++;
		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		displayCounts();



	}

	@Override
	public void onPause() {
		super.onPause();

		// TODO: Emit LogCat message
		Log.i(TAG,"on pause 2");


	}

	@Override
	public void onStop() {
		super.onStop();

		// TODO: Emit LogCat message

		Log.i(TAG,"on pause");

	}

	@Override
	public void onRestart() {
		super.onRestart();

		// TODO: Emit LogCat message

		Log.i(TAG,"on restar 2");
		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		mRestart++;
		displayCounts();


	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(TAG,"on destroy 2");
		// TODO: Emit LogCat message

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		Log.i(TAG,"on save instance 2");
		// TODO:
		// Save counter state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
//		if(savedInstanceState != null ) {
//			mCreate = savedInstanceState.getInt("mCreate");
//			mResume = savedInstanceState.getInt("mResume");
//			mStart = savedInstanceState.getInt("mStart");
//			mRestart = savedInstanceState.getInt("mRestart");
//		}
		savedInstanceState.putInt("mCreate", mCreate);
		savedInstanceState.putInt("mStart", mStart);
		savedInstanceState.putInt("mResume", mResume);
		savedInstanceState.putInt("mRestart", mRestart);


	
	}

	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}

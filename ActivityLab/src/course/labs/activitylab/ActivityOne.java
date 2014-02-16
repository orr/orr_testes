package course.labs.activitylab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";
	
	// Lifecycle counters

	private int mCreate =0;
	private int mResume =0;
	private int mRestart =0;
	private int mStart =0;
	
	// TODO:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called



	// TODO: Create variables for each of the TextViews, called
        // mTvCreate, etc.
	
	private TextView mTvCreate ;
	private TextView mTvRestart;
	private TextView mTvStart;
	private TextView mTvResume;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
		mTvCreate = (TextView) findViewById(R.id.create);
		 mTvRestart = (TextView) findViewById(R.id.restart);
		 mTvResume = (TextView) findViewById(R.id.resume);
		 mTvStart = (TextView) findViewById(R.id.start);
		
		
		System.out.println("oncreate 1");
		Log.i(TAG, "oncreate 1");


		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo); 
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO:
				// Launch Activity Two
				// Hint: use Context's startActivity() method
				System.out.println("clicado2");
				Log.i(TAG,"clicado no 1");
				// Create an intent stating which Activity you would like to start
				Intent i2 = new Intent(ActivityOne.this, ActivityTwo.class);
//				i2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				// Launch the Activity using the intent
				
				startActivity(i2);
			
			
			}
		});
		Log.i(TAG, "before checksaved states");
		// Check for previously saved state
		if (savedInstanceState != null) {
			Log.i(TAG, "on checksaved states");
			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			mCreate = savedInstanceState.getInt("mCreate");
			mResume = savedInstanceState.getInt("mResume");
			mStart = savedInstanceState.getInt("mStart");
			mRestart = savedInstanceState.getInt("mRestart");

			
		}
		Log.i(TAG, "After checksaved states");

		// TODO: Emit LogCat message


		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
		mCreate++;
		displayCounts();


	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		Log.i(TAG, "on restore checksaved states 1 ");
		// TODO:
		// Restore value of counters from saved state
		// Only need 4 lines of code, one for every count variable
		mCreate = savedInstanceState.getInt("mCreate");
		mResume = savedInstanceState.getInt("mResume");
		mStart = savedInstanceState.getInt("mStart");
		mRestart = savedInstanceState.getInt("mRestart");
		displayCounts();
	}
	
	// Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();
		System.out.println("started");
		// TODO: Emit LogCat message
		Log.i(TAG, "on start 1");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		mStart++;
		displayCounts();
	}

	@Override
	public void onResume() {
		super.onResume();

		// TODO: Emit LogCat message
		Log.i(TAG, "on resume 1");
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
		Log.i(TAG, "on pausing 1");
//		
//		savedInstanceState.putInt("mCreate", mCreate);
//		savedInstanceState.putInt("mStart", mStart);
//		savedInstanceState.putInt("mResume", mResume);
//		savedInstanceState.putInt("mRestart", mRestart);
	
	}

	@Override
	public void onStop() {
		super.onStop();

		// TODO: Emit LogCat message
		Log.i(TAG, "on stoping 1");
	}

	@Override
	public void onRestart() {
		super.onRestart();

		// TODO: Emit LogCat message
		Log.i(TAG, "on restart 1");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		mRestart++;
		displayCounts();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// TODO: Emit LogCat message
		Log.i(TAG, "on destroying 1");

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// TODO:
		// Save state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
		
		Log.i(TAG, "onsaveInstance 1");
		savedInstanceState.putInt("mCreate", mCreate);
		savedInstanceState.putInt("mStart", mStart);
		savedInstanceState.putInt("mResume", mResume);
		savedInstanceState.putInt("mRestart", mRestart);



	}
	
	// Updates the displayed counters
	public void displayCounts() {
		Log.i(TAG, "update display 1");
		System.out.println("loll");
		mTvCreate.setText("onCreate() callsss: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}

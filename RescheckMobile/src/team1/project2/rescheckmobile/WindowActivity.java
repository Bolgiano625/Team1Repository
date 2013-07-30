package team1.project2.rescheckmobile;

import java.util.LinkedList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class WindowActivity extends Activity{
	//Metal Frame RadioButton.
	private RadioButton mF_RadioButton;
	//Metal Frame w/ Thermal Break RadioButton.
	private RadioButton mFTB_RadioButton;
	//Wood Frame RadioButton.
	private RadioButton wF_RadioButton;
	//Vinyl Frame RadioButton.
	private RadioButton vF_RadioButton;
	//Other RadioButton.
	private RadioButton other_RadioButton;
	private RadioButton sP_RadioButton;
	private RadioButton dP_RadioButton;
	private RadioButton dPWLE_RadioButton;
	private RadioButton tP_RadioButton;
	private RadioButton tPWLE_RadioButton;
	
	//Create Window Button.
	private Button createWindow_Button;
	//Cancel Button.
	private Button cancel_Button;
	
	//Int value for radio button chosen.
	private int radioButtonPressed = 0;
	
	//String for type of window.
	private String window_String;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.window_layout);
		//Instantiates all RadioButtons. 
		initializeRadioButtons();
		//Instantiates all buttons.
		initializeButtons();
	}
	
	/**
	 * initializeRadioButtons
	 * 
	 * Initializes all radio buttons.
	 */
	private void initializeRadioButtons(){
		//Metal Frame RadioButton.
		mF_RadioButton = (RadioButton)findViewById(R.id.wMFrameRadioButton);
		mF_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 1;
				//I work now!!!
			}
		});
		//Metal Frame w/ Thermal Break RadioButton.
		mFTB_RadioButton = (RadioButton)findViewById(R.id.wMFrameWTBRadioButton);
		mFTB_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 2;
				//I work now!!!
			}
		});	
		//Metal Frame RadioButton.
		wF_RadioButton = (RadioButton)findViewById(R.id.wWFrameRadioButton);
		wF_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 3;
				//I work now!!!
			}
		});
		//Metal Frame RadioButton.
		vF_RadioButton = (RadioButton)findViewById(R.id.wVFrameRadioButton);
		vF_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 4;
				//I work now!!!
			}
		});
		//Metal Frame RadioButton.
		other_RadioButton = (RadioButton)findViewById(R.id.wOFrameRadioButton);
		other_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 5;
				//I work now!!!
			}
		});
		//Metal Frame RadioButton.
		sP_RadioButton = (RadioButton)findViewById(R.id.singlePaneRadioButton);
		sP_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//radioButtonPressed = 6;
				window_String = "Single Pane";
				//I work now!!!
			}
		});
		//Metal Frame RadioButton.
		dP_RadioButton = (RadioButton)findViewById(R.id.wDPaneRadioButton);
		dP_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//radioButtonPressed = 7;
				window_String = "Double Pane";
				//I work now!!!
			}
		});
		//Metal Frame RadioButton.
		dPWLE_RadioButton = (RadioButton)findViewById(R.id.wDPaneWLERadioButton);
		dPWLE_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//radioButtonPressed = 8;
				window_String = "Double Pane w/Low-E";
				//I work now!!!
			}
		});
		//Metal Frame RadioButton.
		tP_RadioButton = (RadioButton)findViewById(R.id.wTPaneRadioButton);
		tP_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//radioButtonPressed = 9;
				window_String = "Triple Pane";
				//I work now!!!
			}
		});
		//Metal Frame RadioButton.
		tPWLE_RadioButton = (RadioButton)findViewById(R.id.wTPaneWLERadioButton);
		tPWLE_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//radioButtonPressed = 10;
				window_String = "Triple Pane w/Low-E";
				//I work now!!!
			}
		});
	}//End of initialize buttons
	
	private void initializeButtons(){
		//Create Ceiling Button. 
		createWindow_Button = (Button)findViewById(R.id.wCreateButton);
		createWindow_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//Intent to return values from Skylight window.
				Intent data = new Intent();
				switch(radioButtonPressed){
				case 1:
					data.putExtra("1v1","Window");
					data.putExtra("1v2","Metal Frame," + window_String);
					data.putExtra("1v3","0");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","0");
					data.putExtra("1v7","0");
					data.putExtra("1v8","0");
					data.putExtra("1v9","0");
					data.putExtra("1v10","0");
					data.putExtra("1v11","0");
					break;
				case 2:
					data.putExtra("1v1","Window");
					data.putExtra("1v2","Metal Frame w/ Thermal Break," + window_String);
					data.putExtra("1v3","0");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","0");
					data.putExtra("1v7","0");
					data.putExtra("1v8","0");
					data.putExtra("1v9","0");
					data.putExtra("1v10","0");
					data.putExtra("1v11","0");
					break;
				case 3:
					data.putExtra("1v1","Window");
					data.putExtra("1v2","Wood Frame," + window_String);
					data.putExtra("1v3","0");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","0");
					data.putExtra("1v7","0");
					data.putExtra("1v8","0");
					data.putExtra("1v9","0");
					data.putExtra("1v10","0");
					data.putExtra("1v11","0");
					break;
				case 4:
					data.putExtra("1v1","Window");
					data.putExtra("1v2","Vinyl Frame," + window_String);
					data.putExtra("1v3","0");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","0");
					data.putExtra("1v7","0");
					data.putExtra("1v8","0");
					data.putExtra("1v9","0");
					data.putExtra("1v10","0");
					data.putExtra("1v11","0");
					break;
				case 5:
					data.putExtra("1v1","Window");
					data.putExtra("1v2","Other");
					data.putExtra("1v3","0");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","0");
					data.putExtra("1v7","0");
					data.putExtra("1v8","0");
					data.putExtra("1v9","0");
					data.putExtra("1v10","0");
					data.putExtra("1v11","0");
					break;
				}
				setResult(RESULT_OK, data);
				finish();
			}
				
		});
		//Cancel Button. 
		cancel_Button = (Button)findViewById(R.id.wCancelButton);
		cancel_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				finish();
			}
						
		});
	}
}
	

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

public class SkylightActivity extends Activity{
	//Metal Frame RadioButton.
	private RadioButton mF_RadioButton;
	//Metal Fram w/ Thermal Break RadioButton.
	private RadioButton mFTB_RadioButton;
	//Wood Frame RadioButton.
	private RadioButton wF_RadioButton;
	//Vinyl Frame RadioButton.
	private RadioButton vF_RadioButton;
	//Other RadioButton.
	private RadioButton other_RadioButton;
	
	//Metal Frame spinner
	private Spinner mF_Spinner;
	//Metale Frame w/ Thermal Break Spinner.
	private Spinner mFTB_Spinner;
	//Wood Frame Spinner.
	private Spinner wF_Spinner;
	//Vinyl Frame Spinner
	private Spinner vF_Spinner;
	
	//Create Skylight Button.
	private Button createSkylight_Button;
	//Cancel Button.
	private Button cancel_Button;
	
	//Int value for radio button chosen.
	private int radioButtonPressed = 0;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.skylight_layout);
		//Instantiates all RadioButtons. 
		initializeRadioButtons();
		//Instantiates all Spinners.
		initializeSpinners();
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
		mF_RadioButton = (RadioButton)findViewById(R.id.mFSkyLightRadioButton);
		mF_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 1;
				//I work now!!!
			}
		});
		//Metal Frame w/ Thermal Break RadioButton.
		mFTB_RadioButton = (RadioButton)findViewById(R.id.mFWTBSkyLightRadioButton);
		mFTB_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 2;
				//I work now!!!
			}
		});	
		//Metal Frame RadioButton.
		wF_RadioButton = (RadioButton)findViewById(R.id.wFSkyLightRadioButton);
		wF_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 3;
				//I work now!!!
			}
		});
		//Metal Frame RadioButton.
		vF_RadioButton = (RadioButton)findViewById(R.id.vFSkyLightRadioButton);
		vF_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 4;
				//I work now!!!
			}
		});
		//Metal Frame RadioButton.
		other_RadioButton = (RadioButton)findViewById(R.id.otherSkyLightRadioButton);
		other_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 5;
				//I work now!!!
			}
		});	
	}//End of initialize buttons
	

	/**
	 * initializeSpinners
	 * 
	 * Initializes all spinners.
	 */
	private void initializeSpinners(){
		//Metal Frame spinner
		mF_Spinner = (Spinner)findViewById(R.id.mFSkyLightSpinner);
		//Metal Frame w/ Thermal Break spinner
		mFTB_Spinner = (Spinner)findViewById(R.id.mFWTBSkyLightSpinner);
		//Wood Frame spinner
		wF_Spinner = (Spinner)findViewById(R.id.wFSkyLightSpinner);
		//Vinyl Frame spinner
		vF_Spinner = (Spinner)findViewById(R.id.vFSkyLightSpinner);
	}
	
	private void initializeButtons(){
		//Create Ceiling Button. 
		createSkylight_Button = (Button)findViewById(R.id.createSkyLightButton);
		createSkylight_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//Intent to return values from Skylight window.
				Intent data = new Intent();
				switch(radioButtonPressed){
				case 1:
					data.putExtra("1v1","Skylight");
					data.putExtra("1v2","Metal Frame," + mF_Spinner.getSelectedItem().toString());
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
					data.putExtra("1v1","Skylight");
					data.putExtra("1v2","Metal Thermal Break," + mFTB_Spinner.getSelectedItem().toString());
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
					data.putExtra("1v1","Skylight");
					data.putExtra("1v2","Wood Frame," + wF_Spinner.getSelectedItem().toString());
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
					data.putExtra("1v1","Skylight");
					data.putExtra("1v2","Vinyl Frame," + vF_Spinner.getSelectedItem().toString());
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
					data.putExtra("1v1","Skylight");
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
		cancel_Button = (Button)findViewById(R.id.cancelSkyLightButton);
		cancel_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				finish();
			}
						
		});
	}
}
	

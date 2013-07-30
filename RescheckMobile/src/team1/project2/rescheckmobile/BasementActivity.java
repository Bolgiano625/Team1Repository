package team1.project2.rescheckmobile;

import java.util.LinkedList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class BasementActivity extends Activity{
	//Create Basement Button.
	private Button createBasement_Button;
	//Cancel Basement Button.
	private Button cancel_Button;
	//Solid Concrete or Masonry RadioButton.
	private RadioButton sCOM_RadioButton;
	//Masonry Block w/ Empty Cells RadioButton.
	private RadioButton mBWEC_RadioButton;
	//Masonry Block w/ Integral Insulation RadioButton.
	private RadioButton mBWII_RadioButton;
	//Wood Frame RadioButton.
	private RadioButton wF_RadioButton;
	//Insulated Concrete Forms RadioButton.
	private RadioButton iCF_RadioButton;
	//other RadioButton.
	private RadioButton other_RadioButton;
	//Wall Height(ft) text field.
	private EditText wallHeight_EditText;
	//Depth Below Grade(ft) text field.
	private EditText dBG_EditText;
	//Depth of Insulation(ft) text field.
	private EditText dOI_EditText;
	//Depth Below Inside Grade(ft) text field.
	private EditText dBIG_EditText;
	//Int value for radio button chosen.
	private int radioButtonPressed = 0;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basement_layout);
		//Instantiates all RadioButtons. 
		initializeRadioButtons();	
		//Instantiates all TextFields.
		initializeEditTexts();
		//Instantiates all Buttons.
		initializeButtons();
	}
	
	/**
	 * initializeRadioButtons
	 * 
	 * Initializes all radio buttons.
	 */
	private void initializeRadioButtons(){
		//Solid Concrete or Masonry RadioButton.
		sCOM_RadioButton = (RadioButton)findViewById(R.id.sCOMBRadioButton);
		sCOM_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 1;
				//I work now!!!
			}
		});
		//Masonry Block w/ Empty Cells RadioButton.
		mBWEC_RadioButton = (RadioButton)findViewById(R.id.mBWECBRadioButton);
		mBWEC_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 2;
				//I work now!!!
			}
		});
		//Masonry Block w/ Integral Insulation RadioButton.
		mBWII_RadioButton = (RadioButton)findViewById(R.id.mBWIIBRadioButton);
		mBWII_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 3;
				//I work now!!!
			}
		});
		//Wood Frame RadioButton.
		wF_RadioButton = (RadioButton)findViewById(R.id.wFBRadioButton);
		wF_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 4;
				//I work now!!!
			}
		});
		//Insulated Concrete Forms RadioButton.
		iCF_RadioButton = (RadioButton)findViewById(R.id.iCFBRadioButton);
		iCF_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 5;
				//I work now!!!
			}
		});
		//Other RadioButton.
		other_RadioButton = (RadioButton)findViewById(R.id.otherBasementRadioButton);
		other_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 6;
				//I work now!!!
			}
		});
	}
	
	/**
	 * initializeEditTexts
	 * 
	 * Initializes all text fields.
	 */
	private void initializeEditTexts(){
		//Title text field.
		wallHeight_EditText = (EditText)findViewById(R.id.wHBasement);
		//Conditioned Floor Area text field.
		dBG_EditText = (EditText)findViewById(R.id.dBGBasement);
		//Notes text field.
		dOI_EditText = (EditText)findViewById(R.id.dOIBasement);
	}
	
	/**
	 * initializeButtons
	 * 
	 * Initializes all buttons.
	 */
	private void initializeButtons(){
		//Create Ceiling Button. 
		createBasement_Button = (Button)findViewById(R.id.createBasementButton);
		createBasement_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//Intent to return values from Ceiling window.
				Intent data = new Intent();
				switch(radioButtonPressed){
				case 1:
					data.putExtra("1v1","Basement");
					data.putExtra("1v2","Solid Concrete or Masonry");
					data.putExtra("1v3","0");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","0");
					data.putExtra("1v7","0");
					data.putExtra("1v8",dOI_EditText.getText().toString());
					data.putExtra("1v9",wallHeight_EditText.getText().toString());
					data.putExtra("1v10",dBG_EditText.getText().toString());
					data.putExtra("1v11","0");
					break;
				case 2:
					data.putExtra("1v1","Basement");
					data.putExtra("1v2","Masonry Block w/ Empty Cells");
					data.putExtra("1v3","0");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","0");
					data.putExtra("1v7","0");
					data.putExtra("1v8",dOI_EditText.getText().toString());
					data.putExtra("1v9",wallHeight_EditText.getText().toString());
					data.putExtra("1v10",dBG_EditText.getText().toString());
					data.putExtra("1v11","0");
					break;
				case 3:
					data.putExtra("1v1","Basement");
					data.putExtra("1v2","Masonry Block w/ Integral Insulation");
					data.putExtra("1v3","0");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","0");
					data.putExtra("1v7","0");
					data.putExtra("1v8",dOI_EditText.getText().toString());
					data.putExtra("1v9",wallHeight_EditText.getText().toString());
					data.putExtra("1v10",dBG_EditText.getText().toString());
					data.putExtra("1v11","0");
					break;
				case 4:
					data.putExtra("1v1","Basement");
					data.putExtra("1v2","Wood Frame");
					data.putExtra("1v3","0");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","0");
					data.putExtra("1v7","0");
					data.putExtra("1v8",dOI_EditText.getText().toString());
					data.putExtra("1v9",wallHeight_EditText.getText().toString());
					data.putExtra("1v10",dBG_EditText.getText().toString());
					data.putExtra("1v11","0");
					break;
				case 5:
					data.putExtra("1v1","Basement");
					data.putExtra("1v2","Insulated Concrete Forms");
					data.putExtra("1v3","0");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","0");
					data.putExtra("1v7","0");
					data.putExtra("1v8",dOI_EditText.getText().toString());
					data.putExtra("1v9",wallHeight_EditText.getText().toString());
					data.putExtra("1v10",dBG_EditText.getText().toString());
					data.putExtra("1v11","0");
					break;
				case 6:
					data.putExtra("1v1","Basement");
					data.putExtra("1v2","Other");
					data.putExtra("1v3","0");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","0");
					data.putExtra("1v7","0");
					data.putExtra("1v8","0");
					data.putExtra("1v9",wallHeight_EditText.getText().toString());
					data.putExtra("1v10",dBG_EditText.getText().toString());
					data.putExtra("1v11","0");
					break;
				}
				setResult(RESULT_OK, data);
				finish();
			}
		});
		//Cancel Button. 
		cancel_Button = (Button)findViewById(R.id.cancelBasementButton);
		cancel_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				
				finish();	
			}
						
		});
	}
}

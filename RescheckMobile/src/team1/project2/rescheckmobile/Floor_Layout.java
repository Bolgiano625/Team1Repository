package team1.project2.rescheckmobile;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
/**
 * Floor Activity 
 * Create floor screen
 * Adam Moore
 * 
**/
public class Floor_Layout extends Activity {
	
	//Create Floor Button
	private Button createFloor;
	//Cancel Button
	private Button Cancel;
	
	//Create a Spinner for All Wood Truss/Joist 
	private Spinner AWoodTrussSpinner;
	private Spinner steel16Spinner;
	private Spinner steel24Spinner;
	private Spinner sIPSpinner;
	private Spinner otherSpinner;
	/*//Create an Adaptor using the string array
	ArrayAdapter<CharSequence> Wadapter = ArrayAdapter.createFromResource(this, R.array.AWoodTrussArray, android.R.layout.simple_spinner_dropdown_item);
	//Setup Layout for the choices
	Wadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	AWoodTrussSpinner.setAdapter(Wadapter);*/
	
	private RadioButton aWJT_RadioButton;
	private RadioButton sF16_RadioButton;
	private RadioButton sF24_RadioButton;
	private RadioButton sIP_RadioButton;
	private RadioButton sOGHID_RadioButton;
	private RadioButton sOGUID_RadioButton;
	private RadioButton other_RadioButton;
	
	private EditText sOGH_EditText;
	private EditText sOGU_EditText;
	
	//Int value for radio button chosen.
	private int radioButtonPressed = 0;
	
	//Check what radio button is checked
	public void onRadioButtonClicked( View activity_floor){
		//Checked if button is checked
		boolean checked = ((RadioButton) activity_floor).isChecked();
		switch(activity_floor.getId()){
			//TODO Add Radio Button checks
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_floor);
		//Initialize RadioButtons.
		initializeRadioButtons();
		//Initialize spinners.
		initializeSpinners();
		//Initialize textfields.
		initializeTextField();
		//Initialize buttons.
		initializeButtons();
	};
	
	/**
	 * initializeRadioButtons
	 * 
	 * Initializes all radio buttons.
	 */
	private void initializeRadioButtons(){
		//All-Wood Joist/Truss RadioButton.
		aWJT_RadioButton = (RadioButton)findViewById(R.id.AWoodTrussButton);
		aWJT_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 1;
				//I work now!!!
			}
		});
		//Steel Frame,16 o.c.  RadioButton.
		sF16_RadioButton = (RadioButton)findViewById(R.id.SteelFrame16button);
		sF16_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 2;
				//I work now!!!
			}
		});
		//Steel Frame,24 o.c.  RadioButton.
		sF24_RadioButton = (RadioButton)findViewById(R.id.SteelFrame32button);
		sF24_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 3;
				//I work now!!!
			}
		});
		//Structural Insulated Panels  RadioButton.
		sIP_RadioButton = (RadioButton)findViewById(R.id.SIPanelButton);
		sIP_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 4;
				//I work now!!!
			}
		});
		//Slap-On-Grade Heated - Insulation Depth(ft)  RadioButton.
		sOGHID_RadioButton = (RadioButton)findViewById(R.id.SOGHeatedButton);
		sOGHID_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 5;
				//I work now!!!
			}
		});
		//Slap-On-Grade UnHeated - Insulation Depth(ft)  RadioButton.
		sOGUID_RadioButton = (RadioButton)findViewById(R.id.SOGUHeatedButton);
		sOGUID_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 6;
				//I work now!!!
			}
		});
		//Other  RadioButton.
		other_RadioButton = (RadioButton)findViewById(R.id.Other);
		other_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 7;
				//I work now!!!
			}
		});
	}
	
	/**
	 * initializeTextFields
	 * 
	 * Initializes all textfields.
	 */
	private void initializeTextField(){
		sOGH_EditText = (EditText)findViewById(R.id.sOGHEditText);
		sOGU_EditText = (EditText)findViewById(R.id.sOGUEditText);
	}
	
	/**
	 * initializeSpinners
	 * 
	 * Initializes all spinners.
	 */
	private void initializeSpinners(){
		AWoodTrussSpinner = (Spinner) findViewById(R.id.AWoodTrussSpinner);
		steel16Spinner = (Spinner) findViewById(R.id.Steel16Spinner);
		steel24Spinner = (Spinner) findViewById(R.id.SteelFrame32Spinner);
		sIPSpinner = (Spinner) findViewById(R.id.SIPPanelSpinner);
		otherSpinner = (Spinner) findViewById(R.id.otherFloorSpinner);
	}
	
	/**
	 * initializeButtons
	 * 
	 * Initializes all buttons.
	 */
	private void initializeButtons(){
		//Create floor button.
		createFloor = (Button)findViewById(R.id.createFloorButton);
		createFloor.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Intent to return values from Floor window.
				Intent data = new Intent();
				switch(radioButtonPressed){
				case 1:
					data.putExtra("1v1","Floor");
					data.putExtra("1v2","All-Wood Joist/Truss" + " "  + AWoodTrussSpinner.getSelectedItem().toString());
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
					data.putExtra("1v1","Floor");
					data.putExtra("1v2","Steel Frame, 16in o.c.," + " "  + steel16Spinner.getSelectedItem().toString());
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
					data.putExtra("1v1","Floor");
					data.putExtra("1v2","Steel Frame, 24in o.c.," + " "  + steel24Spinner.getSelectedItem().toString());
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
					data.putExtra("1v1","Floor");
					data.putExtra("1v2","Insulated Panels" + " "  + sIPSpinner.getSelectedItem().toString());
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
					data.putExtra("1v1","Floor");
					data.putExtra("1v2","Heated Slab-On-Grade");
					data.putExtra("1v3","0");
					data.putExtra("1v4","");
					data.putExtra("1v5","0");
					data.putExtra("1v6","0");
					data.putExtra("1v7","0");
					data.putExtra("1v8",sOGH_EditText.getText().toString());
					data.putExtra("1v9","0");
					data.putExtra("1v10","0");
					data.putExtra("1v11","0");
					break;
				case 6:
					data.putExtra("1v1","Floor");
					data.putExtra("1v2","Unheated Slab-On-Grade");
					data.putExtra("1v3","0");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","0");
					data.putExtra("1v7","0");
					data.putExtra("1v8",sOGU_EditText.getText().toString());
					data.putExtra("1v9","0");
					data.putExtra("1v10","0");
					data.putExtra("1v11","0");
					break;
				case 7:
					data.putExtra("1v1","Floor");
					data.putExtra("1v2","Other" + " "  + otherSpinner.getSelectedItem().toString());
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
		//Cancel button.
		Cancel = (Button)findViewById(R.id.floorCancelButton);
		Cancel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}

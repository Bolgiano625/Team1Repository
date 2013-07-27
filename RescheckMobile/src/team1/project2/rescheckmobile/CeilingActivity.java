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

public class CeilingActivity extends Activity{
	//Flat Ceiling or Scissor Truss RadioButton.
	private RadioButton fCOST_RadioButton;
	//Cathedral Ceiling(no atic) RadioButton.
	private RadioButton cCNA_RadioButton;
	//Raised or Energy Truss RadioButton.
	private RadioButton rOET_RadioButton;
	//Steel Truss RadioButton.
	private RadioButton sTruss_RadioButton;
	//Steel Joist/Rafter, 16in. o.c.-Member Size: RadioButton.
	private RadioButton sJR16_RadioButton;
	//Steel Joist/Rafter, 26in. o.c.-Member Size: RadioButton.
	private RadioButton sJR24_RadioButton;
	//Structural Insulated Panels(SIPs) RadioButton.
	private RadioButton sIP_RadioButton;
	//Other RadioButton.
	private RadioButton other_RadioButton;
	//Steel Joist/Rafter, 16in. o.c.-Member Size: Spinner.
	private Spinner sJR16_Spinner;
	//Steel Joist/Rafter, 24in. o.c.-Member Size: Spinner.
	private Spinner sJR24_Spinner;
	//Create Ceiling Button.
	private Button createCeiling_Button;
	//Cancel Button.
	private Button cancel_Button;
	//Int value for radio button chosen.
	private int radioButtonPressed = 0;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ceiling_layout);
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
		//Flat Ceiling or Scissor Truss RadioButton.
		fCOST_RadioButton = (RadioButton)findViewById(R.id.fCOSTRadioButton);
		fCOST_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 1;
				//I work now!!!
			}
		});
		//Cathedral Ceiling(no atic) RadioButton.
		cCNA_RadioButton = (RadioButton)findViewById(R.id.cCNARadioButton);
		cCNA_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 2;
				//I work now!!!
			}
		});
		//Raised or Energy Truss RadioButton.
		rOET_RadioButton = (RadioButton)findViewById(R.id.rOETRadioButton);
		rOET_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 3;
				//I work now!!!
			}
		});
		//Steel Truss RadioButton.
		sTruss_RadioButton = (RadioButton)findViewById(R.id.sTrussRadioButton);
		sTruss_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 4;
				//I work now!!!
			}
		});
		//Steel Joist/Rafter, 16in. o.c.-Member Size: RadioButton.
		sJR16_RadioButton = (RadioButton)findViewById(R.id.sJR16RadioButton);
		sJR16_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 5;
				//I work now!!!
			}
		});
		//Steel Joist/Rafter, 24in. o.c.-Member Size: RadioButton.
		sJR24_RadioButton = (RadioButton)findViewById(R.id.sJR24RadioButton);
		sJR24_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 6;
				//I work now!!!
			}
		});
		//Steel Joist/Rafter, 24in. o.c.-Member Size: RadioButton.
		sIP_RadioButton = (RadioButton)findViewById(R.id.sIPRadioButton);
		sIP_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 7;
				//I work now!!!
			}
		});
		//Other RadioButton.
		other_RadioButton = (RadioButton)findViewById(R.id.otherRadioButton);
		other_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 8;
				//I work now!!!
			}
		});
	}
	
	/**
	 * initializeSpinners
	 * 
	 * Initializes all spinners.
	 */
	private void initializeSpinners(){
		//Steel Joist/Rafter, 16in. o.c.-Member Size: Spinner.
		sJR16_Spinner = (Spinner)findViewById(R.id.sJR16Spinner);
		//Steel Joist/Rafter, 24in. o.c.-Member Size: Spinner.
		sJR24_Spinner = (Spinner)findViewById(R.id.sJR24Spinner);
	}
	
	/**
	 * initializeButtons
	 * 
	 * Initializes all buttons.
	 */
	private void initializeButtons(){
		//Create Ceiling Button. 
		createCeiling_Button = (Button)findViewById(R.id.createCeilingButton);
		createCeiling_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//Intent to return values from Ceiling window.
				Intent data = new Intent();
				//Intent that returns U-Factor.
				//Intent c = new Intent(CeilingActivity.this, CalculateActivity.class);
				//startActivityForResult(c,0);
				switch(radioButtonPressed){
				case 1:
					data.putExtra("1v1","Ceiling");
					data.putExtra("1v2","Flat or Scissor Truss");
					data.putExtra("1v3","0ft^2");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					break;
				case 2:
					data.putExtra("1v1","Ceiling");
					data.putExtra("1v2","Cathedral");
					data.putExtra("1v3","0ft^2");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					break;
				case 3:
					data.putExtra("1v1","Ceiling");
					data.putExtra("1v2","Raised or Energy Truss");
					data.putExtra("1v3","0ft^2");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					break;
				case 4:
					data.putExtra("1v1","Ceiling");
					data.putExtra("1v2","Steel Truss");
					data.putExtra("1v3","0ft^2");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					break;
				case 5:
					data.putExtra("1v1","Ceiling");
					data.putExtra("1v2","Steel Joist/Rafter,16in.o.c.," + sJR16_Spinner.getSelectedItem().toString());
					data.putExtra("1v3","0ft^2");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					break;
				case 6:
					data.putExtra("1v1","Ceiling");
					data.putExtra("1v2","Steel Joist/Rafter,24in.o.c.," + sJR24_Spinner.getSelectedItem().toString());
					data.putExtra("1v3","0ft^2");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					break;
				case 7:
					data.putExtra("1v1","Ceiling");
					data.putExtra("1v2","Structural Insulated Panels");
					data.putExtra("1v3","0ft^2");
					data.putExtra("1v4","");
					data.putExtra("1v5","0");
					break;
				case 8:
					data.putExtra("1v1","Ceiling");
					data.putExtra("1v2","Other");
					data.putExtra("1v3","0ft^2");
					data.putExtra("1v4","");
					data.putExtra("1v5","");
					break;
				}
				setResult(RESULT_OK, data);
				finish();
			}
		});
		//Cancel Button. 
		cancel_Button = (Button)findViewById(R.id.cancelCeilingButton);
		cancel_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
					finish();	
			}
						
		});
	}
}

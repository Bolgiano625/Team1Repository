package team1.project2.rescheckmobile;

import java.util.LinkedList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

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
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ceiling_layout);
	
		initializeRadioButtons();
	}
	
	/**
	 * initializeRadioButtons
	 * 
	 * Initializes all radio buttons.
	 */
	private void initializeRadioButtons(){
		fCOST_RadioButton = (RadioButton)findViewById(R.id.fCOSTRadioButton);
		fCOST_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//I work now!!!
			}
		});
	}
}

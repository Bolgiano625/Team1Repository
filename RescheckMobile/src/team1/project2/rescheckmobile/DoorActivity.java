package team1.project2.rescheckmobile;

import java.util.LinkedList;

import team1.project2.rescheckmobile.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class DoorActivity extends Activity{
	//Solid Door RadioButton.
	private RadioButton sDO_RadioButton;
	//Glass Door RadioButton.
	private RadioButton gDO_RadioButton;
	//Create Door Button.
	private Button createDoor_Button;
	//Cancel Button.
	private Button cancel_Button;
	//Int value for radio button chosen.
	private int radioButtonPressed = 0;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.door_layout);
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
	//Solid Door RadioButton.
	sDO_RadioButton = (RadioButton)findViewById(R.id.solidDoorRadioButton);
	sDO_RadioButton.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View v) {
			radioButtonPressed = 1;
			//I work now!!!
		}
	});
	//Glass Door RadioButton.
	gDO_RadioButton = (RadioButton)findViewById(R.id.glassDoorRadioButton);
	gDO_RadioButton.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View v) {
			radioButtonPressed = 2;
			//I work now!!!
		}
	});
}

private void initializeButtons(){
	//Create Door Button. 
	createDoor_Button = (Button)findViewById(R.id.createDoorButton);
	createDoor_Button.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View arg0) {
			//Intent to return values from Door window.
			Intent data = new Intent();
			switch(radioButtonPressed){
			case 1:
				data.putExtra("1v1","Door");
				data.putExtra("1v2","Solid");
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
				data.putExtra("1v1","Door");
				data.putExtra("1v2","Glass");
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
	cancel_Button = (Button)findViewById(R.id.cancelDoorButton);
	cancel_Button.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View arg0) {
			finish();		
		}
					
	});
}
};

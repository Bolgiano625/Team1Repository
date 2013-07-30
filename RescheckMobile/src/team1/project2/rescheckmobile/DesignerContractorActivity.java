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

public class DesignerContractorActivity extends Activity{
	//Create Crawl Button.
	private Button update_Button;
	//Cancel Crawl Button.
	private Button cancel_Button;
	private EditText fN_EditText;
	private EditText lN_EditText;
	private EditText address_EditText;
	private EditText city_EditText;
	private EditText state_EditText;
	private EditText zipCode_EditText;
	private EditText phone_EditText;
	private EditText email_EditText;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.designercontractor_layout);
		//Instantiates all TextFields.
		initializeEditTexts();
		//Instantiates all Buttons.
		initializeButtons();
	}
	
	/**
	 * initializeEditTexts
	 * 
	 * Initializes all text fields.
	 */
	private void initializeEditTexts(){
		//Title text field.
		fN_EditText = (EditText)findViewById(R.id.fNDesignerContractor);
		//Title text field.
		lN_EditText = (EditText)findViewById(R.id.lNDesignerContractor);
		//Conditioned Floor Area text field.
		address_EditText = (EditText)findViewById(R.id.addressDesignerContractor);
		//Notes text field.
		city_EditText = (EditText)findViewById(R.id.cityDesignerContractor);
		//Notes text field.
		state_EditText = (EditText)findViewById(R.id.stateDesignerContractor);
		//Notes text field.
		zipCode_EditText = (EditText)findViewById(R.id.zipCodeDesignerContractor);
		//Title text field.
		phone_EditText = (EditText)findViewById(R.id.phoneDesignerContractor);
		//Title text field.
		email_EditText = (EditText)findViewById(R.id.emailDesignerContractor);
	}
	
	/**
	 * initializeButtons
	 * 
	 * Initializes all buttons.
	 */
	private void initializeButtons(){
		//Create Ceiling Button. 
		update_Button = (Button)findViewById(R.id.updateDCButton);
		update_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//Intent to return values from Ceiling window.
				Intent data = new Intent();
					data.putExtra("1v15",address_EditText.getText().toString());
					data.putExtra("1v16",city_EditText.getText().toString());
					data.putExtra("1v17",state_EditText.getText().toString());
					data.putExtra("1v18",zipCode_EditText.getText().toString());
					data.putExtra("1v19",phone_EditText.getText().toString());
					data.putExtra("1v20",email_EditText.getText().toString());
					data.putExtra("1v21",fN_EditText.getText().toString());
					data.putExtra("1v22",lN_EditText.getText().toString());
					setResult(RESULT_OK, data);
				finish();
			}
		});
		//Cancel Button. 
		cancel_Button = (Button)findViewById(R.id.cancelDCButton);
		cancel_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
					finish();	
			}
						
		});
	}
}

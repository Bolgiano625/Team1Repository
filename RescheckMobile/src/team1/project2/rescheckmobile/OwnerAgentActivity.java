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

public class OwnerAgentActivity extends Activity{
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
		setContentView(R.layout.owneragent_layout);
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
		fN_EditText = (EditText)findViewById(R.id.fNOwnerAgent);
		//Title text field.
		lN_EditText = (EditText)findViewById(R.id.lNOwnerAgent);
		//Conditioned Floor Area text field.
		address_EditText = (EditText)findViewById(R.id.addressOwnerAgent);
		//Notes text field.
		city_EditText = (EditText)findViewById(R.id.cityOwnerAgent);
		//Notes text field.
		state_EditText = (EditText)findViewById(R.id.stateOwnerAgent);
		//Notes text field.
		zipCode_EditText = (EditText)findViewById(R.id.zipCodeOwnerAgent);
		//Title text field.
		phone_EditText = (EditText)findViewById(R.id.phoneOwnerAgent);
		//Title text field.
		email_EditText = (EditText)findViewById(R.id.emailOwnerAgent);
	}
	
	/**
	 * initializeButtons
	 * 
	 * Initializes all buttons.
	 */
	private void initializeButtons(){
		//Create Ceiling Button. 
		update_Button = (Button)findViewById(R.id.updateOAButton);
		update_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//Intent to return values from Ceiling window.
				Intent data = new Intent();
					data.putExtra("1v7",address_EditText.getText().toString());
					data.putExtra("1v8",city_EditText.getText().toString());
					data.putExtra("1v9",state_EditText.getText().toString());
					data.putExtra("1v10",zipCode_EditText.getText().toString());
					data.putExtra("1v11",phone_EditText.getText().toString());
					data.putExtra("1v12",email_EditText.getText().toString());
					data.putExtra("1v13",fN_EditText.getText().toString());
					data.putExtra("1v14",lN_EditText.getText().toString());
					setResult(RESULT_OK, data);
				finish();
			}
		});
		//Cancel Button. 
		cancel_Button = (Button)findViewById(R.id.cancelOAButton);
		cancel_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
					finish();	
			}
						
		});
	}
}

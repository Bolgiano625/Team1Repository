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

public class SitePermitActivity extends Activity{
	//Create Crawl Button.
	private Button update_Button;
	//Cancel Crawl Button.
	private Button cancel_Button;
	private EditText address_EditText;
	private EditText city_EditText;
	private EditText state_EditText;
	private EditText zipCode_EditText;
	private EditText permitNumber_EditText;
	private EditText permitDate_EditText;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sitepermit_layout);
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
		permitDate_EditText = (EditText)findViewById(R.id.permitDateSitePermit);
		//Title text field.
		permitNumber_EditText = (EditText)findViewById(R.id.permitNumberSitePermit);
		//Conditioned Floor Area text field.
		address_EditText = (EditText)findViewById(R.id.addressSitePermit);
		//Notes text field.
		city_EditText = (EditText)findViewById(R.id.citySitePermit);
		//Notes text field.
		state_EditText = (EditText)findViewById(R.id.stateSitePermit);
		//Notes text field.
		zipCode_EditText = (EditText)findViewById(R.id.zipCodeSitePermit);
	}
	
	/**
	 * initializeButtons
	 * 
	 * Initializes all buttons.
	 */
	private void initializeButtons(){
		//Create Ceiling Button. 
		update_Button = (Button)findViewById(R.id.updateSPButton);
		update_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//Intent to return values from Ceiling window.
				Intent data = new Intent();
					data.putExtra("1v1",address_EditText.getText().toString());
					data.putExtra("1v2",city_EditText.getText().toString());
					data.putExtra("1v3",state_EditText.getText().toString());
					data.putExtra("1v4",zipCode_EditText.getText().toString());
					data.putExtra("1v5",permitNumber_EditText.getText().toString());
					data.putExtra("1v6",permitDate_EditText.getText().toString());
					setResult(RESULT_OK, data);
				finish();
			}
		});
		//Cancel Button. 
		cancel_Button = (Button)findViewById(R.id.cancelSPButton);
		cancel_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
					finish();	
			}
						
		});
	}
}

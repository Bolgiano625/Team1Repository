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

public class CrawlActivity extends Activity{
	//Create Crawl Button.
	private Button createCrawl_Button;
	//Cancel Crawl Button.
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
		setContentView(R.layout.crawl_layout);
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
		sCOM_RadioButton = (RadioButton)findViewById(R.id.sCOMRadioButton);
		sCOM_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 1;
				//I work now!!!
			}
		});
		//Masonry Block w/ Empty Cells RadioButton.
		mBWEC_RadioButton = (RadioButton)findViewById(R.id.mBWECRadioButton);
		mBWEC_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 2;
				//I work now!!!
			}
		});
		//Masonry Block w/ Integral Insulation RadioButton.
		mBWII_RadioButton = (RadioButton)findViewById(R.id.mBWIIRadioButton);
		mBWII_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 3;
				//I work now!!!
			}
		});
		//Wood Frame RadioButton.
		wF_RadioButton = (RadioButton)findViewById(R.id.wFRadioButton);
		wF_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 4;
				//I work now!!!
			}
		});
		//Insulated Concrete Forms RadioButton.
		iCF_RadioButton = (RadioButton)findViewById(R.id.iCFRadioButton);
		iCF_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				radioButtonPressed = 5;
				//I work now!!!
			}
		});
		//Other RadioButton.
		other_RadioButton = (RadioButton)findViewById(R.id.otherCrawlRadioButton);
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
		wallHeight_EditText = (EditText)findViewById(R.id.wHCrawl);
		//Conditioned Floor Area text field.
		dBG_EditText = (EditText)findViewById(R.id.dBGCrawl);
		//Notes text field.
		dOI_EditText = (EditText)findViewById(R.id.dOICrawl);
		//Notes text field.
		dBIG_EditText = (EditText)findViewById(R.id.dBIGCrawl);
	}
	
	/**
	 * initializeButtons
	 * 
	 * Initializes all buttons.
	 */
	private void initializeButtons(){
		//Create Ceiling Button. 
		createCrawl_Button = (Button)findViewById(R.id.createCrawlButton);
		createCrawl_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//Intent to return values from Ceiling window.
				Intent data = new Intent();
				//Intent to calculate crawl value.
				switch(radioButtonPressed){
				case 1:
					data.putExtra("1v1","Crawl");
					data.putExtra("1v2","Solid Concrete or Masonry");
					data.putExtra("1v3","0ft^2");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","");
					data.putExtra("1v7","");
					data.putExtra("1v8",dOI_EditText.getText() + "ft");
					data.putExtra("1v9",wallHeight_EditText.getText() + "ft");
					data.putExtra("1v10",dBG_EditText.getText() + "ft");
					data.putExtra("1v11",dBIG_EditText.getText() + "ft");
				case 2:
					data.putExtra("1v1","Crawl");
					data.putExtra("1v2","Masonry Block w/ Empty Cells");
					data.putExtra("1v3","0ft^2");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","");
					data.putExtra("1v7","");
					data.putExtra("1v8",dOI_EditText.getText() + "ft");
					data.putExtra("1v9",wallHeight_EditText.getText() + "ft");
					data.putExtra("1v10",dBG_EditText.getText() + "ft");
					data.putExtra("1v11",dBIG_EditText.getText() + "ft");
				case 3:
					data.putExtra("1v1","Crawl");
					data.putExtra("1v2","Masonry Block w/ Integral Insulation");
					data.putExtra("1v3","0ft^2");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","");
					data.putExtra("1v7","");
					data.putExtra("1v8",dOI_EditText.getText() + "ft");
					data.putExtra("1v9",wallHeight_EditText.getText() + "ft");
					data.putExtra("1v10",dBG_EditText.getText() + "ft");
					data.putExtra("1v11",dBIG_EditText.getText() + "ft");
				case 4:
					data.putExtra("1v1","Crawl");
					data.putExtra("1v2","Wood Frame");
					data.putExtra("1v3","0ft^2");
					data.putExtra("1v4","0");
					data.putExtra("1v5","0");
					data.putExtra("1v6","");
					data.putExtra("1v7","");
					data.putExtra("1v8",dOI_EditText.getText() + "ft");
					data.putExtra("1v9",wallHeight_EditText.getText() + "ft");
					data.putExtra("1v10",dBG_EditText.getText() + "ft");
					data.putExtra("1v11",dBIG_EditText.getText() + "ft");
				case 5:
					data.putExtra("1v1","Crawl");
					data.putExtra("1v2","Insulated Concrete Forms");
					data.putExtra("1v3","0ft^2");
					data.putExtra("1v4","");
					data.putExtra("1v5","0");
					data.putExtra("1v6","");
					data.putExtra("1v7","");
					data.putExtra("1v8",dOI_EditText.getText() + "ft");
					data.putExtra("1v9",wallHeight_EditText.getText() + "ft");
					data.putExtra("1v10",dBG_EditText.getText() + "ft");
					data.putExtra("1v11",dBIG_EditText.getText() + "ft");
				case 6:
					data.putExtra("1v1","Crawl");
					data.putExtra("1v2","Other");
					data.putExtra("1v3","0ft^2");
					data.putExtra("1v4","");
					data.putExtra("1v5","");
					data.putExtra("1v6","");
					data.putExtra("1v7","");
					data.putExtra("1v8",dOI_EditText.getText() + "ft");
					data.putExtra("1v9",wallHeight_EditText.getText() + "ft");
					data.putExtra("1v10",dBG_EditText.getText() + "ft");
					data.putExtra("1v11",dBIG_EditText.getText() + "ft");
				}
				data.putExtra("result","");
				data.putExtra("result","");
				data.putExtra("result","");
				data.putExtra("result","");
				setResult(RESULT_OK, data);
				finish();
			}
		});
		//Cancel Button. 
		cancel_Button = (Button)findViewById(R.id.cancelCrawlButton);
		cancel_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
					finish();	
			}
						
		});
	}
}

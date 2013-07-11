package team1.project2.rescheckmobile;

import java.util.LinkedList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class CrawlActivity extends Activity{
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
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ceiling_layout);
		//Instantiates all RadioButtons. 
		initializeRadioButtons();	
		//Instantiates all TextFields.
		initializeEditTexts();
	}
	
	/**
	 * initializeRadioButtons
	 * 
	 * Initializes all radio buttons.
	 */
	private void initializeRadioButtons(){
		//Solid Concrete or Masonry RadioButton.
		sCOM_RadioButton = (RadioButton)findViewById(R.id.fCOSTRadioButton);
		sCOM_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//I work now!!!
			}
		});
		//Masonry Block w/ Empty Cells RadioButton.
		mBWEC_RadioButton = (RadioButton)findViewById(R.id.cCNARadioButton);
		mBWEC_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//I work now!!!
			}
		});
		//Masonry Block w/ Integral Insulation RadioButton.
		mBWII_RadioButton = (RadioButton)findViewById(R.id.rOETRadioButton);
		mBWII_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//I work now!!!
			}
		});
		//Wood Frame RadioButton.
		wF_RadioButton = (RadioButton)findViewById(R.id.sTrussRadioButton);
		wF_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//I work now!!!
			}
		});
		//Insulated Concrete Forms RadioButton.
		iCF_RadioButton = (RadioButton)findViewById(R.id.sJR16RadioButton);
		iCF_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//I work now!!!
			}
		});
		//Other RadioButton.
		other_RadioButton = (RadioButton)findViewById(R.id.sJR24RadioButton);
		other_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//I work now!!!
			}
		});
		//Other RadioButton.
		other_RadioButton = (RadioButton)findViewById(R.id.otherRadioButton);
		other_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
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
}

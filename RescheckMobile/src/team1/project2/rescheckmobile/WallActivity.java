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

/**
 * WallActivity Class
 * --------------------------------
 * Jeremy Vance
  * @author jvance2
 *
 */

public class WallActivity extends Activity {
	//Wood Frame 16" RadioButton.
	private RadioButton wF16_RadioButton;
	//Wood Frame 24" RadioButton.
	private RadioButton wF24_RadioButton;
	//Steel Frame 16" RadioButton.
	private RadioButton sF16_RadioButton;
	//Steel Frame 24" RadioButton.
	private RadioButton sF24_RadioButton;
	//Solid Concrete or Masonry Spinner.
	private Spinner sCOM_Spinner;
	//Solid Concrete or Masonry RadioButton.
	private RadioButton sCOM_RadioButton;
	//Masonry Block w/ empty cells Spinner.
	private Spinner mBWEC_Spinner;
	//Masonry Block w/ empty cells RadioButton.
	private RadioButton mBWEC_RadioButton;
	//Masonry Block w/ integral Insulation Spinner.
	private Spinner mBWII_Spinner;
	//Log Species RadioButton.
	private Spinner lS_Spinner;
	//Log Width RadioButton.
	private Spinner lW_Spinner;
	//Masonry Block w/ integral Insulation RadioButton.
	private RadioButton mBWII_RadioButton;
	//log RadioButton.
	private RadioButton lOG_RadioButton;
	//Structural insulated panel RadioButton
	private RadioButton sIP_RadioButton;
	//Insulated concrete forms RadioButton.
	private RadioButton iCF_RadioButton;
	//Other (U-Factor Options) RadioButton.
	private RadioButton oUFO_RadioButton;
	//Create Wall Button.
	private Button createWall_Button;
	//Cancel Button.
	private Button cancel_Button;
	//Int value for radio button chosen.
	private int radioButtonPressed = 0;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wall_layout);
		//Instantiates all RadioButtons. 
		initializeRadioButtons();
		//Instantiates all Spinners.
		initializeSpinners();
		//Instantiates all buttons.
		initializeButtons();
	}

	private void initializeRadioButtons(){
			//Wood Frame 16" RadioButton.
			wF16_RadioButton = (RadioButton)findViewById(R.id.wF16WallRadioButton);
			wF16_RadioButton.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					radioButtonPressed = 1;
				}
			});

			//Wood Frame 24" RadioButton.
			wF24_RadioButton = (RadioButton)findViewById(R.id.wF24WallRadioButton);
			wF24_RadioButton.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					radioButtonPressed = 2;
				}
			});

			//Steel Frame 16" RadioButton.
			sF16_RadioButton = (RadioButton)findViewById(R.id.sF16WallRadioButton);
			sF16_RadioButton.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					radioButtonPressed = 3;
				}
			});
		
			//Steel Frame 24" RadioButton.
			sF24_RadioButton = (RadioButton)findViewById(R.id.sF24WallRadioButton);
			sF24_RadioButton.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					radioButtonPressed = 4;
				}
			});
			
			//Solid Concrete or Masonry RadioButton.
			sCOM_RadioButton = (RadioButton)findViewById(R.id.sCOMWallRadioButton);
			sCOM_RadioButton.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					radioButtonPressed = 5;
				}
			});
		
			//Masonry Block w/ empty cells RadioButton.
			mBWEC_RadioButton = (RadioButton)findViewById(R.id.mBWECWallRadioButton);
			mBWEC_RadioButton.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					radioButtonPressed = 6;
				}
			});
		
			//Masonry Block w/ empty cells RadioButton.
			mBWII_RadioButton = (RadioButton)findViewById(R.id.mBWIIWallRadioButton);
			mBWII_RadioButton.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					radioButtonPressed = 7;
				}
			});
		
			//Log RadioButton.
			lOG_RadioButton = (RadioButton)findViewById(R.id.lSWallRadioButton);
			lOG_RadioButton.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					radioButtonPressed = 8;
				}
			});
			
			//Structural insulated panel RadioButton.
			sIP_RadioButton = (RadioButton)findViewById(R.id.sIPWallRadioButton);
			sIP_RadioButton.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					radioButtonPressed = 9;
				}
			});
			
			//Insulated concrete forms RadioButton.
			iCF_RadioButton = (RadioButton)findViewById(R.id.iCFWallRadioButton);
			iCF_RadioButton.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					radioButtonPressed = 10;
				}
			});

			//Other (U-Factor Options) RadioButton.
			oUFO_RadioButton = (RadioButton)findViewById(R.id.otherWallRadioButton);
			oUFO_RadioButton.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					radioButtonPressed = 11;
				}
			});
		}
		
	private void initializeSpinners(){
			//Masonry Block w/ empty cells Spinner.
			mBWEC_Spinner = (Spinner)findViewById(R.id.mBWECWallSpinner);
			//Masonry Block w/ integral Insulation Spinner.
			mBWII_Spinner = (Spinner)findViewById(R.id.mBWIIWallSpinner);
			//Solid Concrete or Masonry Spinner.
			sCOM_Spinner = (Spinner)findViewById(R.id.sCOMWallSpinner);
			lS_Spinner = (Spinner)findViewById(R.id.lSWallSpinner);
			lW_Spinner = (Spinner)findViewById(R.id.lTNLWallSpinner);
	}
		
	private void initializeButtons(){
			//Create Wall Button. 
			createWall_Button = (Button)findViewById(R.id.createWallButton);
			createWall_Button.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View arg0) {
					//Intent to return values from Skylight window.
					Intent data = new Intent();
					switch(radioButtonPressed){
					case 1:
						data.putExtra("1v1","Wall");
						data.putExtra("1v2","Wood Frame, 16in.o.c.");
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
						data.putExtra("1v1","Wall");
						data.putExtra("1v2","Wood Frame, 24in.o.c.");
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
						data.putExtra("1v1","Wall");
						data.putExtra("1v2","Steel Frame, 16in.o.c.");
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
						data.putExtra("1v1","Wall");
						data.putExtra("1v2","Steel Frame, 24in.o.c.");
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
						data.putExtra("1v1","Wall");
						data.putExtra("1v2","Solid Concrete or Masonry w/" + sCOM_Spinner.getSelectedItem().toString());
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
					case 6:
						data.putExtra("1v1","Wall");
						data.putExtra("1v2","Masonry Block w/ Empty Cells:" + mBWEC_Spinner.getSelectedItem().toString());
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
					case 7:
						data.putExtra("1v1","Wall");
						data.putExtra("1v2","Masonry Block w/ Integral Insulation:" + mBWII_Spinner.getSelectedItem().toString());
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
					case 8:
						data.putExtra("1v1","Wall");
						data.putExtra("1v2",lW_Spinner.getSelectedItem().toString() + ". " + lS_Spinner.getSelectedItem().toString() + " Logs");
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
					case 9:
						data.putExtra("1v1","Wall");
						data.putExtra("1v2","Structural Insulated Panels");
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
					case 10:
						data.putExtra("1v1","Wall");
						data.putExtra("1v2","Insulated Concrete Forms");
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
					case 11:
						data.putExtra("1v1","Wall");
						data.putExtra("1v2","Other");
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
			cancel_Button = (Button)findViewById(R.id.cancelWallButton);
			cancel_Button.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View arg0) {
					finish();
				}
							
			});
	}
}
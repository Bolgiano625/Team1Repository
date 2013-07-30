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

public class ProjectDetailsActivity extends Activity{
	//Create Ceiling Button.
	private Button updateSP_Button;
	private Button updateOA_Button;
	private Button updateDC_Button;
	//Cancel Button.
	private Button cancel_Button;
	
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projectdetails_layout);
		//Instantiates all buttons.
		initializeButtons();
	}
	
	/**
	 * initializeButtons
	 * 
	 * Initializes all buttons.
	 */
	private void initializeButtons(){
		//Create Ceiling Button. 
		updateSP_Button = (Button)findViewById(R.id.sPDetailsButton);
		updateSP_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//Intent to return values from Ceiling window.
				Intent i = new Intent(ProjectDetailsActivity.this,SitePermitActivity.class);
				startActivityForResult(i, 0);
			}
		});
		//Create Ceiling Button. 
		updateOA_Button = (Button)findViewById(R.id.oADetailsButton);
		updateOA_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//Intent to return values from Ceiling window.
				Intent i = new Intent(ProjectDetailsActivity.this,OwnerAgentActivity.class);
				startActivityForResult(i, 1);
			}
		});
	//Create Ceiling Button. 
	updateDC_Button = (Button)findViewById(R.id.dCDetailsButton);
	updateDC_Button.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View arg0) {
			//Intent to return values from Ceiling window.
			Intent i = new Intent(ProjectDetailsActivity.this,DesignerContractorActivity.class);
			startActivityForResult(i, 2);
		}
	});
		//Cancel Button. 
		cancel_Button = (Button)findViewById(R.id.cancelProjectDetailsButton);
		cancel_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
					finish();	
			}
						
		});
	}
	
	/**
	 * updatesResultsFromAddingComponentsToList
	 * 
	 * Updates the list with a component that is gathered from an intent.
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		  if(resultCode == RESULT_OK){
			  Intent i = new Intent();
			  if(requestCode == 0){
				  	i.putExtra("v1",data.getStringExtra("1v1"));
					i.putExtra("v2",data.getStringExtra("1v2"));
					i.putExtra("v3",data.getStringExtra("1v3"));
					i.putExtra("v4",data.getStringExtra("1v4"));
					i.putExtra("v5",data.getStringExtra("1v5"));
					i.putExtra("v6",data.getStringExtra("1v6"));
					i.putExtra("v7"," ");
					i.putExtra("v8"," ");
					i.putExtra("v9"," ");
					i.putExtra("v10"," ");
					i.putExtra("v11"," ");
					i.putExtra("v12"," ");
					i.putExtra("v13"," ");
					i.putExtra("v14"," ");
					i.putExtra("v15"," ");
					i.putExtra("v16"," ");
					i.putExtra("v17"," ");
					i.putExtra("v18"," ");
					i.putExtra("v19"," ");
					i.putExtra("v20"," ");
					i.putExtra("v21"," ");
					i.putExtra("v22"," ");
			  }
			  else if(requestCode == 1){
				  	i.putExtra("v1"," ");
					i.putExtra("v2"," ");
					i.putExtra("v3"," ");
					i.putExtra("v4"," ");
					i.putExtra("v5"," ");
					i.putExtra("v6"," ");
				  	i.putExtra("v7",data.getStringExtra("1v7"));
					i.putExtra("v8",data.getStringExtra("1v8"));
					i.putExtra("v9",data.getStringExtra("1v9"));
					i.putExtra("v10",data.getStringExtra("1v10"));
					i.putExtra("v11",data.getStringExtra("1v11"));
					i.putExtra("v12",data.getStringExtra("1v12"));
					i.putExtra("v13",data.getStringExtra("1v13"));
					i.putExtra("v14",data.getStringExtra("1v14"));  
					i.putExtra("v15"," ");
					i.putExtra("v16"," ");
					i.putExtra("v17"," ");
					i.putExtra("v18"," ");
					i.putExtra("v19"," ");
					i.putExtra("v20"," ");
					i.putExtra("v21"," ");
					i.putExtra("v22"," ");
			  }
			  else if(requestCode == 2){
				  	i.putExtra("v1"," ");
					i.putExtra("v2"," ");
					i.putExtra("v3"," ");
					i.putExtra("v4"," ");
					i.putExtra("v5"," ");
					i.putExtra("v6"," ");
					i.putExtra("v7"," ");
					i.putExtra("v8"," ");
					i.putExtra("v9"," ");
					i.putExtra("v10"," ");
					i.putExtra("v11"," ");
					i.putExtra("v12"," ");
					i.putExtra("v13"," ");
					i.putExtra("v14"," ");
				  	i.putExtra("v15",data.getStringExtra("1v15"));
					i.putExtra("v16",data.getStringExtra("1v16"));
					i.putExtra("v17",data.getStringExtra("1v17"));
					i.putExtra("v18",data.getStringExtra("1v18"));
					i.putExtra("v19",data.getStringExtra("1v19"));
					i.putExtra("v20",data.getStringExtra("1v20"));
					i.putExtra("v21",data.getStringExtra("1v21"));
					i.putExtra("v22",data.getStringExtra("1v22"));  
			  }
				//i.putExtra("v0",data.getStringExtra("1v0"));
				setResult(RESULT_OK,i);
				finish();
			}
	}
}

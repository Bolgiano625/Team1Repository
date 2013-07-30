package team1.project2.rescheckmobile;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import team1.project2.rescheckmobile.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class ProjectActivity extends Activity{
	/**
	*----------------------------------
	*Christopher T. Bolgiano
	*Start time/date: 3:30pm, 7/5/2013
	*End time/date: 5:18pm, 7/5/13
	*----------------------------------
	**/
	//Instance of this type.
	public static ProjectActivity projectTab;
	//Instance of the Envelope tab.
	private static EnvelopeActivity envelopeTab;
	//TextField for the title of the project.
	public static EditText title_EditText;
	//Button that will save the project.
	private Button save_Button;
	//TextView that displays Code/Location.
	private TextView codeLocation_TextView;
	//TextView that displays Code.
	private TextView code_TextView;
	//TextView that displays State.
	private TextView state_TextView;
	//TextView that stores city.
	private TextView city_TextView;
	//TextView that displays County.
	private TextView county_TextView;
	//TextView that displays Project Type.
	private TextView projectType_TextView;
	//TextView that displays New Construction.
	private TextView newConstruction_TextView;
	//TextView that displays Addition.
	private TextView addition_TextView;
	//TextView that displays Alteration.
	private TextView alteration_TextView;
	//TextView that displays Compliance Method.
	private TextView complianceMethod_TextView;
	//TextView that displays UA Trade-OFF.
	private TextView uATradeOff_TextView;
	//TextView that displays Performance Alternative.
	private TextView performanceAlternative_TextView;
	//TextView that displays Building Characteristics.
	private TextView buildingCharacteristics_TextView;
	//TextView that displays 1 - and 2 - Family.
	private TextView oneAndTwoFamily_TextView;
	//TextView that displays multifamily.
	private TextView multiFamily_TextView;
	//TextView that displays Conditioned Floor Area.
	private TextView conditionedFloorArea_TextView;
	//TextView that displays ft2.
	private TextView ft2_TextView;
	//TextField that stores Conditioned Floor Area.
	public static EditText conditionedFloorArea_EditText;
	//Spinner that stores code values.
	public static Spinner code_Spinner;
	//Spinner that stores state values.
	public static Spinner state_Spinner;
	//Spinner that stores city values.
	public static Spinner city_Spinner;
	//Spinner that stores county values.
	public static Spinner county_Spinner;
	//RadioButton for city.
	public static RadioButton city_RadioButton;
	//RadioButton for county.
	public static RadioButton county_RadioButton;
	//RadioButton for new construction.
	public static RadioButton newConstruction_RadioButton;
	//RadioButton for addition.
	public static RadioButton addition_RadioButton;
	//RadioButton for alteration.
	public static RadioButton alteration_RadioButton;
	//RadioButton for UA Trade-OFF.
	public static RadioButton uATradeOff_RadioButton;
	//RadioButton for performance alteration.
	public static RadioButton performanceAlternative_RadioButton;
	//RadioButton for 1 - and 2 - Family.
	public static RadioButton oneAndTwoFamily_RadioButton;
	//RadioButton for Multifamily.
	public static RadioButton multiFamily_RadioButton;
	//RadioButton for city.
		public static boolean city_boolean = false;
		//RadioButton for county.
		public static boolean county_boolean = false;
		//RadioButton for new construction.
		public static boolean newConstruction_boolean = false;
		//RadioButton for addition.
		public static boolean addition_boolean = false;
		//RadioButton for alteration.
		public static boolean alteration_boolean = false;
		//RadioButton for UA Trade-OFF.
		public static boolean uATradeOff_boolean = false;
		//RadioButton for performance alteration.
		public static boolean performanceAlternative_boolean = false;
		//RadioButton for 1 - and 2 - Family.
		public static boolean oneAndTwoFamily_boolean = false;
		//RadioButton for Multifamily.
		public static boolean multiFamily_boolean = false;
	//Button for project details.
	private Button projectDetails_Button;
	//TextField for notes.
	public static EditText notes_EditText;
	private String notes_String = " ";
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.project_layout);
		
		//Stores all text field.
		initializeEditTexts();
		//Stores all text views.
		initializeTextViews();
		//Stores all Spinners.
		initializeSpinners();
		//Stores all RadioButtons.
		initializeRadioButtons();
		//Stores all Buttons.
		initializeButtons();
	}
	
	/**
	 * initializeEditTexts
	 * 
	 * Initializes all text fields.
	 */
	private void initializeEditTexts(){
		//Title text field.
		title_EditText = (EditText)findViewById(R.id.titleOfProject);
		//Conditioned Floor Area text field.
		conditionedFloorArea_EditText = (EditText)findViewById(R.id.conditionedFloorAreaTextField);
		//Notes text field.
		notes_EditText = (EditText)findViewById(R.id.noteTextArea);
	}
	
	/**
	 * initializeTextViews
	 * 
	 * Initiates all text views.
	 */
	private void initializeTextViews(){
			//Code/Location.
			codeLocation_TextView = (TextView)findViewById(R.id.codeLocation);
			//Code.
			code_TextView = (TextView)findViewById(R.id.code);
			//State.
			state_TextView = (TextView)findViewById(R.id.state);
			//City.
			city_TextView = (TextView)findViewById(R.id.city);
			//County.
			county_TextView = (TextView)findViewById(R.id.county);
			//Project Type.
			projectType_TextView = (TextView)findViewById(R.id.projectType);
			//New Construction.
			newConstruction_TextView = (TextView)findViewById(R.id.newConstruction);
			//Addition.
			addition_TextView = (TextView)findViewById(R.id.addition);
			//Alteration.
			alteration_TextView = (TextView)findViewById(R.id.alteration);
			//Compliance Method.
			complianceMethod_TextView = (TextView)findViewById(R.id.complianceMethod);
			//UA Trade-OFF.
			uATradeOff_TextView = (TextView)findViewById(R.id.uATradeOff);
			//Performance Alternative.
			performanceAlternative_TextView = (TextView)findViewById(R.id.performanceAlternative);
			//Building Characteristics.
			buildingCharacteristics_TextView = (TextView)findViewById(R.id.buildingCharacteristics);
			//1 - and 2 - Family.
			oneAndTwoFamily_TextView = (TextView)findViewById(R.id.oneAndTwoFamily);
			//Multifamily.
			multiFamily_TextView = (TextView)findViewById(R.id.multiFamily);
			//Conditioned Floor Area.
			conditionedFloorArea_TextView = (TextView)findViewById(R.id.conditionedFloorArea);
			//ft2.
			ft2_TextView = (TextView)findViewById(R.id.ft2);
	}
	
	/**
	 * initializeSpinners
	 * 
	 * Initializes all spinners.
	 */
	private void initializeSpinners(){
		//Code Spinner.
		code_Spinner = (Spinner)findViewById(R.id.codeComboBox);
		//State Spinner.
		state_Spinner = (Spinner)findViewById(R.id.stateComboBox);
		//City Spinner.
		city_Spinner = (Spinner)findViewById(R.id.cityComboBox);
		//County Spinner.
		county_Spinner = (Spinner)findViewById(R.id.countyComboBox);
	}
	
	/**
	 * initializeRadioButtons
	 * 
	 * Initializes all radio buttons.
	 */
	private void initializeRadioButtons(){
		//City radio button.
		city_RadioButton = (RadioButton)findViewById(R.id.cityRadioButton);
		city_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				city_boolean = true;
				county_boolean = false;
				System.out.println("RADIOBUTTON WAS CLICKED!!!!!!");
			}
		});
		//County radio button.
		county_RadioButton = (RadioButton)findViewById(R.id.countyRadioButton);
		county_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				city_boolean = false;
				county_boolean = true;				
			}		
		});
		//New construction radio button.
		newConstruction_RadioButton = (RadioButton)findViewById(R.id.newConstructionRadioButton);
		newConstruction_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				newConstruction_boolean = true;
				addition_boolean = false;
				alteration_boolean = false;
			}				
		});
		//Addition radio button.
		addition_RadioButton = (RadioButton)findViewById(R.id.additionRadioButton);
		addition_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				newConstruction_boolean = false;
				addition_boolean = true;
				alteration_boolean = false;				
			}					
		});
		//Alteration radio button.
		alteration_RadioButton = (RadioButton)findViewById(R.id.alterationRadioButton);
		alteration_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				newConstruction_boolean = false;
				addition_boolean = false;
				alteration_boolean = true;				
			}					
		});
		//UA Trade-Off radio button.
		uATradeOff_RadioButton = (RadioButton)findViewById(R.id.uATradeOffRadioButton);
		uATradeOff_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				uATradeOff_boolean = true;
				performanceAlternative_boolean = false;
			}					
		});
		//Performance alternative radio button.
		performanceAlternative_RadioButton = (RadioButton)findViewById(R.id.performanceAlterationRadioButton);
		performanceAlternative_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				uATradeOff_boolean = false;
				performanceAlternative_boolean = true;				
			}					
		});
		//1 and 2 family radio button.
		oneAndTwoFamily_RadioButton = (RadioButton)findViewById(R.id.oneAndTwoFamilyRadioButton);
		oneAndTwoFamily_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				oneAndTwoFamily_boolean = true;
				multiFamily_boolean = false;				
			}					
		});
		//Multifamily radio button.
		multiFamily_RadioButton = (RadioButton)findViewById(R.id.multiFamilyRadioButton);
		multiFamily_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				oneAndTwoFamily_boolean = false;
				multiFamily_boolean = true;				
			}					
		});
		
	}
	
	/**
	 * initializeButtons
	 * 
	 * Initializes all buttons.
	 */
	private void initializeButtons(){
		//Save Project.
		save_Button = (Button)findViewById(R.id.saveProjectButton);
		//System.out.println("HEY I AM RIGHT HERE!");
		save_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//SharedPreferences sP_SharedPreferences = getSharedPreferences("RESCheckPrefs",MODE_PRIVATE); 
				//SharedPreferences.Editor pE_Editor = sP_SharedPreferences.edit();
				System.out.println("SAVING NOW!");
				/*Uri[] intentData = new Uri[4];
				intentData[0] = MainActivity.homeIntent.getData();
				intentData[1] = MainActivity.projectIntent.getData();
				intentData[2] = MainActivity.envelopeIntent.getData();
				intentData[3] = MainActivity.mechanicalIntent.getData();*/
				File path_File = new File(Environment.getExternalStorageDirectory().toString());
				File project_File = new File(path_File,title_EditText.getText().toString());
				try {
					FileWriter fW_FileWriter = new FileWriter(project_File);
					//String intentURIs_String = "";
					//for(int i = 0; i < intentData.length; i++){
						//intentURIs_String = intentURIs_String + intentData[i] + "\n";
					//}
					fW_FileWriter.write(title_EditText.getText().toString() + "!-!");
					fW_FileWriter.write(code_Spinner.getSelectedItem().toString() + "!-!");
					fW_FileWriter.write(state_Spinner.getSelectedItem().toString() + "!-!");
					fW_FileWriter.write(city_Spinner.getSelectedItem().toString() + "!-!");
					fW_FileWriter.write(county_Spinner.getSelectedItem().toString() + "!-!");
					fW_FileWriter.write(city_boolean + "!-!");
					fW_FileWriter.write(county_boolean + "!-!");
					fW_FileWriter.write(newConstruction_boolean + "!-!");
					fW_FileWriter.write(addition_boolean + "!-!");
					fW_FileWriter.write(alteration_boolean + "!-!");
					fW_FileWriter.write(uATradeOff_boolean + "!-!");
					fW_FileWriter.write(performanceAlternative_boolean + "!-!");
					fW_FileWriter.write(oneAndTwoFamily_boolean + "!-!");
					fW_FileWriter.write(multiFamily_boolean + "!-!");
					if(conditionedFloorArea_EditText.getText().toString().equalsIgnoreCase("")){
						fW_FileWriter.write("0" + "!-!");
					}
					else{
						fW_FileWriter.write(conditionedFloorArea_EditText.getText().toString() + "!-!");
					}
					//if(notes_EditText.getText().toString().equalsIgnoreCase("")){
						//fW_FileWriter.write(" " + "!-!");
					//}
					//else{
						fW_FileWriter.write(notes_String + "!-!");
					//}
					System.out.println("ROWS:" + EnvelopeActivity.rowCounter_int);
					if(EnvelopeActivity.rowCounter_int-1 > 0){
						for(int i = 0; i < EnvelopeActivity.rowCounter_int-1; i++){
							TableRow row = EnvelopeActivity.rows_LinkedList.get(i);
							ScrollView temp_ScrollView = (ScrollView)row.getChildAt(0);
							TableRow temp_TableRow = (TableRow)temp_ScrollView.getChildAt(0);
							System.out.println("Children of row:" + temp_TableRow.getChildCount());
							LayoutInflater balloon = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
							TableRow row_TableRow = (TableRow)balloon.inflate(R.layout.row_layout, null);
							TextView index_TextView = (TextView)row_TableRow.findViewById(R.id.indexColumn);
							fW_FileWriter.write(index_TextView.getText() + "!-!");
							final EditText tempComp_EditText = (EditText)temp_TableRow.getChildAt(1);
							fW_FileWriter.write(tempComp_EditText.getText().toString() + "!-!");
							final TextView tempAssembly_EditText = (TextView)temp_TableRow.getChildAt(2);
							fW_FileWriter.write(tempAssembly_EditText.getText() + "!-!");
							final EditText tempGArea_EditText = (EditText)temp_TableRow.getChildAt(3);
							fW_FileWriter.write(tempGArea_EditText.getText() + "!-!");
							final EditText tempCIRV_EditText = (EditText)temp_TableRow.getChildAt(4);
							fW_FileWriter.write(tempCIRV_EditText.getText() + "!-!");
							final EditText tempConIRV_EditText = (EditText)temp_TableRow.getChildAt(5);
							fW_FileWriter.write(tempConIRV_EditText.getText() + "!-!");
							EditText tempUF_EditText = (EditText)temp_TableRow.getChildAt(6);
							fW_FileWriter.write(tempUF_EditText.getText() + "!-!");
							TextView tempSHGC_EditText = (TextView)temp_TableRow.getChildAt(7);
							fW_FileWriter.write(tempSHGC_EditText.getText() + "!-!");
							final EditText tempDOI_EditText = (EditText)temp_TableRow.getChildAt(8);
							fW_FileWriter.write(tempDOI_EditText.getText() + "!-!");
							final EditText tempWH_EditText = (EditText)temp_TableRow.getChildAt(9);
							fW_FileWriter.write(tempWH_EditText.getText() + "!-!");
							final EditText tempDBG_EditText = (EditText)temp_TableRow.getChildAt(10);
							fW_FileWriter.write(tempDBG_EditText.getText() + "!-!");
							final EditText tempDBIG_EditText = (EditText)temp_TableRow.getChildAt(11);
							fW_FileWriter.write(tempDBIG_EditText.getText() + "!-!");
						}
					}
					fW_FileWriter.flush();
					fW_FileWriter.close();
					System.out.println("SAVING COMPLETE!");
					Toast.makeText(ProjectActivity.this, title_EditText.getText().toString() + " has been saved.", Toast.LENGTH_LONG).show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("ERROR SAVING!");
				}
				//SaveProject saveActivity = new SaveProject();
			}
		});
		//Project Details.
		projectDetails_Button = (Button)findViewById(R.id.projectDetailsButton);
		projectDetails_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(ProjectActivity.this,ProjectDetailsActivity.class);
				startActivityForResult(i, 0);
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
				//Project Details String.
				notes_String = "Site/Permit:!Construction Site!-Address:" + data.getStringExtra("v1") + "!-City:" + data.getStringExtra("v2") + "!-State:" + data.getStringExtra("v3") + "!-Zip Code:" + data.getStringExtra("v4") + "!Permit:!-Permit #:" + data.getStringExtra("v5") + "!-Permit Date:" + data.getStringExtra("v6") + "!!Owner/Agent:!!Name!-First Name:" + data.getStringExtra("v13") + "!-Last Name:"  + data.getStringExtra("v14") + "!Contact Information!-Address:" + data.getStringExtra("v7") + "!-City:" + data.getStringExtra("v8") + "!-State:" + data.getStringExtra("v9") + "!-Zip Code:" + data.getStringExtra("v10") + "!-Phone #:" + data.getStringExtra("v11") + "!-E-mail:" + data.getStringExtra("v12") + "!!Designer/Contractor:!Name!-First Name:" + data.getStringExtra("v21") + "!-Last Name:"  + data.getStringExtra("v22") + "!Contact Information!-Address:" + data.getStringExtra("v15") + "!-City:" + data.getStringExtra("v16") + "!-State:" + data.getStringExtra("v17") + "!-Zip Code:" + data.getStringExtra("v18") + "!-Phone #:" + data.getStringExtra("v19") + "!-E-mail:" + data.getStringExtra("v20");
				String temp_String = "Site/Permit:\n\nConstruction Site\n-Address:" + data.getStringExtra("v1") + "\n-City:" + data.getStringExtra("v2") + "\n-State:" + data.getStringExtra("v3") + "\n-Zip Code:" + data.getStringExtra("v4") + "\nPermit:\n-Permit #:" + data.getStringExtra("v5") + "\n-Permit Date:" + data.getStringExtra("v6") + "\n\nOwner/Agent:\n\nName\n-First Name:" + data.getStringExtra("v13") + "\n-Last Name:"  + data.getStringExtra("v14") + "\nContact Information\n-Address:" + data.getStringExtra("v7") + "\n-City:" + data.getStringExtra("v8") + "\n-State:" + data.getStringExtra("v9") + "\n-Zip Code:" + data.getStringExtra("v10") + "\n-Phone #:" + data.getStringExtra("v11") + "\n-E-mail:" + data.getStringExtra("v12") + "\n\nDesigner/Contractor:\n\nName\n-First Name:" + data.getStringExtra("v21") + "\n-Last Name:"  + data.getStringExtra("v22") + "\nContact Information\n-Address:" + data.getStringExtra("v15") + "\n-City:" + data.getStringExtra("v16") + "\n-State:" + data.getStringExtra("v17") + "\n-Zip Code:" + data.getStringExtra("v18") + "\n-Phone #:" + data.getStringExtra("v19") + "\n-E-mail:" + data.getStringExtra("v20");
				notes_EditText.setText(temp_String);
			}
	}
	
	/**
	 * getTitle
	 * 
	 * @return Title of project.
	 */
	public String getProjectTitle(){
		return title_EditText.getText().toString();
	}
	
	/**
	*getCodeSpinner
	*
	*@return code_Spinner Spinner for code selection.
	**/
	public Spinner getCodeSpinner(){
		return code_Spinner;
	}
	
	/**
	*getStateSpinner
	*
	*@return code_Spinner Spinner for state selection.
	**/
	public Spinner getStateSpinner(){
		return state_Spinner;
	}
	
	/**
	*getCitySpinner
	*
	*@return city_Spinner Spinner for city selection.
	**/
	public Spinner getCitySpinner(){
		return city_Spinner;
	}
	
	/**
	*getCountySpinner
	*
	*@return county_Spinner Spinner for county selection.
	**/
	public Spinner getCountySpinner(){
		return county_Spinner;
	}
	
	/**
	 * getCityRadioButton
	 * 
	 * @return city_RadioButton Radio button for city selection.
	 */
	public RadioButton getCityRadioButton(){
		return city_RadioButton;
	}
	
	/**
	 * getCountyRadioButton
	 * 
	 * @return county_RadioButton Radio button for county selection.
	 */
	public RadioButton getCountyRadioButton(){
		return county_RadioButton;
	}
	
	/**
	 * getNewConstructionRadioButton
	 * 
	 * @return newConstruction_RadioButton Radio button for New Construction selection.
	 */
	public RadioButton getNewConstructionRadioButton(){
		return newConstruction_RadioButton;
	}
	
	/**
	 * getAdditionRadioButton
	 * 
	 * @return addition_RadioButton Radio button for addition selection.
	 */
	public RadioButton getAdditionRadioButton(){
		return addition_RadioButton;
	}
	
	/**
	 * getAlterationRadioButton
	 * 
	 * @return alteration_RadioButton Radio button for alteration selection.
	 */
	public RadioButton getAlterationRadioButton(){
		return county_RadioButton;
	}
	
	/**
	 * getUATradeOffRadioButton
	 * 
	 * @return uATradeOff_RadioButton Radio button for UA Trade-OFF selection.
	 */
	public RadioButton getUATradeOffRadioButton(){
		return uATradeOff_RadioButton;
	}
	
	/**
	 * getPerformanceAlternativeRadioButton
	 * 
	 * @return performanceAlternative_RadioButton Radio button for performance alternative selection.
	 */
	public RadioButton getPerformanceAlternativeRadioButton(){
		return performanceAlternative_RadioButton;
	}
	
	/**
	 * getOneAndTwoFamilyRadioButton
	 * 
	 * @return oneAndTwoFamily_RadioButton Radio button for 1 And 2 Family selection.
	 */
	public RadioButton getOneAndTwoFamilyRadioButton(){
		return oneAndTwoFamily_RadioButton;
	}
	
	/**
	 * getMultifamilyRadioButton
	 * 
	 * @return multiFamily_RadioButton Radio button for Multifamily selection.
	 */
	public RadioButton getMultifamilyRadioButton(){
		return multiFamily_RadioButton;
	}
	
	/**
	 * getNotes
	 * 
	 * @return Notes from project.
	 */
	public String getProjectNotes(){
		return notes_EditText.getText().toString();
	}
	
	/**
	 * getProjectTab
	 * 
	 * @return this activity.
	 */
	public ProjectActivity getProjectTab(){
		return this;
	}
}

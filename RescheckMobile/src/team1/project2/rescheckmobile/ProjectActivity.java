package team1.project2.rescheckmobile;
import team1.project2.rescheckmobile.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


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
	private static EditText title_EditText;
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
	private EditText conditionedFloorArea_EditText;
	//Spinner that stores code values.
	private Spinner code_Spinner;
	//Spinner that stores state values.
	private Spinner state_Spinner;
	//Spinner that stores city values.
	private Spinner city_Spinner;
	//Spinner that stores county values.
	private Spinner county_Spinner;
	//RadioButton for city.
	private RadioButton city_RadioButton;
	//RadioButton for county.
	private RadioButton county_RadioButton;
	//RadioButton for new construction.
	private RadioButton newConstruction_RadioButton;
	//RadioButton for addition.
	private RadioButton addition_RadioButton;
	//RadioButton for alteration.
	private RadioButton alteration_RadioButton;
	//RadioButton for UA Trade-OFF.
	private RadioButton uATradeOff_RadioButton;
	//RadioButton for performance alteration.
	private RadioButton performanceAlternative_RadioButton;
	//RadioButton for 1 - and 2 - Family.
	private RadioButton oneAndTwoFamily_RadioButton;
	//RadioButton for Multifamily.
	private RadioButton multiFamily_RadioButton;
	//Button for project details.
	private Button projectDetails_Button;
	//TextField for notes.
	private EditText notes_EditText;
	
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
		city_RadioButton = new RadioButton(this);
		city_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				;				
			}
		});
		//County radio button.
		county_RadioButton = new RadioButton(this);
		county_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				;				
			}		
		});
		//New construction radio button.
		newConstruction_RadioButton = new RadioButton(this);
		newConstruction_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				;				
			}				
		});
		//Addition radio button.
		addition_RadioButton = new RadioButton(this);
		addition_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				;				
			}					
		});
		//Alteration radio button.
		alteration_RadioButton = new RadioButton(this);
		alteration_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				;				
			}					
		});
		//UA Trade-Off radio button.
		uATradeOff_RadioButton = new RadioButton(this);
		uATradeOff_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				;				
			}					
		});
		//Performance alternative radio button.
		performanceAlternative_RadioButton = new RadioButton(this);
		performanceAlternative_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				;				
			}					
		});
		//1 and 2 family radio button.
		oneAndTwoFamily_RadioButton = new RadioButton(this);
		oneAndTwoFamily_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				;				
			}					
		});
		//Multifamily radio button.
		multiFamily_RadioButton = new RadioButton(this);
		multiFamily_RadioButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				;				
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
				projectTab = getProjectTab();
				SaveProject saveActivity = new SaveProject();
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
			if(data.getExtras() != null){
				//Project Details String.
				String temp_String = "Site/Permit:\n\nConstruction Site\n-Address:" + data.getStringExtra("1v1") + "\n-City:" + data.getStringExtra("1v2") + "\n-State:" + data.getStringExtra("1v3") + "\n-Zip Code:" + data.getStringExtra("1v4") + "\nPermit:\n-Permit #:" + data.getStringExtra("1v5") + "\n-Permit Date:" + data.getStringExtra("1v6") + "\n\nOwner/Agent:\n\nName\n-First Name:" + data.getStringExtra("1v13") + "\n-Last Name:"  + data.getStringExtra("1v14") + "\nContact Information\n-Address:" + data.getStringExtra("1v7") + "\n-City:" + data.getStringExtra("1v8") + "\n-State:" + data.getStringExtra("1v9") + "\n-Zip Code:" + data.getStringExtra("1v10") + "\n-Phone #:" + data.getStringExtra("1v11") + "\n-E-mail:" + data.getStringExtra("1v12") + "\n\nDesigner/Contractor:\n\nName\n-First Name:" + data.getStringExtra("1v21") + "\n-Last Name:"  + data.getStringExtra("1v22") + "\nContact Information\n-Address:" + data.getStringExtra("1v15") + "\n-City:" + data.getStringExtra("1v16") + "\n-State:" + data.getStringExtra("1v17") + "\n-Zip Code:" + data.getStringExtra("1v18") + "\n-Phone #:" + data.getStringExtra("1v19") + "\n-E-mail:" + data.getStringExtra("1v20");
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

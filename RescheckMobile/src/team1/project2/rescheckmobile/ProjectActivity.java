package team1.project2.rescheckmobile;
import team1.project2.rescheckmobile.R;
import android.app.Activity;
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
	//TextField for the title of the project.
	private EditText title_EditText;
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
	private RadioButton performanceAlteration_RadioButton;
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
	 * initializeButtons
	 * 
	 * Initializes all button.
	 */
	private void initializeButtons(){
		//Save Project.
		save_Button = (Button)findViewById(R.id.saveProjectButton);
		save_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//What happens when you click save?
			}
		});
		//Project Details.
		projectDetails_Button = (Button)findViewById(R.id.projectDetailsButton);
		projectDetails_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//What happens when you click save?
			}
		});
		
	}
}

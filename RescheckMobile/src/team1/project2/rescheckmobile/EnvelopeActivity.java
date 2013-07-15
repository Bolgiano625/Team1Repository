package team1.project2.rescheckmobile;
import java.util.LinkedList;

import team1.project2.rescheckmobile.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;

/**
 * EnvelopeActivity Class
 * --------------------------------
 * Christopher T. Bolgiano
 * Start time/date 5:30pm, 7/3/13
 * End time/date 6:07pm, 7/3/13
 *---------------------------------
 * @author cbolgiano 
 *
 */
public class EnvelopeActivity extends Activity{
	//Boolean if true capture instance of type.
	public static boolean captureInstaceOfEnvelopeTab = false;
	//Static instance of this class.
	public static EnvelopeActivity envelopeTab;
	//Edit button.
	private Button edit_Button;
	//Duplicate button.
	private Button duplicate_Button;
	//Move up button.
	private Button moveUp_Button;
	//Move down button.
	private Button moveDown_Button;
	//Delete button.
	private Button delete_Button;
	//Ceiling button.
	private Button ceiling_Button;
	//Skylight button.
	private Button skylight_Button;
	//Wall button.
	private Button wall_Button;
	//Window button.
	private Button window_Button;
	//Door button.
	private Button door_Button;
	//Basement button.
	private Button basement_Button;
	//Floor button.
	private Button floor_Button;
	//Crawl button.
	private Button crawl_Button;
	//TableLayout.
	private TableLayout table_TableLayout;
	//Row View.
	private View row_View;
	//Linked list of rows.
	public static LinkedList<EnvelopeRow> rows_LinkedList;
	
	//Ceiling result constant.
	private static final int CEILING_RESULT = 0;
	//Skylight result constant.
	private static final int SKYLIGHT_RESULT = 1;
	//Wall result constant.
	private static final int WALL_RESULT = 2;
	//Window result constant.
	private static final int WINDOW_RESULT = 3;
	//Door result constant.
	private static final int DOOR_RESULT = 4;
	//Basement result constant.
	private static final int BASEMENT_RESULT = 5;
	//Floor result constant.
	private static final int FLOOR_RESULT = 6;
	//Crawl result constant.
	private static final int CRAWL_RESULT = 7;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.envelope_layout);
		rows_LinkedList = new LinkedList<EnvelopeRow>();
		initializeTableLayout();
		instantiateRowButtons();
		instantiateAddButtons();
	}
	
	/**
	 * initializeTableLayout
	 * 
	 * Initializes a table layout to place table rows.
	 */
	private void initializeTableLayout(){
		table_TableLayout = (TableLayout)findViewById(R.id.tableHost);
	}
	
	/**
	 * instantiateRowButtons
	 * 
	 * Instantiates new instances of buttons that will manipulate rows.
	 */
	private void instantiateRowButtons(){
		//Edit button and listener for it.
		edit_Button = (Button)findViewById(R.id.editButton);
		edit_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				
			}
		});
		//Duplicate button and listener for it.
		duplicate_Button = (Button)findViewById(R.id.duplicateButton);
		duplicate_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				
			}
		});
		//Move up button and listener for it.
		moveUp_Button = (Button)findViewById(R.id.moveUpButton);
		moveUp_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
					
			}
		});
		//Move down button and listener for it.
		moveDown_Button = (Button)findViewById(R.id.moveDownButton);
		moveDown_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
		
			}
		});
		//Delete button and listener for it.
		delete_Button = (Button)findViewById(R.id.deleteButton);
		delete_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
			
			}
		});
	}
	
	/**
	 * instantiateAddButtons 
	 * 
	 * Instantiates new instances of buttons that allow a user to add components to their projects.
	 */
	private void instantiateAddButtons(){
		//Ceiling button and listener for it.
		ceiling_Button = (Button)findViewById(R.id.ceilingButton);
		ceiling_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Ceiling window intent.
				Intent i = new Intent(EnvelopeActivity.this,CeilingActivity.class);
				//Request results from activity.
				startActivityForResult(i,CEILING_RESULT);
			}
		});
		//Skylight button and listener for it.
		skylight_Button = (Button)findViewById(R.id.skylightButton);
		skylight_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Skylight window intent.
				Intent i = new Intent(EnvelopeActivity.this,SkylightActivity.class);
				//Request results from activity.
				startActivityForResult(i,SKYLIGHT_RESULT);					
			}
		});
		//Wall button and listener for it.
		wall_Button = (Button)findViewById(R.id.wallButton);
		wall_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
											
			}
		});
		//Window button and listener for it.
		window_Button = (Button)findViewById(R.id.windowButton);
		window_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
											
			}
		});
		//Door button and listener for it.
		door_Button = (Button)findViewById(R.id.doorButton);
		door_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Door window intent.
				Intent i = new Intent(EnvelopeActivity.this,DoorActivity.class);
				//Request results from activity.
				startActivityForResult(i,DOOR_RESULT);									
			}
		});
		//Basement button and listener for it.
		basement_Button = (Button)findViewById(R.id.basementButton);
		basement_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
													
			}
		});
		//Floor button and listener for it.
		floor_Button = (Button)findViewById(R.id.floorButton);
		floor_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Floor window intent.
				Intent i = new Intent(EnvelopeActivity.this,Floor_Layout.class);
				//Request results from activity.
				startActivityForResult(i,FLOOR_RESULT);							
			}
		});
		//Crawl button and listener for it.
		crawl_Button = (Button)findViewById(R.id.crawlButton);
		crawl_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Crawl window intent.
				Intent i = new Intent(EnvelopeActivity.this,CrawlActivity.class);
				//Request results from activity.
				startActivityForResult(i,CRAWL_RESULT);									
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
		//Result from ceiling intent.
		if(resultCode == RESULT_OK && requestCode == CEILING_RESULT){
			if(data.hasExtra("1")){
				Intent i = new Intent(this,EnvelopeRow.class);
				i.putExtra("v1","Ceiling");
				i.putExtra("v2","Flat or Scissor Truss");
				i.putExtra("v3","0ft^2");
				i.putExtra("v4","0");
				i.putExtra("v5","0");
				i.putExtra("v6","0.568");
				i.putExtra("v7","");
				startActivity(i);
				makeComponentRow();
			}
		}
		//Result from skylight intent.
		if(resultCode == RESULT_OK && requestCode == SKYLIGHT_RESULT){
					
		}
		//Result from door intent.
		if(resultCode == RESULT_OK && requestCode == DOOR_RESULT){
							
		}
		//Result from floor intent.
		if(resultCode == RESULT_OK && requestCode == FLOOR_RESULT){
							
		}
		//Result from crawl intent.
		if(resultCode == RESULT_OK && requestCode == CRAWL_RESULT){
							
		}
	}
	
	/**
	 * makeComponentRow
	 * 
	 * Creates a new component row.
	 */
	private void makeComponentRow(){
		LayoutInflater balloon = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		row_View = balloon.inflate(R.layout.row_layout, null);
		table_TableLayout.addView(row_View);
	}
}

package team1.project2.rescheckmobile;
import java.util.LinkedList;

import team1.project2.rescheckmobile.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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
	
	//Linked list of rows.
	public static LinkedList<EnvelopeRow> rows_LinkedList;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.envelope_layout);
		rows_LinkedList = new LinkedList<EnvelopeRow>();
		instantiateRowButtons();
		instantiateAddButtons();
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
				
			}
		});
		//Skylight button and listener for it.
		skylight_Button = (Button)findViewById(R.id.skylightButton);
		skylight_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
									
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
											
			}
		});
		//Crawl button and listener for it.
		crawl_Button = (Button)findViewById(R.id.crawlButton);
		crawl_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
													
			}
		});
	}
}

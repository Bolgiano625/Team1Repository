package team1.project2.rescheckmobile;
import java.util.LinkedList;

import team1.project2.rescheckmobile.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

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
	//Check Compliance button.
	private Button checkCompliance_Button;
	//TableLayout.
	private TableLayout table_TableLayout;
	//Row View.
	private TableRow row_TableRow;
	//Linked list of rows.
	public static LinkedList<TableRow> rows_LinkedList;
	//Row counter.
	public static int rowCounter_int = 1;
	//Move counter.
	private int moveCounter_int = 0;
	//Edit button boolean.
	private boolean edit_boolean = false;
	//Delete button boolean.
	private boolean delete_boolean = false;
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
	//Calculate result constant.
	private static final int CALCULATE_RESULT = 8;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.envelope_layout);
		rows_LinkedList = new LinkedList<TableRow>();
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
				if(rows_LinkedList.size() > 0){
					edit_boolean = true;
					if(moveCounter_int == rows_LinkedList.size()){
						moveCounter_int--;
					}
					TableRow temp_TableRow = (TableRow)rows_LinkedList.get(moveCounter_int);
					ScrollView temp_ScrollView = (ScrollView)temp_TableRow.getChildAt(0);
					TableRow row_TableRow = (TableRow)temp_ScrollView.getChildAt(0);
					EditText tempComponent_EditText = (EditText)row_TableRow.getChildAt(1);
					if(tempComponent_EditText.getText().toString().equals("Ceiling")){
						System.out.println("Text:" + tempComponent_EditText.getText());
						//Ceiling window intent.
						Intent i = new Intent(EnvelopeActivity.this,CeilingActivity.class);
						//Request results from activity.
						startActivityForResult(i,CEILING_RESULT);
					}
					else if(tempComponent_EditText.getText().toString().equals("Skylight")){
						//Skylight window intent.
						Intent i = new Intent(EnvelopeActivity.this,SkylightActivity.class);
						//Request results from activity.
						startActivityForResult(i,SKYLIGHT_RESULT);
					}
					else if(tempComponent_EditText.getText().toString().equals("Wall")){
						//Wall window intent.
						Intent i = new Intent(EnvelopeActivity.this,WallActivity.class);
						//Request results from activity.
						startActivityForResult(i,WALL_RESULT);
					}
					else if(tempComponent_EditText.getText().toString().equals("Window")){
						//Window window intent.
						Intent i = new Intent(EnvelopeActivity.this,WindowActivity.class);
						//Request results from activity.
						startActivityForResult(i,WINDOW_RESULT);
					}
					else if(tempComponent_EditText.getText().toString().equals("Door")){
						//Door window intent.
						Intent i = new Intent(EnvelopeActivity.this,DoorActivity.class);
						//Request results from activity.
						startActivityForResult(i,DOOR_RESULT);
					}
					else if(tempComponent_EditText.getText().toString().equals("Basement")){
						//Basement window intent.
						Intent i = new Intent(EnvelopeActivity.this,BasementActivity.class);
						//Request results from activity.
						startActivityForResult(i,BASEMENT_RESULT);
					}
					else if(tempComponent_EditText.getText().toString().equals("Floor")){
						//Floor window intent.
						Intent i = new Intent(EnvelopeActivity.this,Floor_Layout.class);
						//Request results from activity.
						startActivityForResult(i,FLOOR_RESULT);
					}
					else if(tempComponent_EditText.getText().toString().equals("Crawl")){
						//Crawl window intent.
						Intent i = new Intent(EnvelopeActivity.this,CrawlActivity.class);
						//Request results from activity.
						startActivityForResult(i,CRAWL_RESULT);
					}
				}
			}
		});
		//Duplicate button and listener for it.
		duplicate_Button = (Button)findViewById(R.id.duplicateButton);
		duplicate_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				if(rows_LinkedList.size() > 0){
					TableRow temp_TableRow = (TableRow)rows_LinkedList.get(moveCounter_int);
					makeDuplicateRow(temp_TableRow);
				}
			}
		});
		//Move up button and listener for it.
		moveUp_Button = (Button)findViewById(R.id.moveUpButton);
		moveUp_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				if(rows_LinkedList.size() > 0){
					for(int i = 0; i < rows_LinkedList.size(); i++){
						System.out.println("Size of list:" + rows_LinkedList.size());
						if(i == moveCounter_int-1){
						//TableRow temp_TableRow = (TableRow)table_TableLayout.getChildAt(moveCounter_int);	
						rows_LinkedList.get(i).getChildAt(0).setBackgroundColor(Color.BLACK);
						}
						else{
							rows_LinkedList.get(i).getChildAt(0).setBackgroundColor(Color.WHITE);
						}
					}
					if(moveCounter_int > 0){
						moveCounter_int--;
					}
					System.out.println("MoveCount:" + moveCounter_int);
				}
			}
		});
		//Move down button and listener for it.
		moveDown_Button = (Button)findViewById(R.id.moveDownButton);
		moveDown_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				if(rows_LinkedList.size() > 0){
					for(int i = 0; i < rows_LinkedList.size(); i++){
						System.out.println("Size of list:" + rows_LinkedList.size());
						if(i == moveCounter_int+1){
						//TableRow temp_TableRow = (TableRow)table_TableLayout.getChildAt(moveCounter_int);	
						rows_LinkedList.get(i).getChildAt(0).setBackgroundColor(Color.BLACK);
						}
						else{
							rows_LinkedList.get(i).getChildAt(0).setBackgroundColor(Color.WHITE);
						}
					}
					if(rows_LinkedList.size() > moveCounter_int){
						moveCounter_int++;
					}
					
					System.out.println("MoveCount:" + moveCounter_int);
				}
			}
		});
		//Delete button and listener for it.
		delete_Button = (Button)findViewById(R.id.deleteButton);
		delete_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				if(rows_LinkedList.size() > 0){
					delete_boolean = true;
					table_TableLayout.removeViewAt(rows_LinkedList.size());
					rows_LinkedList.removeLast();
					rowCounter_int--;
					System.out.println("RowCOunter WHEN DELETING:" + rowCounter_int);
					if(moveCounter_int > 0){
						moveCounter_int--;
					}
				}
				delete_boolean = false;
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
				//Wall window intent.
				Intent i = new Intent(EnvelopeActivity.this,WallActivity.class);
				//Request results from activity.
				startActivityForResult(i,WALL_RESULT);
			}
		});
		//Window button and listener for it.
		window_Button = (Button)findViewById(R.id.windowButton);
		window_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Window window intent.
				Intent i = new Intent(EnvelopeActivity.this,WindowActivity.class);
				//Request results from activity.
				startActivityForResult(i,WINDOW_RESULT);
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
				//Basement window intent.
				Intent i = new Intent(EnvelopeActivity.this,BasementActivity.class);
				//Request results from activity.
				startActivityForResult(i,BASEMENT_RESULT);
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
		//Check Compliance button and listener for it.
		checkCompliance_Button = (Button)findViewById(R.id.checkComplianceButton);
		checkCompliance_Button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
					if(rows_LinkedList.size() > 0){
						for(int i = 0; i < rows_LinkedList.size(); i++){
							//Calculations intent.
							Intent c = new Intent();
							EditText tempComp_EditText = (EditText)rows_LinkedList.get(i).getChildAt(1);
							//if(tempComp_EditText.getText().equals("Ceiling")){
								TextView tempAssembly_EditText = (TextView)rows_LinkedList.get(i).getChildAt(2);
								EditText tempGArea_EditText = (EditText)rows_LinkedList.get(i).getChildAt(3);
								EditText tempCIRV_EditText = (EditText)rows_LinkedList.get(i).getChildAt(4);
								EditText tempConIRV_EditText = (EditText)rows_LinkedList.get(i).getChildAt(5);
								EditText tempUF_EditText = (EditText)rows_LinkedList.get(i).getChildAt(6);
								TextView tempSHGC_EditText = (TextView)rows_LinkedList.get(i).getChildAt(7);
								EditText tempDOI_EditText = (EditText)rows_LinkedList.get(i).getChildAt(8);
								EditText tempWH_EditText = (EditText)rows_LinkedList.get(i).getChildAt(9);
								EditText tempDBG_EditText = (EditText)rows_LinkedList.get(i).getChildAt(10);
								EditText tempDBIG_EditText = (EditText)rows_LinkedList.get(i).getChildAt(11);
								c.putExtra("1v1", tempComp_EditText.getText());
								c.putExtra("1v2", tempAssembly_EditText.getText());
								c.putExtra("1v3", tempGArea_EditText.getText());
								c.putExtra("1v4", tempCIRV_EditText.getText());
								c.putExtra("1v5", tempConIRV_EditText.getText());
								c.putExtra("1v6", tempUF_EditText.getText());
								c.putExtra("1v7", tempSHGC_EditText.getText());
								c.putExtra("1v8", tempDOI_EditText.getText());
								c.putExtra("1v9", tempWH_EditText.getText());
								c.putExtra("1v10", tempDBG_EditText.getText());
								c.putExtra("1v11", tempDBIG_EditText.getText());
								startActivityForResult(c,CALCULATE_RESULT);
							/*}
							else if(tempComp_EditText.getText().equals("Skylight")){
								
							}
							else if(tempComp_EditText.getText().equals("Wall")){
								
							}
							else if(tempComp_EditText.getText().equals("Window")){
	
							}
							else if(tempComp_EditText.getText().equals("Door")){
								
							}
							else if(tempComp_EditText.getText().equals("Basement")){
								
							}
							else if(tempComp_EditText.getText().equals("Floor")){
								
							}
							else if(tempComp_EditText.getText().equals("Crawl")){
								
							}*/
						}
					}
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
				if(requestCode != CALCULATE_RESULT){
				Intent i = new Intent(this,EnvelopeRow.class);
				//i.putExtra("v0",data.getStringExtra("1v0"));
				i.putExtra("v1",data.getStringExtra("1v1"));
				i.putExtra("v2",data.getStringExtra("1v2"));
				i.putExtra("v3",data.getStringExtra("1v3"));
				i.putExtra("v4",data.getStringExtra("1v4"));
				i.putExtra("v5",data.getStringExtra("1v5"));
				i.putExtra("v6",data.getStringExtra("1v6"));
				i.putExtra("v7",data.getStringExtra("1v7"));
				i.putExtra("v8",data.getStringExtra("1v8"));
				i.putExtra("v9",data.getStringExtra("1v9"));
				i.putExtra("v10",data.getStringExtra("1v10"));
				i.putExtra("v11",data.getStringExtra("1v11"));
				startActivity(i);
				if(!edit_boolean){
					makeComponentRow(i);
				}
				else{
					editComponentRow(moveCounter_int, i);
				}
				}
				else{
					updateComponentRowUFactor(Integer.valueOf(data.getStringExtra("rowNumber")), data);
				}
			}
	}
	
	/**
	 * makeComponentRow
	 * 
	 * Creates a new component row.
	 */
	private void makeComponentRow(Intent i){
		LayoutInflater balloon = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		row_TableRow = (TableRow)balloon.inflate(R.layout.row_layout, null);
		TextView index_TextView = (TextView)row_TableRow.findViewById(R.id.indexColumn);
		index_TextView.setText(rowCounter_int +"");
		EditText component_EditText = (EditText)row_TableRow.findViewById(R.id.componentColumn);
		component_EditText.setText(i.getStringExtra("v1"));
		TextView assembly_TextView = (TextView)row_TableRow.findViewById(R.id.assemblyColumn);
		assembly_TextView.setText(i.getStringExtra("v2"));
		EditText grossArea_EditText = (EditText)row_TableRow.findViewById(R.id.grossAreaColumn);
		grossArea_EditText.setText(i.getStringExtra("v3"));
		EditText cavityIRValue_EditText = (EditText)row_TableRow.findViewById(R.id.cavityIRValueColumn);
		cavityIRValue_EditText.setText(i.getStringExtra("v4"));
		EditText continuousIRValue_EditText = (EditText)row_TableRow.findViewById(R.id.continuousIRValueColumn);
		continuousIRValue_EditText.setText(i.getStringExtra("v5"));
		EditText uFactor_EditText = (EditText)row_TableRow.findViewById(R.id.uFactorColumn);
		uFactor_EditText.setText(i.getStringExtra("v6"));
		TextView sHGC_TextView = (TextView)row_TableRow.findViewById(R.id.sHGCColumn);
		sHGC_TextView.setText(i.getStringExtra("v7"));
		EditText dOI_EditText = (EditText)row_TableRow.findViewById(R.id.dOIColumn);
		dOI_EditText.setText(i.getStringExtra("v8"));
		EditText wH_EditText = (EditText)row_TableRow.findViewById(R.id.wHColumn);
		wH_EditText.setText(i.getStringExtra("v9"));
		EditText dBG_EditText = (EditText)row_TableRow.findViewById(R.id.dBGColumn);
		dBG_EditText.setText(i.getStringExtra("v10"));
		EditText dBIG_EditText = (EditText)row_TableRow.findViewById(R.id.dBIGColumn);
		dBIG_EditText.setText(i.getStringExtra("v11"));
		
		//OnFocusChangeListener for continuous insulation R-Value column
		/*continuousIRValue_EditText.setOnFocusChangeListener(new OnFocusChangeListener() {          
			public void onFocusChange(View v, boolean hasFocus) {
				if((!hasFocus && !delete_boolean){
					System.out.println("Hi I have lost focus!");
					Intent c = new Intent(EnvelopeActivity.this, CalculateActivity.class);
					startActivityForResult(c,CALCULATE_RESULT);
				}
			}
		});*/
		/*.addTextChangedListener(new TextWatcher(){
	        public void afterTextChanged(Editable s) {
	        	System.out.println("Hi I have changed!");
	        }

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
		});*/
		rows_LinkedList.add(row_TableRow);
		if(rows_LinkedList.size() < 2){
			row_TableRow.getChildAt(0).setBackgroundColor(Color.BLACK);
		}
		table_TableLayout.addView(row_TableRow);
		System.out.println("RowCOunter WHEN ADDING:" + rowCounter_int);
		TableRow row = rows_LinkedList.get(rowCounter_int-1);
		ScrollView temp_ScrollView = (ScrollView)row.getChildAt(0);
		TableRow temp_TableRow = (TableRow)temp_ScrollView.getChildAt(0);
		final EditText tempComp_EditText = (EditText)temp_TableRow.getChildAt(1);
		final TextView tempAssembly_EditText = (TextView)temp_TableRow.getChildAt(2);
		final EditText tempGArea_EditText = (EditText)temp_TableRow.getChildAt(3);
		final EditText tempCIRV_EditText = (EditText)temp_TableRow.getChildAt(4);
		final EditText tempConIRV_EditText = (EditText)temp_TableRow.getChildAt(5);
		final EditText tempDOI_EditText = (EditText)temp_TableRow.getChildAt(8);
		final EditText tempWH_EditText = (EditText)temp_TableRow.getChildAt(9);
		final EditText tempDBG_EditText = (EditText)temp_TableRow.getChildAt(10);
		final EditText tempDBIG_EditText = (EditText)temp_TableRow.getChildAt(11);
		
		
		//OnFocusChangeListener for gross area column
		tempGArea_EditText.setOnFocusChangeListener(new OnFocusChangeListener() {          
	    public void onFocusChange(View v, boolean hasFocus) {
	            if((!hasFocus && !delete_boolean)){
	            	System.out.println("Hi I have lost focus!");
	            	Intent c = new Intent(EnvelopeActivity.this, CalculateActivity.class);
	            	c.putExtra("a", tempComp_EditText.getText().toString());
	            	c.putExtra("b", tempAssembly_EditText.getText().toString());
	            	c.putExtra("c", tempGArea_EditText.getText().toString());
	            	c.putExtra("d", "" + (rowCounter_int-1));
	            	c.putExtra("e", tempCIRV_EditText.getText().toString());
					c.putExtra("f", tempConIRV_EditText.getText().toString());
					c.putExtra("g", tempDOI_EditText.getText().toString());
					c.putExtra("h", tempWH_EditText.getText().toString());
					c.putExtra("i", tempDBG_EditText.getText().toString());
					c.putExtra("j", tempDBIG_EditText.getText().toString());
	            	startActivityForResult(c,CALCULATE_RESULT);
	            }
	        }
	    });
		//OnFocusChangeListener for cavity insulation R-Value column
		tempCIRV_EditText.setOnFocusChangeListener(new OnFocusChangeListener() {          
	    public void onFocusChange(View v, boolean hasFocus) {
	            if((!hasFocus && !delete_boolean)){
	            	System.out.println("Hi I have lost focus!");
	            	Intent c = new Intent(EnvelopeActivity.this, CalculateActivity.class);
	            	c.putExtra("a", tempComp_EditText.getText().toString());
	            	c.putExtra("b", tempAssembly_EditText.getText().toString());
	            	c.putExtra("c", tempGArea_EditText.getText().toString());
	            	c.putExtra("d", "" + (rowCounter_int-1));
	            	c.putExtra("e", tempCIRV_EditText.getText().toString());
					c.putExtra("f", tempConIRV_EditText.getText().toString());
					c.putExtra("g", tempDOI_EditText.getText().toString());
					c.putExtra("h", tempWH_EditText.getText().toString());
					c.putExtra("i", tempDBG_EditText.getText().toString());
					c.putExtra("j", tempDBIG_EditText.getText().toString());
	            	startActivityForResult(c,CALCULATE_RESULT);
	            }
	        }
	    });
		//OnFocusChangeListener for continuous insulation R-Value column
		tempConIRV_EditText.setOnFocusChangeListener(new OnFocusChangeListener() {          
	    public void onFocusChange(View v, boolean hasFocus) {
	            if((!hasFocus && !delete_boolean)){
	            	System.out.println("Hi I have lost focus!");
	            	Intent c = new Intent(EnvelopeActivity.this, CalculateActivity.class);
	            	c.putExtra("a", tempComp_EditText.getText().toString());
	            	c.putExtra("b", tempAssembly_EditText.getText().toString());
	            	c.putExtra("c", tempGArea_EditText.getText().toString());
	            	c.putExtra("d", "" + (rowCounter_int-1));
	            	c.putExtra("e", tempCIRV_EditText.getText().toString());
					c.putExtra("f", tempConIRV_EditText.getText().toString());
					c.putExtra("g", tempDOI_EditText.getText().toString());
					c.putExtra("h", tempWH_EditText.getText().toString());
					c.putExtra("i", tempDBG_EditText.getText().toString());
					c.putExtra("j", tempDBIG_EditText.getText().toString());
	            	startActivityForResult(c,CALCULATE_RESULT);
		           }
	        }
	    });
		//OnFocusChangeListener for depth of insulation column
		tempDOI_EditText.setOnFocusChangeListener(new OnFocusChangeListener() {          
	    public void onFocusChange(View v, boolean hasFocus) {
	            if((!hasFocus && !delete_boolean)){
	            	System.out.println("Hi I have lost focus!");
	            	Intent c = new Intent(EnvelopeActivity.this, CalculateActivity.class);
	            	c.putExtra("a", tempComp_EditText.getText().toString());
	            	c.putExtra("b", tempAssembly_EditText.getText().toString());
	            	c.putExtra("c", tempGArea_EditText.getText().toString());
	            	c.putExtra("d", "" + (rowCounter_int-1));
	            	c.putExtra("e", tempCIRV_EditText.getText().toString());
					c.putExtra("f", tempConIRV_EditText.getText().toString());
					c.putExtra("g", tempDOI_EditText.getText().toString());
					c.putExtra("h", tempWH_EditText.getText().toString());
					c.putExtra("i", tempDBG_EditText.getText().toString());
					c.putExtra("j", tempDBIG_EditText.getText().toString());
	            	startActivityForResult(c,CALCULATE_RESULT);
		           }
	        }
	    });
		//OnFocusChangeListener for wall height column
		tempWH_EditText.setOnFocusChangeListener(new OnFocusChangeListener() {          
		  public void onFocusChange(View v, boolean hasFocus) {
			      if((!hasFocus && !delete_boolean)){
			    	  System.out.println("Hi I have lost focus!");
		            	Intent c = new Intent(EnvelopeActivity.this, CalculateActivity.class);
		            	c.putExtra("a", tempComp_EditText.getText().toString());
		            	c.putExtra("b", tempAssembly_EditText.getText().toString());
		            	c.putExtra("c", tempGArea_EditText.getText().toString());
		            	c.putExtra("d", "" + (rowCounter_int-1));
		            	c.putExtra("e", tempCIRV_EditText.getText().toString());
						c.putExtra("f", tempConIRV_EditText.getText().toString());
						c.putExtra("g", tempDOI_EditText.getText().toString());
						c.putExtra("h", tempWH_EditText.getText().toString());
						c.putExtra("i", tempDBG_EditText.getText().toString());
						c.putExtra("j", tempDBIG_EditText.getText().toString());
		            	startActivityForResult(c,CALCULATE_RESULT);
	               }
		       }
	    });
		//OnFocusChangeListener for depth below grade column
		tempDBG_EditText.setOnFocusChangeListener(new OnFocusChangeListener() {          
	    public void onFocusChange(View v, boolean hasFocus) {
	            if((!hasFocus && !delete_boolean)){
	            	System.out.println("Hi I have lost focus!");
	            	Intent c = new Intent(EnvelopeActivity.this, CalculateActivity.class);
	            	c.putExtra("a", tempComp_EditText.getText().toString());
	            	c.putExtra("b", tempAssembly_EditText.getText().toString());
	            	c.putExtra("c", tempGArea_EditText.getText().toString());
	            	c.putExtra("d", "" + (rowCounter_int-1));
	            	c.putExtra("e", tempCIRV_EditText.getText().toString());
					c.putExtra("f", tempConIRV_EditText.getText().toString());
					c.putExtra("g", tempDOI_EditText.getText().toString());
					c.putExtra("h", tempWH_EditText.getText().toString());
					c.putExtra("i", tempDBG_EditText.getText().toString());
					c.putExtra("j", tempDBIG_EditText.getText().toString());
	            	startActivityForResult(c,CALCULATE_RESULT);
	            }
	        }
	    });
		//OnFocusChangeListener for depth below inside grade column
		tempDBIG_EditText.setOnFocusChangeListener(new OnFocusChangeListener() {          
	    public void onFocusChange(View v, boolean hasFocus) {
	            if((!hasFocus && !delete_boolean)){
	            	System.out.println("Hi I have lost focus!");
	            	Intent c = new Intent(EnvelopeActivity.this, CalculateActivity.class);
	            	c.putExtra("a", tempComp_EditText.getText().toString());
	            	c.putExtra("b", tempAssembly_EditText.getText().toString());
	            	c.putExtra("c", tempGArea_EditText.getText().toString());
	            	c.putExtra("d", "" + (rowCounter_int-1));
	            	c.putExtra("e", tempCIRV_EditText.getText().toString());
					c.putExtra("f", tempConIRV_EditText.getText().toString());
					c.putExtra("g", tempDOI_EditText.getText().toString());
					c.putExtra("h", tempWH_EditText.getText().toString());
					c.putExtra("i", tempDBG_EditText.getText().toString());
					c.putExtra("j", tempDBIG_EditText.getText().toString());
	            	startActivityForResult(c,CALCULATE_RESULT);
	            }
	        }
		});
		//if(rowCounter_int < 1){
			//moveCounter_int++;
		//}
		rowCounter_int++;
	}
	
	/**
	 * makeDuplicateComponentRow
	 * 
	 * Creates a new component row.
	 */
	private void makeDuplicateRow(TableRow row){
		ScrollView temp_ScrollView = (ScrollView)row.getChildAt(0);
		TableRow temp_TableRow = (TableRow)temp_ScrollView.getChildAt(0);
		System.out.println("Children of row:" + temp_TableRow.getChildCount());
		LayoutInflater balloon = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		row_TableRow = (TableRow)balloon.inflate(R.layout.row_layout, null);
		TextView index_TextView = (TextView)row_TableRow.findViewById(R.id.indexColumn);
		index_TextView.setText(rowCounter_int +"");
		EditText component_EditText = (EditText)row_TableRow.findViewById(R.id.componentColumn);
		final EditText tempComp_EditText = (EditText)temp_TableRow.getChildAt(1);
		component_EditText.setText(tempComp_EditText.getText().toString());
		TextView assembly_TextView = (TextView)row_TableRow.findViewById(R.id.assemblyColumn);
		final TextView tempAssembly_EditText = (TextView)temp_TableRow.getChildAt(2);
		assembly_TextView.setText(tempAssembly_EditText.getText());
		EditText grossArea_EditText = (EditText)row_TableRow.findViewById(R.id.grossAreaColumn);
		final EditText tempGArea_EditText = (EditText)temp_TableRow.getChildAt(3);
		grossArea_EditText.setText(tempGArea_EditText.getText());
		EditText cavityIRValue_EditText = (EditText)row_TableRow.findViewById(R.id.cavityIRValueColumn);
		final EditText tempCIRV_EditText = (EditText)temp_TableRow.getChildAt(4);
		cavityIRValue_EditText.setText(tempCIRV_EditText.getText());
		EditText continuousIRValue_EditText = (EditText)row_TableRow.findViewById(R.id.continuousIRValueColumn);
		final EditText tempConIRV_EditText = (EditText)temp_TableRow.getChildAt(5);
		continuousIRValue_EditText.setText(tempConIRV_EditText.getText());
		EditText uFactor_EditText = (EditText)row_TableRow.findViewById(R.id.uFactorColumn);
		EditText tempUF_EditText = (EditText)temp_TableRow.getChildAt(6);
		uFactor_EditText.setText(tempUF_EditText.getText());
		TextView sHGC_TextView = (TextView)row_TableRow.findViewById(R.id.sHGCColumn);
		TextView tempSHGC_EditText = (TextView)temp_TableRow.getChildAt(7);
		sHGC_TextView.setText(tempSHGC_EditText.getText());
		EditText dOI_EditText = (EditText)row_TableRow.findViewById(R.id.dOIColumn);
		final EditText tempDOI_EditText = (EditText)temp_TableRow.getChildAt(8);
		dOI_EditText.setText(tempDOI_EditText.getText());
		EditText wH_EditText = (EditText)row_TableRow.findViewById(R.id.wHColumn);
		final EditText tempWH_EditText = (EditText)temp_TableRow.getChildAt(9);
		wH_EditText.setText(tempWH_EditText.getText());
		EditText dBG_EditText = (EditText)row_TableRow.findViewById(R.id.dBGColumn);
		final EditText tempDBG_EditText = (EditText)temp_TableRow.getChildAt(10);
		dBG_EditText.setText(tempDBG_EditText.getText());
		EditText dBIG_EditText = (EditText)row_TableRow.findViewById(R.id.dBIGColumn);
		final EditText tempDBIG_EditText = (EditText)temp_TableRow.getChildAt(11);
		dBIG_EditText.setText(tempDBIG_EditText.getText());
		//OnFocusChangeListener for gross area column
		tempGArea_EditText.setOnFocusChangeListener(new OnFocusChangeListener() {          
	    public void onFocusChange(View v, boolean hasFocus) {
	            if((!hasFocus && !delete_boolean)){
	            	System.out.println("Hi I have lost focus!");
	            	Intent c = new Intent(EnvelopeActivity.this, CalculateActivity.class);
	            	c.putExtra("a", tempComp_EditText.getText().toString());
	            	c.putExtra("b", tempAssembly_EditText.getText().toString());
	            	c.putExtra("c", tempGArea_EditText.getText().toString());
	            	c.putExtra("d", "" + (rowCounter_int-1));
	            	c.putExtra("e", tempCIRV_EditText.getText().toString());
					c.putExtra("f", tempConIRV_EditText.getText().toString());
					c.putExtra("g", tempDOI_EditText.getText().toString());
					c.putExtra("h", tempWH_EditText.getText().toString());
					c.putExtra("i", tempDBG_EditText.getText().toString());
					c.putExtra("j", tempDBIG_EditText.getText().toString());
	            	startActivityForResult(c,CALCULATE_RESULT);
	            }
	        }
	    });
		//OnFocusChangeListener for cavity insulation R-Value column
		tempCIRV_EditText.setOnFocusChangeListener(new OnFocusChangeListener() {          
	    public void onFocusChange(View v, boolean hasFocus) {
	            if((!hasFocus && !delete_boolean)){
	            	System.out.println("Hi I have lost focus!");
	            	Intent c = new Intent(EnvelopeActivity.this, CalculateActivity.class);
	            	c.putExtra("a", tempComp_EditText.getText().toString());
	            	c.putExtra("b", tempAssembly_EditText.getText().toString());
	            	c.putExtra("c", tempGArea_EditText.getText().toString());
	            	c.putExtra("d", "" + (rowCounter_int-1));
	            	c.putExtra("e", tempCIRV_EditText.getText().toString());
					c.putExtra("f", tempConIRV_EditText.getText().toString());
					c.putExtra("g", tempDOI_EditText.getText().toString());
					c.putExtra("h", tempWH_EditText.getText().toString());
					c.putExtra("i", tempDBG_EditText.getText().toString());
					c.putExtra("j", tempDBIG_EditText.getText().toString());
	            	startActivityForResult(c,CALCULATE_RESULT);
	            }
	        }
	    });
		//OnFocusChangeListener for continuous insulation R-Value column
		tempConIRV_EditText.setOnFocusChangeListener(new OnFocusChangeListener() {          
	    public void onFocusChange(View v, boolean hasFocus) {
	            if((!hasFocus && !delete_boolean)){
	            	System.out.println("Hi I have lost focus!");
	            	Intent c = new Intent(EnvelopeActivity.this, CalculateActivity.class);
	            	c.putExtra("a", tempComp_EditText.getText().toString());
	            	c.putExtra("b", tempAssembly_EditText.getText().toString());
	            	c.putExtra("c", tempGArea_EditText.getText().toString());
	            	c.putExtra("d", "" + (rowCounter_int-1));
	            	c.putExtra("e", tempCIRV_EditText.getText().toString());
					c.putExtra("f", tempConIRV_EditText.getText().toString());
					c.putExtra("g", tempDOI_EditText.getText().toString());
					c.putExtra("h", tempWH_EditText.getText().toString());
					c.putExtra("i", tempDBG_EditText.getText().toString());
					c.putExtra("j", tempDBIG_EditText.getText().toString());
	            	startActivityForResult(c,CALCULATE_RESULT);
		           }
	        }
	    });
		//OnFocusChangeListener for depth of insulation column
		tempDOI_EditText.setOnFocusChangeListener(new OnFocusChangeListener() {          
	    public void onFocusChange(View v, boolean hasFocus) {
	            if((!hasFocus && !delete_boolean)){
	            	System.out.println("Hi I have lost focus!");
	            	Intent c = new Intent(EnvelopeActivity.this, CalculateActivity.class);
	            	c.putExtra("a", tempComp_EditText.getText().toString());
	            	c.putExtra("b", tempAssembly_EditText.getText().toString());
	            	c.putExtra("c", tempGArea_EditText.getText().toString());
	            	c.putExtra("d", "" + (rowCounter_int-1));
	            	c.putExtra("e", tempCIRV_EditText.getText().toString());
					c.putExtra("f", tempConIRV_EditText.getText().toString());
					c.putExtra("g", tempDOI_EditText.getText().toString());
					c.putExtra("h", tempWH_EditText.getText().toString());
					c.putExtra("i", tempDBG_EditText.getText().toString());
					c.putExtra("j", tempDBIG_EditText.getText().toString());
	            	startActivityForResult(c,CALCULATE_RESULT);
		           }
	        }
	    });
		//OnFocusChangeListener for wall height column
		tempWH_EditText.setOnFocusChangeListener(new OnFocusChangeListener() {          
		  public void onFocusChange(View v, boolean hasFocus) {
			      if((!hasFocus && !delete_boolean)){
			    	  System.out.println("Hi I have lost focus!");
		            	Intent c = new Intent(EnvelopeActivity.this, CalculateActivity.class);
		            	c.putExtra("a", tempComp_EditText.getText().toString());
		            	c.putExtra("b", tempAssembly_EditText.getText().toString());
		            	c.putExtra("c", tempGArea_EditText.getText().toString());
		            	c.putExtra("d", "" + (rowCounter_int-1));
		            	c.putExtra("e", tempCIRV_EditText.getText().toString());
						c.putExtra("f", tempConIRV_EditText.getText().toString());
						c.putExtra("g", tempDOI_EditText.getText().toString());
						c.putExtra("h", tempWH_EditText.getText().toString());
						c.putExtra("i", tempDBG_EditText.getText().toString());
						c.putExtra("j", tempDBIG_EditText.getText().toString());
		            	startActivityForResult(c,CALCULATE_RESULT);
	               }
		       }
	    });
		//OnFocusChangeListener for depth below grade column
		tempDBG_EditText.setOnFocusChangeListener(new OnFocusChangeListener() {          
	    public void onFocusChange(View v, boolean hasFocus) {
	            if((!hasFocus && !delete_boolean)){
	            	System.out.println("Hi I have lost focus!");
	            	Intent c = new Intent(EnvelopeActivity.this, CalculateActivity.class);
	            	c.putExtra("a", tempComp_EditText.getText().toString());
	            	c.putExtra("b", tempAssembly_EditText.getText().toString());
	            	c.putExtra("c", tempGArea_EditText.getText().toString());
	            	c.putExtra("d", "" + (rowCounter_int-1));
	            	c.putExtra("e", tempCIRV_EditText.getText().toString());
					c.putExtra("f", tempConIRV_EditText.getText().toString());
					c.putExtra("g", tempDOI_EditText.getText().toString());
					c.putExtra("h", tempWH_EditText.getText().toString());
					c.putExtra("i", tempDBG_EditText.getText().toString());
					c.putExtra("j", tempDBIG_EditText.getText().toString());
	            	startActivityForResult(c,CALCULATE_RESULT);
	            }
	        }
	    });
		//OnFocusChangeListener for depth below inside grade column
		tempDBIG_EditText.setOnFocusChangeListener(new OnFocusChangeListener() {          
	    public void onFocusChange(View v, boolean hasFocus) {
	            if((!hasFocus && !delete_boolean)){
	            	System.out.println("Hi I have lost focus!");
	            	Intent c = new Intent(EnvelopeActivity.this, CalculateActivity.class);
	            	c.putExtra("a", tempComp_EditText.getText().toString());
	            	c.putExtra("b", tempAssembly_EditText.getText().toString());
	            	c.putExtra("c", tempGArea_EditText.getText().toString());
	            	c.putExtra("d", "" + (rowCounter_int-1));
	            	c.putExtra("e", tempCIRV_EditText.getText().toString());
					c.putExtra("f", tempConIRV_EditText.getText().toString());
					c.putExtra("g", tempDOI_EditText.getText().toString());
					c.putExtra("h", tempWH_EditText.getText().toString());
					c.putExtra("i", tempDBG_EditText.getText().toString());
					c.putExtra("j", tempDBIG_EditText.getText().toString());
	            	startActivityForResult(c,CALCULATE_RESULT);
	            }
	        }
		});
		rows_LinkedList.add(row_TableRow);
		table_TableLayout.addView(row_TableRow);
		rowCounter_int++;
	}
	
	/**
	 * editComponentRow
	 * 
	 * Creates a new component row.
	 */
	private void editComponentRow(int count,Intent i){
		TableRow row = rows_LinkedList.get(count);
		ScrollView temp_ScrollView = (ScrollView)row.getChildAt(0);
		TableRow temp_TableRow = (TableRow)temp_ScrollView.getChildAt(0);
		System.out.println("Children of row:" + temp_TableRow.getChildCount());
		LayoutInflater balloon = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		row_TableRow = (TableRow)balloon.inflate(R.layout.row_layout, null);
		EditText tempComp_EditText = (EditText)temp_TableRow.getChildAt(1);
		tempComp_EditText.setText(i.getStringExtra("v1"));
		TextView tempAssembly_EditText = (TextView)temp_TableRow.getChildAt(2);
		tempAssembly_EditText.setText(i.getStringExtra("v2"));
		EditText tempGArea_EditText = (EditText)temp_TableRow.getChildAt(3);
		tempGArea_EditText.setText(i.getStringExtra("v3"));
		EditText tempCIRV_EditText = (EditText)temp_TableRow.getChildAt(4);
		tempCIRV_EditText.setText(i.getStringExtra("v4"));
		EditText tempConIRV_EditText = (EditText)temp_TableRow.getChildAt(5);
		tempConIRV_EditText.setText(i.getStringExtra("v5"));
		EditText tempUF_EditText = (EditText)temp_TableRow.getChildAt(6);
		tempUF_EditText.setText(i.getStringExtra("v6"));
		TextView tempSHGC_EditText = (TextView)temp_TableRow.getChildAt(7);
		tempSHGC_EditText.setText(i.getStringExtra("v7"));
		EditText tempDOI_EditText = (EditText)temp_TableRow.getChildAt(8);
		tempDOI_EditText.setText(i.getStringExtra("v8"));
		EditText tempWH_EditText = (EditText)temp_TableRow.getChildAt(9);
		tempWH_EditText.setText(i.getStringExtra("v9"));
		EditText tempDBG_EditText = (EditText)temp_TableRow.getChildAt(10);
		tempDBG_EditText.setText(i.getStringExtra("v10"));
		EditText tempDBIG_EditText = (EditText)temp_TableRow.getChildAt(11);
		tempDBIG_EditText.setText(i.getStringExtra("v11"));
		edit_boolean = false;
	}
	
	/**
	 * updateComponentRowUFactor
	 * 
	 * Updates u-Factor in a component row.
	 */
	private void updateComponentRowUFactor(int count,Intent i){
		TableRow row = rows_LinkedList.get(count-1);
		ScrollView temp_ScrollView = (ScrollView)row.getChildAt(0);
		TableRow temp_TableRow = (TableRow)temp_ScrollView.getChildAt(0);
		System.out.println("Children of row:" + temp_TableRow.getChildCount());
		LayoutInflater balloon = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		row_TableRow = (TableRow)balloon.inflate(R.layout.row_layout, null);
		EditText tempUF_EditText = (EditText)temp_TableRow.getChildAt(6);
		tempUF_EditText.setText(i.getStringExtra("uFactor"));
	}
}

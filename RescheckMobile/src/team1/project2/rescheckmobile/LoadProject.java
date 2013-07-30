package team1.project2.rescheckmobile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
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
*----------------------------------
*Christopher T. Bolgiano
*Start time/date: 4:30pm, 7/7/2013
*End time/date: , 7/7/13
*----------------------------------
**/
public class LoadProject extends Activity{
	//Calculate result constant.
		private static final int CALCULATE_RESULT = 8;
	//TableLayout.
	private TableLayout table_TableLayout;
	//Row View.
	private TableRow row_TableRow;
	//Linked list of rows.
	private LinkedList<TableRow> rows_LinkedList;
		
	//Load file button.
	private Button loadFile_Button;
	//Deletefile button.
	private Button deleteFile_Button;
	//COunter
	private int counter =0;
	
	//Load boolean.
	public static boolean loadFile_boolean = false;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.load_layout);
		getFilesFromExternalStorage();
	}
	
	/**
	 * getFilesFromExternalStorage
	 * 
	 * Retrieves all the internal files that are associated with this application.
	 */
	private void getFilesFromExternalStorage(){
		//List of table rows.
		rows_LinkedList = new LinkedList<TableRow>();
		//Path to external storage device.
		File path_File = new File(Environment.getExternalStorageDirectory().toString());
		//List of files
		final File[] files_File = path_File.listFiles();
		System.out.println("Files:" +files_File.length);
		//Initializes table layout for table rows.
		table_TableLayout = (TableLayout)findViewById(R.id.tableHost);
		
		for(int i = 0; i < files_File.length; i++){
			final int numberOfFile_int = i;
			LayoutInflater balloon = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row_TableRow = (TableRow)balloon.inflate(R.layout.filerow_layout, null);
			final TextView fileName_TextView = (TextView)row_TableRow.findViewById(R.id.fileName);
			fileName_TextView.setText(files_File[i].getName());
			//Load file Button.
			loadFile_Button = (Button)row_TableRow.findViewById(R.id.loadFileButton);
			loadFile_Button.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					String result_String = "";
					File path_File = new File(Environment.getExternalStorageDirectory().toString());
					File project_File = new File(path_File,fileName_TextView.getText().toString());
					try {
						loadFile_boolean = true;
						//Intent main_Intent = new Intent(LoadProject.this,MainActivity.class);
						//startActivity(main_Intent);
						FileReader fR_FileReader = new FileReader(project_File);
						BufferedReader bR_BufferedReader = new BufferedReader(fR_FileReader);
						
						//int temp_Count = 0;
						
						String line_String = "";
						while((line_String = bR_BufferedReader.readLine())!=null){
							
							/*Uri u_Uri = Uri.parse(line_String);
							System.out.println("Intent" + temp_Count + u_Uri);
							Intent i = new Intent();
							i.setData(u_Uri);
							try{
							startActivity(i);
							}
							catch(ActivityNotFoundException e){
								e.printStackTrace();
							}
							if(temp_Count == 0){
								MainActivity.homeTab = MainActivity.tabHost.newTabSpec("Home");
								MainActivity.homeTab.setIndicator("Home");
								MainActivity.homeTab.setContent(i);
								//MainActivity.tabHost.addTab(MainActivity.homeTab);
							}
							else if(temp_Count == 1){
								MainActivity.projectTab = MainActivity.tabHost.newTabSpec("Project");
								MainActivity.projectTab.setIndicator("Project");
								MainActivity.projectTab.setContent(i);
								//MainActivity.tabHost.addTab(MainActivity.projectTab);
							}
							else if(temp_Count == 2){
								MainActivity.envelopeTab = MainActivity.tabHost.newTabSpec("Envelope");
								MainActivity.envelopeTab.setIndicator("Envelope");
								MainActivity.envelopeTab.setContent(i);
								//MainActivity.tabHost.addTab(MainActivity.envelopeTab);
							}
							else if(temp_Count == 3){
								MainActivity.mechanicalTab = MainActivity.tabHost.newTabSpec("Mechanical");
								MainActivity.mechanicalTab.setContent(i);
								MainActivity.mechanicalTab.setIndicator("Mechanical");
								//MainActivity.tabHost.addTab(MainActivity.mechanicalTab);
							}
							temp_Count++;
						}
						finish();*/
							
							result_String = line_String;
						}
						//bR_BufferedReader.close();
						System.out.println("Text:" + result_String);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String[] result_Array = result_String.split("!-!");
					//Project tab.
					for(int i = 0; i < 16; i++){
						//System.out.println("Results:" + result_Array[i]);
						switch(i){
							case 0:
								ProjectActivity.title_EditText.setText(result_Array[i]);
							break;
							case 1:
								ProjectActivity.code_Spinner.setSelection(0);
							break;
							case 2:
								ProjectActivity.state_Spinner.setSelection(0);
							break;
							case 3:
								if(result_Array[i].equalsIgnoreCase("Radford")){
									ProjectActivity.city_Spinner.setSelection(0);
								}
								else if(result_Array[i].equalsIgnoreCase("Christiansburg")){
									ProjectActivity.city_Spinner.setSelection(1);
								}
								else if(result_Array[i].equalsIgnoreCase("Blacksburg")){
									ProjectActivity.city_Spinner.setSelection(2);
								}
							break;
							case 4:
								ProjectActivity.county_Spinner.setSelection(0);
							break;
							case 5:
								if(result_Array[i].equalsIgnoreCase("true")){
									ProjectActivity.city_RadioButton.setChecked(true);
								}
							break;
							case 6:
								if(result_Array[i].equalsIgnoreCase("true")){
									ProjectActivity.county_RadioButton.setChecked(true);
								}
							break;
							case 7:
								if(result_Array[i].equalsIgnoreCase("true")){
									ProjectActivity.newConstruction_RadioButton.setChecked(true);
								}
							break;
							case 8:
								if(result_Array[i].equalsIgnoreCase("true")){
									ProjectActivity.addition_RadioButton.setChecked(true);
								}
							break;
							case 9:
								if(result_Array[i].equalsIgnoreCase("true")){
									ProjectActivity.alteration_RadioButton.setChecked(true);
								}
							break;
							case 10:
								if(result_Array[i].equalsIgnoreCase("true")){
									ProjectActivity.uATradeOff_RadioButton.setChecked(true);
								}
							break;
							case 11:
								if(result_Array[i].equalsIgnoreCase("true")){
									ProjectActivity.performanceAlternative_RadioButton.setChecked(true);
								}
							break;
							case 12:
								if(result_Array[i].equalsIgnoreCase("true")){
									ProjectActivity.oneAndTwoFamily_RadioButton.setSelected(true);
								}
							break;
							case 13:
								if(result_Array[i].equalsIgnoreCase("true")){
									ProjectActivity.multiFamily_RadioButton.setSelected(true);
								}
							break;
							case 14:
									ProjectActivity.conditionedFloorArea_EditText.setText(result_Array[i]);
							break;
							case 15:
								String[] notes_Array = result_Array[i].split("!");
								String noteResults_String = "";
								for(int k = 0; k < notes_Array.length; k++){
									noteResults_String = noteResults_String + notes_Array[k] + "\n";
								}
								System.out.println("Notes:" + noteResults_String);
								ProjectActivity.notes_EditText.setText(noteResults_String);
							break;
						}
					}
					if(result_Array.length > 15){
						int temp_Counter = 0;
						int rowCounter_int = 0;
						//EnvelopeActivity.table_TableLayout.removeAllViews();
						//EnvelopeActivity.table_TableLayout.getParent().removeView(EnvelopeActivity.table_TableLayout)
						//Envelope tab.
						
						for(int j = 16; j < result_Array.length; j++){
							LayoutInflater balloon = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
							TableRow row1_TableRow = (TableRow)balloon.inflate(R.layout.row_layout, null);
							TextView index_TextView = (TextView)row1_TableRow.findViewById(R.id.indexColumn);
							EditText component_EditText = (EditText)row1_TableRow.findViewById(R.id.componentColumn);
							TextView assembly_TextView = (TextView)row1_TableRow.findViewById(R.id.assemblyColumn);
							EditText grossArea_EditText = (EditText)row1_TableRow.findViewById(R.id.grossAreaColumn);
							EditText cavityIRValue_EditText = (EditText)row1_TableRow.findViewById(R.id.cavityIRValueColumn);
							EditText continuousIRValue_EditText = (EditText)row1_TableRow.findViewById(R.id.continuousIRValueColumn);
							EditText uFactor_EditText = (EditText)row1_TableRow.findViewById(R.id.uFactorColumn);
							TextView sHGC_TextView = (TextView)row1_TableRow.findViewById(R.id.sHGCColumn);
							EditText dOI_EditText = (EditText)row1_TableRow.findViewById(R.id.dOIColumn);
							EditText wH_EditText = (EditText)row1_TableRow.findViewById(R.id.wHColumn);
							EditText dBG_EditText = (EditText)row1_TableRow.findViewById(R.id.dBGColumn);
							EditText dBIG_EditText = (EditText)row1_TableRow.findViewById(R.id.dBIGColumn);
							if(temp_Counter < 12){
							System.out.println("Results:" + result_Array[j]);
							switch(rowCounter_int){
									case 0:
										index_TextView.setText(result_Array[j]);
										System.out.println("Index:" + result_Array[j]);
										rowCounter_int++;
									break;
									case 1:
										component_EditText.setText(result_Array[j]);
										System.out.println("Component:" + result_Array[j]);
										rowCounter_int++;
									break;
									case 2:
										assembly_TextView.setText(result_Array[j]);
										rowCounter_int++;
										break;
									case 3:
										grossArea_EditText.setText(result_Array[j]);
										rowCounter_int++;
										break;
									case 4:
										cavityIRValue_EditText.setText(result_Array[j]);
										rowCounter_int++;
										break;
									case 5:
										continuousIRValue_EditText.setText(result_Array[j]);
										rowCounter_int++;
										break;
									case 6:
										uFactor_EditText.setText(result_Array[j]);
										rowCounter_int++;
										break;
									case 7:
										sHGC_TextView.setText(result_Array[j]);
										rowCounter_int++;
										break;
									case 8:
										dOI_EditText.setText(result_Array[j]);
										rowCounter_int++;
										break;
									case 9:
										wH_EditText.setText(result_Array[j]);
										rowCounter_int++;
										break;
									case 10:
										dBG_EditText.setText(result_Array[j]);
										rowCounter_int++;
										break;
									case 11:
										dBIG_EditText.setText(result_Array[j]);
										rowCounter_int++;
										break;
								}
								System.out.println("Counter:" + rowCounter_int);

							/*TableRow row = rows_LinkedList.get(rowCounter_int);
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
						            if((!hasFocus && !EnvelopeActivity.delete_boolean)){
						            	System.out.println("Hi I have lost focus!");
						            	Intent c = new Intent(LoadProject.this, CalculateActivity.class);
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
						            if((!hasFocus && !EnvelopeActivity.delete_boolean)){
						            	System.out.println("Hi I have lost focus!");
						            	Intent c = new Intent(LoadProject.this, CalculateActivity.class);
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
						            if((!hasFocus && !EnvelopeActivity.delete_boolean)){
						            	System.out.println("Hi I have lost focus!");
						            	Intent c = new Intent(LoadProject.this, CalculateActivity.class);
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
						            if((!hasFocus && !EnvelopeActivity.delete_boolean)){
						            	System.out.println("Hi I have lost focus!");
						            	Intent c = new Intent(LoadProject.this, CalculateActivity.class);
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
								      if((!hasFocus && !EnvelopeActivity.delete_boolean)){
								    	  System.out.println("Hi I have lost focus!");
							            	Intent c = new Intent(LoadProject.this, CalculateActivity.class);
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
						            if((!hasFocus && !EnvelopeActivity.delete_boolean)){
						            	System.out.println("Hi I have lost focus!");
						            	Intent c = new Intent(LoadProject.this, CalculateActivity.class);
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
						            if((!hasFocus && !EnvelopeActivity.delete_boolean)){
						            	System.out.println("Hi I have lost focus!");
						            	Intent c = new Intent(LoadProject.this, CalculateActivity.class);
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
							}
							else{
								temp_Counter = 0;
							}
							rows_LinkedList.add(row_TableRow);
							if(rows_LinkedList.size() < 2){
								row_TableRow.getChildAt(0).setBackgroundColor(Color.BLACK);
							*/}
							if(rowCounter_int > 11){
								//rows_LinkedList.add(row1_TableRow);
								EnvelopeActivity.table_TableLayout.addView(row1_TableRow/*rows_LinkedList.get(counter)*/);
								rowCounter_int = 0;
								counter++;
								System.out.println("Adding row");
							}
						}
					}
					finish();
				}
			});
			//Delete file Button.
			deleteFile_Button = (Button)row_TableRow.findViewById(R.id.deleteFileButton);
			deleteFile_Button.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					files_File[numberOfFile_int].delete();
					Intent i = new Intent(LoadProject.this,LoadProject.class);
					startActivity(i);
					finish();
				}
			});
			rows_LinkedList.add(row_TableRow);
			table_TableLayout.addView(row_TableRow);
		}
		System.out.println("LOADING FILES");
	}
	/**
	 * updatesResultsFromAddingComponentsToList
	 * 
	 * Updates the list with a component that is gathered from an intent.
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
			if(resultCode == RESULT_OK){
				if(requestCode == CALCULATE_RESULT){
						updateComponentRowUFactor(Integer.valueOf(data.getStringExtra("rowNumber")), data);
				}
			
		}
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

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
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
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
					for(int i = 0; i < 15; i++){
						System.out.println("Resuls:" + result_Array[i]);
					}
					int temp_Counter = 0;
					//Envelope tab.
					for(int j = 15; j < result_Array.length; j++){
						if(temp_Counter < 12){
						System.out.println("Resuls:" + result_Array[j]);
						}
						else{
							temp_Counter = 0;
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
}

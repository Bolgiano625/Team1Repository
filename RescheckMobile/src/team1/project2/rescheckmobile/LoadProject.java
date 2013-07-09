package team1.project2.rescheckmobile;

import java.io.FileInputStream;
import java.util.LinkedList;
import android.app.Activity;
import android.os.Bundle;

/**
*----------------------------------
*Christopher T. Bolgiano
*Start time/date: 4:30pm, 7/7/2013
*End time/date: , 7/7/13
*----------------------------------
**/
public class LoadProject extends Activity{
	
	//File input stream.
	private FileInputStream fileInputStream;
	//Number of files found.
	private int numberOfFiles_int;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.load_layout);
	}
	
	/**
	 * getFilesFromInternalStorage
	 * 
	 * Retrieves all the internal files that are associated with this application.
	 */
	private void getFilesFromInternalStorage(){
		
	}
	
	/**
	 * renderFilesFromInternalStorage
	 * 
	 * Renders each file as a row with a load and delete button.
	 */
	private void renderFilesFromInternalStorage(){
		
	}
}

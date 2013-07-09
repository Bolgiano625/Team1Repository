package team1.project2.rescheckmobile;

import android.app.Activity;
import android.os.Bundle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import android.content.Context;
/**
*----------------------------------
*Christopher T. Bolgiano
*Start time/date: 11:40pm, 7/7/2013
*End time/date: 5:18pm, 7/7/13
*----------------------------------
**/
public class SaveProject{
	//File output stream.
	private FileOutputStream fileOutputStream;
	//Object output stream.
	private ObjectOutputStream objectOutputStream;
	//Project tab.
	private ProjectActivity projectTab;
	//Envelope tab.
	private EnvelopeActivity envelopeTab;
	//Delimeter.
	private String delimeter = ",";
	//public void onCreate(Bundle savedInstanceState){
		//super.onCreate(savedInstanceState);
	public SaveProject(){	
		try {
			writeToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * writeToFile
	 * 
	 * Writes all project parameters to file.
	 * @throws IOException 
	 */
	private void writeToFile() throws IOException{
		projectTab = ProjectActivity.projectTab;
		envelopeTab = EnvelopeActivity.envelopeTab;	
		//Project Tab.
		//Output stream for a specified file.
		fileOutputStream = projectTab.openFileOutput(projectTab.getProjectTitle(),Context.MODE_PRIVATE);
		//Output stream for objects.
		objectOutputStream = new ObjectOutputStream(fileOutputStream);
		//Title.
		fileOutputStream.write(projectTab.getProjectTitle().getBytes());
		//Delimiter.
		fileOutputStream.write(delimeter.getBytes());
		//Code spinner selection.
		fileOutputStream.write(String.valueOf(projectTab.getCodeSpinner().getSelectedItem()).getBytes());
		//Delimiter.
		fileOutputStream.write(delimeter.getBytes());
		//State spinner selection.
		fileOutputStream.write(String.valueOf(projectTab.getStateSpinner().getSelectedItem()).getBytes());
		//Delimiter.
		fileOutputStream.write(delimeter.getBytes());
		//City spinner selection.
		fileOutputStream.write(String.valueOf(projectTab.getCitySpinner().getSelectedItem()).getBytes());
		//Delimiter.
		fileOutputStream.write(delimeter.getBytes());
		//County spinner selection.
		fileOutputStream.write(String.valueOf(projectTab.getCountySpinner().getSelectedItem()).getBytes());
		//Delimiter.
		fileOutputStream.write(delimeter.getBytes());
		//City radio button.
		fileOutputStream.write(String.valueOf(projectTab.getCityRadioButton().isSelected()).getBytes());
		//Delimiter.
		fileOutputStream.write(delimeter.getBytes());
		//County radio button.
		fileOutputStream.write(String.valueOf(projectTab.getCountyRadioButton().isSelected()).getBytes());
		//Delimiter.
		fileOutputStream.write(delimeter.getBytes());
		//New construction radio button.
		fileOutputStream.write(String.valueOf(projectTab.getNewConstructionRadioButton().isSelected()).getBytes());
		//Delimiter.
		fileOutputStream.write(delimeter.getBytes());
		//Addition radio button.
		fileOutputStream.write(String.valueOf(projectTab.getAdditionRadioButton().isSelected()).getBytes());
		//Delimiter.
		fileOutputStream.write(delimeter.getBytes());
		//Alteration radio button.
		fileOutputStream.write(String.valueOf(projectTab.getAlterationRadioButton().isSelected()).getBytes());
		//Delimiter.
		fileOutputStream.write(delimeter.getBytes());
		//UA Trade-OFF radio button.
		fileOutputStream.write(String.valueOf(projectTab.getUATradeOffRadioButton().isSelected()).getBytes());
		//Delimiter.
		fileOutputStream.write(delimeter.getBytes());
		//Performance alternative radio button.
		fileOutputStream.write(String.valueOf(projectTab.getPerformanceAlternativeRadioButton().isSelected()).getBytes());
		//Delimiter.
		fileOutputStream.write(delimeter.getBytes());
		//1 and 2 Family radio button.
		fileOutputStream.write(String.valueOf(projectTab.getOneAndTwoFamilyRadioButton().isSelected()).getBytes());
		//Delimiter.
		fileOutputStream.write(delimeter.getBytes());
		//Multifamily radio button.
		fileOutputStream.write(String.valueOf(projectTab.getMultifamilyRadioButton().isSelected()).getBytes());
		//Delimiter.
		fileOutputStream.write(delimeter.getBytes());
		//Notes.
		fileOutputStream.write(projectTab.getProjectNotes().getBytes());
		//Delimiter.
		fileOutputStream.write(delimeter.getBytes());
		
		//Envelope Tab.
		objectOutputStream.writeObject(EnvelopeActivity.rows_LinkedList);
		
		//Close writers.
		fileOutputStream.close();
		objectOutputStream.close();
	}
}

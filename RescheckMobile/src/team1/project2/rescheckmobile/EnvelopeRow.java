package team1.project2.rescheckmobile;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

/**
 * EnvelopeRow
 * -----------------------------------
 * Christopher T. Bolgiano
 * Start time/date 6:08pm, 7/3/13
 * End time/date 6:34pm,7/3/13
 * -----------------------------------
 * @author cbolgiano
 *
 */
public class EnvelopeRow extends Activity{
	
	//Index to keep track of the number of rows.
	private TextView index_TextView;
	//TextField for the component column.
	private EditText component_EditText;
	//TextView for the assembly column.
	private TextView assembly_TextView;
	//TextField for the gross area column.
	private EditText grossArea_EditText;
	//TextField for the cavity insulation R-Value column.
	private EditText cavityIRValue_EditText;
	//TextField for the continuous insulation R-Value column.
	private EditText continuousIRValue_EditText;
	//TextView for the u-factor column.
	private TextView uFactor_TextView;
	//TextView for the SHGC column.
	private TextView sHGC_TextView;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.row_layout);
		instantiateTextFields();
		instantiateTextView();
	}
	
	/**
	 * instantiateTextFields
	 * 
	 * Instantiates every text field per row.
	 */
	private void instantiateTextFields(){
		//Component column.
		component_EditText = (EditText)findViewById(R.id.componentColumn);
		//Gross area column.
		grossArea_EditText = (EditText)findViewById(R.id.grossAreaColumn);
		//Cavity insulation R-Value column.
		cavityIRValue_EditText = (EditText)findViewById(R.id.cavityIRValueColumn);
		//Continuous insulation R-Value column.
		continuousIRValue_EditText = (EditText)findViewById(R.id.continuousIRValueColumn);
	}
	
	/**
	 * instantiateTextViews
	 * 
	 * Instantiates every text view per row.
	 */
	private void instantiateTextView(){
		//Index column.
		index_TextView = (TextView)findViewById(R.id.indexColumn);
		//Assembly column.
		assembly_TextView = (TextView)findViewById(R.id.assemblyColumn);
		//U-Factor column.
		uFactor_TextView = (TextView)findViewById(R.id.uFactorColumn);
		//SHGC column.
		sHGC_TextView = (TextView)findViewById(R.id.sHGCColumn);
	}
}

package team1.project2.rescheckmobile;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	//Host for tabbed panes.
	private TabHost tabHost;
	//Tab for home.
	private TabSpec homeTab;
	//Tab for project.
	private TabSpec projectTab;
	//Tab for envelope.
	private TabSpec envelopeTab;
	//Tab for mechanical.
	private TabSpec mechanicalTab;
	//Intent for the home activity.
	private Intent homeIntent;
	//Intent for the project activity.
	private Intent projectIntent;
	//Intent for the envelope activity.
	private Intent envelopeIntent;
	//Intent for the mechanical activity.
	private Intent mechanicalIntent;
	
	
	/* (non-Javadoc)
	 * @see android.app.ActivityGroup#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project);
		initializeTabbedView();
		
	}
	
	/**
	 * initializeTabbedView Method
	 * 
	 * Initializes or instantiates all tabs. 
	 */
	private void initializeTabbedView(){
		tabHost = getTabHost();
		tabHost.setup();
		instantiateHomeTab();
		instantiateProjectTab();
		instantiateEnvelopeTab();
		instantiateMechanicalTab();
		tabHost.addTab(homeTab);
		tabHost.addTab(projectTab);
		tabHost.addTab(envelopeTab);
		tabHost.addTab(mechanicalTab);
	}
	
	/**
	 * instantiateHomeTab Method
	 * 
	 * Instantiates the home tab
	 */
	private void instantiateHomeTab(){
		homeTab = tabHost.newTabSpec("Home");
		homeIntent = new Intent(this, HomeActivity.class);
		homeTab.setIndicator("Home");
		homeTab.setContent(homeIntent);
	}

	/**
	 * instantiateProjectTab Method
	 * 
	 * Instantiates the project tab
	 */
	private void instantiateProjectTab(){
		projectTab = tabHost.newTabSpec("Project");
		projectIntent = new Intent(this, ProjectActivity.class);
		projectTab.setIndicator("Project");
		projectTab.setContent(projectIntent);
	}
	
	/**
	 * instantiateEnvelopeTab Method
	 * 
	 * Instantiates the envelope tab
	 */
	private void instantiateEnvelopeTab(){
		envelopeTab = tabHost.newTabSpec("Envelope");
		envelopeIntent = new Intent(this, EnvelopeActivity.class);
		envelopeTab.setIndicator("Envelope");
		envelopeTab.setContent(envelopeIntent);
	}
	
	/**
	 * instantiateMechanicalTab Method
	 * 
	 * Instantiates the mechanical tab
	 */
	private void instantiateMechanicalTab(){
		mechanicalTab = tabHost.newTabSpec("Mechanical");
		mechanicalIntent = new Intent(this, MechanicalActivity.class);
		mechanicalTab.setIndicator("Mechanical");
		mechanicalTab.setContent(mechanicalIntent);
	}
}

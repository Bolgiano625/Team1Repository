package team1.project2.rescheckmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends Activity{
	
	//New project button.
	private Button newProject_Button;
	//Load project button.
	private Button loadProject_Button;
		
	//Logo image.
	private ImageView logo_ImageView;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initializeImages();
		initializeButtons();
	}
	
	/**
	 *initializeImages Method
	 *
	 *Initializes images.
	 */
	private void initializeImages(){
		logo_ImageView = (ImageView)findViewById(R.id.logo);
		logo_ImageView.setImageResource(R.raw.logo);
	}
	
	/**
	 *initializeButtons Method
	 *
	 *Initializes and or instantiates all buttons and their listeners.
	 */
	private void initializeButtons(){
		//New Project Button.
		newProject_Button = (Button)findViewById(R.id.newProject);
		newProject_Button.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//Start a new activity here by creating a new intent.
				Intent i = new Intent(HomeActivity.this,MainActivity.class);
				startActivity(i);
			}
		});
		//Load Project Button
		loadProject_Button = (Button)findViewById(R.id.loadProject);
		loadProject_Button.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//Load an existing project.
				Intent i = new Intent(HomeActivity.this,LoadProject.class);
				startActivity(i);
			}
		});
	}
}

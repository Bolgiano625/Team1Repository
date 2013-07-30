package team1.project2.rescheckmobile;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class CalculateActivity extends Activity {
	
	//Component
	private String component_String;
	//Row
	private int row_int;
	//Cavity insulation R-Value
	private double cavityIRV_double;
	//Continuous insulation R-Value
	private double continuousIRV_double;
	//Assembly value.
	private String a_String;
	//Gross area value.
	private double gA_double;
	//Depth of insulation.
	private double dOI_double;
	//Wall height.
	private double wH_double;
	//Depth below grade.
	private double dBG_double;
	//Depth below inside grade.
	private double dBIG_double;
	//CheckCompliance
	private String check_String;
	//Communication between the envelope activity.
	private Bundle extra;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		extra = getIntent().getExtras();
		//Component
		component_String = extra.getString("a");
		System.out.println("Component!:" + extra.getString("a"));
		//Assembly
		a_String = extra.getString("b");
		System.out.println("Assembly!:" + extra.getString("b"));
		System.out.println("Assembly String Length!:" + extra.getString("b").length());
		//Gross Area
		if(extra.getString("c").equals("")){
			gA_double = 0;
		}
		else{
			gA_double = Double.parseDouble(extra.getString("c"));
			System.out.println("Gross Area!:" + extra.getString("c"));
		}
		//Row
		row_int = Integer.parseInt(extra.getString("d"));
		System.out.println("Row!: " + extra.getString("d"));
		//Cavity insulation R-Value
		if(extra.getString("e").equals("")){
			cavityIRV_double = 0;
		}
		else{
			cavityIRV_double = Double.parseDouble(extra.getString("e"));
			System.out.println("Cavity!: " + extra.getString("e"));
		}
		//Continuous insulation R-Value
		if(extra.getString("f").equals("")){
			continuousIRV_double = 0;
		}
		else{
			continuousIRV_double = Double.parseDouble(extra.getString("f"));
			System.out.println("Continuous!: " + extra.getString("f"));
		}
		//Depth of insulation.
		if(extra.getString("g").equals("")){
			dOI_double = 0;
		}
		else{
			dOI_double = Double.parseDouble(extra.getString("g"));
			System.out.println("Depth of insulation!: " + extra.getString("g"));
		}
		//Wall Height.
		if(extra.getString("h").equals("")){
			wH_double = 0;
		}
		else{
			wH_double = Double.parseDouble(extra.getString("h"));
			System.out.println("Wall Height!: " + extra.getString("h"));
		}
		//Depth Below Grade.
		if(extra.getString("i").equals("")){
			dBG_double = 0;
		}
		else{
			dBG_double = Double.parseDouble(extra.getString("i"));
			System.out.println("Depth Below Grade!: " + extra.getString("i"));
		}
		//Depth Below Inside Grade.
		if(extra.getString("j").equals("")){
			dBIG_double = 0;
		}
		else{
			dBIG_double = Double.parseDouble(extra.getString("j"));
			System.out.println("Depth Below Inside Grade!: " + extra.getString("j"));
		}
		//Results Intent.
		Intent i = new Intent();
		//Calculations if component equals Ceiling.
		if(component_String.equals("Ceiling")){
			System.out.println("I am in ceiling.");
			//Calculations if assembly equals Flat or Scissor Truss or Raised or Energy Truss.
			if(a_String.equals("Flat or Scissor Truss") || a_String.equals("Raised or Energy Truss")){
				double flatCeilingUFactor = calculateFlatCeilingUFactor(cavityIRV_double, continuousIRV_double);
				i.putExtra("uFactor", String.valueOf(flatCeilingUFactor));
			}
			//Calculations if assembly equals Cathedral.
			else if(a_String.equals("Cathedral")){
				double cathedralCeilingUFactor = calculateCathedralCeilingUFactor(cavityIRV_double, continuousIRV_double);
				i.putExtra("uFactor", String.valueOf(cathedralCeilingUFactor));
			}
			//Calculations if assembly equals Steel Truss.
			else if(a_String.equals("Steel Truss")){
				double steelFrameTrussCeilingUFactor = calculateSteelFrameTrussCeilingUFactor(0.0, 0.0);
				i.putExtra("uFactor", String.valueOf(steelFrameTrussCeilingUFactor));
			}
			//Calculations if assembly equals Structural Insulated Panels.
			else if(a_String.equals("Structural Insulated Panels")){
				double sipCeilingUFactor = calculateCeilingSIPUFactor(continuousIRV_double);
				i.putExtra("uFactor", String.valueOf(sipCeilingUFactor));
			}
			//Calculations if assembly equals Steel Joist/Rafter,16in.o.c..
			else if(a_String.substring(0,"Steel Joist/Rafter,16in.o.c.,".length()).equals("Steel Joist/Rafter,16in.o.c.,")){
				double steelFrameJoistCeilingUFactor = calculateSteelFrameJoistCeilingUFactor(cavityIRV_double, continuousIRV_double, 16, a_String.substring("Steel Joist/Rafter,16in.o.c.,".length()));
				i.putExtra("uFactor", String.valueOf(steelFrameJoistCeilingUFactor));
			}
			//Calculations if assembly equals Steel Joist/Rafter,24in.o.c..
			else if(a_String.substring(0,"Steel Joist/Rafter,24in.o.c.,".length()).equals("Steel Joist/Rafter,24in.o.c.,")){
				double steelFrameJoistCeilingUFactor = calculateSteelFrameJoistCeilingUFactor(cavityIRV_double, continuousIRV_double, 24, a_String.substring("Steel Joist/Rafter,24in.o.c.,".length()));
				i.putExtra("uFactor", String.valueOf(steelFrameJoistCeilingUFactor));
			}
		}
		//Calculations if component equals Skylight.
		else if(component_String.equals("Skylight")){
			//Calculations if assembly equals Metal Frame.
			if(a_String.substring(0,"Metal Frame,".length()).equals("Metal Frame,")){
				System.out.println("Metal Frame!!!!!");
			}
			//Calculations if assembly equals Metal Thermal Break.
			else if(a_String.substring(0,"Metal Thermal Break,".length()).equals("Metal, Thermal Break,")){
				System.out.println("Metal Frame Thermal Break!!!!!");
			}
			//Calculations if assembly equals Wood Frame.
			else if(a_String.substring(0,"Wood Frame,".length()).equals("Wood Frame,")){
				System.out.println("Wood Frame Break!!!!!");
			}
			//Calculations if assembly equals Vinyl Frame.
			else if(a_String.substring(0,"Vinyl Frame,".length()).equals("Vinyl Frame,")){
				System.out.println("Vinyl Frame Break!!!!!");
			}
		}
		//Calculations if component equals Walls.
		else if(component_String.equals("Wall")){
			System.out.println(a_String.substring(a_String.length()-4));
			//Calculations if assembly equals Wood Frame, 16in.o.c..
			if(a_String.equals("Wood Frame, 16in.o.c.")){
				double woodFrameWallUFactor = calculateWoodFrameWallUFactor(cavityIRV_double, continuousIRV_double, 16);
				i.putExtra("uFactor", String.valueOf(woodFrameWallUFactor));
				System.out.println("Wood Frame,16in.o.c.!!!!");
			}
			//Calculations if assembly equals Wood Frame, 24in.o.c..
			else if(a_String.equals("Wood Frame, 24in.o.c.")){
				double woodFrameWallUFactor = calculateWoodFrameWallUFactor(cavityIRV_double, continuousIRV_double, 24);
				i.putExtra("uFactor", String.valueOf(woodFrameWallUFactor));
				System.out.println("Wood Frame,24in.o.c.!!!!");
			}
			//Calculations if assembly equals Steel Frame, 16in.o.c..
			else if(a_String.equals("Steel Frame, 16in.o.c.")){
				double steelFrameWallUFactor = calculateSteelFrameWallUFactor(cavityIRV_double, continuousIRV_double, 16);
				i.putExtra("uFactor", String.valueOf(steelFrameWallUFactor));
				System.out.println("Wood Frame,16in.o.c.!!!!");
			}
			//Calculations if assembly equals Steel Frame, 24in.o.c..
			else if(a_String.equals("Steel Frame, 24in.o.c.")){
				double steelFrameWallUFactor = calculateSteelFrameWallUFactor(cavityIRV_double, continuousIRV_double, 24);
				i.putExtra("uFactor", String.valueOf(steelFrameWallUFactor));
				System.out.println("Wood Frame,24in.o.c.!!!!");
			}
			//Calculations if assembly equals Logs.
			else if(a_String.substring(a_String.length()-4).equals("Logs")){
				System.out.println(a_String + "!!!!!!!!!!!!");
			}
			//Calculations if assembly equals Structural Insulated Panels.
			else if(a_String.equals("Structural Insulated Panels")){
				double wallSIPUFactor = calculateWallSIPUFactor(continuousIRV_double);
				i.putExtra("uFactor", String.valueOf(wallSIPUFactor));
				System.out.println(a_String + "!!!!!!!!!!");
			}
			//Calculations if assembly equals Insulated Concrete Forms.
			else if(a_String.equals("Insulated Concrete Forms")){
				if(wH_double > 0 && dBG_double > 0){
					double belowGradeInsulatedConcreteFormsUFactor = calculateBelowGradeInsulatedConcreteFormsUFactor(continuousIRV_double, wH_double, dBG_double);
					i.putExtra("uFactor", String.valueOf(belowGradeInsulatedConcreteFormsUFactor));
				}
				else{
					double aboveGradeInsulatedConcreteFormsUFactor = calculateAboveGradeInsulatedConcreteFormsUFactor(continuousIRV_double);
					i.putExtra("uFactor", String.valueOf(aboveGradeInsulatedConcreteFormsUFactor));
				}
				System.out.println(a_String + "!!!!!!!!!!");
			}
			//Calculations if assembly equals Solid Concrete or Masonry.
			else if(a_String.substring(0,"Solid Concrete or Masonry w/".length()).equals("Solid Concrete or Masonry w/")){
				double solidConcreteWallUFactor = calculateSolidConcreteWallUFactor(cavityIRV_double, continuousIRV_double);
				i.putExtra("uFactor", String.valueOf(solidConcreteWallUFactor));
				System.out.println(a_String + "!!!!!!!!!!");
			}
			//Calculations if assembly equals Masonry Block w/ Empty Cells.
			else if(a_String.substring(0,"Masonry Block w/ Empty Cells:".length()).equals("Masonry Block w/ Empty Cells:")){
				double masonryBlockEmptyCellWallUFactor = calculateMasonryBlockEmptyCellWallUFactor(cavityIRV_double, continuousIRV_double);
				i.putExtra("uFactor", String.valueOf(masonryBlockEmptyCellWallUFactor));
				System.out.println(a_String + "!!!!!!!!!!");
			}
			//Calculations if assembly equals Masonry Block w/ Integral Insulation.
			else if(a_String.substring(0,"Masonry Block w/ Integral Insulation:".length()).equals("Masonry Block w/ Integral Insulation:")){
				double masonryBlockIntegralCellWallUFactor = calculateMasonryBlockIntegralCellWallUFactor(cavityIRV_double, continuousIRV_double);
				i.putExtra("uFactor", String.valueOf(masonryBlockIntegralCellWallUFactor));
				System.out.println(a_String + "!!!!!!!!!!");
			}
		}
		//Calculations if component equals Window.
		else if(component_String.equals("Window")){
			//Calculations if assembly equals Metal Frame.
			if(a_String.substring(0,"Metal Frame,".length()).equals("Metal Frame,")){
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Metal Thermal Break.
			else if(a_String.substring(0,"Metal Thermal Break,".length()).equals("Metal, Thermal Break,")){
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Wood Frame.
			else if(a_String.substring(0,"Wood Frame,".length()).equals("Wood Frame,")){
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Vinyl Frame.
			else if(a_String.substring(0,"Vinyl Frame,".length()).equals("Vinyl Frame,")){
				System.out.println(a_String + "!!!!!");
			}
		}
		//Calculations if component equals Door.
		else if(component_String.equals("Door")){
			//Calculations if assembly equals Solid.
			if(a_String.equals("Solid")){
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Glass.
			else if(a_String.equals("Glass")){
				System.out.println(a_String + "!!!!!");
			}
		}
		//Calculations if component equals Basement.
		else if(component_String.equals("Basement")){
			//Calculations if assembly equals Solid Concrete or Masonry.
			if(a_String.equals("Solid Concrete or Masonry")){
				double proposedBasementWallUFactor = calculateProposedBasementWallUFactor(cavityIRV_double, continuousIRV_double, gA_double, wH_double, dBG_double);
				i.putExtra("uFactor", String.valueOf(proposedBasementWallUFactor));
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Masonry Block w/ Empty Cells.
			else if(a_String.equals("Masonry Block w/ Empty Cells")){
				double proposedBasementWallUFactor = calculateProposedBasementWallUFactor(cavityIRV_double, continuousIRV_double, gA_double, wH_double, dBG_double);
				i.putExtra("uFactor", String.valueOf(proposedBasementWallUFactor));
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Masonry Block w/ Integral Insulation.
			else if(a_String.equals("Masonry Block w/ Integral Insulation")){
				double proposedBasementWallUFactor = calculateProposedBasementWallUFactor(cavityIRV_double, continuousIRV_double, gA_double, wH_double, dBG_double);
				i.putExtra("uFactor", String.valueOf(proposedBasementWallUFactor));
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Wood Frame.
			else if(a_String.equals("Wood Frame")){
				double proposedBasementWallUFactor = calculateProposedBasementWallUFactor(cavityIRV_double, continuousIRV_double, gA_double, wH_double, dBG_double);
				i.putExtra("uFactor", String.valueOf(proposedBasementWallUFactor));
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Insulated Concrete Forms.
			else if(a_String.equals("Insulated Concrete Forms")){
				double proposedBasementWallUFactor = calculateProposedBasementWallUFactor(cavityIRV_double, continuousIRV_double, gA_double, wH_double, dBG_double);
				i.putExtra("uFactor", String.valueOf(proposedBasementWallUFactor));
				System.out.println(a_String + "!!!!!");
			}
		}
		//Calculations if component equals Floor.
		else if(component_String.equals("Floor")){
			//Calculations if assembly equals All-Wood Joist/Truss.
			if(a_String.substring(0,"All-Wood Joist/Truss".length()).equals("All-Wood Joist/Truss")){
				double allWoodJoistFloorsUFactor = calculateAllWoodJoistFloorsUFactor(cavityIRV_double);
				i.putExtra("uFactor", String.valueOf(allWoodJoistFloorsUFactor));
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Slab-On-Grade(Heated)-Insulation Depth(ft).
			else if(a_String.substring(0,"Heated Slab-On-Grade".length()).equals("Heated Slab-On-Grade")){
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Slab-On-Grade(Unheated)-Insulation Depth(ft).
			else if(a_String.substring(0,"Unheated Slab-On-Grade".length()).equals("Unheated Slab-On-Grade")){
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Steel Frame, 16in.o.c..
			else if(a_String.substring(0,"Steel Frame, 16in o.c.,".length()).equals("Steel Frame, 16in o.c.,")){
				double steelFrameFloorUFactor = calculateSteelFrameFloorUFactor(cavityIRV_double, continuousIRV_double, 16, a_String.substring("Steel Frame, 16in o.c.,".length()));
				i.putExtra("uFactor", String.valueOf(steelFrameFloorUFactor));
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Steel Frame, 24in.o.c..
			else if(a_String.substring(0,"Steel Frame, 24in o.c.,".length()).equals("Steel Frame, 24in o.c.,")){
				double steelFrameFloorUFactor = calculateSteelFrameFloorUFactor(cavityIRV_double, continuousIRV_double, 24, a_String.substring("Steel Frame, 16in o.c.,".length()));
				i.putExtra("uFactor", String.valueOf(steelFrameFloorUFactor));
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Structural Insulated Panels.
			else if(a_String.substring(0,"Insulated Panels".length()).equals("Insulated Panels")){
				double floorSIPUFactor = calculateFloorSIPUFactor(continuousIRV_double);
				i.putExtra("uFactor", String.valueOf(floorSIPUFactor));
				System.out.println(a_String + "!!!!!");
			}
		}
		//Calculations if component equals Crawl.
		else if(component_String.equals("Crawl")){
			//Calculations if assembly equals Solid Concrete or Masonry.
			if(a_String.equals("Solid Concrete or Masonry")){
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Masonry Block w/ Empty Cells.
			else if(a_String.equals("Masonry Block w/ Empty Cells")){
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Masonry Block w/ Integral Insulation.
			else if(a_String.equals("Masonry Block w/ Integral Insulation")){
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Wood Frame.
			else if(a_String.equals("Wood Frame")){
				System.out.println(a_String + "!!!!!");
			}
			//Calculations if assembly equals Insulated Concrete Forms.
			else if(a_String.equals("Insulated Concrete Forms")){
				System.out.println(a_String + "!!!!!");
			}
		}
		
		i.putExtra("rowNumber", String.valueOf(row_int));
		setResult(RESULT_OK, i);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	//*********************************************************************
	//********************Ceiling Calcs************************************
	//*********************************************************************
	public double calculateFlatCeilingUFactor(double cavityRValue, double sheathingRValue)
	{
		double ceilingUFactor;
		double Rij = getCeilingRIJ(cavityRValue);
		double Ric = getCeilingRIC(cavityRValue);
		double Rs = sheathingRValue;
		
		ceilingUFactor = ((0.07/(6.05+Rij+Rs)) + (0.93/(1.67+Ric+Rs)));
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(ceilingUFactor));
	}
	
	public double getCeilingRIC(double cavityRValue)
	{
		double RIC;
		
		double ricNominal = cavityRValue;
		double yicFull = cavityRValue/2.5;
		double yicEave;
		if (yicFull > 15.86)
		{
			yicEave = 15.86;
		}
		else
		{
			yicEave = 3.86;
		}
		double roofHeight = 56;
		
		RIC = (ricNominal/(1 + (yicFull/roofHeight) * (Math.log((yicFull/yicEave))) - ((yicFull - yicEave)/roofHeight)));
		
		return RIC;
	}
	
	public double getCeilingRIJ(double cavityRValue)
	{
		double RIJ;
		
		double rijNominal = cavityRValue - (3.5 * 2.5);
		double yijFull = (cavityRValue/2.5) - 3.5;
		double yijEave;
		if (yijFull > 12.36)
		{
			yijEave = 12.36;
		}
		else
		{
			yijEave = .36;
		}
		int roofHeight = 56;
		
		RIJ = (rijNominal/(1 + (yijFull/roofHeight) * (Math.log(yijFull/yijEave)) - ((yijFull - yijEave)/roofHeight)));
		
		return RIJ;
	}
	
	public double calculateCathedralCeilingUFactor(double cavityRValue, double sheathingRValue)
	{
		double ceilingUFactor;
		
		double Ri = cavityRValue;
		double Rs = sheathingRValue;
		double Rr = 1.25 * (Ri/3.0);
		
		ceilingUFactor = ((0.07/(1.67 + Rr + Rs)) + (0.93/(1.67 + Ri + Rs)));
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(ceilingUFactor));
	}
	
	public double calculateSteelFrameJoistCeilingUFactor(double cavityRValue, double sheathingRValue, int framingSpacing, String memberSize)
	{
		double ceilingUFactor;
		
		double Rs = sheathingRValue;
		double Fcor = getCorrectionFactor(cavityRValue, framingSpacing, memberSize);
		double Ric = cavityRValue;
		
		ceilingUFactor = (1/(1.67 + Rs + (Fcor * Ric)));
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(ceilingUFactor));
	}
	
	public double getCorrectionFactor(double rValue, int framingSpacing, String memberSize)
	{
		double correctionFactor = 0.0;
		if (framingSpacing == 16)
		{
			if (rValue == 19)
			{
				if (memberSize == "2x4")
				{
				correctionFactor = .90;
				}
				else if (memberSize == "2x6")
				{
					correctionFactor = .70;
				}
				else if (memberSize == "2x8")
				{
					correctionFactor = .35;
				}
				else if (memberSize == "2x10")
				{
					correctionFactor = .35;
				}
				else if (memberSize == "2x12")
				{
					correctionFactor = .35;
				}
			}
			else if (rValue == 30)
			{
				if (memberSize == "2x4")
				{
				correctionFactor = .94;
				}
				else if (memberSize == "2x6")
				{
					correctionFactor = .81;
				}
				else if (memberSize == "2x8")
				{
					correctionFactor = .65;
				}
				else if (memberSize == "2x10")
				{
					correctionFactor = .27;
				}
				else if (memberSize == "2x12")
				{
					correctionFactor = .27;
				}
			}
			else if (rValue == 38)
			{
				if (memberSize == "2x4")
				{
				correctionFactor = .95;
				}
				else if (memberSize == "2x6")
				{
					correctionFactor = .85;
				}
				else if (memberSize == "2x8")
				{
					correctionFactor = .72;
				}
				else if (memberSize == "2x10")
				{
					correctionFactor = .62;
				}
				else if (memberSize == "2x12")
				{
					correctionFactor = .51;
				}
			}
			else if (rValue == 49)
			{
				if (memberSize == "2x4")
				{
				correctionFactor = .96;
				}
				else if (memberSize == "2x6")
				{
					correctionFactor = .88;
				}
				else if (memberSize == "2x8")
				{
					correctionFactor = .78;
				}
				else if (memberSize == "2x10")
				{
					correctionFactor = .70;
				}
				else if (memberSize == "2x12")
				{
					correctionFactor = .62;
				}
			}
		}
		else if (framingSpacing == 24)
		{
			if (rValue == 19)
			{
				if (memberSize == "2x4")
				{
				correctionFactor = .95;
				}
				else if (memberSize == "2x6")
				{
					correctionFactor = .78;
				}
				else if (memberSize == "2x8")
				{
					correctionFactor = .44;
				}
				else if (memberSize == "2x10")
				{
					correctionFactor = .44;
				}
				else if (memberSize == "2x12")
				{
					correctionFactor = .44;
				}
			}
			else if (rValue == 30)
			{
				if (memberSize == "2x4")
				{
				correctionFactor = .96;
				}
				else if (memberSize == "2x6")
				{
					correctionFactor = .86;
				}
				else if (memberSize == "2x8")
				{
					correctionFactor = .72;
				}
				else if (memberSize == "2x10")
				{
					correctionFactor = .35;
				}
				else if (memberSize == "2x12")
				{
					correctionFactor = .35;
				}
			}
			else if (rValue == 38)
			{
				if (memberSize == "2x4")
				{
				correctionFactor = .97;
				}
				else if (memberSize == "2x6")
				{
					correctionFactor = .88;
				}
				else if (memberSize == "2x8")
				{
					correctionFactor = .78;
				}
				else if (memberSize == "2x10")
				{
					correctionFactor = .69;
				}
				else if (memberSize == "2x12")
				{
					correctionFactor = .61;
				}
			}
			else if (rValue == 49)
			{
				if (memberSize == "2x4")
				{
				correctionFactor = .97;
				}
				else if (memberSize == "2x6")
				{
					correctionFactor = .91;
				}
				else if (memberSize == "2x8")
				{
					correctionFactor = .83;
				}
				else if (memberSize == "2x10")
				{
					correctionFactor = .76;
				}
				else if (memberSize == "2x12")
				{
					correctionFactor = .69;
				}
			}
		}
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(correctionFactor));
	}
	
	public double calculateSteelFrameTrussCeilingUFactor(double cavityRValue, double sheathingRValue)
	{
		double ceilingUFactor;
		
		double Rs = sheathingRValue;
		double BOA = 0.0;
		if (Rs < 3.0)
		{
			BOA = 0.33;
		}
		else if (Rs >= 3.0 && Rs < 5.0)
		{
			BOA = 1.994;
		}
		else if (Rs >= 5.0)
		{
			BOA = 2.082;
		}
		double Ric = cavityRValue;
		
		ceilingUFactor = (1.0/(BOA + Rs + (0.864 * Ric)));
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(ceilingUFactor));
		
	}
	
	public double calculateCeilingSIPUFactor(double sheathingRValue)
	{
		double wallUFactor = 1.67 + (sheathingRValue * .91);
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(wallUFactor));
	}
	
	
	//*********************************************************************
	//********************Wall Calcs***************************************
	//*********************************************************************
	public double calculateWoodFrameWallUFactor(double cavityRValue, double sheathingRValue, int onCenter)
	{
		double wallUFactor = 0.0;
		double Rs = 0.0;
		double Rw = 0.0;
		double Ri = 0.0;
		
		if (sheathingRValue == 0)
		{
			Rs = .83;
		}
		else
		{
			Rs = sheathingRValue; 
		}
		
		if (cavityRValue <= 15.0)
		{
			Rw = 4.38;
		}
		else if (cavityRValue > 15.0)
		{
			Rw = 6.88;
		}
		
		if (cavityRValue < 11)
		{
			Ri = cavityRValue + .9;
		}
		else
		{
			Ri = cavityRValue;
		}
		
		
		if(onCenter == 16)
		{
			wallUFactor = ((0.25/(1.97 + Rs + Rw)) + (0.75/(1.97 + Rs + Ri)));
		}
		else if (onCenter == 24)
		{
			wallUFactor = ((0.22/(1.97 + Rs + Rw)) + (0.78/(1.97 + Rs + Ri)));
		}
				
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(wallUFactor));
		
	}
	
	public double calculateSteelFrameWallUFactor(double cavityRValue, double sheathingRValue, int spacing)
	{
		double wallUFactor;
		double Rs = 0.0;
		double Re = 0.0;
		
		
		if (sheathingRValue == 0)
		{
			Rs = .83;
		}
		else
		{
			Rs = sheathingRValue;
		}
		
		if (cavityRValue < 11)
		{
			Re = getEquivalentRValue(cavityRValue, spacing) + .9;
		}
		else
		{
			Re = getEquivalentRValue(cavityRValue, spacing);
		}
		
		wallUFactor = (1.0/(1.97 + Rs + Re));
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(wallUFactor));
	}
	
	public double getEquivalentRValue(double cavityRValue, int spacing)
	{
		double equivalentRValue = 0.0;
		
		if (spacing == 16)
		{
			if (cavityRValue >= 0 && cavityRValue <+10.9)
			{
				equivalentRValue = 0.0;
			}
			else if (cavityRValue >= 11.0 && cavityRValue <= 12.9)
			{
				equivalentRValue = 5.5;
			}
			else if (cavityRValue >= 13.0 && cavityRValue <= 14.9)
			{
				equivalentRValue = 6.0;
			}
			else if (cavityRValue >= 15.0 && cavityRValue <= 18.9)
			{
				equivalentRValue = 6.4;
			}
			else if (cavityRValue >= 19.0 && cavityRValue <= 20.9)
			{
				equivalentRValue = 7.1;
			}
			else if (cavityRValue >= 21.0 && cavityRValue <= 24.9)
			{
				equivalentRValue = 7.4;
			}
			else if (cavityRValue >= 25.0)
			{
				equivalentRValue = 7.8;
			}
		}
		else if (spacing == 24)
		{
			if (cavityRValue >= 0 && cavityRValue <+10.9)
			{
				equivalentRValue = 0.0;
			}
			else if (cavityRValue >= 11.0 && cavityRValue <= 12.9)
			{
				equivalentRValue = 6.6;
			}
			else if (cavityRValue >= 13.0 && cavityRValue <= 14.9)
			{
				equivalentRValue = 7.2;
			}
			else if (cavityRValue >= 15.0 && cavityRValue <= 18.9)
			{
				equivalentRValue = 7.8;
			}
			else if (cavityRValue >= 19.0 && cavityRValue <= 20.9)
			{
				equivalentRValue = 8.6;
			}
			else if (cavityRValue >= 21.0 && cavityRValue <= 24.9)
			{
				equivalentRValue = 9.0;
			}
			else if (cavityRValue >= 25.0)
			{
				equivalentRValue = 9.6;
			}
		}
		
		return equivalentRValue;
	}
	
	public double calculateSolidConcreteWallUFactor(double cavityRValue, double sheathingRValue)
	{
		double wallUFactor = 0.0;
		
		double Reff = getInteriorFurringRValue(cavityRValue);
		double Rwall = 1.6;
		double Rcont = sheathingRValue;
		
		if (cavityRValue != 0 || sheathingRValue != 0)
		{
			wallUFactor = (1/(Reff + Rwall + Rcont));
		}
		else
		{
			wallUFactor = 0.333;
		}
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(wallUFactor));
	}

	public double calculateMasonryBlockEmptyCellWallUFactor(double cavityRValue, double sheathingRValue)
	{
		double wallUFactor = 0.0;
		
		double Reff = getInteriorFurringRValue(cavityRValue);
		double Rwall = 1.8;
		double Rcont = sheathingRValue;
		
		wallUFactor = (1/(Reff + Rwall + Rcont));
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(wallUFactor));
	}
	
	public double calculateMasonryBlockIntegralCellWallUFactor(double cavityRValue, double sheathingRValue)
	{
		double wallUFactor = 0.0;
		
		double Reff = getInteriorFurringRValue(cavityRValue);
		double Rwall = 2.4;
		double Rcont = sheathingRValue;
		
		wallUFactor = (1/(Reff + Rwall + Rcont));
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(wallUFactor));
	}
	//*********************************************************************
	//********************Floor Calcs************************************
	//*********************************************************************
	
	public double calculateMassWallUFactor(double cavityRValue, double sheathingRValue, String massWallType)
	{
		double massWallUFactor = 0.0;
		
		double Reff = getInteriorFurringRValue(cavityRValue);
		double RWall = 0.0;
		if (massWallType == "Solid Concrete" || massWallType == "Masonry")
		{
			RWall = 1.6;
		}
		else if (massWallType == "Masonry With Empty Cells")
		{
			RWall = 1.8;
		}
		else if (massWallType == "Masonry With Integral Insulation")
		{
			RWall = 2.4;
		}
		double Rcont = sheathingRValue;
		
		massWallUFactor = (1/(Reff + RWall + Rcont));
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(massWallUFactor));
	}
	
	public double calculateWallSIPUFactor(double sheathingRValue)
	{
		double wallUFactor = 1.38 + (sheathingRValue * .875);
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(wallUFactor));
	}

	public double calculateAboveGradeInsulatedConcreteFormsUFactor(double sheathingRValue)
	{
		double wallUFactor = 1.38 + (sheathingRValue * .89);
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(wallUFactor));
	}
	
	public double calculateBelowGradeInsulatedConcreteFormsUFactor(double sheathingRValue, double wallHeight, double depthBelowGrade)
	{
		double soilImpact = getSoilRValue(depthBelowGrade);
		double wallUFactor = .68 + (sheathingRValue * .89) + soilImpact;
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(wallUFactor));
	}

	
	
	//*********************************************************************
	//********************Floor Calcs**************************************
	//*********************************************************************
	public double calculateAllWoodJoistFloorsUFactor(double cavityRValue)
	{
		double floorUFactor;
		double Ri = cavityRValue;
		double Rj = 1.25 * (Ri/3.0);
		
		floorUFactor = ((0.1/(4.01 + Rj)) + (0.9/(4.01 + Ri)));
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(floorUFactor));		
	}
	
	public double calculateFloorSIPUFactor(double sheathingRValue)
	{
		double wallUFactor = 3.07 + (sheathingRValue * .95);
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(wallUFactor));
	}
	
	public double calculateSteelFrameFloorUFactor(double cavityRValue, double sheathingRValue, int framingSpacing, String memberSize)
	{
		double floorUFactor = 0.0;
		
		double Rs = sheathingRValue;
		double Fcor = getSteelFloorCorrectionFactors(cavityRValue, framingSpacing, memberSize);
		double Ric = cavityRValue;
		
		floorUFactor = (1/(4.01 + Rs + (Fcor * Ric)));
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(floorUFactor));	
	}
	
	public double getSteelFloorCorrectionFactors(double rValue, int framingSpacing, String memberSize)
	{
		double correctionFactor = 0.0;
		if (framingSpacing == 16)
		{
			if (rValue == 19)
			{
				if (memberSize == "2x6")
				{
					correctionFactor = .70;
				}
				else if (memberSize == "2x8")
				{
					correctionFactor = .35;
				}
				else if (memberSize == "2x10")
				{
					correctionFactor = .35;
				}
				else if (memberSize == "2x12")
				{
					correctionFactor = .35;
				}
			}
			else if (rValue == 30)
			{
				if (memberSize == "2x10")
				{
					correctionFactor = .27;
				}
				else if (memberSize == "2x12")
				{
					correctionFactor = .27;
				}
			}
			else if (rValue == 38)
			{
				if (memberSize == "2x12")
				{
					correctionFactor = .24;
				}
			}
		}
		else if (framingSpacing == 24)
		{
			if (rValue == 19)
			{
				if (memberSize == "2x6")
				{
					correctionFactor = .78;
				}
				else if (memberSize == "2x8")
				{
					correctionFactor = .44;
				}
				else if (memberSize == "2x10")
				{
					correctionFactor = .44;
				}
				else if (memberSize == "2x12")
				{
					correctionFactor = .44;
				}
			}
			else if (rValue == 30)
			{
				if (memberSize == "2x10")
				{
					correctionFactor = .35;
				}
				else if (memberSize == "2x12")
				{
					correctionFactor = .35;
				}
			}
			else if (rValue == 38)
			{
				if (memberSize == "2x12")
				{
					correctionFactor = .32;
				}
			}
		}
		return correctionFactor;
	}
	
	
	
	//*********************************************************************
	//********************Basement Calcs***********************************
	//*********************************************************************

	public double calculateProposedBasementWallUFactor(double cavityRValue, double continuousRValue, double wallArea, double wallHeight, double depthBelowGrade)
	{
		double proposedWallUFactor;
		
		double wallRValue = calculateSolidConcreteMasonryUFactor(cavityRValue, continuousRValue);
		double soilRValue = getSoilRValue(depthBelowGrade);
		double area = wallArea;
		
		proposedWallUFactor = ((1/(wallRValue + soilRValue)) * area);
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		return Double.valueOf(df.format(proposedWallUFactor));
	}
		
	public double calculateSolidConcreteMasonryUFactor(double cavityRValue, double continuousRValue)
	{	
		double wallRValue;
		double Reff = getInteriorFurringRValue(cavityRValue);
		double Rwall = 1.6;
		double Rcont = continuousRValue;
		
		wallRValue = Reff +  Rwall + Rcont;
		
		return wallRValue;
	}
	
	public double getInteriorFurringRValue(double cavityRValue)
	{
		double reffRValue = 0.0;
		switch((int)cavityRValue)
		{
		case 0: reffRValue = 1.4;
		break;
		case 1: reffRValue = 1.4;
		break;
		case 2: reffRValue = 2.1;
		break;
		case 3: reffRValue = 2.7;
		break;
		case 4: reffRValue = 3.4;
		break;
		case 5: reffRValue = 4.4;
		break;
		case 6: reffRValue = 4.9;
		break;
		case 7: reffRValue = 5.9;
		break;
		case 8: reffRValue = 6.4;
		break;
		case 9: reffRValue = 7.4;
		break;
		case 10: reffRValue = 7.9;
		break;
		case 11: reffRValue = 9.3;
		break;
		case 12: reffRValue = 9.8;
		break;
		case 13: reffRValue = 10.4;
		break;
		case 14: reffRValue = 10.9;
		break;
		case 15: reffRValue = 11.3;
		break;
		case 16: reffRValue = 13.6;
		break;
		case 17: reffRValue = 14.2;
		break;
		case 18: reffRValue = 14.7;
		break;
		case 19: reffRValue = 15.3;
		break;
		case 20: reffRValue = 15.8;
		break;
		case 21: reffRValue = 16.3;
		break;
		}
		
		return reffRValue;
	}
	
	public double getSoilRValue(double depthBelowGrade)
	{
		double soilRValue = 0.0;
		
		if(depthBelowGrade > 0 && depthBelowGrade <= 1)
		{
			soilRValue = 0.839;
		}
		else if(depthBelowGrade > 1 && depthBelowGrade <= 2)
		{
			soilRValue = 2.905;
		}
		else if(depthBelowGrade > 2 && depthBelowGrade <= 3)
		{
			soilRValue = 4.852;
		}
		else if(depthBelowGrade > 3 && depthBelowGrade <= 4)
		{
			soilRValue = 6.803;
		}
		else if(depthBelowGrade > 4 && depthBelowGrade <= 5)
		{
			soilRValue = 8.817;
		}
		else if(depthBelowGrade > 5 && depthBelowGrade <= 6)
		{
			soilRValue = 11.058;
		}
		else if(depthBelowGrade > 6 && depthBelowGrade <= 7)
		{
			soilRValue = 12.893;
		}
		else if(depthBelowGrade > 7 && depthBelowGrade <= 8)
		{
			soilRValue = 14.793;
		}
		else if(depthBelowGrade > 8 && depthBelowGrade <= 9)
		{
			soilRValue = 16.582;
		}
		else if(depthBelowGrade > 9)
		{
			soilRValue = 18.808;
		}
			
		return soilRValue;
	}	
	
	 
	
}
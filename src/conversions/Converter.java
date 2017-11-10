package conversions;

import java.util.Scanner;

public class Converter {

	final private double INCH_TO_METER = 0.0254;
	final private double FOOT_TO_METER = 0.3048;
	final private double MILE_TO_METER = 1609.344;
	final private double MM_TO_METER = 0.001;
	final private double CM_TO_METER = 0.01;
	final private double KM_TO_METER = 1000;
	final private double YD_TO_METER = 0.9144;
	final private double GALLON_TO_LITER = 3.78541178;
	final private double PINT_TO_LITER = 0.473176473;
	final private double MILLILITER_TO_LITER = 0.001;
	final private double CUBIC_METER_TO_METER = 1000.000;
	
	
	
	static Scanner sc = new Scanner(System.in);
	
	private double factor;
	
	public Converter(String type){
		if(type.equalsIgnoreCase("length")){
			System.out.println("What unit convert to (in/ft/mi/mm/cm/km/yd)");
			String unit = sc.nextLine();
			lengths(unit);
		}else if(type.equalsIgnoreCase("liters")){
			System.out.println("What unit convert to (gallons/pints/milliliters/cubic meters)");
			String unit = sc.nextLine();
			volumes(unit);
		}
		
		
		
	}
	
	public double toOrFromMeters(String what, double measurment){
		if(what.equalsIgnoreCase("to")){
			return (measurment*factor);
		}else{
			return(measurment / factor);
		}
	}
	
	public double toMeters(double measurment){
		return (measurment*factor);
	}
	
	
	
	public double fromMeters(double measurment){
		return(measurment / factor);
	}
	
	public void volumes (String unit){
		
	}
	
	public void lengths(String unit){
		if(unit.equalsIgnoreCase("in")){
			factor= INCH_TO_METER;
		}else if(unit.equalsIgnoreCase("ft")){
			factor = FOOT_TO_METER;
		}else if(unit.equalsIgnoreCase("mi")){
			factor = MILE_TO_METER;
		}else if(unit.equalsIgnoreCase("mm")){
			factor = MM_TO_METER;
		}else if(unit.equalsIgnoreCase("cm")){
			factor = CM_TO_METER;
		}else if(unit.equalsIgnoreCase("km")){
			factor = KM_TO_METER;
		}else if(unit.equalsIgnoreCase("yd")){
			factor = YD_TO_METER;
		}
		
	}
	public static void main(String[] args) {
		
		System.out.println("Convert (meters/liters..)");
		String fromUnit = sc.nextLine();
		
		/*System.out.println("Convert From");
		String toUnit = sc.nextLine();
		*/
		Converter conv = new Converter(fromUnit);
		System.out.println("To or From?");
		String choice = sc.nextLine();
		
		System.out.println("Value");
		double val = sc.nextDouble();
		
		double res = conv.toOrFromMeters(choice, val);
		

		System.out.println(res);
		
		
	}
}
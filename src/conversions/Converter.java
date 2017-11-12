package conversions;

public class Converter {

	final private static double INCH_TO_METER = 0.0254;
	final private static double FOOT_TO_METER = 0.3048;
	final private static double MILE_TO_METER = 1609.344;
	final private static double MM_TO_METER = 0.001;
	final private static double CM_TO_METER = 0.01;
	final private static double KM_TO_METER = 1000;
	final private static double YD_TO_METER = 0.9144;
	final private static double GALLON_TO_LITER = 3.78541178;
	final private static double PINT_TO_LITER = 0.473176473;
	final private static double MILLILITER_TO_LITER = 0.001;
	final private static double CUBIC_METER_TO_LITER = 1000.000;
	final private static double POUND_TO_KG = 0.45359237;
	final private static double OUNCE_TO_KG = 0.0283495231;
	final private static double STONE_TO_KG = 6.35029318;

	public static double toOrFromConvert(String what, double measurment, double factor){
		if(what.equalsIgnoreCase("to")){
			return (measurment*factor);
		}else{
			return(measurment / factor);
		}
	}

	public static double weight(String unit){
		double factor = 0.45359237;
		if(unit.equalsIgnoreCase("pounds")){
			factor= POUND_TO_KG;
		}else if(unit.equalsIgnoreCase("ounces")){
			factor = OUNCE_TO_KG;
		}else if(unit.equalsIgnoreCase("stones")){
			factor = STONE_TO_KG;
		}

		return factor;
	}

	public static double volumes(String unit){
		double factor = 0.001;
		if(unit.equalsIgnoreCase("gallons")){
			factor= GALLON_TO_LITER;
		}else if(unit.equalsIgnoreCase("pints")){
			factor = PINT_TO_LITER;
		}else if(unit.equalsIgnoreCase("milliliters")){
			factor = MILLILITER_TO_LITER;
		}else if(unit.equalsIgnoreCase("cubic meters")){
			factor = CUBIC_METER_TO_LITER;
		}

		return factor;
	}

	public static double lengths(String unit){
		double factor = 1000;
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

		return factor;
	}
}
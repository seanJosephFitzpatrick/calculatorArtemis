package ReversePolishNotation;

public class EquationGenerator {
	
	public static String formatEquation(String userInput){
		String equation = "";
		
		equation = userInput.replace("acos", "bac"); 				//ACos
		equation = equation.replace("asin", "dsn");					//ASin
		equation = equation.replace("atan", "atn");					//ATan 
		
		equation = equation.replace("cos", "cos");					//Cosine
		equation = equation.replace("sin", "sin");					//Sine
		equation = equation.replace("tan", "tan");					//Tangent
		equation = equation.replace("\u221A", "rts");				//Square root
		equation = equation.replace("ln", "elg");					//Natural Log
		equation = equation.replace("log", "lgt");					//Log base 10
		
		equation = equation.replace("\u03C0", Double.toString(Math.PI));
		
		equation = equation.replace("\u00B2", " ^ 2");
		
		return equation;
	}
	
}

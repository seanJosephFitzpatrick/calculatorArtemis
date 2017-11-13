package ReversePolishNotation;

import CombinationsAndProbability.Factorial;

public class EquationGenerator {

	
	public static String formatEquation(String userInput){
		String equation = "";
		
		if(userInput.contains("!")){
			userInput = evaluateFactorial(userInput);
		}
		
		equation = userInput.replace("acos", "bac"); 				//ACos
		equation = equation.replace("asin", "dsn");					//ASin
		equation = equation.replace("atan", "atn");					//ATan 
		
		equation = equation.replace("cos", "cos");					//Cosine
		equation = equation.replace("sin", "sin");					//Sine
		equation = equation.replace("tan", "tan");					//Tangent
		equation = equation.replace("\u221A", "rts");				//Square root
		equation = equation.replace("ln", "elg");					//Natural Log
		equation = equation.replace("log", "lgt");					//Log base 10
		equation = equation.replace("lgx", "nlg");					//Log base x
		equation = equation.replace("\u03C0", Double.toString(Math.PI));
		equation = equation.replace("\u00B2", " ^ 2");
		
		
		System.out.println("sfa" + userInput);
		
		if(equation.contains("nlg")){
			equation = evaluateLogBaseX(equation);
		}
		
		
		System.out.println(equation);
		
		return equation;
	}
	
	public static String evaluateLogBaseX(String userInput){
		String append = "";
		String d = userInput.substring(userInput.indexOf("nlg"));
		String f = d.substring(0, d.indexOf(')'));
		if(f.length() != d.length()){
			append = d.substring(d.indexOf(')') + 1);
		}
		
		String result = "";
		MathematicalEvaluator ME = new MathematicalEvaluator(true);
		String equation = userInput.substring(userInput.indexOf("nlg"), userInput.indexOf(")") + 1);
		equation = ME.logBaseX(equation);
		
		result = userInput.substring(0, userInput.indexOf("nlg"));
		result += equation;	
		
		if(!append.equals("")){
			result += append;
		}
		System.out.println(result);
		
		return result;
	}
	
	public static String evaluateFactorial(String input) throws IllegalArgumentException{
		String equation = "";
		String factorial = "";
		boolean last = false;
		
		if(input.indexOf("!") == input.length() - 1){
			last = true;
		}
		
		int i = (input.indexOf("!") - 1);
		while(i >= 0 && Character.isDigit(input.charAt(i))){
			factorial += input.charAt(i);
			i--;
		}
		
		if(i != -1){
			if(input.charAt(i) == '.'){
				throw new IllegalArgumentException();
			}
		}
		
		factorial = new StringBuilder(factorial).reverse().toString();
		
		int value = Integer.parseInt(factorial);
		
		factorial = Factorial.factorial(value).toString();
		
		equation = input.substring(0, i + 1);
		equation += factorial;
		
		if(!last){
			equation += input.substring(input.indexOf("!") + 1);
		}
		
		if(equation.contains("!")){
			equation = evaluateFactorial(equation);
		}	
		return equation;
	}
	
	
}

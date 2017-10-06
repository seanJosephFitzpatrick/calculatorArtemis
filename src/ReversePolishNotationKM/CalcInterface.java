package ReversePolishNotationKM;

import java.util.Scanner;;

public class CalcInterface {

	static Scanner sc = new Scanner(System.in);

	//Commented Main method to move to GUI input!
	
	public static void main(String[] args){
		String workingInput;
		String storedInput;
		String input = "";
		System.out.println("Please input an expression to evaluate: ");
		System.out.println("(Leave a space between each token)");
		System.out.print("Input: ");
		input = sc.nextLine();
		storedInput = input;
		input = formatInputString(input); // method to format input string to allow any number of spaces.
		workingInput = input;
		if(ShuntingYard.checkForFunction(workingInput)){
			workingInput = ShuntingYard.parseFunction(workingInput, resultInRadsDegs());
			input = formatInputString(workingInput);
		}
		String postfix = "";
		postfix = ShuntingYard.postfix(workingInput);
		System.out.println(postfix);
		MathematicalEvaluator ME = new MathematicalEvaluator();
		System.out.println("----------");
		System.out.println("Input Expression: " + formatInputString(storedInput));
		ME.evaluateExpression(postfix);
		ME.opCharList.clear();
		ME.opList.clear();
		ME.opListRev.clear();
		ME.workingList.clear();
	}
	
	public static String run(String expression){
		String workingInput;
		String storedInput;
		String input = expression;
		String result = "";

		storedInput = input;
		input = formatInputString(input); // method to format input string to allow any number of spaces.
		workingInput = input;
		if(ShuntingYard.checkForFunction(workingInput)){
			workingInput = ShuntingYard.parseFunction(workingInput, true);
			input = formatInputString(workingInput);
		}
		String postfix = "";
		postfix = ShuntingYard.postfix(workingInput);
		System.out.println(postfix);
		MathematicalEvaluator ME = new MathematicalEvaluator();
		System.out.println("----------");
		System.out.println("Input Expression: " + formatInputString(storedInput));
		result = ME.evaluateExpression(postfix);
		ME.opCharList.clear();
		ME.opList.clear();
		ME.opListRev.clear();
		ME.workingList.clear();
		return result;
	}
	
	public static String formatInputString(String input) {
		input = input.replaceAll("\\s+","");//remove all spaces.
		input = input.replace("*", " * ");
		input = input.replace("+", " + ");
		input = input.replace("-", " - ");
		input = input.replace("/", " / ");
		input = input.replace("(", " ( ");
		input = input.replace(")", " ) ");
		input = input.replace("^", " ^ ");
		input = input.replace("cos", " cos ");		//Cosine
		
		input = input.replace("bac", " bac "); 		//ACos (NOT DONE)
		input = input.replace("dsn", " dsn ");		//ASin (NOT DONE)
		input = input.replace("atn", " atn ");		//ATan (NOT DONE)
		
		input = input.replace("sin", " sin ");		//Sine
		input = input.replace("tan", " tan ");		//Tangent
		input = input.replace("rts", " rts ");		//Square root
		input = input.replace("elg", " elg ");		//Natural Log
		input = input.replace("lgt", " lgt ");		//Log base 10
		
		return input;//return formatted string of tokens
	}
	
	public static boolean resultInRadsDegs(){
		System.out.print("Input in Radians or Degrees? r/d: ");
		String radsDegs = sc.next();
		boolean degrees = false;
		if(radsDegs.equalsIgnoreCase("R")){
			degrees = false;
		} else if(radsDegs.equalsIgnoreCase("D")){
			degrees = true;
		}
		return degrees;
	}
	
}



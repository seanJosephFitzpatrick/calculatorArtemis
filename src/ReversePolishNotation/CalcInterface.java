package ReversePolishNotation;

import java.util.Scanner;;

public class CalcInterface {

	static Scanner sc = new Scanner(System.in);

	//Commented Main method to move to GUI input!
	
//	public static void main(String[] args){
//		boolean radians = true;
//		String workingInput;
//		String storedInput;
//		String input = "";
//		System.out.print("1 - if input is DEGREES, 2 - if RADS: ");
//		int inputChoice = sc.nextInt();
//		if(inputChoice == 1){
//			radians = true;
//		} else if(inputChoice == 2){
//			radians = false;
//		} else {
//			throw new IllegalArgumentException();
//		}
//		System.out.println("Please input an expression to evaluate: ");
//		System.out.println("(Leave a space between each token)");
//		System.out.print("Input: ");
//		sc.nextLine();
//		input = sc.nextLine();
//		storedInput = input;
//		input = formatInputString(input); // method to format input string to allow any number of spaces.
//		workingInput = input;
//		if(ShuntingYard.checkForFunction(workingInput)){
//			workingInput = ShuntingYard.parseFunction(workingInput, radians);	//true = result in rads!
//			input = formatInputString(workingInput);
//		}
//		String postfix = "";
//		postfix = ShuntingYard.postfix(workingInput);
//		System.out.println(postfix);
//		MathematicalEvaluator ME = new MathematicalEvaluator(radians);
//		System.out.println("----------");
//		System.out.println("Input Expression: " + formatInputString(storedInput));
//		ME.evaluateExpression(postfix);
//		ME.opCharList.clear();
//		ME.opList.clear();
//		ME.opListRev.clear();
//		ME.workingList.clear();
//	}
	
	public static String run(String expression, boolean radians){
		String workingInput;
		String storedInput;
		String input = expression;
		String result = "";
		try {
			storedInput = input;
			input = formatInputString(input); 										//method to format input string to allow any number of spaces.
			MathematicalEvaluator ME = new MathematicalEvaluator(radians);
//			System.out.println(input);
			workingInput = input;
			if(ShuntingYard.checkForFunction(workingInput)){
				workingInput = ShuntingYard.parseFunction(workingInput, radians);
				input = formatInputString(workingInput);
			}
			String postfix = "";
			postfix = ShuntingYard.postfix(workingInput);
//			System.out.println(postfix);
//			System.out.println("----------");
//			System.out.println("Input Expression: " + formatInputString(storedInput));
			result = ME.evaluateExpression(postfix);
			ME.opCharList.clear();
			ME.opList.clear();
			ME.opListRev.clear();
			ME.workingList.clear();
		} catch (java.util.EmptyStackException e) {
			result = "Syntax Error";
		} catch (java.lang.NumberFormatException a) {
			result = "Syntax Error";
		} catch (java.lang.ArithmeticException f) {
			result = "Syntax Error";
		}
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
		
		input = input.replace("bac", " bac "); 		//ACos
		input = input.replace("dsn", " dsn ");		//ASin
		input = input.replace("atn", " atn ");		//ATan 
		
		input = input.replace("cos", " cos ");		//Cosine
		input = input.replace("sin", " sin ");		//Sine
		input = input.replace("tan", " tan ");		//Tangent
		input = input.replace("rts", " rts ");		//Square root
		input = input.replace("elg", " elg ");		//Natural Log
		input = input.replace("lgt", " lgt ");		//Log base 10
		
		return input;//return formatted string of tokens
	}
	
	
}



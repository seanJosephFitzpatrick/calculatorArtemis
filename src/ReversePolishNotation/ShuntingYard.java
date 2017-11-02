package ReversePolishNotation;

import java.util.*;

public class ShuntingYard {

	static Scanner sc = new Scanner(System.in);

	private enum Operator {
		ADD(2), SUBTRACT(2), MULTIPLY(3), DIVIDE(3), EXPONENT(4);
		final int precedence;
		Operator(int p) { 
			precedence = p; 
		}
	}

	private static Map<String, Operator> ops = new HashMap<String, Operator>() {
		private static final long serialVersionUID = 1L;
		{
			put("+", Operator.ADD);
			put("-", Operator.SUBTRACT);
			put("*", Operator.MULTIPLY);
			put("/", Operator.DIVIDE);
			put("^", Operator.EXPONENT);
		}};

		private static boolean isHigerPrec(String op, String sub){
			return (ops.containsKey(sub) && ops.get(sub).precedence >= ops.get(op).precedence);
		}
		
		public static String postfix(String infix){
			StringBuilder output = new StringBuilder();
			Deque<String> stack  = new LinkedList<>(); 

			boolean opLastEncountered = false;
			for (String token : infix.split("\\s")) {
					// operator	
				if(ops.containsKey(token)) {
						if(token.equalsIgnoreCase("-")){
							if((stack.isEmpty() && output.length() == 0 || opLastEncountered)){
								opLastEncountered = true;
								output.append("-");
							} else if(!opLastEncountered){
								while ( ! stack.isEmpty() && isHigerPrec(token, stack.peek())){
									opLastEncountered = true;
									output.append(stack.pop()).append(' ');
								}
								stack.push(token);
							}
						} else {
							if(stack.isEmpty()){
								opLastEncountered = true;
								stack.push(token);
							} else {
							while ( ! stack.isEmpty() && isHigerPrec(token, stack.peek())){
								output.append(stack.pop()).append(' ');
							}
							stack.push(token);
							opLastEncountered = true;
//							stack.push(token);
						}
						}
//						stack.push(token);
					
						// left parenthesis
					} else if (token.equals("(")) {
						opLastEncountered = true;
						stack.push(token);

						// right parenthesis
					} else if (token.equals(")")) {
						while ( ! stack.peek().equals("("))
							output.append(stack.pop()).append(' ');
						stack.pop();
					}else if(token.equalsIgnoreCase("")){
						//DO NOTHING WITH A SPACE!
						
						//Digit
					} else {
						opLastEncountered = false;
						output.append(token).append(' ');
					}
				}

				while ( ! stack.isEmpty()){
					output.append(stack.pop()).append(' ');
				}
			return output.toString();
		}
		
		public static boolean checkForFunction(String input){
			boolean containsFunction = false;;
			for(int i = 0; i < input.length() && !containsFunction; i++){
				
				if(input.charAt(i) == 'c' ||input.charAt(i) == 's' || input.charAt(i) == 't' ||
						input.charAt(i) == 'e' || input.charAt(i) == 'l' || input.charAt(i)  == 'b' ||
								input.charAt(i) == 'd') {
					
					containsFunction = true;
				}
			}
			return containsFunction;
		}
		
		public static String parseFunction(String input, boolean radians){
			MathematicalEvaluator ME = new MathematicalEvaluator(radians);

			
			String theFunction = "";
			String infixFunction = "";
			String functionResult = "";
			String bracketResult = "";
			String aWorkingInput = input;

//			boolean function = checkForFunction(input);
//			if(function){
//				input = trigFunctionEvaluator(input, degrees);
//			}

				char currentFunction = whichFunction(aWorkingInput);

				int rBcount = 0;
				int lBcount = 0;

				boolean equationFormed = false;

				int sizeOfSub = 0;
				for(int i = aWorkingInput.indexOf(currentFunction); i < aWorkingInput.length(); i++){
					sizeOfSub++;
				}


				for(int i = aWorkingInput.indexOf(currentFunction); i < aWorkingInput.length() && !equationFormed; i++){
					char ch = aWorkingInput.charAt(i);
					theFunction += ch;
					if(ch == '('){
						lBcount++;
					} else if(ch == ')'){
						rBcount++;
						if(lBcount == rBcount){
							equationFormed = true;
						}

					}
				}
				theFunction = theFunction.substring(4);
				infixFunction = theFunction;
					if(ShuntingYard.checkForFunction(theFunction)){	//RECURSION - DOES THE NEWLY MADE TRIG EXPRESSION CONTAIN ANOTHER FUNCTION?
						theFunction = ShuntingYard.parseFunction(theFunction, radians);	//ISSUE REMAINS - IF THAT FUNCTION CALLS ANOTHER FUNCTION
					}																			
				theFunction = ShuntingYard.postfix(theFunction);
				bracketResult = ME.evaluateExpression(theFunction);
				functionResult = ME.functionEvaluator(currentFunction, bracketResult); //SHOULD HAVE A RESULT HERE (RADIANS)!!!
				//System.out.println(trigResult);					//NEED TO TAKE THE TRIG EXPRESSION OUT AND REPLACE WITH THIS
				aWorkingInput = aWorkingInput.substring(0, (aWorkingInput.indexOf(currentFunction) - 1)); //Take out the expression that has been evaluated and append
				aWorkingInput += functionResult;																//It's result
				//System.out.println(aWorkingInput);
				if(input.indexOf(currentFunction) + sizeOfSub > infixFunction.length()){
					String additional = input.substring((input.indexOf(currentFunction) + 4 + infixFunction.length()), input.length());
					aWorkingInput += additional.substring(1);		//If there was anything beyond what was evaluated
				}												//will be added to working input string here!
				//System.out.println("xx: " + aWorkingInput);
				if(checkForFunction(aWorkingInput)){
					aWorkingInput = parseFunction(aWorkingInput, radians);
				} 
			theFunction = "";
			return aWorkingInput;
		}
		
		public static char whichFunction(String input){
			char function = ' ';
			//SYMBOL TABLE - Because the functions are evaluated off chars - the following 
			//is how each should be presented to the calculator - FUNCTIONS MUST BE 3 CHARS AT THE
			//	cosine = cos                                            MOMENT!
			//  sine = sin
			//  tangent = tan
			//  square root = rts
			// natural log = elg
			// log ten = lgt
			// arc cosine = bac
			// arc sin = dsn
			
			int cosLoc = input.indexOf('c');
			int sinLoc = input.indexOf('s');
			int tanLoc = input.indexOf('t');
			int sRootLoc = input.indexOf('r');
			int nLogLoc = input.indexOf('e');
			int tLogLoc = input.indexOf('l');
			int aCosLoc = input.indexOf('b'); 
			int aSinLoc = input.indexOf('d');
			int aTanLoc = input.indexOf('a');
			
			int firstLoc = 0;
			
			if(cosLoc == -1){
				cosLoc = 1000;
			}
			
			if(sinLoc == -1){
				sinLoc = 1000;
			}
			
			if(tanLoc == -1){
				tanLoc = 1000;
			}
			
			if(sRootLoc == -1){
				sRootLoc = 1000;
			}
			
			if(nLogLoc == -1){
				nLogLoc = 1000;
			}
			
			if(tLogLoc == -1){
				tLogLoc = 1000;
			}
			
			if(aCosLoc == -1){
				aCosLoc = 1000;
			}
			
			if(aSinLoc == -1){
				aSinLoc = 1000;
			}
			
			if(aTanLoc == -1){
				aTanLoc = 1000;
			}
			
			if(cosLoc < sinLoc){
				firstLoc = cosLoc;
			} else {
				firstLoc = sinLoc;
			}
			
		
			if(tanLoc < firstLoc){
				firstLoc = tanLoc;
			}
			
			if(sRootLoc < firstLoc){
				firstLoc = sRootLoc;
			}
			
			if(nLogLoc < firstLoc){
				firstLoc = nLogLoc;
			}
			
			if(tLogLoc < firstLoc){
				firstLoc = tLogLoc;
			}
			
			if(aCosLoc < firstLoc){
				firstLoc = aCosLoc;
			}
			
			if(aSinLoc < firstLoc){
				firstLoc = aSinLoc;
			}
			
			if(aTanLoc < firstLoc){
				firstLoc = aTanLoc;
			}
			
			cosLoc = input.indexOf('c');
			sinLoc = input.indexOf('s');
			tanLoc = input.indexOf('t');
			sRootLoc = input.indexOf('r');
			nLogLoc = input.indexOf('e');
			tLogLoc = input.indexOf('l');
			aCosLoc = input.indexOf('b');
			aSinLoc = input.indexOf('d');
			aTanLoc = input.indexOf('a');
			
			if(firstLoc == cosLoc){
				function = 'c';
			} else if(firstLoc == sinLoc){
				function = 's';
			} else if(firstLoc == tanLoc){
				function = 't';
			} else if(firstLoc == sRootLoc){
				function = 'r';
			} else if(firstLoc == nLogLoc){
				function = 'e';
			} else if(firstLoc == tLogLoc){
				function = 'l';
			} else if(firstLoc == aCosLoc){
				function = 'b';
			} else if(firstLoc == aSinLoc){
				function = 'd';
			} else if(firstLoc == aTanLoc){
				function = 'a';
			}
			return function;
		}
}
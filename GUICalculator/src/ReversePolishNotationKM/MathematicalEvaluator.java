package ReversePolishNotationKM;

import java.util.Stack;

public class MathematicalEvaluator {
	
	private boolean radians;

	private final static double PI = Math.PI;
	private final static double E = Math.E;
			
	public Stack<Character> opCharList;
	public Stack<String> opListRev;
	public Stack<String> opList;
	public Stack<String> workingList;

	
	public MathematicalEvaluator(){
		opCharList = new Stack<Character>();
		opListRev = new Stack<String>();
		opList = new Stack<String>();
		workingList = new Stack<String>();
		this.setRadians(false);					//Input in degrees to start!
	}
	
	public boolean isRadians() {
		return radians;
	}

	public void setRadians(boolean radians) {
		this.radians = radians;
	}

	public void addRPNToStack(String postfix){
		if(!ShuntingYard.checkForFunction(postfix)){
			System.out.println("Reverse Polish Notation: " + postfix);
		} else {
			//IF THERE IS A FUNCTION WITHIN A FUNCTION BRACKETS - EVALUATE
		}
		opCharList = new Stack<Character>();
		char[] RPN = postfix.toCharArray();
		for(int i = 0; i < RPN.length; i++){
			opCharList.push(RPN[i]);
		}
		
		opListRev = new Stack<String>();
		String s1 = "";
		while(!opCharList.isEmpty()){
			char ch = opCharList.pop();
			if(Character.isDigit(ch) || ch == '.'){
				s1 = Character.toString(ch) + s1;
			} else if(Character.isWhitespace(ch)){
				if(s1.length() != 0){
					opListRev.push(s1);
					s1 = "";
				}
			} else {
				s1 = Character.toString(ch) + s1;
				opListRev.push(s1);
				s1 = "";
			}
		}
		if(!s1.equals("")){
			opListRev.push(s1);
		}
		opList = new Stack<String>();
		while(!opListRev.isEmpty()){
			opList.push(opListRev.pop());
		}	
	}

	public void showList(){
		System.out.println("Character List: ");
		for(int i = 0; i < opCharList.size(); i++){
			System.out.println(opCharList.get(i));
		}
		System.out.println();
		System.out.println("Operation List: ");
		for(int i = 0; i < opList.size(); i++){
			System.out.println(opList.get(i));
		}
	}

	public String evaluateExpression(String postfix){
		
		addRPNToStack(postfix);
		
		workingList = new Stack<String>();
		int opListSizeNow = opList.size();
		for(int i = 0; i < opListSizeNow; i++){
			String s1 = opList.get(i);
			if(s1.length() > 1 && Character.isDigit(s1.charAt(0))){		//IF the string is longer than 1 char and the 1st char is a digit -
				workingList.push(s1);									//then it is a digit - (something longer that 1 could be a function, not
			} else if(Character.isDigit(s1.charAt(0))){					//added yet)
				workingList.push(s1);	//IF the string is only 1 char and that char is a digit, also a number - in either case push the number
				//onto the stack
			} else if(s1.charAt(0) == '-' && s1.length() > 1 && (Character.isDigit(s1.charAt(1)) || s1.charAt(3) == '-')){
				workingList.push(s1);													//This is a special case - should be treated as a digit
			} else {						//IF we reach this branch then s1 is an operand - we now need to get the top
				double a = Double.parseDouble(workingList.pop());	//two off the stack 
				double b = Double.parseDouble(workingList.pop());
				double result = 0;
				String resString = "";
				switch(s1){
				case "+" : result = b + a;			//Manipulate a + b based on s1s value
				break;
				case "-" : result = b - a;
				break;
				case "*" : result = b * a;
				break;
				case "/" : 
					if(a == 0){
						result = 0d;
						System.out.println("Throw divide by zero exception here!");
					} else {				//Remove divide by 0
						result = b / a;
					}
				break;
				case "^" : result = Math.pow(b, a);
				break;
				default:
					break;
				}
				resString = Double.toString(result);	//Restring the result value and add it back onto the working list
				workingList.push(resString);
			}
		}
		String result = workingList.pop();				//Result of any operation passed to evaluation! 
		System.out.println("Result: " + result);	//At end this should be the only value on the stack
		workingList.clear();
		opList.clear();
		return result;
	} 

	public String opListToString(){
		return null;
	}
	
	public String functionEvaluator(char function, String operand){
	
		String result = "";
		Double dResult = 0.0;
		
		Double dOperand = Double.parseDouble(operand);
		
		
		
		switch(function){
		case 'c' : 	
			if(!this.radians){
				if(dOperand == 90d || dOperand == 270d){
					dResult = 0d;
				} else {
					dResult = Math.cos(Math.toRadians(dOperand));
				}
			} else {
				if(dOperand == (PI / 2) || dOperand == ((PI * 2))){
					dResult = 0d;
				} else {
					dResult = Math.cos(dOperand);
				}
			}
			break;
		case 's' :  
			if(!this.radians){
				if(dOperand % 180 == 0){
					dResult = 0d;
				} else {
					dResult = Math.sin(Math.toRadians(dOperand));
				}
			} else {
				if(dOperand % PI == 0){
					dResult = 0d;
				} else {
					dResult = Math.sin(dOperand);
				}
			}
				
			break;
		case 't' : 	
			if(!this.radians){
				if(dOperand % 180 == 0){
					dResult = 0d;
				} else if(dOperand % 90 == 0){
					throw new IllegalArgumentException();
				} else {
					dResult = Math.tan(Math.toRadians(dOperand));
				}
			} else {
				if(dOperand % PI == 0){
					dResult = 0d;
				} else if(dOperand % ((PI) / 2) == 0) {
					dResult = 0d;
				} else {
					dResult = Math.tan(dOperand);
				}
			}
		break;
		case 'r' : dResult = Math.sqrt(dOperand);
		break;
		case 'e' : dResult = Math.log(dOperand);
		break;
		case 'l' : dResult = Math.log10(dOperand);
		break;
		case 'b' : 					//What is acceptable for ACos input?
			if(!this.radians){
				if(dOperand <= -1 || dOperand >= 1){
					throw new IllegalArgumentException();
				} else {
					dResult = Math.acos(Math.toRadians(dOperand));
				}
			} else {	//What is a valid Radian input for acos?
				if(dOperand == (PI / 2) || dOperand == ((PI * 2))){
					dResult = 0d;
				} else {
					dResult = Math.acos(dOperand);
				}
			}
			break;
		default : 
			break;
		}
		
		result = dResult.toString();
		return result;
	}



}

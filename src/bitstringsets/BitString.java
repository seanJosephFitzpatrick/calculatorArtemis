package bitstringsets;

import java.util.Scanner;

public class BitString {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		int intVal1 = 0;
		int intVal2 = 0;
		
		System.out.print("Number 1: ");
		intVal1 = sc.nextInt();
		System.out.print("Number 2: ");
		intVal2 = sc.nextInt();
		
		String value1 = BitString.toBitRepresentation(decToBinaryString(Integer.toString(intVal1)));
		String value2 = BitString.toBitRepresentation(decToBinaryString(Integer.toString(intVal2)));
		
		System.out.println(intVal1 + " binary representation: " + value1);
		System.out.println(intVal2 + " binary representation: " + value2);
		System.out.println("------------------------");
		System.out.println();
		
		if(value1.length() > value2.length()){
			value2 = BitString.increaseBitString(value2, value1.length());
		}else if(value2.length() > value1.length()){
			value1 = BitString.increaseBitString(value1, value2.length());
		}
		
		BitString.bitWiseAnd(value1, value2);
		System.out.println();
		BitString.bitWiseOr(value1, value2);
		System.out.println();
		BitString.bitWiseNand(value1, value2);
		System.out.println();
		BitString.bitWiseXor(value1, value2);
		System.out.println();
		BitString.getTwosComplement(value1);
		
		

	}
	
	
	
	
	public static String decToBinaryString(String aValue){
		int value = Integer.parseInt(aValue);
		return Integer.toBinaryString(value);
	}
	
	public static String decToHexString(String aValue){
		int value = Integer.parseInt(aValue);
		return Integer.toHexString(value);
	}
	
	public static String decToOctalString(String aValue){
		int value = Integer.parseInt(aValue);
		return Integer.toOctalString(value);
	}
	
	public static String bitWiseAnd(String aValue1, String aValue2){
		String result = "";
		for(int i = 0; i < aValue1.length(); i++){
			if(aValue1.charAt(i) == '1' && aValue2.charAt(i) == '1'){
				result += "1";
			} else {
				result += "0";
			}
		}
//		System.out.println("AND");
//		System.out.println("Value 1:\t" + aValue1);
//		System.out.println("Value 2:\t" + aValue2);
//		System.out.println("------------------------");
//		System.out.println("Result:\t\t" + result);
		return result;
	}
	
	public static String bitWiseOr(String aValue1, String aValue2){
		String result = "";
		for(int i = 0; i < aValue1.length(); i++){
			if(aValue1.charAt(i) == '1' || aValue2.charAt(i) == '1'){
				result += "1";
			} else {
				result += "0";
			}
		}
//		System.out.println("OR");
//		System.out.println("Value 1:\t" + aValue1);
//		System.out.println("Value 2:\t" + aValue2);
//		System.out.println("------------------------");
//		System.out.println("Result:\t\t" + result);
		return result;
	}
	
	public static String bitWiseNand(String aValue1, String aValue2){
		String result = "";
		for(int i = 0; i < aValue1.length(); i++){
			if(aValue1.charAt(i) == '1' && aValue2.charAt(i) == '1'){
				result += "0";
			} else {
				result += "1";
			}
		}
//		System.out.println("NAND");
//		System.out.println("Value 1:\t" + aValue1);
//		System.out.println("Value 2:\t" + aValue2);
//		System.out.println("------------------------");
//		System.out.println("Result:\t\t" + result);
		return result;
	}
	
	public static String bitWiseXor(String aValue1, String aValue2){
		String result = "";
		for(int i = 0; i < aValue1.length(); i++){
			if((aValue1.charAt(i) == '1' && aValue2.charAt(i) == '0') || (aValue1.charAt(i) == '0' && aValue2.charAt(i) == '1')){
				result += "1";
			} else {
				result += "0";
			}
		}
//		System.out.println("XOR");
//		System.out.println("Value 1:\t" + aValue1);
//		System.out.println("Value 2:\t" + aValue2);
//		System.out.println("------------------------");
//		System.out.println("Result:\t\t" + result);
		return result;
	}
	
	public static String toBitRepresentation(String aValue){
		if(aValue.length() > 16){
			return BitString.to32BitRepresentation(aValue);
		}else if(aValue.length() > 8){
			return BitString.to16BitRepresentation(aValue);
		}else if(aValue.length() < 8){
			return BitString.to8BitRepresentation(aValue);
		}
		return aValue;
	}
	
	private static String to8BitRepresentation(String aValue){
		String result = "";
		if(aValue.length() < 8){
			int zeros = (8 - aValue.length());
			for(int i = 0; i < zeros; i++){
				result += "0";
			}
		}
		result += aValue;
		return result;
	}
	
	private static String to16BitRepresentation(String aValue){
		String result = "";
		if(aValue.length() < 16){
			int zeros = (16 - aValue.length());
			for(int i = 0; i < zeros; i++){
				result += "0";
			}
		}
		result += aValue;
		return result;
	}
	
	private static String to32BitRepresentation(String aValue){
		String result = "";
		if(aValue.length() < 32){
			int zeros = (32 - aValue.length());
			for(int i = 0; i < zeros; i++){
				result += "0";
			}
		}
		result += aValue;
		return result;
	}
	
	private static String increaseBitString(String aValue, int representation){
		int diff = (representation - aValue.length());
		String result = "";
		for(int i = 0; i < diff; i++){
			result += "0";
		}
		result += aValue;
		return result;
	}
	
	private static int getDifferenceInLength(String aValue1, String aValue2){
		if(aValue1.length() > aValue2.length()){
			return (aValue1.length() - aValue2.length());
		}else if(aValue2.length() > aValue2.length()){
			return (aValue2.length() - aValue1.length());
		}
		return 0;
	}
	
	public static String getOnesComplement(String aValue){
		String result = "";
		for(int i = 0; i < aValue.length(); i++){
			if(aValue.charAt(i) == '1'){
				result += "0";
			} else {
				result += "1";
			}
		}
//		System.out.println("1's COMPLEMENT");
//		System.out.println("Value:\t\t" + aValue);
//		System.out.println("One's Comp:\t" + result);
//		System.out.println("------------------------");
//		System.out.println();
		return result;
	}
	
	public static String getTwosComplement(String aValue){
		String ones = BitString.getOnesComplement(aValue);
		Long operand = Long.parseLong(ones, 2);
		operand++;
		String twos = Long.toBinaryString(operand);
		if(twos.length() < aValue.length()){
			twos = BitString.increaseBitString(twos, (aValue.length() - twos.length()));
		}
//		System.out.println("2's COMPLEMENT");
//		System.out.println("Value:\t\t" + aValue);
//		System.out.println("Two's comp:\t" + twos);
//		System.out.println("------------------------");
//		System.out.println();
		return null;
	}
	
}

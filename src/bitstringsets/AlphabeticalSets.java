package bitstringsets;

import java.util.BitSet;

public class AlphabeticalSets {
	
	
	
	public static String generateBitString(String elements){
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		String bitString = "";
		for(int i = 0; i < alpha.length(); i++){
			if(elements.indexOf(alpha.charAt(i)) != -1){
				bitString += "1";
			} else {
				bitString += "0";
			}
		}
		return bitString;
	}
	
	public static String generateElements(String bitString){
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		String elements = "";
		for(int i = 0; i < bitString.length(); i++){
			if(bitString.charAt(i) == '1'){
				elements += alpha.charAt(i);
			}
		}
		return elements;
	}
	
	public static String getIntersection(String set1, String set2){
		return generateElements(BitString.bitWiseAnd(set1, set2));
	}
	
	public static String getUnion(String set1, String set2){
		return BitString.bitWiseOr(set1, set2);
	}
	
	public static String getDifference(String set1, String set2){
		String result = "";
		for(int i = 0; i < set1.length(); i++){
			if(set2.indexOf(set1.charAt(i)) == -1){
				result += set1.charAt(i);
			}
		}
		return result;
	}
	
	public static String getComplement(String set){
		return BitString.getOnesComplement(set);
	}
	
//	public static String parseSetInput(String input){
//		String result = "";
//		for(int i = 0; i < input.length(); i++){
//			char ch = input.charAt(i);
//			if(Character.isLetter(ch))
//		}
//	}
//	
	
	
	
}

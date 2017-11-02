package bitstringsets;

public class SetTests {
	public static void main(String[] args){
		String S = "ABCD1aasf23";
		String T = "BCD3KJAGFKJafasf";
		String intersection = "";
		String union = "";
		String sComplement = "";
		String tComplement = "";
		String difference = "";
		
		String sBits = AlphabeticalSets.generateBitString(S);
		String tBits = AlphabeticalSets.generateBitString(T);
		
		intersection = AlphabeticalSets.getIntersection(sBits, tBits);
		union = AlphabeticalSets.getUnion(sBits, tBits);
		sComplement = AlphabeticalSets.getComplement(sBits);
		tComplement = AlphabeticalSets.getComplement(tBits);
		difference = AlphabeticalSets.getDifference(S, T);
		
		intersection = AlphabeticalSets.generateElements(intersection);
		union = AlphabeticalSets.generateElements(union);
		
		sComplement = AlphabeticalSets.generateElements(sComplement);
		tComplement = AlphabeticalSets.generateElements(tComplement);
		
		
		System.out.println("Set1:\t\t" + S);
		System.out.println("Set2:\t\t" + T);
		System.out.println("---------------------------------");
		System.out.println("Intersect:\t" + intersection);
		System.out.println("Union:\t\t" + union);
		System.out.println("S Complement:\t" + sComplement);
		System.out.println("T Complement:\t" + tComplement);
		System.out.println("Difference S/T:\t" + difference);
		
	}
	
}

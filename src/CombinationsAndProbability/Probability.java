package CombinationsAndProbability;

import java.util.Scanner;

import ReversePolishNotation.CalcInterface;

public class Probability {

	static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("(y): ");
        int poss = sc.nextInt();
        System.out.println("(k): ");
        int samples = sc.nextInt();
        System.out.println("(n): ");
        int n = sc.nextInt();
        
        String comb = Combinations.calcCombinations(n, samples);
        
        String yN = CalcInterface.run((" ( " + poss + " ^ " + n + " ) "), true);
        
        String result = CalcInterface.run((comb + " / " + yN), true);
        
        System.out.println(result);
               
	}
	
}

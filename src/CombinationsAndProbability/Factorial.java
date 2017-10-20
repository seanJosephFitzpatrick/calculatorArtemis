package CombinationsAndProbability;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
    public static String factorial(int n) {
    	BigInteger result = new BigInteger("1");
    	for ( int i = 1; i <= n; i++)
    	result = result.multiply(new BigInteger(i + ""));
		return result.toString();  //n!	
    }
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter your number: ");
//        int n = sc.nextInt();  
//        System.out.println("n! : " + factorial(n));
//      
//	}

}

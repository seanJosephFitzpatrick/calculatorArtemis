package integrals;

import java.util.Scanner;

public class Integrals {
	 public static double f (double x) {
	    	return (-6*x);
	    	}
		
		 static Scanner sc = new Scanner (System.in);
			public static void main(String[] args) {
					
				System.out.println("Enter a: ");
				double a = sc.nextDouble();
				
				System.out.println("Enter b: ");
				double b = sc.nextDouble();
				System.out.println(" eps ");
				double eps = sc.nextDouble();

				double I=eps+1, I1=0;//I-���������� ����������� �������� ���������, I1-�����, � ������� N.
				
				for (int N=2; (N<=4)||(Math.abs(I1-I)>eps); N*=2){
					double h, sum2=0, sum4=0, sum=0;
					h=(b-a)/(2*N);//��� ��������������.
					for (int i=1; i<=2*N-1; i+=2){   
						sum4+=f(a+h*i);//�������� � ��������� ���������, ������� ����� �������� �� 4.
						sum2+=f(a+h*(i+1));//�������� � ������� ���������, ������� ����� �������� �� 2.
					}
					sum=f(a)+4*sum4+2*sum2-f(b);//�������� �������� f(b) ��� ��� ����� ��������� ��� ������. 
					I=I1;
					I1=(h/3)*sum;
				}
				System.out.println(I1);
			}
		}

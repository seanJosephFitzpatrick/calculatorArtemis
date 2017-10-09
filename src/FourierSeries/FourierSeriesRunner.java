package FourierSeries;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;

public class FourierSeriesRunner {
	private static Scanner sc = new Scanner(System.in);
	private static String[] variables = new String[5];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = getInputMode();
		variables[0]=Integer.toString(input);
		if(input==1){
			plotFourierSeries();
		}
		else{
			plotUserDefinedWaveform();
		}
		Application.launch(FourierSeries.class, variables);
	}
private static void plotUserDefinedWaveform() {
	
	variables[1] = getWaveformType();
	String[] temp = new String[2];
	temp = getFourierSeriesVariables();
	
	for (int i = 0; i < temp.length; i++) {
		variables[i+2]=temp[i];
	}
		
	}
private static int getInputMode() {
		System.out.println("Please select the waveform plotting mode");
		System.out.println("1 - Fourier series\n2 - User defined waveform");
		if(sc.nextInt()==1){
			return 1;
		}
		else{
			return 2;
		}
	}
public static String getWaveformType(){
	System.out.println("Please Enter the wave you want to display (Square,Triangle or Sawtooth): ");
	return sc.next();
	
}
public static String[] getFourierSeriesVariables(){
	String[] variables = new String[2];
	System.out.println("Please Enter the number of harmonics you wish to include: ");
	variables[0]=sc.next();
	System.out.print("Please enter the period of the signal in seconds: ");
	variables[1]=sc.next();
	return variables;
}
public static String[] getUserDefinedWaveformVariables(){
	String[] variables = new String[3];
	System.out.println("Please Enter the Amplitude of the signal: ");
	variables[0]=sc.next();
	System.out.print("Please enter the period of the signal in seconds: ");
	variables[1]=sc.next();
	System.out.print("Please enter the phase of the signal in degrees: ");
	variables[1]=sc.next();
	return variables;
}
public static void plotFourierSeries(){
	variables[1] = getWaveformType();
	
	String[] temp = new String[2];
	temp = getFourierSeriesVariables();
	
	for (int i = 0; i < temp.length; i++) {
		variables[i+2]=temp[i];
	}
}

}

package FourierSeries;

import java.util.ArrayList;

public final class DFT {
	
	public static void computeDft(ArrayList<Double> inreal, ArrayList<Double> inimag, Complex[] result) {
		int n = inreal.size();
		for (int k = 0; k < n; k++) {  
			double sumreal = 0;
			double sumimag = 0;
			for (int t = 0; t < n; t++) { 
				double angle = 2 * Math.PI * t * k / n;
				sumreal +=  inreal.get(t) * Math.cos(angle) + inimag.get(t) * Math.sin(angle);
				sumimag += -inreal.get(t) * Math.sin(angle) + inimag.get(t) * Math.cos(angle);
			}
		
			result[k] = new Complex(sumreal,sumimag);
		}
	}
	
}
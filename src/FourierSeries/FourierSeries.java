package FourierSeries;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

import ReversePolishNotation.CalcInterface;
import integrals.IntegralPlotter;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class FourierSeries extends Application {
 
	private static ArrayList<Double> plotPointsY = new ArrayList<Double>();
	private static ArrayList<Double> plotPointsX = new ArrayList<Double>();
	private static int count=0;
	@Override public void start(Stage stage) {
        stage.setTitle("Signal Analysis");
        double yAxismin = Collections.min(plotPointsY);
        double yAxismax = Collections.max(plotPointsY);
        double xAxismin = Collections.min(plotPointsX);
        double xAxismax = Collections.max(plotPointsX);
        String xAxisLabel="";
        String yAxisLabel="";
        if(count==0){
        	xAxisLabel="Time(s)";
        	yAxisLabel="Amplitude(V)";
        }
        else{
        	xAxisLabel="Frequency(Hz)";
        	yAxisLabel="Magnitude";
        }
       
        NumberAxis xAxis = new NumberAxis(xAxisLabel,xAxismin, xAxismax, (xAxismax-xAxismin)*.1);
        NumberAxis yAxis = new NumberAxis(yAxisLabel,yAxismin+yAxismin*0.2, yAxismax+yAxismax*0.2, (yAxismax-yAxismin)*.1);
      

        
       
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
        if(count==0){       
        	lineChart.setTitle("Time Domain");
        	count++;
        }else{
        	lineChart.setTitle("Frequency Domain");
        	count--;
        }
       
        XYChart.Series series = new XYChart.Series();
        
        //series.setName(SimpsonsRule.getFunctionText());
       
        for(int x=0;x<plotPointsY.size();x++){
        	series.getData().add(new XYChart.Data(plotPointsX.get(x), plotPointsY.get(x)));	
        }
        Scene scene  = new Scene(lineChart,500,300);
        lineChart.getData().add(series);
       
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }

    public static ArrayList<Double> getIntegralPointsY() {
		return plotPointsY;
	}

	public static void setIntegralPointsY(ArrayList<Double> integralPointsY) {
		FourierSeries.plotPointsY = integralPointsY;
	}

	public static ArrayList<Double> getIntegralPointsX() {
		return plotPointsX;
	}

	public static void setIntegralPointsX(ArrayList<Double> integralPointsX) {
		FourierSeries.plotPointsX = integralPointsX;
	}
	public static void generatePlotPointsFourier(int harmonic,double period,String waveform,String harmonicType, double x){
    	double y=0;
    	double xMax=-x;
    	double xInc = period*0.01;
    	int har=1,harInc=1;
    	plotPointsX.clear();
		plotPointsY.clear();
		if(harmonicType.equalsIgnoreCase("odd")){
			harInc=2;
		}else if(harmonicType.equalsIgnoreCase("even")){
			har=2;
			harInc=2;
		}
   
    	for(;x<=xMax;x+=xInc){
    		
		if(waveform.equalsIgnoreCase("square")){
			for(int harLoop=har;harLoop<=harmonic;harLoop+=harInc)
			{
			//y1=CalcInterface.run(y, false);
		    	

			y=y+(6/(Math.PI*harLoop))*(Math.sin(x*(1/period)*2*Math.PI*harLoop));

			}
    	 
		}else if(waveform.equalsIgnoreCase("triangle")){
			for(int harLoop=har;harLoop<=harmonic;harLoop+=harInc)
			{
				y=y+(8/(Math.pow(Math.PI, 2)))*(Math.cos(x*(1/period)*2*Math.PI*harLoop)/(Math.pow(harLoop, 2)));

			}
		}else{
			for(int harLoop=har;harLoop<=harmonic;harLoop+=harInc){
				y=y+(Math.pow(1, harLoop+1)*2)*(Math.sin(x*(1/period)*2*Math.PI*harLoop)/(harLoop));

			}
		}
    	
		plotPointsX.add(x);
		plotPointsY.add(y);
		y=0;
    	}
    	
	}
	

	public static void generatePlotPointsFourier(double amplitude, double period, double phase, double xMin, double xMax, double samplingPeriod) {
		// TODO Auto-generated method stub
		plotPointsX.clear();
		plotPointsY.clear();
		double y=0;
		
		
		//String x1=String.format("%f", x);
		for(;xMin<=xMax;xMin+=samplingPeriod){
		//String y1=CalcInterface.run(amplitude+"*sin(2*"+Math.PI+"*(1/"+period+")*("+x1+")+("+phase+"*("+Math.PI+"/180)))", false);
		y=amplitude*Math.sin(2*Math.PI*(1/period)*xMin+(phase*(Math.PI/180)));;
		plotPointsX.add(xMin);
		plotPointsY.add(y);
		y=0;
		}
			
	}
	
	public static void generatePlotPointsDFT(double period){
		ArrayList<Double> dftReal =new ArrayList<Double>();
		ArrayList<Double> dftImag =new ArrayList<Double>();
		for(int n=0;n<plotPointsY.size();n++){
			dftReal.add(plotPointsY.get(n));
			dftImag.add(0.0);
		}
		Complex[] results = new Complex[plotPointsY.size()];
		DFT.computeDft(dftReal, dftImag, results);
		plotPointsX.clear();
		plotPointsY.clear();
		
		
		
		
		for(int n=1;n<results.length;n++){
			plotPointsX.add((double) -n/2);
			plotPointsY.add(results[n].abs());
		}
		for(int n=0;n<results.length;n++){
			plotPointsX.add((double) n/2);
			plotPointsY.add(results[n].abs());
		}
		
			System.out.println(plotPointsX);	
		
		
		
	}
	
}
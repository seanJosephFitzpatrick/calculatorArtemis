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

	@Override public void start(Stage stage) {
        stage.setTitle("Simpsons Rule");
        double yAxismin = Collections.min(plotPointsY);
        double yAxismax = Collections.max(plotPointsY);
        double xAxismin = Collections.min(plotPointsX);
        double xAxismax = Collections.max(plotPointsX);
       
        NumberAxis xAxis = new NumberAxis("x values",xAxismin, xAxismax, (xAxismax-xAxismin)*.1);
        NumberAxis yAxis = new NumberAxis("y values",yAxismin+yAxismin*0.2, yAxismax+yAxismax*0.2, (yAxismax-yAxismin)*.1);
     

        
       
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Function Plotter");
       
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
	public static void generatePlotPointsFourier(int harmonic,double period,String waveform,double x){
    	double y=0;
    	double xMax=-x;
    	double xInc = period*0.01;
    	plotPointsX.clear();
		plotPointsY.clear();
   
    	for(;x<=xMax;x+=xInc){
    		
		if(waveform.equalsIgnoreCase("square")){
			for(int har=1;har<=harmonic;har+=2)
			{
			//y1=CalcInterface.run(y, false);
		    	

			y=y+(6/(Math.PI*har))*(Math.sin(x*(1/period)*2*Math.PI*har));

			}
    	 
		}else if(waveform.equalsIgnoreCase("triangle")){
			for(int har=1;har<=harmonic;har+=2)
			{
				y=y+(8/(Math.pow(Math.PI, 2)))*(Math.cos(x*(1/period)*2*Math.PI*har)/(Math.pow(har, 2)));

			}
		}else{
			for(int har=1;har<=harmonic;har++){
				y=y+(Math.pow(1, har+1)*2)*(Math.sin(x*(1/period)*2*Math.PI*har)/(har));

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
		y=amplitude*Math.sin(2*Math.PI*(1/period)*xMin+(phase*(Math.PI/180)));
		plotPointsX.add(xMin);
		plotPointsY.add(y);
		y=0;
		}
		//double result=Double.parseDouble(y1);
		//double result=y;
		
	}
}
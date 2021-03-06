package integrals;
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class IntegralPlotter extends Application {
 
	private static ArrayList<Double> integralPointsY = new ArrayList<Double>();
	private static ArrayList<Double> integralPointsX = new ArrayList<Double>();

	@Override public void start(Stage stage) {
        stage.setTitle("Simpsons Rule");
        double yAxismin = Collections.min(integralPointsY);
        double yAxismax = Collections.max(integralPointsY);
        double xAxismin = Collections.min(integralPointsX);
        double xAxismax = Collections.max(integralPointsX);
       
        NumberAxis xAxis = new NumberAxis("x values",xAxismin, xAxismax, (xAxismax-xAxismin)*.1);
        NumberAxis yAxis = new NumberAxis("y values",yAxismin+yAxismin*0.2, yAxismax+yAxismax*0.2, (yAxismax-yAxismin)*.1);
     

        
       
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Function Plotter");
       
        XYChart.Series series = new XYChart.Series();
        
        series.setName(SimpsonsRule.getFunctionText());
       
        for(int x=0;x<integralPointsY.size();x++){
        	series.getData().add(new XYChart.Data(integralPointsX.get(x), integralPointsY.get(x)));	
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
		return integralPointsY;
	}

	public static void setIntegralPointsY(ArrayList<Double> integralPointsY) {
		IntegralPlotter.integralPointsY = integralPointsY;
	}

	public static ArrayList<Double> getIntegralPointsX() {
		return integralPointsX;
	}

	public static void setIntegralPointsX(ArrayList<Double> integralPointsX) {
		IntegralPlotter.integralPointsX = integralPointsX;
	}
}
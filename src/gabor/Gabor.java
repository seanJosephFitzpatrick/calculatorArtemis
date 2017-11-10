package gabor;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kfitzgerald
 */

public class Gabor
{
    CreateImage ci;
    final double NEXT_ORIENTATION = 12.38571429;
    private double t = 180;
    private double lamda=200;
    private double theta=90;
    private double varphi=0;
    private double upsi=0;
    private double bandW=0;
    private double B=0; 
    private double sigma=0;
    private double kappa=0;
    private double[][] GaborGrid;
    private double[][] GaborNorm;
    private static double[][] AverageVals;
    public static ArrayList<double[][]> grids = new ArrayList<double[][]>();

    int size=0;
    double toRadians=180/Math.PI, min=500, max=-500, mean=0;;
    int gaussian=0;
    double rotation;
    double GLFmean=0;
    //Standard Gabor no quantization
    public Gabor(double v, double u, double b, int sze)
    {
        lamda = 100;
        
        
        theta= t/toRadians;
        varphi=v/toRadians;
        upsi=u;
        bandW=b;
        kappa=(2*Math.PI)/lamda;
        Calculate_Sigma();
        size=sze;
        gaussian=sze/2;
        RunGabor();
        aggregatePixelValues();
        NormaliseAverageImage();
    }
    
    public void RunGabor()
    {	
    	int imageCount = 0;
    	int row = 5;
    	int col = 8;
    	while(lamda >= 40){
    		col = 8;
    		t = 180;
    		while(t > 0){
    			theta = t/toRadians;
    			GaborGrid = new double[size][size];
    			double x = 0;
    			double y = 0;
    			double xA = 0;
    			double yA = 0;
    			double value = 0;
    			double count = 0;
    			double total = 0;
    			int arrX = 0;
    			int arrY = 0;

    			for(int i = -gaussian; i < gaussian; i++){
    				for(int j = -gaussian; j < gaussian; j++){
    					x = j;
    					y = i;

    					xA = (x * Math.cos(theta)) + (y * Math.sin(theta));
    					yA = ((-x) * Math.sin(theta)) + (y * Math.cos(theta));

    					value = Math.exp(-(Math.pow(xA, 2) + (Math.pow(yA, 2)) * (Math.pow(upsi, 2))) / (2 * Math.pow(sigma, 2)));
    					value *= Math.cos((2 * Math.PI * (xA / lamda) + varphi));

    					GaborGrid[arrY][arrX] = value;
    					total += GaborGrid[arrY][arrX];
    					count++;
    					arrX++;
    				}
    				arrX = 0;
    				arrY += 1;
    			}
    			if(lamda == 55){
    				grids.add(GaborGrid);
    			}
    			mean = total / count;
    			System.out.println(t + "\t : " + lamda);
    			NormaliseImage(lamda, t);
    			imageCount++;
    			t -= NEXT_ORIENTATION * 2;
    			col--;
    		}
    		lamda -= 15;
    		System.out.println("Lamda: " + lamda);
    		row--;
    	}
    	System.out.println(imageCount);
    }
    public void NormaliseImage(double row, double col)
    {	
		GaborNorm = new double[size][size];
    	double temp;
    	double average = 0;
    	
    	for(int i = 0; i < size; i++){
    		for(int j = 0; j < size; j++){
    			if(GaborGrid[i][j] < min){
    				min = GaborGrid[i][j];
    			} else if(GaborGrid[i][j] > max){
    				max = GaborGrid[i][j];
    			}
    		}
    	}
    	
        for(int i = 0; i < size; i++){
        	for(int j = 0; j < size; j++){
        		temp = ((((double)(GaborGrid[i][j] - min)) /((double)(max - min))) * 255);
        		if(temp <= (int)(average)){
        			temp = 0;
        		}
        		GaborNorm[i][j] = temp;
        	}
        }
        ci = new CreateImage(GaborNorm, ("Gabor" + row + "," + col));
    }
    
    public void NormaliseAverageImage(){	
		GaborNorm = new double[size][size];
    	double temp;
    	double average = 0;
    	for(int i = 0; i < size; i++){
    		for(int j = 0; j < size; j++){
    			if(AverageVals[i][j] < min){
    				min = AverageVals[i][j];
    			} else if(AverageVals[i][j] > max){
    				max = AverageVals[i][j];
    			}
    		}
    	}
    	
        for(int i = 0; i < size; i++){
        	for(int j = 0; j < size; j++){
        		temp = ((((double)(AverageVals[i][j] - min)) /((double)(max - min))) * 255);
        		if(temp <= (int)(average)){
        			temp = 0;
        		}
        		GaborNorm[i][j] = temp;
        	}
        }
        ci = new CreateImage(GaborNorm, ("Gabor" + " Average"));
    }
    
    
    private void Calculate_Sigma()
    {
        B=(1/Math.PI)*(0.588705011)*((Math.pow(2, bandW)+1)/(Math.pow(2, bandW)-1));
        sigma=B*lamda;
    }
    
    private void aggregatePixelValues(){
        AverageVals = new double[size][size];
        System.out.println("Total for AVG: " + grids.size());
    	double sum = 0;
    	for(int i = 0; i < AverageVals.length; i++){
    		for(int j = 0; j < AverageVals.length; j++){
    			for(double[][] grid : grids){
    				sum += grid[i][j];
    			}
    			AverageVals[i][j] = (sum / (double)(grids.size()));
    			sum = 0;
    		}    		
    	}
    }

}

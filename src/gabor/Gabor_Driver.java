package gabor;

public class Gabor_Driver
{
    public static void main(String[]args){
        double varphi=90;
        double upsi=1;
        double bandW=1;
        int size=301;
        Gabor gabor = new Gabor(varphi, upsi, bandW, size);
        
        
    }
    
    public static void runGabor(double v, double u, double b){
    	int size = 301;											//Ideal Values
    	Gabor gabor = new Gabor(v, u, b, size);					// v = 90, u = 1, b = 1
    }
}


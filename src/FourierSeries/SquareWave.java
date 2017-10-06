package FourierSeries;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SquareWave extends JFrame {
	private static Scanner sc = new Scanner(System.in);
	private static int harmonic;

public SquareWave() {
    setLayout(new BorderLayout());
    add(new DrawSine(), BorderLayout.CENTER);
    
}

public static void main(String[] args) {
	String proceed="y";
	
	while(proceed.equalsIgnoreCase("y"))
	{
	System.out.println("Enter the number of the last harmonic you want to include in the series: ");
	harmonic = sc.nextInt();
    SquareWave frame = new SquareWave();
    frame.setSize(400, 250);
    frame.setTitle("Square wave fourier series");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    System.out.println("Continue? (y/n)");
    proceed=sc.next();
	}
}

class DrawSine extends JPanel {

    double f(double x) {
        return Math.sin(x);
    }

    double gCos(double y) {
        return Math.cos(y);
    }

    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        g.drawLine(10, 100, 380, 100);
        g.drawLine(200, 30, 200, 190);

        g.drawLine(380, 100, 370, 90);
        g.drawLine(380, 100, 370, 110);
        g.drawLine(200, 30, 190, 40);
        g.drawLine(200, 30, 210, 40);

        g.drawString("X", 360, 80);
        g.drawString("Y", 220, 40);

        Polygon p = new Polygon();
       // Polygon p2 = new Polygon();
        
        double calc=0;
       for (int x = -170; x <= 170; x++) {
    	   for(int y=1;y<=harmonic;y+=2)
    	   {
    		   calc=calc+(6/(Math.PI*y))*(f(x*(1/100.0)*2*Math.PI*y));
    		   //calc = calc + ((1/y)*f(x*0.01*y*Math.PI));
    	   }
          p.addPoint(x + 200, 100 - (int)(calc*25));//50 is amp, t is time,50 is period (freq = 1/T)
          calc=0;
        }

//        for (int x = -170; x <= 170; x++) {
//            p2.addPoint(x + 200, 100 - (int) (50 * gCos((x / 100.0) * 2
//                    * Math.PI)));
//
//        }

        g.setColor(Color.blue);
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
        g.drawString("-2\u03c0", 95, 115);
        g.drawString("2\u03c0", 305, 115);
        g.drawString("0", 200, 115);

//        g.setColor(Color.blue);
//        g.drawPolyline(p2.xpoints, p2.ypoints, p2.npoints);

    }
 }
}
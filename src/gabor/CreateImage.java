package gabor;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kfitzgerald
 */
import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;


public class CreateImage
{
	private static ArrayList<String> fileNames= new ArrayList<String>();
    int[] pixels;
    int width=0, height=0;
    String  name;

    public CreateImage(double[][] data, String IMGname)
    {
        name = IMGname;
        width =  data[0].length;
        height = data.length;
        pixels = new int[height*width];
        int count=0;
        for(int i=0; i<data.length; i++)
        {
            for(int j=0; j<data[0].length; j++)
            {
                pixels[count] = (int)Math.abs(data[i][j]);
                pixels[count] = convert2pixel(pixels[count]);
                count++;
            }
        }
        Create(width, height, pixels, name);
    }
    public int convert2pixel(int pixel)
    {
        return ((0xff<<24)|(pixel<<16)|(pixel<<8)|pixel);
    }
    public int convert2grey(double pixel)
    {
        int red=((int)pixel>>16) & 0xff;
        int green = ((int)pixel>>8) & 0xff;
        int blue = (int)pixel & 0xff;
        return (int)(0.3*red+0.6*green+0.1*blue);
    }
    public void Create(int Width, int Height, int pixels[], String n)//throws Exception
    {
        MemoryImageSource MemImg = new MemoryImageSource(Width,Height,pixels,0,Width);
        Image img2= Toolkit.getDefaultToolkit().createImage(MemImg);

        BufferedImage bfi = new BufferedImage(Height,Width, BufferedImage.TYPE_INT_BGR);
        Graphics2D g2D = bfi.createGraphics();

        g2D.drawImage(img2, 0, 0, Width, Height, null);
        try
        {
            ImageIO.write(bfi, "png", new File("GaborImages/"+n+".png"));
            System.out.println(n);
            fileNames.add(n+".png");
        }
        catch(Exception e){}
    }
    public static ArrayList<String> getFileNames() {
		return fileNames;
	}
	public static void setFileNames(ArrayList<String> fileNames) {
		CreateImage.fileNames = fileNames;
	}

}
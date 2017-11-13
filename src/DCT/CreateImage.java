package DCT;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class CreateImage extends JFrame {
  int height = 0; int width = 0;
  int[] pixels;

  public CreateImage(int[][] data, String IMGname) {
    width = data[0].length;
    height = data.length;

    pixels = new int[height * width];
    int count = 0;
    for (int i = 0; i < data.length; i++)
    {
      for (int j = 0; j < data[0].length; j++)
      {
        pixels[count] = ((int)Math.abs(data[i][j]));
        pixels[count] = convert2pixel(pixels[count]);
        count++;
      }
    }
    Create(width, height, pixels, IMGname);
  }

  public int convert2pixel(int pixel) {
    return 0xFF000000 | pixel << 16 | pixel << 8 | pixel;
  }

  public int convert2grey(double pixel) {
    int red = (int)pixel >> 16 & 0xFF;
    int green = (int)pixel >> 8 & 0xFF;
    int blue = (int)pixel & 0xFF;
    return (int)(0.3D * red + 0.6D * green + 0.1D * blue);
  }

  public void Create(int Width, int Height, int[] pixels, String n)
  {
    MemoryImageSource MemImg = new MemoryImageSource(Width, Height, pixels, 0, Width);
    Image img2 = Toolkit.getDefaultToolkit().createImage(MemImg);

    BufferedImage bfi = new BufferedImage(Height, Width, 4);
    Graphics2D g2D = bfi.createGraphics();

    g2D.drawImage(img2, 0, 0, Width, Height, null);
    try
    {
      ImageIO.write(bfi, "png", new File("Images/" + n + ".png"));
    }
    catch (Exception e) {}
  }
}

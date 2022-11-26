 package vai.expedition.engine.assets;
 
 import java.awt.image.BufferedImage;
 import javax.imageio.ImageIO;
 
 
 public class ImageLoader
 {
   public static BufferedImage load(String path) {
     try {
       return ImageIO.read(ImageLoader.class.getResource(path));
     } catch (Exception exception) {
       exception.printStackTrace();
       System.exit(1);
       return null;
     } 
   }
 }



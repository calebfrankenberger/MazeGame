 package vai.expedition.engine.assets;
 
 import java.awt.image.BufferedImage;
 
 public class SpriteSheet
 {
   private BufferedImage image;
   
   public SpriteSheet(String path) {
     this.image = ImageLoader.load(path);
   }
   
   public BufferedImage crop(int x, int y, int width, int height) {
     return this.image.getSubimage(x, y, width, height);
   }
 }



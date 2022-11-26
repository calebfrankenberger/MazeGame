 package vai.expedition.engine.assets;
 
 import java.awt.Image;
 import java.awt.image.BufferedImage;
 
 
 
 
 public class Assets
 {
   private static final int width = 16;
   private static final int height = 16;
   public static BufferedImage FINISH;
   public static BufferedImage PATH;
   public static BufferedImage START;
   public static BufferedImage VOID;
   public static BufferedImage WALL;
   public static BufferedImage HEART_FULL;
   
   public static void init() {
     SpriteSheet sheet = new SpriteSheet("/sprite_sheet.png");
     SpriteSheet overlay = new SpriteSheet("/overlay.png");
     SpriteSheet end_screen = new SpriteSheet("/end_screen.png");
     SpriteSheet playerSheet = new SpriteSheet("/player_sheet.png");
 
     
     VOID = sheet.crop(0, 0, 16, 16);
     FINISH = sheet.crop(16, 0, 16, 16);
     PATH = sheet.crop(32, 0, 16, 16);
     WALL = sheet.crop(48, 0, 16, 16);
     START = sheet.crop(64, 0, 16, 16);
 
 
     
     PLAYER = playerSheet.crop(0, 0, 64, 64);
     OVERLAY = overlay.crop(0, 0, 600, 600).getScaledInstance(800, 600, 0);
     END_SCREEN = end_screen.crop(0, 0, 600, 600).getScaledInstance(800, 600, 0);
 
     
     HEART_FULL = sheet.crop(0, 112, 16, 16);
     HEART_EMPTY = sheet.crop(16, 112, 16, 16);
     SB = sheet.crop(32, 112, 16, 16);
     SM = sheet.crop(48, 112, 16, 16);
     SE = sheet.crop(64, 112, 16, 16);
     INV_SLOT = sheet.crop(0, 96, 16, 16);
   }
   
   public static BufferedImage HEART_EMPTY;
   public static BufferedImage SB;
   public static BufferedImage SM;
   public static BufferedImage SE;
   public static BufferedImage INV_SLOT;
   public static Image OVERLAY;
   public static Image END_SCREEN;
   public static BufferedImage PLAYER;
 }



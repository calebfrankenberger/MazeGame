 package vai.expedition.engine.graphics.animation;
 
 import java.awt.Graphics;
 import java.awt.image.BufferedImage;
 
 
 public class Animation
 {
   private int speed;
   private int frames;
   private int index = 0;
   private int count = 0;
   
   private BufferedImage[] images;
   private BufferedImage current;
   private boolean paused;
   
   public Animation(int speed, BufferedImage... args) {
     this.speed = speed;
     
     this.images = new BufferedImage[args.length];
     this.frames = args.length;
     
     for (int i = 0; i < args.length; i++)
       this.images[i] = args[i]; 
   }
   
   public void play() {
     this.index++;
     
     if (this.index > this.speed) {
       this.index = 0;
       nextFrame();
     } 
   }
   
   private void nextFrame() {
     if (this.paused) {
       return;
     }
     for (int i = 0; i < this.frames; i++) {
       if (this.count == i)
         this.current = this.images[i]; 
     }  this.count++;
     
     if (this.count > this.frames)
       this.count = 0; 
   }
   
   public void draw(Graphics gfx, int x, int y) {
     gfx.drawImage(this.current, x, y, null);
   }
   
   public void draw(Graphics gfx, int x, int y, int scaleX, int scaleY) {
     gfx.drawImage(this.current, x, y, scaleX, scaleY, null);
   }
   
   public void pause() {
     setPaused(!this.paused);
   }
 
   
   public int getSpeed() {
     return this.speed;
   }
   
   public boolean isPaused() {
     return this.paused;
   }
   
   public void setPaused(boolean paused) {
     this.paused = paused;
   }
   
   public void setSpeed(int speed) {
     this.speed = speed;
   }
   
   public int getFrames() {
     return this.frames;
   }
   
   public void setFrames(int frames) {
     this.frames = frames;
   }
   
   public int getIndex() {
     return this.index;
   }
   
   public void setIndex(int index) {
     this.index = index;
   }
   
   public int getCount() {
     return this.count;
   }
   
   public void setCount(int count) {
     this.count = count;
   }
   
   public BufferedImage[] getImages() {
     return this.images;
   }
   
   public BufferedImage getCurrent() {
     return this.current;
   }
   
   public void setCurrent(BufferedImage current) {
     this.current = current;
   }
 }



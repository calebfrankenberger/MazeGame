 package vai.expedition.entity;
 
 import java.awt.Graphics;
 import java.awt.Rectangle;
 import vai.expedition.engine.Handler;
 
 
 
 public abstract class Entity
 {
   public static final int DEFAULT_CREATURE_WIDTH = 32;
   public static final int DEFAULT_CREATURE_HEIGHT = 64;
   protected Handler handler;
   protected EntityType type;
   protected boolean living;
   protected float x;
   protected float y;
   protected int width;
   protected int height;
   protected Rectangle bounds;
   
   public Entity(Handler handler, int x, int y, EntityType type) {
     this.handler = handler;
     this.width = 32;
     this.height = 64;
     
     this.x = x;
     this.y = y;
     
     this.type = type;
     this.bounds = new Rectangle(x, y, this.width, this.height);
   }
 
   
   public abstract void tick();
 
   
   public float getX() {
     return this.x;
   } public abstract void render(Graphics paramGraphics);
   public abstract boolean isLiving();
   public void setX(float x) {
     this.x = x;
   }
   
   public float getY() {
     return this.y;
   }
   
   public void setY(float y) {
     this.y = y;
   }
   
   public EntityType getType() {
     return this.type;
   }
   
   public Handler getHandler() {
     return this.handler;
   }
   
   public int getWidth() {
     return this.width;
   }
   
   public void setWidth(int width) {
     this.width = width;
   }
   
   public int getHeight() {
     return this.height;
   }
   
   public void setHeight(int height) {
     this.height = height;
   }
   
   public Rectangle getBounds() {
     return this.bounds;
   }
   
   public void setBounds(Rectangle bounds) {
     this.bounds = bounds;
   }
 }



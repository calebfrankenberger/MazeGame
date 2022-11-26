 package vai.expedition.engine.graphics;
 
 import vai.expedition.engine.Handler;
 import vai.expedition.entity.Entity;
 
 
 public class Camera
 {
   private float x;
   private float y;
   private Handler handler;
   
   public Camera(Handler handler, float x, float y) {
     this.handler = handler;
     this.x = x;
     this.y = y;
   }
   
   public void center(Entity entity) {
     this.x = entity.getX() - 400.0F + (entity.getWidth() / 2);
     this.y = entity.getY() - 400.0F + (entity.getHeight() / 2);
   }
 
   
   public void filter() {
     if (this.x < 0.0F) {
       this.x = 0.0F;
     } else if (this.x > (this.handler.getLevel().getWidth() * 64 - 800)) {
       this.x = (this.handler.getLevel().getWidth() * 64 - 800);
     } 
     if (this.y < 0.0F) {
       this.y = 0.0F;
     } else if (this.y > (this.handler.getLevel().getHeight() * 64 - 600)) {
       this.y = (this.handler.getLevel().getHeight() * 64 - 600);
     } 
   }
   public void move(float xMove, float yMove) {
     this.x += xMove;
     this.y += yMove;
   }
 
   
   public float getX() {
     return this.x;
   }
   
   public void setX(float x) {
     this.x = x;
   }
   
   public float getY() {
     return this.y;
   }
   
   public void setY(float y) {
     this.y = y;
   }
 }



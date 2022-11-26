 package vai.expedition.entity;
 
 import java.awt.image.BufferedImage;
 import vai.expedition.engine.Handler;
 
 
 
 
 public abstract class LivingEntity
   extends Entity
 {
   public static final int DEFAULT_HEALTH = 10;
   public static final float DEFAULT_SPEED = 3.0F;
   protected int health;
   protected float speed;
   protected BufferedImage texture;
   protected float xMove;
   protected float yMove;
   
   public LivingEntity(Handler handler, int x, int y, EntityType type) {
     super(handler, x, y, type);
     this.health = 10;
     this.speed = 3.0F;
     
     this.xMove = 0.0F;
     this.yMove = 0.0F;
   }
   
   public void move() {
     moveX();
     moveY();
   }
   
   private void moveX() {
     if (this.xMove > 0.0F) {
       int tx = (int)(this.xMove + this.x + this.bounds.x + this.bounds.width) / 64;
       if (!collides(tx, (int)(this.y + this.bounds.y) / 64) && 
         !collides(tx, (int)(this.y + this.bounds.y + this.bounds.height) / 64)) {
         this.x += this.xMove;
       } else {
         this.x = (tx * 64 - this.bounds.x - this.bounds.width - 1);
       }
     
     } else if (this.xMove < 0.0F) {
       int tx = (int)(this.xMove + this.x + this.bounds.x) / 64;
       if (!collides(tx, (int)(this.y + this.bounds.y) / 64) && 
         !collides(tx, (int)(this.y + this.bounds.y + this.bounds.height) / 64)) {
         this.x += this.xMove;
       } else {
         this.x = (tx * 64 + 64 - this.bounds.x);
       } 
     } 
   }
   private void moveY() {
     if (this.yMove < 0.0F) {
       int ty = (int)(this.y + this.yMove + this.bounds.y) / 64;
       if (!collides((int)(this.x + this.bounds.x) / 64, ty) && 
         !collides((int)(this.x + this.bounds.x + this.bounds.width) / 64, ty)) {
         this.y += this.yMove;
       } else {
         this.y = (ty * 64 + 64 - this.bounds.y);
       }
     
     } else if (this.yMove > 0.0F) {
       int ty = (int)(this.y + this.yMove + this.bounds.y + this.bounds.height) / 64;
       if (!collides((int)(this.x + this.bounds.x + this.bounds.width) / 64, ty) && 
         !collides((int)(this.x + this.bounds.x + this.bounds.width) / 64, ty)) {
         this.y += this.yMove;
       } else {
         this.y = (ty * 64 - this.bounds.y - this.bounds.height - 1);
       } 
     } 
   }
   protected boolean collides(int x, int y) {
     return this.handler.getLevel().getTile(x, y).isSolid();
   }
 
   
   public boolean isLiving() {
     return true;
   }
 
   
   public BufferedImage getTexture() {
     return this.texture;
   }
   
   public void setTexture(BufferedImage texture) {
     this.texture = texture;
   }
   
   public float getxMove() {
     return this.xMove;
   }
   
   public void setxMove(float xMove) {
     this.xMove = xMove;
   }
   
   public float getyMove() {
     return this.yMove;
   }
   
   public void setyMove(float yMove) {
     this.yMove = yMove;
   }
   
   public int getHealth() {
     return this.health;
   }
   
   public void setHealth(int health) {
     this.health = health;
   }
 }



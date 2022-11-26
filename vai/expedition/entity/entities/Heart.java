 package vai.expedition.entity.entities;
 
 import java.awt.Graphics;
 import java.awt.image.BufferedImage;
 import vai.expedition.engine.Handler;
 import vai.expedition.engine.assets.Assets;
 import vai.expedition.entity.Entity;
 import vai.expedition.entity.EntityType;
 
 public class Heart
   extends Entity
 {
   private boolean empty;
   private BufferedImage texture;
   
   public Heart(Handler handler) {
     super(handler, 0, 0, EntityType.HEART);
     setWidth(32);
     setHeight(32);
     
     this.empty = false;
     this.texture = Assets.HEART_FULL;
   }
 
   
   public void tick() {
     if (this.empty)
       this.texture = Assets.HEART_EMPTY; 
   }
   
   public void render(Graphics gfx) {
     gfx.drawImage(this.texture, (int)this.x, (int)this.y, this.width, this.height, null);
   }
   
   public boolean isLiving() {
     return false;
   }
 
   
   public boolean isEmpty() {
     return this.empty;
   }
 
   
   public void setEmpty(boolean empty) {
     this.empty = empty;
   }
 }



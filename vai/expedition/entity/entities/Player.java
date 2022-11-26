 package vai.expedition.entity.entities;
 
 import java.awt.Color;
 import java.awt.Graphics;
 import java.text.DecimalFormat;
 import vai.expedition.Game;
 import vai.expedition.engine.Handler;
 import vai.expedition.engine.assets.Assets;
 import vai.expedition.entity.Entity;
 import vai.expedition.entity.EntityType;
 import vai.expedition.entity.LivingEntity;
 import vai.expedition.level.tile.Tile;
 import vai.expedition.level.tile.TileType;
 
 public class Player
   extends LivingEntity {
   private int maxHealth = 10;
   private DecimalFormat format = new DecimalFormat("#");
   
   public TileType current = TileType.VOID;
   
   public Player(Handler handler, int x, int y) {
     super(handler, x, y, EntityType.PLAYER);
     this.texture = Assets.PLAYER;
     
     setHealth(this.maxHealth);
     setWidth(64);
     setHeight(64);
     
     this.bounds.x = 12;
     this.bounds.y = 12;
     this.bounds.width = 38;
     this.bounds.height = 38;
   }
   
   public void tick() {
     updateInput();
     
     if (this.current.equals(TileType.FINISH)) {
       this.handler.getGame().setEndTime(System.currentTimeMillis());
       this.handler.getGame().setStage(Game.GameStage.END);
       
       return;
     } 
     move();
     this.handler.getCamera().center((Entity)this);
     this.current = getCurrentTile().getType();
     
     if (!this.handler.getMap().isDiscovered(Integer.valueOf(this.format.format((this.x / 64.0F))).intValue(), Integer.valueOf(this.format.format((this.y / 64.0F))).intValue()))
       this.handler.getMap().setDiscovered(Integer.valueOf(this.format.format((this.x / 64.0F))).intValue(), Integer.valueOf(this.format.format((this.y / 64.0F))).intValue(), true); 
   }
   
   public void render(Graphics gfx) {
     gfx.drawImage(this.texture, (int)(this.x - this.handler.getCamera().getX()), (int)(this.y - this.handler.getCamera().getY()), this.width, this.height, null);
   }
   
   public int getTileX() {
     return Integer.valueOf(this.format.format((this.x / 64.0F))).intValue();
   }
   
   public int getTileY() {
     return Integer.valueOf(this.format.format((this.y / 64.0F))).intValue();
   }
   
   public Tile getCurrentTile() {
     return this.handler.getLevel().getTile(Integer.valueOf(this.format.format((this.x / 64.0F))).intValue(), Integer.valueOf(this.format.format((this.y / 64.0F))).intValue());
   }
   
   public void drawBounds(Graphics gfx) {
     gfx.setColor(Color.RED);
     gfx.drawRect((int)(this.x + this.bounds.x - this.handler.getCamera().getX()), 
         (int)(this.y + this.bounds.x - this.handler.getCamera().getY()), this.bounds.width, this.bounds.height);
   }
   
   private void updateInput() {
     this.xMove = 0.0F;
     this.yMove = 0.0F;
     
     if ((this.handler.getKeyManager()).u)
       this.handler.getGame().stop(); 
     if ((this.handler.getKeyManager()).o)
       this.handler.getGame().restart(); 
     if ((this.handler.getKeyManager()).p) {
       this.handler.getMap().setSolution(!(this.handler.getMap()).showSolution);
     }
     if ((this.handler.getKeyManager()).up || (this.handler.getKeyManager()).up2)
       this.yMove = -this.speed; 
     if ((this.handler.getKeyManager()).down || (this.handler.getKeyManager()).down2)
       this.yMove = this.speed; 
     if ((this.handler.getKeyManager()).left || (this.handler.getKeyManager()).left2)
       this.xMove = -this.speed; 
     if ((this.handler.getKeyManager()).right || (this.handler.getKeyManager()).right2)
       this.xMove = this.speed; 
     if ((this.handler.getKeyManager()).escape) {
       this.handler.getGame().setEndTime(System.currentTimeMillis());
       this.handler.getGame().setStage(Game.GameStage.END);
     } 
 
     
     if ((this.handler.getKeyManager()).shift) {
       this.yMove /= 2.0F;
       this.xMove /= 2.0F;
     } 
   }
 }



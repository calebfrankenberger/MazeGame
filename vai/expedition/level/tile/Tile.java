 package vai.expedition.level.tile;
 
 import java.awt.Graphics;
 import java.awt.image.BufferedImage;
 import vai.expedition.level.tile.tiles.FinishTile;
 import vai.expedition.level.tile.tiles.PathTile;
 import vai.expedition.level.tile.tiles.StartTile;
 import vai.expedition.level.tile.tiles.VoidTile;
 import vai.expedition.level.tile.tiles.WallTile;
 
 
 
 public abstract class Tile
 {
   public static VoidTile voidTile = new VoidTile();
   public static FinishTile finishTile = new FinishTile();
   public static PathTile pathTile = new PathTile();
   public static WallTile wallTile = new WallTile();
   public static StartTile startTile = new StartTile();
   
   public static final int TILE_WIDTH = 64;
   
   public static final int TILE_HEIGHT = 64;
   
   protected BufferedImage texture;
   
   protected final TileType type;
   
   public Tile(BufferedImage texture, TileType type) {
     this.type = type;
     this.texture = texture;
   }
 
   
   public void tick() {}
 
   
   public void render(Graphics gfx, int x, int y) {
     gfx.drawImage(this.texture, x, y, 64, 64, null);
   }
 
   
   public abstract boolean isSolid();
   
   public TileType getType() {
     return this.type;
   }
   
   public BufferedImage getTexture() {
     return this.texture;
   }
   
   public void setTexture(BufferedImage texture) {
     this.texture = texture;
   }
 }



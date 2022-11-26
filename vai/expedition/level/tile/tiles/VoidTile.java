 package vai.expedition.level.tile.tiles;
 
 import vai.expedition.engine.assets.Assets;
 import vai.expedition.level.tile.Tile;
 import vai.expedition.level.tile.TileType;
 
 public class VoidTile
   extends Tile {
   public VoidTile() {
     super(Assets.VOID, TileType.VOID);
   }
 
   
   public boolean isSolid() {
     return false;
   }
 }



 package vai.expedition.level.tile.tiles;
 
 import vai.expedition.engine.assets.Assets;
 import vai.expedition.level.tile.Tile;
 import vai.expedition.level.tile.TileType;
 
 public class StartTile
   extends Tile {
   public StartTile() {
     super(Assets.START, TileType.START);
   }
 
   
   public boolean isSolid() {
     return false;
   }
 }



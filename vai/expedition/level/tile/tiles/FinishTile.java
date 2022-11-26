 package vai.expedition.level.tile.tiles;
 
 import vai.expedition.engine.assets.Assets;
 import vai.expedition.level.tile.Tile;
 import vai.expedition.level.tile.TileType;
 
 public class FinishTile
   extends Tile {
   public FinishTile() {
     super(Assets.FINISH, TileType.FINISH);
   }
 
   
   public boolean isSolid() {
     return false;
   }
 }



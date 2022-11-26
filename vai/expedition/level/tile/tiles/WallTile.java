 package vai.expedition.level.tile.tiles;
 
 import vai.expedition.engine.assets.Assets;
 import vai.expedition.level.tile.Tile;
 import vai.expedition.level.tile.TileType;
 
 public class WallTile
   extends Tile {
   public WallTile() {
     super(Assets.WALL, TileType.WALL);
   }
 
   
   public boolean isSolid() {
     return true;
   }
 }



 package vai.expedition.level.tile.tiles;
 
 import vai.expedition.engine.assets.Assets;
 import vai.expedition.level.tile.Tile;
 import vai.expedition.level.tile.TileType;
 
 public class PathTile
   extends Tile {
   public PathTile() {
     super(Assets.PATH, TileType.PATH);
   }
 
   
   public boolean isSolid() {
     return false;
   }
 }



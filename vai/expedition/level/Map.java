 package vai.expedition.level;
 
 import java.awt.Color;
 import java.awt.Graphics;
 import vai.expedition.engine.Handler;
 import vai.expedition.level.tile.TileType;
 
 
 
 
 
 
 public class Map
 {
   private Handler handler;
   public boolean showSolution = false;
   public boolean[][] tiles;
   private int size;
   
   public void setSolution(boolean solution) {
     this.showSolution = solution;
   }
   
   public boolean isDiscovered(int x, int y) {
     if (this.tiles[x][y])
       return true; 
     return false;
   }
   
   public void setDiscovered(int x, int y, boolean discovered) {
     this.tiles[x][y] = discovered;
   }
 
   
   public void tick() {}
   
   public Map(Handler handler) {
     this.size = 4;
     this.handler = handler;
     this.tiles = new boolean[handler.getLevel().getWidth()][handler.getLevel().getHeight()]; } public void render(Graphics gfx) {
     for (int y = 0; y < this.handler.getLevel().getHeight(); y++) {
       for (int x = 0; x < this.handler.getLevel().getWidth(); x++) {
         int xPos = x * this.size;
         int yPos = y * this.size;
         
         if (this.tiles[x][y]) {
           gfx.setColor(Color.CYAN);
           gfx.fillRect(xPos, yPos, this.size, this.size);
         } 
       } 
     } 
     
     if (this.showSolution) {
       for (int j = 0; j < this.handler.getLevel().getHeight(); j++) {
         for (int i = 0; i < this.handler.getLevel().getWidth(); i++) {
           int xPos = i * this.size;
           int yPos = j * this.size;
           
           if ((this.handler.getLevel()).correctPath[i][j]) {
             gfx.setColor(Color.GREEN);
             gfx.fillRect(xPos, yPos, this.size, this.size);
           } 
           
           if (!(this.handler.getLevel()).correctPath[i][j] && 
             !this.handler.getLevel().getTile(i, j).getType().equals(TileType.WALL)) {
             gfx.setColor(Color.CYAN);
             gfx.fillRect(xPos, yPos, this.size, this.size);
           } 
         } 
       } 
     }
     
     gfx.setColor(Color.orange);
     gfx.fillRect(this.handler.getGame().getPlayer().getTileX() * this.size, this.handler.getGame().getPlayer().getTileY() * this.size, this.size, this.size);
   }
 }



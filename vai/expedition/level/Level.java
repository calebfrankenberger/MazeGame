 package vai.expedition.level;
 
 import java.awt.Graphics;
 import vai.expedition.PrimsRecursive;
 import vai.expedition.engine.Handler;
 import vai.expedition.level.tile.Tile;
 
 
 
 public class Level
 {
   private int width;
   private int height;
   private Tile[][] tiles;
   private PrimsRecursive.Point startingPoint;
   private PrimsRecursive.Point endingPoint;
   private char[][] maz;
   private Handler handler;
   int[][] maze;
   boolean[][] wasHere;
   boolean[][] correctPath;
   boolean hasSolution;
   
   public Level(Handler handler, int h, int w) {
     this.handler = handler;
     this.height = h;
     this.width = w;
     load(h, w);
   }
 
 
   
   public void tick() {}
 
 
   
   public void render(Graphics gfx) {
     int xStart = Math.max(0, (int)this.handler.getCamera().getX() / 64);
     int xEnd = (int)Math.min(this.width, (this.handler.getCamera().getX() + 
         800.0F) / 64.0F + 1.0F);
     
     int yStart = Math.max(0, (int)this.handler.getCamera().getY() / 64);
     int yEnd = (int)Math.min(this.height, (this.handler.getCamera().getY() + 
         600.0F) / 64.0F + 1.0F);
     
     for (int y = yStart; y < yEnd; y++) {
       for (int x = xStart; x < xEnd; x++)
         getTile(x, y).render(gfx, (int)((x * 64) - this.handler.getCamera().getX()), 
             (int)((y * 64) - this.handler.getCamera().getY())); 
     } 
   }
   public Tile getTile(int x, int y) {
     if (x < 0 || y < 0 || x >= this.width || y >= this.height)
       return (Tile)Tile.voidTile; 
     if (this.tiles[x][y] == null)
       return (Tile)Tile.voidTile; 
     return this.tiles[x][y];
   }
 
   
   public void load(int w, int h) {
     this.tiles = new Tile[w][h];
     
     setWidth(w);
     setHeight(h);
     
     PrimsRecursive gen = new PrimsRecursive();
     
     this.maz = gen.generate(h, w);
     this.startingPoint = gen.getStartingPoint();
     this.endingPoint = gen.getEndingPoint();
     
     for (int y = 0; y < w; y++) {
       for (int x = 0; x < h; x++) {
         if (this.maz[x][y] == '*')
           this.tiles[x][y] = (Tile)Tile.wallTile; 
         if (this.maz[x][y] == '.') {
           this.tiles[x][y] = (Tile)Tile.pathTile;
         }
         if (this.maz[x][y] == 'S')
           this.tiles[x][y] = (Tile)Tile.startTile; 
         if (this.maz[x][y] == 'E')
           this.tiles[x][y] = (Tile)Tile.finishTile; 
       } 
     } 
     solveMaze();
     
     if (!this.hasSolution) {
       this.handler.getGame().restart();
     }
   }
 
 
 
 
 
   
   public int[][] convertMaze(char[][] maz) {
     int[][] temp = new int[this.width][this.height];
     
     for (int y = 0; y < this.width; y++) {
       for (int x = 0; x < this.height; x++) {
         if (maz[x][y] == '*') {
           temp[x][y] = 2;
         } else {
           temp[x][y] = 1;
         } 
       } 
     }  return temp;
   }
   
   public boolean[][] solveMaze() {
     this.maze = convertMaze(getMaz());
     this.wasHere = new boolean[this.width][this.height];
     this.correctPath = new boolean[this.width][this.height];
     
     for (int row = 0; row < this.maze.length; row++) {
       for (int col = 0; col < (this.maze[row]).length; col++) {
         this.wasHere[row][col] = false;
         this.correctPath[row][col] = false;
       } 
     } 
     this.hasSolution = recursiveSolve(this.startingPoint.r.intValue(), this.startingPoint.c.intValue(), this.endingPoint.r.intValue(), this.endingPoint.c.intValue(), this.maze);
     
     System.out.println("Solution: " + this.hasSolution);
     return this.correctPath;
   }
 
   
   public boolean recursiveSolve(int x, int y, int endX, int endY, int[][] maze) {
     if (x == endX && y == endY) return true; 
     if (maze[x][y] == 2 || this.wasHere[x][y]) return false;
     
     this.wasHere[x][y] = true;
     if (x != 0 && 
       recursiveSolve(x - 1, y, endX, endY, maze)) {
       this.correctPath[x][y] = true;
       return true;
     } 
     if (x != this.width - 1 && 
       recursiveSolve(x + 1, y, endX, endY, maze)) {
       this.correctPath[x][y] = true;
       return true;
     } 
     if (y != 0 && 
       recursiveSolve(x, y - 1, endX, endY, maze)) {
       this.correctPath[x][y] = true;
       return true;
     } 
     
     if (y != this.height - 1 && 
       recursiveSolve(x, y + 1, endX, endY, maze)) {
       this.correctPath[x][y] = true;
       return true;
     } 
     return false;
   }
   
   public char[][] getMaz() {
     return this.maz;
   }
   
   public PrimsRecursive.Point getEndingPoint() {
     return this.endingPoint;
   }
   
   public PrimsRecursive.Point getStartingPoint() {
     return this.startingPoint;
   }
 
   
   public int getWidth() {
     return this.width;
   }
   
   public void setWidth(int width) {
     this.width = width;
   }
   
   public int getHeight() {
     return this.height;
   }
   
   public void setHeight(int height) {
     this.height = height;
   }
 }



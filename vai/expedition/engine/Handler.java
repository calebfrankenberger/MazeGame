 package vai.expedition.engine;
 
 import vai.expedition.Game;
 import vai.expedition.engine.graphics.Camera;
 import vai.expedition.engine.graphics.Screen;
 import vai.expedition.engine.input.KeyManager;
 import vai.expedition.level.Level;
 import vai.expedition.level.Map;
 
 
 
 
 public class Handler
 {
   private int width;
   private int height;
   private String name;
   private Game game;
   
   public Handler(Game game) {
     this.game = game;
     init();
   }
   
   public void init() {
     this.width = 800;
     this.height = 600;
     this.name = "Maze Game V0.1 (by Caleb Frankenberger)";
   }
 
   
   public Map getMap() {
     return this.game.getMap();
   }
   
   public Level getLevel() {
     return this.game.getLevel();
   }
   
   public Camera getCamera() {
     return this.game.getCamera();
   }
   
   public KeyManager getKeyManager() {
     return this.game.getKeyManager();
   }
   
   public int getWidth() {
     return this.width;
   }
   
   public int getHeight() {
     return this.height;
   }
   
   public String getName() {
     return this.name;
   }
   
   public Game getGame() {
     return this.game;
   }
   
   public Screen getScreen() {
     return this.game.getScreen();
   }
 }



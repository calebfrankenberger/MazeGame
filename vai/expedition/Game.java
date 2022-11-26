 package vai.expedition;
 
 import java.awt.Color;
 import java.awt.Font;
 import java.awt.Graphics;
 import java.awt.event.KeyListener;
 import java.awt.image.BufferStrategy;
 import vai.expedition.engine.Handler;
 import vai.expedition.engine.assets.Assets;
 import vai.expedition.engine.graphics.Camera;
 import vai.expedition.engine.graphics.Screen;
 import vai.expedition.engine.input.KeyManager;
 import vai.expedition.entity.entities.Player;
 import vai.expedition.level.Level;
 import vai.expedition.level.Map;
 
 
 
 
 
 public class Game
   implements Runnable
 {
   private Screen screen;
   private Camera camera;
   private Thread thread;
   private boolean running = false;
   private Handler handler;
   private int fps;
   private KeyManager keyManager;
   private Player player;
   private Level level;
   private Map map;
   private long startTime;
   private long endTime;
   private int fpsCounter;
   private GameStage stage;
   
   public enum GameStage
   {
     START, END;
   }
 
 
   
   public Game() {
     this.keyManager = new KeyManager();
   }
   
   public void init() {
     Assets.init();
     setStage(GameStage.START);
     setStartTime(System.currentTimeMillis());
     
     this.screen = new Screen("Maze Game V0.1 (by Caleb Frankenberger)", 800, 600);
     this.screen.getFrame().addKeyListener((KeyListener)this.keyManager);
     
     this.handler = new Handler(this);
     this.camera = new Camera(this.handler, 0.0F, 0.0F);
     
     this.level = new Level(this.handler, 50, 50);
     this.player = new Player(this.handler, (this.level.getStartingPoint()).r.intValue() * 64, (this.level.getStartingPoint()).c.intValue() * 64);
     this.map = new Map(this.handler);
   }
   
   public void run() {
     init();
 
     
     long lastTime = System.nanoTime();
     double tps = 60.0D;
     double nano = 1.0E9D / tps;
     double delta = 0.0D;
     
     long timer = System.currentTimeMillis();
     
     int updates = 0;
     this.fps = 0;
     
     while (this.running) {
       long now = System.nanoTime();
       delta += (now - lastTime) / nano;
       lastTime = now;
       
       while (delta >= 1.0D) {
         tick();
         updates++;
         delta--;
       } 
       
       render();
       this.fps++;
       
       if (System.currentTimeMillis() - timer > 1000L) {
         timer += 1000L;
         System.out.println("FPS: " + this.fps + " TICKS: " + updates);
         setFpsCounter(this.fps);
         
         this.fps = 0;
         updates = 0;
       } 
     } 
   }
   
   private void tick() {
     if (getStage().equals(GameStage.END)) {
       return;
     }
     
     this.keyManager.tick();
     this.level.tick();
     this.player.tick();
   }
   
   private void render() {
     BufferStrategy strat = this.screen.getCanvas().getBufferStrategy();
     if (strat == null) {
       this.screen.getCanvas().createBufferStrategy(3);
       return;
     } 
     Graphics gfx = strat.getDrawGraphics();
     gfx.clearRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
 
     
     if (getStage().equals(GameStage.END)) {
       gfx.drawImage(Assets.END_SCREEN, 0, 0, null);
       
       gfx.setFont(new Font("TimesRoman", 1, 50));
       gfx.setColor(Color.GREEN);
       gfx.drawString(startTimeFrom(this.startTime, this.endTime), this.handler.getWidth() / 2 - 30, this.handler.getHeight() / 2 + 50);
       
       gfx.setFont(new Font("TimesRoman", 2, 50));
       gfx.setColor(Color.GREEN);
       gfx.drawString("Time: ", this.handler.getWidth() / 2 - 150, this.handler.getHeight() / 2 + 50);
       
       gfx.dispose();
       strat.show();
       
       return;
     } 
     gfx.setColor(Color.BLACK);
     gfx.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
     
     this.level.render(gfx);
     this.player.render(gfx);
     
     gfx.drawImage(Assets.OVERLAY, 0, 0, null);
     
     gfx.setFont(new Font("TimesRoman", 1, 20));
     
     gfx.setColor(Color.YELLOW);
     gfx.drawString(startTimeFrom(this.startTime, System.currentTimeMillis()), this.handler.getWidth() - 100, 20);
     gfx.setColor(Color.GREEN);
     gfx.drawString("FPS: " + getFpsCounter(), this.handler.getWidth() - 100, 40);
     
     gfx.setFont(new Font("TimesRoman", 0, 12));
     gfx.setColor(Color.WHITE);
     gfx.drawString("U - Press to exit", this.handler.getWidth() - 110, 60);
     gfx.drawString("O - Press to restart", this.handler.getWidth() - 110, 75);
     gfx.drawString("P - Press to cheat", this.handler.getWidth() - 110, 90);
     
     this.map.render(gfx);
 
     
     gfx.dispose();
     strat.show();
   }
   
   public synchronized void start() {
     if (this.running) {
       return;
     }
     this.running = true;
     this.thread = new Thread(this);
     this.thread.start();
   }
   
   public synchronized void stop() {
     if (!this.running)
       return; 
     this.running = false;
     this.screen.getFrame().dispose();
     try {
       this.thread.join();
     } catch (Exception exception) {}
   }
   
   public synchronized void restart() {
     (new Game()).start();
     stop();
   }
 
   
   public String startTimeFrom(long startTime, long currentTime) {
     long millis = currentTime - startTime;
     
     long second = millis / 1000L % 60L;
     long minute = millis / 60000L % 60L;
     long hour = millis / 3600000L % 24L;
     
     String time = String.format("%02d:%02d:%02d", new Object[] { Long.valueOf(hour), Long.valueOf(minute), Long.valueOf(second) });
     return time;
   }
   
   public Player getPlayer() {
     return this.player;
   }
   
   public int getFPS() {
     return this.fps;
   }
   
   public Level getLevel() {
     return this.level;
   }
   
   public Camera getCamera() {
     return this.camera;
   }
   
   public KeyManager getKeyManager() {
     return this.keyManager;
   }
   
   public Screen getScreen() {
     return this.screen;
   }
   
   public Handler getHandler() {
     return this.handler;
   }
   
   public Map getMap() {
     return this.map;
   }
   
   public GameStage getStage() {
     return this.stage;
   }
   
   public void setStage(GameStage stage) {
     this.stage = stage;
   }
   
   public long getStartTime() {
     return this.startTime;
   }
   
   public void setStartTime(long startTime) {
     this.startTime = startTime;
   }
   
   public long getEndTime() {
     return this.endTime;
   }
   
   public void setEndTime(long endTime) {
     this.endTime = endTime;
   }
 
   
   public int getFpsCounter() {
     return this.fpsCounter;
   }
   
   public void setFpsCounter(int fpsCounter) {
     this.fpsCounter = fpsCounter;
   }
 }



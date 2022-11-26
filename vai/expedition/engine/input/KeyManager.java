 package vai.expedition.engine.input;
 
 import java.awt.event.KeyEvent;
 import java.awt.event.KeyListener;
 
 
 
 
 public class KeyManager
   implements KeyListener
 {
   private boolean[] keys = new boolean[999]; public boolean up; public boolean down; public boolean left; public boolean right; public boolean shift;
   public boolean up2;
   
   public void tick() {
     this.shift = this.keys[16];
     this.up = this.keys[87];
     this.left = this.keys[65];
     this.down = this.keys[83];
     this.right = this.keys[68];
     this.up2 = this.keys[38];
     this.left2 = this.keys[37];
     this.down2 = this.keys[40];
     this.right2 = this.keys[39];
     this.escape = this.keys[27];
     this.u = this.keys[85];
     this.o = this.keys[79];
     this.p = this.keys[80];
   }
   public boolean down2; public boolean left2; public boolean right2; public boolean escape; public boolean u; public boolean o; public boolean p;
   
   public void keyPressed(KeyEvent event) {
     this.keys[event.getKeyCode()] = true;
   }
 
   
   public void keyReleased(KeyEvent event) {
     this.keys[event.getKeyCode()] = false;
   }
   
   public void keyTyped(KeyEvent arg0) {}
 }



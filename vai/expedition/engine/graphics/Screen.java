 package vai.expedition.engine.graphics;
 
 import java.awt.Canvas;
 import java.awt.Component;
 import java.awt.Dimension;
 import javax.swing.JFrame;
 
 public class Screen
 {
   private static JFrame frame;
   private static Canvas canvas;
   private String NAME;
   private int WIDTH;
   private int HEIGHT;
   
   public Screen(String name, int w, int h) {
     this.NAME = name;
     this.WIDTH = w;
     this.HEIGHT = h;
     
     init();
   }
   
   private void init() {
     frame = new JFrame(this.NAME);
     
     frame.setSize(this.WIDTH, this.HEIGHT);
     frame.setMaximumSize(new Dimension(this.WIDTH, this.HEIGHT));
     frame.setMinimumSize(new Dimension(this.WIDTH, this.HEIGHT));
     frame.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
     
     frame.setResizable(false);
     frame.setDefaultCloseOperation(3);
     
     frame.setLocationRelativeTo((Component)null);
     frame.setVisible(true);
     
     canvas = new Canvas();
     
     canvas.setSize(new Dimension(this.WIDTH, this.HEIGHT));
     canvas.setMaximumSize(new Dimension(this.WIDTH, this.HEIGHT));
     canvas.setMinimumSize(new Dimension(this.WIDTH, this.HEIGHT));
     canvas.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
     canvas.setFocusable(false);
     
     frame.add(canvas);
     frame.pack();
   }
   
   public Canvas getCanvas() {
     return canvas;
   }
   
   public JFrame getFrame() {
     return frame;
   }
 }



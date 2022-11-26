 package vai.expedition.objects;
 
 import java.awt.Graphics;
 import vai.expedition.entity.entities.Player;
 
 
 public class Inventory
 {
   private int slots;
   private String name;
   
   public Inventory(String name, int slots) {
     this.slots = slots;
     this.name = name;
   }
 
 
   
   public void open(Player player) {}
 
 
   
   public void tick() {}
 
 
   
   public void render(Graphics gfx) {}
 
   
   public int getSlots() {
     return this.slots;
   }
   
   public void setSlots(int slots) {
     this.slots = slots;
   }
   
   public String getName() {
     return this.name;
   }
   
   public void setName(String name) {
     this.name = name;
   }
 }



 package vai.expedition;
 
 import java.util.ArrayList;
 
 public class PrimsRecursive
 {
   private Point startingPoint = null;
   private Point endingPoint = null;
   
   public Point getEndingPoint() {
     return this.endingPoint;
   }
   
   public Point getStartingPoint() {
     return this.startingPoint;
   }
 
 
 
 
 
 
 
   
   public char[][] generate(int length, int width) {
     StringBuilder s = new StringBuilder(width);
     char[][] maz = new char[length][width];
     int x;
     for (x = 0; x < width; x++)
       s.append('*'); 
     for (x = 0; x < length; x++) {
       maz[x] = s.toString().toCharArray();
     }
     
     this.startingPoint = new Point((int)(Math.random() * length), (int)(Math.random() * width), null);
     maz[this.startingPoint.r.intValue()][this.startingPoint.c.intValue()] = 'S';
 
     
     ArrayList<Point> frontier = new ArrayList<>();
     for (int i = -1; i <= 1; i++) {
       for (int y = -1; y <= 1; y++) {
         if ((i != 0 || y != 0) && (i == 0 || y == 0))
           
           try {
             
             if (maz[this.startingPoint.r.intValue() + i][this.startingPoint.c.intValue() + y] != '.')
             {
 
 
 
 
 
               
               frontier.add(new Point(this.startingPoint.r.intValue() + i, this.startingPoint.c.intValue() + y, this.startingPoint)); } 
           } catch (Exception e) {} 
       } 
     }  Point last = null;
     while (!frontier.isEmpty()) {
       
       Point current = frontier.remove((int)(Math.random() * frontier.size()));
       Point opposite = current.opposite();
 
       
       try {
         if (maz[current.r.intValue()][current.c.intValue()] == '*' && 
           maz[opposite.r.intValue()][opposite.c.intValue()] == '*') {
 
           
           maz[current.r.intValue()][current.c.intValue()] = '.';
           maz[opposite.r.intValue()][opposite.c.intValue()] = '.';
 
           
           last = opposite;
 
           
           for (int k = -1; k <= 1; k++) {
             for (int y = -1; y <= 1; y++) {
               if ((k != 0 || y != 0) && (k == 0 || y == 0)) {
                 
                 try {
                   if (maz[opposite.r.intValue() + k][opposite.c.intValue() + y] != '.')
                   {
 
 
 
                     
                     frontier.add(new Point(opposite.r.intValue() + k, opposite.c.intValue() + y, opposite));
                   }
                 } catch (Exception e) {}
               }
             } 
           } 
         } 
       } catch (Exception exception) {}
 
       
       for (int j = 0; j < length; j++) {
         for (int y = 0; y < width; y++) {
           if (j == 0 || j == length - 1)
             maz[j][y] = '*'; 
           if (y == 0 || y == width - 1) {
             maz[j][y] = '*';
           }
         } 
       } 
       if (frontier.isEmpty()) {
         maz[last.r.intValue()][last.c.intValue()] = 'E';
         this.endingPoint = new Point(last.r.intValue(), last.c.intValue(), null);
       } 
     } 
     
     return maz;
   }
   
   public static class Point { public Integer r;
     public Integer c;
     Point parent;
     
     public Point(int x, int y, Point p) {
       this.r = Integer.valueOf(x); this.c = Integer.valueOf(y); this.parent = p;
     }
 
     
     public Point opposite() {
       if (this.r.compareTo(this.parent.r) != 0)
         return new Point(this.r.intValue() + this.r.compareTo(this.parent.r), this.c.intValue(), this); 
       if (this.c.compareTo(this.parent.c) != 0)
         return new Point(this.r.intValue(), this.c.intValue() + this.c.compareTo(this.parent.c), this); 
       return null;
     } }
 
 }



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import ivisible.IVisible;
import figures.*;

class Project1App {
    public static void main (String[] args) {
        IfaceFrame frame = new IfaceFrame();
        frame.setVisible(true);
    }
}

class IfaceFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    Figure focus = null;

    IfaceFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        
        this.addKeyListener (
            new KeyAdapter() {
                boolean Rr = false, Ro = false;
                int i = 0;int P = 0;int c = 0;
                int x = 0, y = 0, w = 100, h = 100, arcw = 50, arch = 50;   
                public void keyPressed (KeyEvent evt) {
                 
                    
                    if ( i == 0 )  P = 0;  
                    
                    //System.out.println("i = ");
                    //System.out.println(i);  
         
                    char n = evt.getKeyChar();
                    int num = evt.getKeyChar();
                    num -= 48;
         

                  //  System.out.println("i = ");
                  //  System.out.println(i); 
                  //  System.out.println("num = ");
                  //  System.out.println(num);
                    if ( (num >= 0)&&(num <= 9)  ) {
                       
                        if ( i == 0 ) P = P + num*100;
                        if ( i == 1 ) P = P + num*10;
                        if ( i == 2 ) {

                            P = P + num;
                           
                         //   System.out.println("P =");
                         //   System.out.println(P);
                      
                        }    
                  
                        i++;
                  
                        if ( i == 3 ) {
                        
                            if ( c == 0 ) {

                                x = P;

                                System.out.println("x =");
                                System.out.println(x);
                            }    
                       
                            if ( c == 1 ) {

                                y = P;

                                System.out.println("y =");
                                System.out.println(y);
                            }  

                            if ( c == 2 ) {

                                w = P;

                                System.out.println("w =");
                                System.out.println(w);
                            }  
                       
                            if ( c == 3 ) {

                                h = P;

                                System.out.println("h =");
                                System.out.println(h);
                            }  
  
                            if ( c == 4 ) {

                                arcw = P;

                                System.out.println("arcw =");
                                System.out.println(arcw);
                            }  
 
                            if ( c == 5 ) {

                                arch = P;

                                System.out.println("arch =");
                                System.out.println(arch);
                            }  
 
                 //           if ( c == 0 ) x = P; 
                 //           if ( c == 1 ) y = P;
                 //           if ( c == 2 ) w = P;
                 //           if ( c == 3 ) h = P;
                 //           if ( c == 4 ) arcw = P;
                 //           if ( c == 5 ) arch = P;                            
                            i = 0;
                            c++;
                 //           System.out.println("c =");
                 //           System.out.println(c);
                            if ( (!Rr)&&(c == 4 ) ) {
         
                                c = 0;

                            }
                          
                            if ( (Rr)&&(c == 6 ) ) {
         
                                c = 0;
                                Ro = true;

                            }
                         
                        };
               //         System.out.println("c =");
             //           System.out.println(c);  

                         
                



                    }
             //       System.out.println("n =");
               //     System.out.println(n); 
               //     System.out.println("i = ");
             //       System.out.println(i); 
                    if (evt.getKeyChar() == 'e') {
                        System.out.println("Ellipse");

                        Ellipse e = new Ellipse(x,y,w,h);
                        figs.add(e);   
                    }
                    if (evt.getKeyChar() == 'r') {
                        System.out.println("Rect");

                        Rect r = new Rect(x,y,w,h);
                        figs.add(r);   
                    }
                    if (evt.getKeyChar() == 'o') {
                        System.out.println("RoundRect");
                        Rr = true;
                        if ( (Rr)&&(Ro) ) {
                            RoundRect o = new RoundRect(x,y,w,h,arcw,arch);
                            figs.add(o);
                            Rr = false;
                            Ro = false; 
                        }   
                        
                    }
                    repaint();
                }
            }
        );

        this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    int x = evt.getX();
                    int y = evt.getY();
                    focus = null;                                
                    
                    for (Figure fig: figs) {
                         
                        
                        if (fig.clicked(x,y)/*(x>=fig.x)&&(x<=fig.x+fig.w)&&(y>=fig.y)&&(y<=fig.y+fig.h)*/) {
                       
                            System.out.println("CLICKED");   
                            focus = fig;
                                         
                        }
                  
                    }
                    if (focus != null) {
                     
                        figs.remove(focus);
                        figs.add(focus); 
                    
                    }
                    repaint();
                }
            }
        );

 //       this.addMouseMotionListener (
 //           new MouseMotionAdapter() {
 //               public void mousePressed (MouseEvent evt) {
 //                   int dx = evt.getMotionX();
  //                  int dy = evt.getMotionY();
 //                   //focus = null;                                
                    
                  //  for (Figure fig: figs) {
           
 //                       if (focus != null) {
                     
 //                           fig.drag(dx,dy); 
  //                          repaint();

    //                    }

                   // }
                    
      //          }
 //           }
   //     );








        this.setTitle("Interface IVisible");
        this.setSize(500, 500);
    }

    public void paint (Graphics g) {
        super.paint(g);  
        for (Figure fig: this.figs) {
            if (fig == focus) fig.paint(g,true);
            else fig.paint(g,false);        
        }
    }

}





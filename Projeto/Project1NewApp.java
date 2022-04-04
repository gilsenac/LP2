import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import ivisible.IVisible;
import figures.*;

class Project1NewApp {
    public static void main (String[] args) {
        IfaceFrame frame = new IfaceFrame();
        frame.setVisible(true);
    }
}

class IfaceFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    Figure focus = null;
    Figure geom = null;
    char n = 'A';
    int X, Y, W, H;
    boolean dragged = false;
    int conta = 0;

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
             
            //    int x = 0, y = 0, w = 100, h = 100, arcw = 50, arch = 50;   
               
                public void keyPressed (KeyEvent evt) {
                 
                    n = evt.getKeyChar();
                    int num = (int)n;
                    num -= 48;
             
                    if (focus != null) {
                        if (n == 'd') {
                           figs.remove(focus);
                           repaint();
                        }
                    }
                }
            }
        );

        this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    int x = evt.getX();
                    int y = evt.getY();
                    int cont = 0;
                    focus = null;                                
                    
                    for (Figure fig: figs) {
                         
                        
                        if (fig.clicked(x,y)/*(x>=fig.x)&&(x<=fig.x+fig.w)&&(y>=fig.y)&&(y<=fig.y+fig.h)*/) {
                       
                            System.out.println( "CLICKED" + ++cont );
    
                            if ( cont == 1 ) { 

                                focus = fig;

                            }                            
                        }
                    }

                    if (focus != null) {
                        if (n == 'd') figs.remove(focus);                      
                        figs.remove(focus);
                        figs.add(focus); 
                    }
                    else {
                        X = x; Y = y;
                    }
                    repaint();
                }

                public void mouseReleased (MouseEvent evt) {
           
                    System.out.println("RELEASED");   

                    if ( dragged ) {                    
         
                        conta = 0;
                        System.out.println(n);   
                        dragged = false;
                        repaint();
                    }
                                      
                }
            }
        );

        this.addMouseMotionListener (
            new MouseMotionAdapter() {
                 
                int tam = 0;
              
                public void mouseDragged (MouseEvent evt) {
                  //  int dx = evt.getMotionX();
                  //  int dy = evt.getMotionY();
                  //focus = null;
                    
                    System.out.println("DRAGGED" + ++conta);                                
                    W = Math.abs ( X - evt.getX()  ); 
                    H = Math.abs ( Y - evt.getY() );
                    dragged = true;
                    if ( ( conta > 1 )&&((n == 'e')||(n == 'r')||(n == 'o')) ) figs.remove(geom);                    
                    if (n == 'e') {

                       System.out.println("Ellipse");
                       Ellipse e = new Ellipse(X,Y,W,H);
                       figs.add(e);
                       geom = e;   
                    }
                    if (n == 'r') {

                        System.out.println("Rect");
                        Rect r = new Rect(X,Y,W,H);
                        figs.add(r);
                        geom = r;   
                    }
                    if (n == 'o') {

                        System.out.println("RoundRect");
                        RoundRect o = new RoundRect(X,Y,W,H,50,50);
                        figs.add(o);
                        geom = o;  
                    }
                    			
                    for (Figure fig: figs) {

                        tam++; 
                    }
                    System.out.println( "Tam =" + tam );
                    tam = 0;
                
                    repaint();                                                                   
                }               
            }
        );


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




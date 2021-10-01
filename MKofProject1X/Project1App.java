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
                public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    int arcw = rand.nextInt(35);
                    int arch = rand.nextInt(35);
                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect(x,y, w,h);
                        figs.add(r);
                    }  
                    if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h));
                    }
                    if (evt.getKeyChar() == 'o') {
                        figs.add(new RoundRect(x,y, w,h, arcw,arch));
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
                    repaint(); 
                }
            }
        );

        this.setTitle("Interface IVisible");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);  
        for (Figure fig: this.figs) {
            if (fig == focus) fig.paint(g,true);
            else fig.paint(g,false);        
        }
    }
}

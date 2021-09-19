import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListAppNew {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    ListFrame () {
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
                    int z = rand.nextInt(175);
                    int k = rand.nextInt(175);
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
                    if (evt.getKeyChar() == 'l') {
                        figs.add(new Line(x,y, z,k));
                    }
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PackAppNewest {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    RectNew r1;
    EllipseNew e1;
    RoundRectNew u1;    

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);
        this.r1 = new RectNew(50,50, 100,30,'r','g');
        this.e1 = new EllipseNew(50,100, 100,30,'p','w');
        this.u1 = new RoundRectNew(50,150, 100,50, 20,15,'b','y');  
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
        this.u1.paint(g);
    }
}

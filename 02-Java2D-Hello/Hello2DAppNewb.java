import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DAppNewb {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - God save the Queen !");
        this.setSize(350, 350);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        g2d.setPaint(Color.yellow);
        g2d.drawRect(0,0, w,h);
        g2d.fillRect(0,0, w,h);
        g2d.setPaint(Color.green);
        g2d.drawRect(100,100, w-200,h-200);
        g2d.fillRect(100,100, w-200,h-200);
        g2d.setPaint(Color.red);
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
        g2d.drawLine(w/2,0, w/2,h);
        g2d.drawLine(0,h/2, w,h/2);
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class PaintAppNewest {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Ellipse e1,e2,e3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.e1 = new Ellipse(50,40, 200,90,'r','y');
        this.e2 = new Ellipse(50,160, 250,40,'g','v');
        this.e3 = new Ellipse(50,230, 70,50,'p','b');
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
    }
}

class Ellipse {
    int x, y;
    int w, h;
    char border;
    char cor; 
    Ellipse (int x, int y, int w, int h, char b, char c) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.border = b;
        this.cor = c;
    }

    void print () {
        System.out.format("Ellipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        if (cor == 'b') g.setColor(Color.blue);
        if (cor == 'r') g.setColor(Color.red);
        if (cor == 'y') g.setColor(Color.yellow);
        if (cor == 'g') g.setColor(Color.green);
        if (cor == 'p') g.setColor(Color.black);
        if (cor == 'w') g.setColor(Color.white);
        if (cor == 'v') g.setColor(Color.pink);
    //  g.setColor(new Color(0,255,0));
        Graphics2D g2d = (Graphics2D) g;
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        if (border == 'b') g.setColor(Color.blue);
        if (border == 'r') g.setColor(Color.red);
        if (border == 'y') g.setColor(Color.yellow);
        if (border == 'g') g.setColor(Color.green);
        if (border == 'p') g.setColor(Color.black);
        if (border == 'w') g.setColor(Color.white);
        if (border == 'v') g.setColor(Color.pink);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}

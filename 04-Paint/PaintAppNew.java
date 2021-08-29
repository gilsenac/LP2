import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintAppNew {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1,r2,r3;

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
        this.r1 = new Rect(50,50, 100,30,'b','w');
        this.r2 = new Rect(50,100, 100,30,'r','p');
        this.r3 = new Rect(50,150, 100,30,'y','g');
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    char border;
    char cor; 
    Rect (int x, int y, int w, int h, char b, char c) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.border = b;
        this.cor = c;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
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
        g2d.fillRect(this.x,this.y, this.w,this.h);
        if (border == 'b') g.setColor(Color.blue);
        if (border == 'r') g.setColor(Color.red);
        if (border == 'y') g.setColor(Color.yellow);
        if (border == 'g') g.setColor(Color.green);
        if (border == 'p') g.setColor(Color.black);
        if (border == 'w') g.setColor(Color.white);
        if (border == 'v') g.setColor(Color.pink);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}

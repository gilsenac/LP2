package figures;

import java.awt.*;

public class RectNew {
    int x, y;
    int w, h;
    char border, cor;

    public RectNew (int x, int y, int w, int h, char b, char c) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.border = b;
        this.cor = c;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        if (cor == 'b') g.setColor(Color.blue);
        if (cor == 'r') g.setColor(Color.red);
        if (cor == 'y') g.setColor(Color.yellow);
        if (cor == 'g') g.setColor(Color.green);
        if (cor == 'p') g.setColor(Color.black);
        if (cor == 'w') g.setColor(Color.white);
        if (cor == 'v') g.setColor(Color.pink);
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

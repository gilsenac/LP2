package figures;

import java.awt.*;

public class RoundRect extends Figure {
    int x, y;
    int w, h;
    int arcw,arch;

    public RoundRect (int x, int y, int w, int h, int arcw, int arch) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.arcw = arcw;
        this.arch = arch;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y, this.arcw, this.arch );
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRoundRect(this.x,this.y, this.w,this.h, this.arcw, this.arch);
    }
}

package figures;

import java.awt.*;

public class RoundRect extends Figure {
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
        System.out.format("Retangulo arredondado de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        if (focused) {
            g2d.setPaint(Color.RED);
         //   g2d.fillRoundRect(this.x-2,this.y-2, this.w+4,this.h+4, this.arcw,this.arch);
            g2d.drawRoundRect(this.x-2,this.y-2, this.w+4,this.h+4, this.arcw,this.arch);
        }
      //  g2d.setPaint(Color.WHITE);
     //   g2d.fillRoundRect(this.x,this.y, this.w,this.h, this.arcw,this.arch);
        g2d.setPaint(Color.BLACK);
        g2d.drawRoundRect(this.x,this.y, this.w,this.h, this.arcw,this.arch);
    }
}

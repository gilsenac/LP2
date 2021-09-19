package figures;

import java.awt.*;

public class Line extends Figure {
    int x, y;
    int z, k;

    public Line (int x, int y, int z, int k) {
        this.x = x;
        this.y = y;
  
        this.z = z;
        this.k = k;
    }

    public void print () {
        System.out.format("Linha de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.z, this.k, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(this.x,this.y, this.z,this.k);
    }
}  



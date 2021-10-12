package ivisible;

import java.awt.Graphics;

public interface IVisible {
    public abstract boolean clicked (int x, int y);
    public abstract void    paint   (Graphics g,boolean focused);
}

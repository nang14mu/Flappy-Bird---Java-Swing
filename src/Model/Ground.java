package Model;

import java.awt.*;

public class Ground implements ObjGameSymmetric{
    private int x;
    private int ytop;
    private int yunder;
    private int width;
    private int height;
    private int gap = 500;

    public Ground(int x, int y, int width, int height){
        this.x=x;
        this.ytop =y;
        this.yunder = ytop + gap;
        this.width=width;
        this.height=height;
    }

    public int getX() {
        return x;
    }

    public int getYtop() {
        return ytop;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getGap(){
        return this.gap;
    }

    public int getYunder() {
        return yunder;
    }

    @Override
    public void update() {

    }

    @Override
    public Rectangle getBoundTop() {
        return new Rectangle(x, ytop,width,height);
    }

    @Override
    public Rectangle getBoundUnder() {
        return new Rectangle(x, ytop +gap,width,height);
    }
}

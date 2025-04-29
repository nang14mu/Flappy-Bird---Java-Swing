package Model;

import java.awt.*;
import java.util.Random;

public class Pipe implements ObjGameSymmetric{
    private int xPipe;
    private int yTopPipe;
    private int yUnderPipe;
    private final int widthPipe = 50;
    private int topHeight;
    private int underHeight;
    private int speed = 3;
    private final int  gap = 100;//khoảng cách cột trên và dưới
    private boolean isOffScreen = true;
    private Random random;

    public Pipe(int xOfFrontPipe){
        random = new Random();
        this.xPipe = xOfFrontPipe + 150;
        this.yTopPipe = 70;
        this.topHeight = random.nextInt(50,300);
        this.yUnderPipe = yTopPipe + topHeight + gap;
        this.underHeight = 500 - gap - yTopPipe;
    }

    public void move(){
        xPipe -=speed;
    }

    //kiểm tra cột ra ngoài
    public boolean setOffScreen(){
        if(this.xPipe < 0){
            return false;
        }
        return true;
    }

    public int getxPipe() {
        return xPipe;
    }

    public int getyTopPipe() {
        return yTopPipe;
    }

    public int getyUnderPipe() {
        return yUnderPipe;
    }

    public int getWidthPipe() {
        return widthPipe;
    }

    public int getTopHeight() {
        return topHeight;
    }

    public int getUnderHeight() {
        return underHeight;
    }

    @Override
    public void update() {
        if(isOffScreen){
            move();
        }
    }

    @Override
    public Rectangle getBoundTop() {
        return new Rectangle(xPipe, yTopPipe, widthPipe, topHeight);
    }

    @Override
    public Rectangle getBoundUnder() {
        return new Rectangle(xPipe, yUnderPipe, widthPipe,underHeight);
    }
}

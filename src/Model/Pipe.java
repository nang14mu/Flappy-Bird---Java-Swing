package Model;

import java.awt.*;
import java.util.Random;

public class Pipe implements ObjGameSymmetric,GameDefaultSize{
    private int xPipe;
    private int yTopPipe;
    private int yUnderPipe;
    private final int widthPipe = GameDefaultSize.widhPipe;
    private int topHeight;
    private int underHeight;
    private int speed = 3;
    private final int  gap = 100;//khoảng cách cột trên và dưới
    private boolean isOffScreen = true;
    private boolean isPassed = false;
    private Random random;

    public Pipe(int xOfFrontPipe){
        random = new Random();
        this.xPipe = xOfFrontPipe + 150;
        //this.yTopPipe = 70;
        this.yTopPipe = 50;
        this.topHeight = random.nextInt(50,300);
        this.yUnderPipe = yTopPipe + topHeight + gap;
        //this.underHeight = 500 - gap - yTopPipe;
        this.underHeight = 500 - gap - topHeight;
    }

    public void move(){
        xPipe -=speed;
    }

    //kiểm tra cột ra ngoài
    public boolean isOnScreen() {
        return this.xPipe + widthPipe >= 0;
    }

    public boolean getPassed(){
        return isPassed;
    }

    public void setIsPassed(boolean passed){
        isPassed = passed;
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

package Model;

import java.awt.*;

public class Bird implements ObjGame{
    private final int xBird = 200;
    private int yBird;
    private int widthBird = 30;
    private int heightBird = 30;
    private float birdVelocity;

    public Bird(int y){
        this.yBird = y;
        birdVelocity = 0;
    }

    //kiểm tra có va chạm trả về true
    public boolean checkCollistion(Pipe pipe){
        Rectangle birdBound = this.getBound();
        Rectangle topPipeBound = pipe.getBoundTop();
        Rectangle underPipeBound = pipe.getBoundUnder();
        if(birdBound.intersects(topPipeBound) || birdBound.intersects(underPipeBound)){
            return true;
        }
        return false;
    }
    public boolean checkCollistion(Ground ground){
        Rectangle birdBound = this.getBound();
        Rectangle topGroundBound = ground.getBoundTop();
        Rectangle underGroundBound = ground.getBoundUnder();
        if(birdBound.intersects(topGroundBound) || birdBound.intersects(underGroundBound)){
            return true;
        }
        return false;
    }

    public void flap(){
        birdVelocity = -8;
    }

    public void update(){
        birdVelocity += 1;
        yBird += birdVelocity;
    }

    public int getXBird() {
        return xBird;
    }

    public int getYBird() {
        return yBird;
    }

    public int getWidthBird() {
        return widthBird;
    }

    public int getHeightBird() {
        return heightBird;
    }

    @Override
    public Rectangle getBound() {
        return new Rectangle(xBird, yBird, widthBird, heightBird);
    }
}

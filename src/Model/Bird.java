package Model;

import java.awt.*;

public class Bird implements ObjGame,GameDefaultSize{
    private final int xBird = 200;
    private int yBird;
    private int widthBird = GameDefaultSize.widthBird;
    private int heightBird = GameDefaultSize.heightBird;
    private float birdVelocity; // vận tốc
    private float maxFallSpeed = 10.0f;
    public Bird(int y){
        this.yBird = y;
        birdVelocity = 0;
    }

    //kiểm tra có va chạm trả về true
    public boolean checkCollision(Pipe pipe){
        Rectangle birdBound = this.getBound();
        Rectangle topPipeBound = pipe.getBoundTop();
        Rectangle underPipeBound = pipe.getBoundUnder();
        if(birdBound.intersects(topPipeBound) || birdBound.intersects(underPipeBound)){
            return true;
        }
        return false;
    }
    public boolean checkCollision(Ground ground){
        Rectangle birdBound = this.getBound();
        Rectangle topGroundBound = ground.getBoundTop();
        Rectangle underGroundBound = ground.getBoundUnder();
        if(birdBound.intersects(topGroundBound) || birdBound.intersects(underGroundBound)){
            return true;
        }
        return false;
    }

    public boolean isPassedPipe(Pipe pipe){
        return !pipe.getPassed() && (this.xBird > pipe.getxPipe()+pipe.getWidthPipe());
    }

    public void flap(){
        birdVelocity = -8;
    }

    public void update(){
        birdVelocity += 1;

        // Giới hạn tốc độ rơi tối đa
        if (birdVelocity > maxFallSpeed) {
            birdVelocity = maxFallSpeed;
        }
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

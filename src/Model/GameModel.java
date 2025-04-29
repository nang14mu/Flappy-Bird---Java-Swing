package Model;

import java.util.Iterator;
import java.util.LinkedList;

public class GameModel implements GameDefaultSize{
    private final int WIDTH = GameDefaultSize.WIDTH;
    private final int HEIGHT = GameDefaultSize.HEIGHT;
    private Bird bird;
    private LinkedList<Pipe> linkedListPipe;
    private Ground ground;
    private int score;
    private boolean overGame;

    public GameModel(){
        bird = new Bird(HEIGHT/2);
        ground = new Ground(0,0,WIDTH, HEIGHT/8);
        score = 0;
        overGame = false;

        linkedListPipe = new LinkedList<>();
        linkedListPipe.add(new Pipe(400));
        for(int i=1; i<=8; i++){
            linkedListPipe.add(new Pipe(linkedListPipe.getLast().getxPipe()));
        }
    }

    public void update(){
        if(!overGame){
            bird.update();
            Iterator<Pipe> iterator = linkedListPipe.iterator();
            while (iterator.hasNext()) {
                Pipe pipe = iterator.next();
                if(pipe.setOffScreen()){
                    pipe.move();
                }
                else {
                    iterator.remove(); // An toàn, không gây lỗi
                }
            }
            if(bird.checkCollistion(ground) ){
                overGame = true;
            }
            for(Pipe pipe : linkedListPipe){
                if(bird.checkCollistion(pipe)){
                    overGame = true;
                }
            }
        }
    }

    public void flap(){
        if(!overGame){
            bird.flap();
        }
    }

    public void increaseScore(){
        score++;
    }

    public int getScore() {
        return score;
    }

    public boolean isOverGame(){
        return overGame;
    }

    public Bird getBird(){
        return bird;
    }

    public Ground getGround() {
        return ground;
    }

    public LinkedList<Pipe> getLinkedListPipe() {
        return linkedListPipe;
    }
}

package Model;

import java.util.Iterator;
import java.util.LinkedList;

public class GameModel implements GameDefaultSize{
    private final int WIDTH = GameDefaultSize.WIDTH;
    private final int HEIGHT = GameDefaultSize.HEIGHT;
    private Bird bird;
    private LinkedList<Pipe> linkedListPipe;
    private Ground ground;
    private boolean overGame;
    private int score;
    private boolean gameStart;

    public GameModel(){
        bird = new Bird(HEIGHT/2);
        ground = new Ground(0,0,800, 50);
        overGame = false;
        score = 0;

        linkedListPipe = new LinkedList<>();
        Pipe p = new Pipe(400);
        linkedListPipe.add(p);
        for(int i=1; i<=8; i++){
            Pipe p1 = new Pipe(linkedListPipe.getLast().getxPipe());
            linkedListPipe.add(p1);
        }
        gameStart = false;
    }

    public void update(){
        if(!gameStart){
            return;
        }
        if(!overGame){
            bird.update();
            Iterator<Pipe> iterator = linkedListPipe.iterator();
            while (iterator.hasNext()) {
                Pipe pipe = iterator.next();
                if(pipe.isOnScreen()){
                    pipe.update();
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
                if (bird.isPassedPipe(pipe)) {
                    score++;
                    pipe.setIsPassed(true);
                }
            }
            if (linkedListPipe.size() < 9) {
                Pipe lastPipe = linkedListPipe.getLast();
                Pipe newPipe = new Pipe(lastPipe.getxPipe());
                linkedListPipe.add(newPipe);
            }
        }
    }

    public void flap(){
        if(!gameStart){
            gameStart = true;
        }
        if(!overGame){
            bird.flap();
        }
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

    public int getScore(){
        return score;
    }

    public boolean isGameStart() {
        return gameStart;
    }
}

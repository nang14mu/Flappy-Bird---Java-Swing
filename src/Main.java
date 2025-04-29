import Cotroller.*;
import Model.*;
import View.*;
public class Main {
    public static void main(String[] args) {
        GameModel m = new GameModel();
        PlappyBirdView v = new PlappyBirdView(m);
        cotrollerGame c= new cotrollerGame(m,v);
    }
}
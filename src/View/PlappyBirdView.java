package View;

import Model.GameDefaultSize;
import Model.GameModel;

import javax.swing.*;
import java.awt.*;

public class PlappyBirdView extends JFrame implements GameDefaultSize {
    private GameView gameView;
    private MenuView menuView;
    private GameModel gameModel;

    public PlappyBirdView(GameModel gameModel){
        this.setTitle("FLAPPY BIRD");
        this.setSize(800,630);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.gameModel = gameModel;
        gameView = new GameView(this.gameModel);

        this.add(gameView,BorderLayout.CENTER);

        this.setVisible(true);
    }
}

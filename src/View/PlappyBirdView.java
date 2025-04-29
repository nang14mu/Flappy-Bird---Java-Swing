package View;

import Model.GameDefaultSize;
import Model.GameModel;

import javax.swing.*;

public class PlappyBirdView extends JFrame implements GameDefaultSize {
    private GameView gameView;
    private MenuView menuView;
    private GameModel gameModel;

    public PlappyBirdView(GameModel gameModel){
        this.setTitle("FLAPPY BIRD");
        this.setSize(800,620);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.gameModel = gameModel;
        gameView = new GameView(this.gameModel);
        gameView.setBounds(0,20,800,600);
        this.add(gameView);
    }
}

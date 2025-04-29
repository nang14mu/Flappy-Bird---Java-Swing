package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuView extends JPanel{
    private JButton play;
    private JButton newGame;

    public MenuView(){
        setBackground(Color.BLACK);

        play = new JButton("PLAY");
        play.setBackground(Color.WHITE);
        play.setPreferredSize(new Dimension(50,20));
        add(play);

        newGame = new JButton("New Game");
        newGame.setBackground(Color.WHITE);
        newGame.setPreferredSize(new Dimension(50,20));
        add(newGame);
    }

    public void addPlayButtonListenner(ActionListener playAction){
        play.addActionListener(playAction);
    }

    public void addNewGameButtonListenner(ActionListener newGameAction){
        newGame.addActionListener(newGameAction);
    }

    public void updatePanel(boolean isPlaying){
        if(isPlaying){
            newGame.setEnabled(false);
            play.setText("Pause");
        }
        else{
            newGame.setEnabled(true);
            play.setText("Play");
        }
    }

    public void updatePanelGameOver(){
        newGame.setEnabled(true);
        play.setEnabled(false);
    }

    public void updatePanelGameStart(){
        newGame.setEnabled(true);
        play.setEnabled(true);
    }
}

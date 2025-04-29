package Cotroller;

import Model.GameModel;
import View.MenuView;
import View.PlappyBirdView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class cotrollerGame {
    private GameModel model;
    private PlappyBirdView view;
    private Timer gameLoop;

    public cotrollerGame(GameModel model, PlappyBirdView view){
        this.model = model;
        this.view = view;

        view.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    model.flap();
                }
            }
        });

        gameLoop = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.update();
                view.repaint();
            }
        });
        gameLoop.start();
    }

}

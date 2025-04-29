package View;

import Model.GameModel;
import Model.Pipe;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    GameModel model;
    private Image imageBird;

    public GameView(GameModel model){
        this.model = model;
        this.setSize(800,600);
        imageBird = new ImageIcon("Bird.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBird,model.getBird().getXBird(),model.getBird().getYBird(),model.getBird().getWidthBird(),model.getBird().getHeightBird(),this);

        g.setColor(Color.cyan);
        for(Pipe pipe: model.getLinkedListPipe()){
            g.fillRect(pipe.getxPipe(),pipe.getyTopPipe(),pipe.getWidthPipe(),pipe.getTopHeight());
            g.fillRect(pipe.getxPipe(),pipe.getyUnderPipe(),pipe.getWidthPipe(),pipe.getUnderHeight());
        }

        g.fillRect(model.getGround().getX(),model.getGround().getYtop(),model.getGround().getWidth(),model.getGround().getHeight());
        g.fillRect(model.getGround().getX(),model.getGround().getYunder(),model.getGround().getWidth(),model.getGround().getHeight());
    }


}

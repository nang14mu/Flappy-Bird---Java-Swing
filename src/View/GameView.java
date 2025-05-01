package View;

import Model.GameModel;
import Model.Pipe;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    GameModel model;
    private Image imageBackGround;
    private Image imageBird;
    private Image imageColumnTop;
    private Image imageColumnUnder;
    private Image imageGroundTop;
    private Image imageGroundUnder;

    public GameView(GameModel model){
        this.model = model;
        this.setSize(800,600);
        imageBird = new ImageIcon("D:\\java\\baiTapLonJava\\pic\\Bird1.png").getImage();
        imageColumnTop = new  ImageIcon("D:\\java\\baiTapLonJava\\pic\\columnTop.png").getImage();
        imageColumnUnder = new ImageIcon("D:\\java\\baiTapLonJava\\pic\\columnUnder.png").getImage();
        imageBackGround = new ImageIcon("D:\\java\\baiTapLonJava\\pic\\background.png").getImage();
        imageGroundTop = new ImageIcon("D:\\java\\baiTapLonJava\\pic\\GroundTop.png").getImage();
        imageGroundUnder = new ImageIcon("D:\\java\\baiTapLonJava\\pic\\GroundUnder.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBackGround,0,0,getWidth(),getHeight(),this);

        g.drawImage(imageBird,model.getBird().getXBird(),model.getBird().getYBird(),model.getBird().getWidthBird(),model.getBird().getHeightBird(),this);

        for(Pipe pipe: model.getLinkedListPipe()){
            g.drawImage(imageColumnTop,pipe.getxPipe(),pipe.getyTopPipe(),pipe.getWidthPipe(),pipe.getTopHeight(),this);
            g.drawImage(imageColumnUnder,pipe.getxPipe(),pipe.getyUnderPipe(),pipe.getWidthPipe(),pipe.getUnderHeight(),this);
        }

        g.drawImage(imageGroundTop,model.getGround().getX(),model.getGround().getYtop(),model.getGround().getWidth(),model.getGround().getHeight(),this);
        g.drawImage(imageGroundUnder,model.getGround().getX(),model.getGround().getYunder(),model.getGround().getWidth(),model.getGround().getHeight(),this);
    }


}

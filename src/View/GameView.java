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
    private Image imageGround;


    public GameView(GameModel model){
        this.model = model;
        this.setSize(800,600);
        imageBird = new ImageIcon("D:\\java\\baiTapLonJava\\pic\\Bird.png").getImage();
        imageColumnTop = new  ImageIcon("D:\\java\\baiTapLonJava\\pic\\columnTop.png").getImage();
        imageColumnUnder = new ImageIcon("D:\\java\\baiTapLonJava\\pic\\columnUnder.png").getImage();
        imageBackGround = new ImageIcon("D:\\java\\baiTapLonJava\\pic\\background.png").getImage();
        imageGround = new ImageIcon("D:\\java\\baiTapLonJava\\pic\\Ground.png").getImage();
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

        g.drawImage(imageGround,model.getGround().getX(),model.getGround().getYtop(),model.getGround().getWidth(),model.getGround().getHeight(),this);
        g.drawImage(imageGround,model.getGround().getX(),model.getGround().getYunder(),model.getGround().getWidth(),model.getGround().getHeight(),this);

        // Vẽ điểm số đơn giản nhưng rõ ràng
        if (model.isGameStart()) {
            // Đổ bóng cho chữ (làm cho chữ dễ đọc trên mọi nền)
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.setColor(Color.BLACK);
            g.drawString("Score: " + model.getScore(), 22, 42);

            // Vẽ chữ điểm số với màu trắng
            g.setColor(Color.WHITE);
            g.drawString("Score: " + model.getScore(), 20, 40);
        }

        if (!model.isGameStart()) {
            g.setColor(new Color(0, 0, 0, 180)); // Màu đen mờ
            g.fillRect(200, 200, 400, 150);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("FLAPPY BIRD", 290, 250);

            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("Nhấn SPACE để bắt đầu", 270, 300);
        }

        if (model.isOverGame()) {
            g.setColor(new Color(0, 0, 0, 150)); // Màu đen mờ
            g.fillRect(300, 200, 200, 100);

            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER", 320, 250);
            g.drawString("Score: " + model.getScore(), 320, 280);
        }
    }


}

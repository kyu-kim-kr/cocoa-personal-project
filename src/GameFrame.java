import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GameFrame extends JFrame implements KeyListener {

    private boolean isKeyUp, isKeyDown, isKeyLeft, isKeyRight = false;
    private boolean playerMove = false;

    private final int FRAME_WIDTH = 600;
    private final int FRAME_HEIGHT = 600;

    private int xPlayer, yPlayer;

    Toolkit tk = Toolkit.getDefaultToolkit();
    Image imagePlayer = tk.getImage("0.png");

    Image bufferImage;
    Graphics gp;

    GameFrame() {
        init();

        addKeyListener(this);

        setVisible(true);

    }

    private void init() {
        setTitle("Eat Coin");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        //xPlayer, yPlayer를 프레임의 가운데에 배치하는 값을 저장한다.
        xPlayer = (FRAME_WIDTH - imagePlayer.getWidth(this)) / 2;
        yPlayer = (FRAME_HEIGHT - imagePlayer.getHeight(this)) / 2;
    }

    public void paint(Graphics g) {
        //가상에 그려준다
        bufferImage = createImage(FRAME_WIDTH, FRAME_HEIGHT);
        gp = bufferImage.getGraphics();
        gp.drawImage(imagePlayer, xPlayer, yPlayer, this);


        //가상에 그린 것을 딱! 한번에!
        g.drawImage(bufferImage, 0, 0, this);
    }

    private void move() {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) { //입럭된 키보드 값을 가져온다
            case KeyEvent.VK_UP:
                isKeyUp = true;
                break;

            case KeyEvent.VK_DOWN:
                isKeyDown = true;
                break;

            case KeyEvent.VK_LEFT:
                isKeyLeft = true;
                break;

            case KeyEvent.VK_RIGHT:
                isKeyRight = true;
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) { //입럭된 키보드 값을 가져온다
            case KeyEvent.VK_UP:
                isKeyUp = false;
                break;

            case KeyEvent.VK_DOWN:
                isKeyDown = false;
                break;

            case KeyEvent.VK_LEFT:
                isKeyLeft = false;
                break;

            case KeyEvent.VK_RIGHT:
                isKeyRight = false;
                break;
        }
    }
    @Override
    public void keyTyped (KeyEvent e){
    }
}


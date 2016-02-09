package ru.engine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Crow on 27.01.2016.
 */
public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;

    private boolean running;

    private boolean upPressed = false;
    private boolean downPressed = false;

    private static int x = 0;
    private static int y = 0;

    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    public static String NAME = "TUTORIAL 1";
    public static final int MOVE_SPEED_IN_MILLIS = 2;


    public static Sprite hero;

    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void run() {
        long lastTime = System.currentTimeMillis();
        long delta;

        init();

        while(running) {
            delta = System.currentTimeMillis() - lastTime;
            lastTime = System.currentTimeMillis();
            render();
            update(delta);
        }
    }

    public void init() {
        hero = getSprite("/resources/bar.png");
        addKeyListener(new KeyInputHandler());
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            requestFocus();
            return;
        }

        Graphics g = bs.getDrawGraphics(); //получаем Graphics из созданной нами BufferStrategy
        g.setColor(Color.black); //выбрать цвет
        g.fillRect(0, 0, getWidth(), getHeight()); //заполнить прямоугольник
        hero.draw(g, x, y);
        g.dispose();
        bs.show(); //показать
    }

    public void update(long delta) {
        if (upPressed == true && y > 0 && canMove()) {
            y--;
        }
        if (downPressed == true && y < HEIGHT - 40 && canMove()) {
            y++;
        }
    }

    private long lastKeyPressTimeMillis = 0;
    private boolean canMove() {
        boolean canMove = false;
        if(System.currentTimeMillis() - lastKeyPressTimeMillis > MOVE_SPEED_IN_MILLIS) {
            lastKeyPressTimeMillis = System.currentTimeMillis();
            canMove = true;
        }

        return canMove;
    }

    private class KeyInputHandler extends KeyAdapter {
        public void keyPressed(KeyEvent e) { //клавиша нажата
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = true;
            }
        }

        public void keyReleased(KeyEvent e) { //клавиша отпущена
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = false;
            }
        }
    }


    public Sprite getSprite(String path) {
        BufferedImage sourceImage = null;

        try {
            sourceImage = ImageIO.read(this.getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sprite sprite = new Sprite(Toolkit.getDefaultToolkit().createImage(sourceImage.getSource()));

        return sprite;
    }

    public static void main(String[] args) {
        ru.engine.Game game = new ru.engine.Game();
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        JFrame frame = new JFrame(ru.engine.Game.NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        game.start();
    }
}

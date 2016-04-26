package ru.games.engine.object;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Crow on 09.02.2016.
 */
public class Board extends Canvas {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String TITLE = "Tenis. Bar fight!";


    public Board() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // инициализируется техническая хрень
        initJFame(TITLE);
    }

    public void init() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(2);
            requestFocus();
        }
    }

    public void clean(Graphics g) {
        // выбрать цвет
        g.setColor(Color.black);
        // заполнить прямоугольник
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public void showObjs() {
        getGraphics().dispose();
        // показать
        getBufferStrategy().show();
    }

    public Graphics getGraphics() {
        Graphics graphics = null;
        if(getBufferStrategy() != null) {
            // получаем Graphics из созданной нами BufferStrategy
            graphics = getBufferStrategy().getDrawGraphics();
        }

        return graphics;
    }

    private void initJFame(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

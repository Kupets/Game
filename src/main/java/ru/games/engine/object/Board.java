package ru.games.engine.object;

import java.awt.*;

/**
 * Created by Crow on 09.02.2016.
 */
public class Board implements GameObject {
    private static final long serialVersionUID = 1L;

    private int width;
    private int height;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void init(Component component) {
        width = component.getWidth();
        height = component.getHeight();
    }

    public void draw(Graphics g) {
        // выбрать цвет
        g.setColor(Color.black);
        // заполнить прямоугольник
        g.fillRect(0, 0, width, height);
    }

    public void update() {
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}

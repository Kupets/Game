package ru.engine.object;

import ru.engine.GameListener;

import java.awt.*;

/**
 * Created by Crow on 09.02.2016.
 */
public class Board implements GameListener {
    private static final long serialVersionUID = 1L;

    private int width;
    private int height;
    private final String TITLE = "Bar fight";

    public void init(Component component) {
        width = component.getWidth();
        height = component.getHeight();
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);         //выбрать цвет
        g.fillRect(0, 0, width, height); //заполнить прямоугольник
    }

    public void update() {
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getTitle() {
        return TITLE;
    }
}

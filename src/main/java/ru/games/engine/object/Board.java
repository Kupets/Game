package ru.games.engine.object;

import java.awt.*;

/**
 * Created by Crow on 09.02.2016.
 */
public class Board implements GameObject {
    private static final long serialVersionUID = 1L;

    private int width;
    private int height;
    private final String TITLE = "Tenis. Bar fight!";

    // тест коментов
    public void init(Component component) {
        width = component.getWidth();
        height = component.getHeight();
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);         //������� ����
        g.fillRect(0, 0, width, height); //��������� �������������
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

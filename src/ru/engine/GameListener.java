package ru.engine;

import java.awt.*;

/**
 * Created by Crow on 03.02.2016.
 */
public interface GameListener {
    void init(Component component); // ����������, ����� ���� ��������
    void update();                  // ���������� ������ �����
    void draw(Graphics g);          // ���������� update()
}

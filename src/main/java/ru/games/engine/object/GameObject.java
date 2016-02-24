package ru.games.engine.object;

import java.awt.*;

/**
 * Created by Crow on 03.02.2016.
 */
public interface GameObject {
    void init(Component component); // ����������, ����� ���� ��������
    void update();                  // ���������� ������ �����
    void draw(Graphics g);          // ���������� update()
}

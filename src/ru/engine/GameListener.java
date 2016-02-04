package ru.engine;

/**
 * Created by Crow on 03.02.2016.
 */
public interface GameListener {
    void start();   // ����������, ����� ���� ��������
    void update();  // ���������� ������ �����
    void draw();    // ���������� update()
    void destroy(); // ����������, ����� ������ "�����������"
}

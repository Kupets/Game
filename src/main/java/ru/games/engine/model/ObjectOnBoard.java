package ru.games.engine.model;

import ru.games.engine.object.Board;

import java.awt.*;
import java.util.Date;

/**
 * Created by Crow on 03.02.2016.
 */
public interface ObjectOnBoard {
    // вызывается, когда игра началась и при рестарте
    void init();
    // вызывается каждый фрейм для обновления игрового состояния
    void update(Date currentTime);
    // рисуем обьекты каждый фрейм
    void draw(Graphics g);
    // подчеркиваем, что обьект должен находиться на доске
    Board getBoard();
}

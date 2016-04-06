package ru.games.engine.model;

import ru.games.engine.object.Board;
import ru.games.engine.object.Sprite;

import java.util.Date;

/**
 * Created by Crow on 03.02.2016.
 */
public interface ObjectOnBoard {
    // вызывается, когда игра началась и при рестарте
    void init();
    // вызывается каждый фрейм
    void update(Date currentTime);
    // картинка, используется вместо рисования обьекта
    Sprite getSprite();
    // подчеркиваем, что обьект должен находиться на доске
    Board getBoard();
}

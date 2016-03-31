package ru.games.engine.object;

import java.awt.Graphics;

/**
 * Created by Crow on 03.02.2016.
 */
public interface GameObject {
    // вызывается, когда игра началась и при рестарте
    void init();
    // вызывается каждый фрейм
    void update();
    // аналогично update()
    void draw(Graphics g);
}

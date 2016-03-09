package ru.games.engine.object;

import java.awt.*;

/**
 * Created by Crow on 03.02.2016.
 */
public interface GameObject {
    // вызывается, когда игра началась
    void init(Component component);
    // вызывается каждый фрейм
    void update();
    // аналогично update()
    void draw(Graphics g);
}

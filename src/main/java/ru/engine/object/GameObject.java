package ru.engine.object;

import java.awt.*;

/**
 * Created by Crow on 03.02.2016.
 */
public interface GameObject {
    void init(Component component); // вызывается, когда игра началась
    void update();                  // вызывается каждый фрейм
    void draw(Graphics g);          // аналогично update()
}

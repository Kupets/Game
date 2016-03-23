package ru.games.engine.object;

import ru.games.engine.Sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Crow on 24.03.2016.
 */
public abstract class SpriteGameObject implements GameObject {
    private String spritePath;
    private Sprite sprite;
    protected int x = 0;
    protected int y = 0;

    public SpriteGameObject(int x, int y, String spritePath) {
        this.spritePath = spritePath;
        this.x = x;
        this.y = y;
    }

    public void init(Component component) {
        sprite = getSprite(spritePath);
    }

    private Sprite getSprite(String path) {
        BufferedImage sourceImage = null;

        try {
            sourceImage = ImageIO.read(this.getClass().getResourceAsStream(path));
        } catch(IOException e) {
            e.printStackTrace();
        }

        Sprite sprite = new Sprite(Toolkit.getDefaultToolkit().createImage(sourceImage.getSource()));

        return sprite;
    }


    public void draw(Graphics g) {
        sprite.draw(g, x, y);
    }
}

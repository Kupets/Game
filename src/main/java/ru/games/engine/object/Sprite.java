package ru.games.engine.object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Crow on 24.03.2016.
 */
public class Sprite {
    private Image image;
    protected int x = 0;
    protected int y = 0;


    public Sprite(String spritePath) {
        initSprite(spritePath);
    }

    private void initSprite(String path) {
        BufferedImage sourceImage = null;

        try {
            sourceImage = ImageIO.read(this.getClass().getResourceAsStream(path));
        } catch(IOException e) {
            e.printStackTrace();
        }

        image = Toolkit.getDefaultToolkit().createImage(sourceImage.getSource());
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    public int getWidth() {
        return image.getWidth(null);
    }

    public int getHeight() {
        return image.getHeight(null);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

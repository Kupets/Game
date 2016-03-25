package ru.games.engine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Crow on 24.03.2016.
 */
public class Sprite {
    private Image image;


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

    public void draw(Graphics g, int x, int y) {
        g.drawImage(image, x, y, null);
    }
}

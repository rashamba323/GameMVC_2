package view;

import model.Sprite;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Render extends Canvas {

    Sprite sprite = new Sprite();

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            requestFocus();
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, sprite.getWidth(), sprite.getHeight());
        paintRect(g);
        bg.draw(g,0,0);
        hero.draw(g, x, y);
        hero2.draw(g, x2, y2);
        bird.draw(g,xG, yG);
        g.dispose();
        bs.show();
    }

}

package game;

import javax.swing.*;

import controller.KeyInputHandler;
import model.Sprite;
import model.SpriteList;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas  implements Runnable {

    private KeyInputHandler keyInputHandler = new KeyInputHandler();

    private SpriteList spriteList = new SpriteList();

    private boolean running;

    public static int WIDTH = 990;
    public static int HEIGHT = 690;

    public static String NAME = "OguretsGame";


    public static Sprite hero;
    public static Sprite hero2;
    public static Sprite bg;
    private static Sprite bird;

    private static int x = 0;
    private static int y = 300;
    private static int x2 = 500;
    private static int y2 = 500;

    private static int xG = 10;
    private static int yG = 10;

    Rectangle2D rectangle;
    Rectangle2D rectangle2;

    Sprite sprite = new Sprite();

    public void paintRect(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        rectangle = new Rectangle2D.Double(x,y,hero.getWidth(),hero.getHeight());
        rectangle2 = new Rectangle2D.Double(x2,y2,hero2.getWidth(),hero2.getHeight());
        g2.setColor(Color.white);
        g2.draw(rectangle);
        g2.draw(rectangle2);
        if (rectangle2.intersects(rectangle)){
            for (int i = 0;i<100;i++ )
                System.out.println("Connect");
            //System.exit(0);
        }
    }


    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void run() {
        long lastTime = System.currentTimeMillis();
        long delta;

        init();

        while(running) {
            delta = System.currentTimeMillis() - lastTime;
            lastTime = System.currentTimeMillis();
            render();
            ColiziaBorder();
            update(delta);
        }
    }



    public void init() {
        addKeyListener(keyInputHandler);
        spriteList.setLits();

        hero = sprite.getSprite("Kaktus.png");
        hero2 = sprite.getSprite("KaktusBanditLeft.png");
        bg = sprite.getSprite("Background.png");
        bird = sprite.getSprite("GolubRight.png");
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            requestFocus();
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        paintRect(g);
        bg.draw(g,0,0);
        hero.draw(g, x, y);
        hero2.draw(g, x2, y2);
        bird.draw(g,xG, yG);
        g.dispose();
        bs.show();
    }

    public void update(long delta) {

        if (keyInputHandler.isLeftPressed() == true) {
            x-=3;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    hero = spriteList.animateLeft(hero);
                }
            }).start();

        }
        if (keyInputHandler.isRightPressed() == true) {
            x+=3;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    hero = spriteList.animateRight(hero);
                }
            }).start();

        }
        if (keyInputHandler.isUpPressed() == true) {
            y-=3;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    hero = spriteList.animateLeft(hero);
                }
            }).start();
        }
        if (keyInputHandler.isDownPressed() == true) {
            y+=3;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    hero = spriteList.animateRight(hero);
                }
            }).start();
        }
        if (keyInputHandler.isLeftPressed2() == true) {
            x2-=1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    hero2 = spriteList.animateLeft2(hero2);
                }
            }).start();
        }
        if (keyInputHandler.isRightPressed2() == true) {
            x2+=1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    hero2 = spriteList.animateRight2(hero2);
                }
            }).start();

        }
        if (keyInputHandler.isUpPressed2() == true) {
            y2-=1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    hero2 = spriteList.animateLeft2(hero2);
                }
            }).start();
        }
        if (keyInputHandler.isDownPressed2() == true) {
            y2+=1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    hero2 = spriteList.animateRight2(hero2);
                }
            }).start();
        }

        Random random = new Random( 1);

        new Thread(new Runnable() {
            @Override
            public void run() {

                int check = random.nextInt();
                if(check == 1){
                    xG+=2;
                    bird = spriteList.animateRightGolub(bird);

                } else {
                    xG-=2;
                    bird = spriteList.animateLeftGolub(bird);

                }
            }
        }).start();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        JFrame frame = new JFrame(Game.NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        game.start();
    }

    public void ColiziaBorder(){
        if (x >= WIDTH-60){
            keyInputHandler.setRightPressed(false);
        }
       if (x <= -1){
           keyInputHandler.setLeftPressed(false);
        }
        if (y >= HEIGHT-85){
            keyInputHandler.setDownPressed(false);
        }
        if (y <= 230){
            keyInputHandler.setUpPressed(false);
        }
        if (x2 >= WIDTH-60){
            keyInputHandler.setRightPressed2(false);
        }
        if (x2 == -1){
            keyInputHandler.setLeftPressed2(false);
        }
        if (y2 >= HEIGHT-85){
            keyInputHandler.setDownPressed2(false);
        }
        if (y2 <= 230){
            keyInputHandler.setUpPressed2(false);
        }
    }
}
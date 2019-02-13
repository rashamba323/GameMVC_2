package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputHandler extends KeyAdapter {

    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed2 = false;
    private boolean rightPressed2 = false;
    private boolean upPressed2 = false;
    private boolean downPressed2 = false;

    public boolean isLeftPressed() {
        return leftPressed;
    }
    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }
    public boolean isRightPressed() {
        return rightPressed;
    }
    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }
    public boolean isUpPressed() {
        return upPressed;
    }
    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }
    public boolean isDownPressed() {
        return downPressed;
    }
    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }
    public boolean isLeftPressed2() {
        return leftPressed2;
    }
    public void setLeftPressed2(boolean leftPressed2) {
        this.leftPressed2 = leftPressed2;
    }
    public boolean isRightPressed2() {
        return rightPressed2;
    }
    public void setRightPressed2(boolean rightPressed2) {
        this.rightPressed2 = rightPressed2;
    }
    public boolean isUpPressed2() {
        return upPressed2;
    }
    public void setUpPressed2(boolean upPressed2) {
        this.upPressed2 = upPressed2;
    }
    public boolean isDownPressed2() {
        return downPressed2;
    }
    public void setDownPressed2(boolean downPressed2) {
        this.downPressed2 = downPressed2;
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            setLeftPressed(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            setRightPressed(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            setUpPressed(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            setDownPressed(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            setLeftPressed2(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            setRightPressed2(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            setUpPressed2(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            setDownPressed2(true);
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            setLeftPressed(false);

        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            setRightPressed(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            setUpPressed(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            setDownPressed(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            setLeftPressed2(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            setRightPressed2(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            setUpPressed2(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            setDownPressed2(false);
        }
    }
}
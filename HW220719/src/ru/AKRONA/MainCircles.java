package ru.AKRONA;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainCircles extends JFrame {

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private Sprite[] sprites = new Sprite[1000000];
    private int spritesCount = 5;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        GameCanvas gameCanvas = new GameCanvas(this);
        addMouseListener(new CirclesClickListener());
        initApplication();
        add(gameCanvas, BorderLayout.CENTER);
        setVisible(true);
    }

    void initApplication() {
        for (int i = 0; i < spritesCount; i++) {
            sprites[i] = null;
        }
        for (int i = 0; i < spritesCount; i++) {
            sprites[i] = new Ball();
        }
    }

    void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime){
        for (int i = 0; i < sprites.length; i++) {
            if (sprites[i] != null)
                sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            if (sprites[i] != null)
                sprites[i].render(canvas, g);
        }
    }
    private class CirclesClickListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getButton()==MouseEvent.BUTTON1){
                addSprites();
            }else if(e.getButton()==MouseEvent.BUTTON3){
                deleteSprites();
            }
        }
    }

    private void addSprites(){
        int i = 0;
        while (sprites[i] != null) i++;
        sprites[i] = new Ball();
    }
    void deleteSprites(){
        int i = 0;
        while (sprites[i] != null)i++;
        if(i>0) sprites[i-1] = null;
    }
}
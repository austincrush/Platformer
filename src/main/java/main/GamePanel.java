package main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100;
    private float yDelta = 100;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick;
    private int aniIndex;
    private int aniSpeed = 15;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        importImage();
        loadAnimations();
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        animations = new BufferedImage[6][6];

        for (int i = 0; i < animations.length; i++) {
            for (int j = 0; j < animations[i].length; j++) {
                animations[i][j] = img.getSubimage(j * 48, i * 48, 48, 48);
            }
        }


    }

    public void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
    }

    public void importImage() {
        InputStream is = getClass().getResourceAsStream("/Adventure_Character_Simple.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeXDelta(int val) {
        this.xDelta += val;
    }

    public void changeYDelta(int val) {
        this.yDelta += val;
    }

    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    private void updateAnimationTick() {

        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= 6) {
                aniIndex = 0;
            }
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateAnimationTick();

        g.drawImage(animations[5][aniIndex], (int) xDelta, (int) yDelta, 80, 80, null);
    }
}

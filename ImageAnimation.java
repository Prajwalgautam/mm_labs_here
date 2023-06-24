import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageAnimation extends JFrame {
    private AnimationPanel animationPanel;

    public ImageAnimation() {
        setTitle("Image Animation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        animationPanel = new AnimationPanel();
        add(animationPanel);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageAnimation::new);
    }
}

class AnimationPanel extends JPanel {
    private ImageIcon[] frames;
    private int currentFrameIndex;
    private Timer animationTimer;

    public AnimationPanel() {
        setPreferredSize(new Dimension(1000, 600));

        frames = new ImageIcon[4];
        frames[0] = new ImageIcon("frame1.png");
        frames[1] = new ImageIcon("frame2.png");
        frames[2] = new ImageIcon("frame3.png");
        frames[3] = new ImageIcon("frame4.png");

        currentFrameIndex = 0;

        animationTimer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateFrame();
                repaint();
            }
        });
        animationTimer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = frames[currentFrameIndex].getImage();
        g.drawImage(image, 0, 0, this);
    }

    private void updateFrame() {
        currentFrameIndex = (currentFrameIndex + 1) % frames.length;
    }
}
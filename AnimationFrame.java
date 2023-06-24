import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimationFrame extends JFrame {
    private AnimationPanel animationPanel;

    public AnimationFrame() {
        setTitle("Animation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        animationPanel = new AnimationPanel();
        add(animationPanel);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AnimationFrame::new);
    }
}

class AnimationPanel extends JPanel {
    private int x;
    private int y;

    public AnimationPanel() {
        setPreferredSize(new Dimension(500, 500));

        x = 0;
        y = 0;

        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatePosition();
                repaint();
            }
        });
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50);
    }

    private void updatePosition() {
        x += 1;
        y += 1;

        if (x > getWidth()) {
            x = 0;
        }
        if (y > getHeight()) {
            y = 0;
        }
    }
}
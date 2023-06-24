import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MidpointCircleFrame extends JFrame {
    private int centerX, centerY, radius;

    public MidpointCircleFrame() {
        setTitle("Midpoint Circle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        // Set the center point and radius of the circle
        centerX = 250;
        centerY = 250;
        radius = 200;

        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        drawCircleMidpoint(g, centerX, centerY, radius);
    }

    public void drawCircleMidpoint(Graphics g, int centerX, int centerY, int radius) {
        int x = 0;
        int y = radius;
        int p = 1 - radius;

        plotCirclePoints(g, centerX, centerY, x, y);

        while (x < y) {
            x++;
            if (p < 0) {
                p += 2 * x + 1;
            } else {
                y--;
                p += 2 * (x - y) + 1;
            }
            plotCirclePoints(g, centerX, centerY, x, y);
        }
    }

    public void plotCirclePoints(Graphics g, int centerX, int centerY, int x, int y) {
        g.drawOval(centerX + x, centerY + y, 1, 1);
        g.drawOval(centerX + x, centerY - y, 1, 1);
        g.drawOval(centerX - x, centerY + y, 1, 1);
        g.drawOval(centerX - x, centerY - y, 1, 1);
        g.drawOval(centerX + y, centerY + x, 1, 1);
        g.drawOval(centerX + y, centerY - x, 1, 1);
        g.drawOval(centerX - y, centerY + x, 1, 1);
        g.drawOval(centerX - y, centerY - x, 1, 1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MidpointCircleFrame::new);
    }
}
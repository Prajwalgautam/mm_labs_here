import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BresenhamLineFrame extends JFrame {
    private int x1, y1, x2, y2;

    public BresenhamLineFrame() {
        setTitle("Bresenham Line");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        // Set the starting and ending points of the line
        x1 = 50;
        y1 = 50;
        x2 = 400;
        y2 = 400;

        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        drawLineBresenham(g, x1, y1, x2, y2);
    }

    public void drawLineBresenham(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        int err = dx - dy;

        while (true) {
            g.drawLine(x1, y1, x1, y1);

            if (x1 == x2 && y1 == y2)
                break;

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BresenhamLineFrame::new);
    }
}
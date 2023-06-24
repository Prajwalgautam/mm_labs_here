import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageBackgroundChanger extends JFrame {
    private BufferedImage image;
    private JPanel imagePanel;
    private JButton redButton;
    private JButton greenButton;
    private JButton blueButton;

    public ImageBackgroundChanger() {
        setTitle("Image Background Changer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Load the image
        try {
            image = ImageIO.read(new File("animes.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create the image panel to display the image
        imagePanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
        add(imagePanel, BorderLayout.CENTER);

        // Create the buttons for changing the background color
        redButton = new JButton("Red");
        greenButton = new JButton("Green");
        blueButton = new JButton("Blue");

        redButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor(Color.RED);
            }
        });

        greenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor(Color.GREEN);
            }
        });

        blueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor(Color.BLUE);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(redButton);
        buttonPanel.add(greenButton);
        buttonPanel.add(blueButton);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    private void changeBackgroundColor(Color color) {
        Graphics2D g2d = image.createGraphics();
        g2d.setBackground(color);
        g2d.clearRect(0, 0, image.getWidth(), image.getHeight());
        g2d.drawImage(image, 0, 0, null);
        imagePanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageBackgroundChanger::new);
    }
}
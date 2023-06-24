import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AudioPlayerFrame extends JFrame implements ActionListener {
    private JButton playButton;
    private Clip clip;

    public AudioPlayerFrame() {
        setTitle("Audio Player");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        playButton = new JButton("Play");
        playButton.addActionListener(this);
        add(playButton);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AudioPlayerFrame::new);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            playAudio("lol.wav");
        }
    }

    public void playAudio(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

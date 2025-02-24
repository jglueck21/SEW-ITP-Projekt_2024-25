package Hangman;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawHangmanView extends JPanel{
    private Hangmanmodel model;
    private int mistakes;

    public void setMistakes(int mistakes) {
        this.mistakes = mistakes;
    }

    public DrawHangmanView(Hangmanmodel model) {
        this.model = model;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        model.drawHangman(g, mistakes);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hangman Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        DrawHangmanView panel = new DrawHangmanView(new Hangmanmodel("arsch"));
        frame.add(panel);
        panel.setMistakes(Integer.parseInt(JOptionPane.showInputDialog("Anzahl der Fehler eingeben (0-11):")));
        
        frame.setVisible(true);
    }
}

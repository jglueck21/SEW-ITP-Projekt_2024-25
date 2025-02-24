package Hangman;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawHangmanView extends JPanel{
    private Hangmanmodel model;
    private int mistakes;

    public void setMistakes(int mistakes) {
        this.mistakes = mistakes;
    }

    public DrawHangmanView(int mistakes) {
        this.mistakes = mistakes;
        this.setPreferredSize(new Dimension(200, 200));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawHangman(g, mistakes);
    }

    public void drawHangman(Graphics g, int mistakes) {
        if (mistakes >= 1) g.drawArc(50, 250, 400, 100, 0, 180); // Halbkreis
        if (mistakes >= 2) g.drawLine(175, 250, 275, 250); // Boden
        if (mistakes >= 3) g.drawLine(225, 50, 225, 250); // Pfosten
        if (mistakes >= 4) g.drawLine(225, 50, 325, 50); // Querbalken
        if (mistakes >= 5) g.drawLine(325, 50, 325, 80); // Seil
        if (mistakes >= 6) g.drawOval(305, 80, 40, 40); // Kopf
        if (mistakes >= 7) g.drawLine(325, 120, 325, 180); // Körper
        if (mistakes >= 8) g.drawLine(325, 140, 295, 120); // Linker Arm
        if (mistakes >= 9) g.drawLine(325, 140, 355, 120); // Rechter Arm
        if (mistakes >= 10) g.drawLine(325, 180, 295, 220); // Linkes Bein
        if (mistakes >= 11) g.drawLine(325, 180, 355, 220); // Rechtes Bein
    }

    public Hangmanmodel getModel() {
        return this.model;
    }

    public void setModel(Hangmanmodel model) {
        this.model = model;
    }

    public int getMistakes() {
        return this.mistakes;
    }


}

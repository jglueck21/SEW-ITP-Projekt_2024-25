package Hangman;
import javax.swing.*;
import java.awt.*;


public class Hangman {
    private JPanel buttonPanel, eingabePanel, platzhalter;
    private JButton home, retry;
    private JTextField eingabeBuchstaben, falscheBuchstaben;
    private JLabel titleLabel, uescrhiftEins, ueschriftZwei, Jwort, man, wort;
    private JFrame frame;
    private DrawHangmanView hang;
    private int mistakes;

    public Hangman(){
        frame = new JFrame("Startmenü");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());

        platzhalter = new JPanel();
        hang = new DrawHangmanView(0); 
        hang.setPreferredSize(new Dimension(400, 100));
        buttonPanel = new JPanel(new GridLayout(2,3));
        eingabePanel = new JPanel(new GridLayout(2,2,80,10));

        retry = new JButton("Retry");
        eingabeBuchstaben = new JTextField();
        falscheBuchstaben = new JTextField();
        falscheBuchstaben.setEnabled(false);
        wort = new JLabel("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _", SwingConstants.CENTER);
        wort.setEnabled(false);
        Jwort = new JLabel("Wort:",SwingConstants.CENTER);
        Jwort.setFont(new Font("Arial",Font.BOLD,12));
        home = new JButton("Home");

        titleLabel = new JLabel("Hang", SwingConstants.RIGHT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        man = new JLabel("man", SwingConstants.LEFT);
        man.setFont(new Font("Arial", Font.BOLD, 24));
        uescrhiftEins = new JLabel("Eingabe:", SwingConstants.CENTER);
        uescrhiftEins.setFont(new Font("Arial", Font.BOLD, 12));
        ueschriftZwei = new JLabel("Nicht gültige Buchstaben", SwingConstants.CENTER);
        ueschriftZwei.setFont(new Font("Arial", Font.BOLD, 12));

        eingabePanel.add(uescrhiftEins);
        eingabePanel.add(platzhalter);
        eingabePanel.add(ueschriftZwei);
        eingabePanel.add(eingabeBuchstaben);
        eingabePanel.add(home);
        eingabePanel.add(falscheBuchstaben);

        buttonPanel.add(titleLabel);
        buttonPanel.add(man);
        buttonPanel.add(Jwort);
        buttonPanel.add(wort);

        frame.add(hang, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(eingabePanel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
    
        frame.setVisible(true);

    }

    public void adden(DrawHangmanView view) {
        frame.remove(hang);
        this.hang = view;
        frame.add(hang, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    public void win() {
        frame.remove(hang);
        JPanel t = new JPanel();
        t.add(new JLabel("Gewonnen", SwingConstants.CENTER));
        set(retry);
        frame.add(t);
    }

    private void set(JButton but) {
        frame.remove(platzhalter);
        eingabePanel.add(uescrhiftEins);
        eingabePanel.add(but);
        eingabePanel.add(ueschriftZwei);
        eingabePanel.add(eingabeBuchstaben);
        eingabePanel.add(home);
        eingabePanel.add(falscheBuchstaben);
    }

    public int getMistakes() {
        return this.mistakes;
    }

    public void setMistakes(int mistakes) {
        this.mistakes = mistakes;
    }

    public JPanel getButtonPanel() {
        return this.buttonPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public JPanel getEingabePanel() {
        return this.eingabePanel;
    }

    public void setEingabePanel(JPanel eingabePanel) {
        this.eingabePanel = eingabePanel;
    }

    public JButton getHome() {
        return this.home;
    }

    public void setHome(JButton home) {
        this.home = home;
    }

    public JTextField getEingabeBuchstaben() {
        return this.eingabeBuchstaben;
    }

    public void setEingabeBuchstaben(JTextField eingabeBuchstaben) {
        this.eingabeBuchstaben = eingabeBuchstaben;
    }

    public JTextField getFalscheBuchstaben() {
        return this.falscheBuchstaben;
    }

    public void setFalscheBuchstaben(JTextField falscheBuchstaben) {
        this.falscheBuchstaben = falscheBuchstaben;
    }

    public JLabel getTitleLabel() {
        return this.titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JLabel getUescrhiftEins() {
        return this.uescrhiftEins;
    }

    public void setUescrhiftEins(JLabel uescrhiftEins) {
        this.uescrhiftEins = uescrhiftEins;
    }

    public JLabel getUeschriftZwei() {
        return this.ueschriftZwei;
    }

    public void setUeschriftZwei(JLabel ueschriftZwei) {
        this.ueschriftZwei = ueschriftZwei;
    }

    public JLabel getJwort() {
        return this.Jwort;
    }

    public void setJwort(JLabel Jwort) {
        this.Jwort = Jwort;
    }

    public JLabel getMan() {
        return this.man;
    }

    public void setMan(JLabel man) {
        this.man = man;
    }

    public JLabel getWort() {
        return this.wort;
    }

    public void setWort(JLabel wort) {
        this.wort = wort;
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public DrawHangmanView getHang() {
        return this.hang;
    }

    public void setHang(DrawHangmanView hang) {
        this.hang = hang;
    }

    public static void main(String[] args) {
        new Hangman();
    }
}

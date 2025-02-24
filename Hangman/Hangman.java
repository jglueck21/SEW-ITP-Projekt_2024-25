package Hangman;
import javax.swing.*;
import java.awt.*;


public class Hangman {
    private JPanel buttonPanel, eingabePanel;
    private JButton home;
    private JTextField eingabeBuchstaben, falscheBuchstaben;
    private JLabel titleLabel, uescrhiftEins, ueschriftZwei, Jwort, man, wort;
    private JFrame frame;
    private DrawHangmanView hang;

    public Hangman(){
        frame = new JFrame("Startmenü");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());

        hang = new DrawHangmanView(new Hangmanmodel("arsch")); 
        hang.setPreferredSize(new Dimension(400, 100));
        buttonPanel = new JPanel(new GridLayout(2,3));
        eingabePanel = new JPanel(new GridLayout(2,2,80,10));

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
        eingabePanel.add(new JPanel());
        eingabePanel.add(ueschriftZwei);
        eingabePanel.add(eingabeBuchstaben);
        eingabePanel.add(home);
        eingabePanel.add(falscheBuchstaben);

        buttonPanel.add(titleLabel);
        buttonPanel.add(man);
        buttonPanel.add(Jwort);
        buttonPanel.add(wort);

        hang.setMistakes(Integer.parseInt(JOptionPane.showInputDialog("Anzahl der Fehler eingeben (0-11):")));
        frame.add(hang, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(eingabePanel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
    
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Hangman();
    }
}

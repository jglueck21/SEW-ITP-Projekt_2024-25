package Hangman;
import javax.swing.*;
import java.awt.*;


public class Hangman {
    private JPanel mainPanel, buttonPanel, eingabePanel;
    private JButton home;
    private JTextField eingabeBuchstaben, falscheBuchstaben;
    private JLabel titleLabel, uescrhiftEins, ueschriftZwei;
    private JFrame frame;

    public Hangman(){
        frame = new JFrame("Startmenü");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        mainPanel = new JPanel(); 
        mainPanel.setPreferredSize(new Dimension(400, 100));
        buttonPanel = new JPanel();
        eingabePanel = new JPanel(new GridLayout(2,2));

        eingabeBuchstaben = new JTextField();
        falscheBuchstaben = new JTextField();
        falscheBuchstaben.setEnabled(false);

        home = new JButton("Home");

        titleLabel = new JLabel("Hangman", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        uescrhiftEins = new JLabel("Eingabe:", SwingConstants.CENTER);
        uescrhiftEins.setFont(new Font("Arial", Font.BOLD, 12));
        ueschriftZwei = new JLabel("Nicht gültige Buchstaben", SwingConstants.CENTER);
        ueschriftZwei.setFont(new Font("Arial", Font.BOLD, 12));

        eingabePanel.add(uescrhiftEins);
        eingabePanel.add(ueschriftZwei);
        eingabePanel.add(eingabeBuchstaben);
        eingabePanel.add(falscheBuchstaben);

        buttonPanel.add(titleLabel);
        buttonPanel.add(home);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(eingabePanel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
    
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Hangman();
    }
}

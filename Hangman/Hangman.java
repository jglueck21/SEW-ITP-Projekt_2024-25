package Hangman;
import javax.swing.*;
import java.awt.*;



public class Hangman {
    private JPanel mainPanel, buttonPanel, hangerPanel, namePanel;
    private JButton home;
    private JTextField eingabeBuchstaben, falscheBuchstaben;
    private JFrame frame;

    public Hangman(){
        frame = new JFrame("Startmenü");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        mainPanel = new JPanel(); 
        buttonPanel = new JPanel();
        hangerPanel = new JPanel();
        namePanel = new JPanel();

        JLabel titleLabel = new JLabel("Hangman", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.setLocationRelativeTo(null);
    
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Hangman();
    }
}

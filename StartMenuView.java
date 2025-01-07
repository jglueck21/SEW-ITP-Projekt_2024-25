import javax.swing.*;
import java.awt.*;

public class StartMenuView {
    private JFrame frame;
    private JButton manageButton;
    private JButton quizButton;
    private JButton gameButton;

    public StartMenuView() {
        frame = new JFrame("Startmenü");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        // Titel
        JLabel titleLabel = new JLabel("Projekt Titel", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Bild
        ImageIcon imageIcon = new ImageIcon("./images/background.png"); // Bild muss vorhanden sein
        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);
        frame.add(imageLabel, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        manageButton = new JButton("Verwaltung");
        quizButton = new JButton("Quiz");
        gameButton = new JButton("Spiel");
        buttonPanel.add(manageButton);
        buttonPanel.add(quizButton);
        buttonPanel.add(gameButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public JButton getManageButton() {
        return manageButton;
    }

    public JButton getQuizButton() {
        return quizButton;
    }

    public JButton getGameButton() {
        return gameButton;
    }

    public void close() {
        frame.dispose();
    }
}

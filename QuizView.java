import javax.swing.*;
import java.awt.*;

public class QuizView {
    private JFrame frame;
    private JButton weiterButton;
    private JTextField fragenFeld, antwortfeld;

    public QuizView() {
        frame = new JFrame("Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        fragenFeld = new JTextField("Hier steht eine Frage");
        fragenFeld.setEditable(false);
        fragenFeld.setHorizontalAlignment(JTextField.CENTER);
        fragenFeld.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(fragenFeld, BorderLayout.NORTH);

        JPanel antwortPanel = new JPanel();
        antwortPanel.setLayout(new FlowLayout());
        antwortfeld = new JTextField(20);
        antwortPanel.add(antwortfeld);
        frame.add(antwortPanel, BorderLayout.CENTER);

        JPanel weiterPanel = new JPanel();
        weiterPanel.setLayout(new BorderLayout());
        weiterButton = new JButton("Weiter");
        weiterPanel.add(weiterButton, BorderLayout.EAST);
        frame.add(weiterPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        QuizView quizView = new QuizView();

    }

}

package Quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class QuizView extends JFrame {
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton homeButton, nextButton, rerunButton;

    public QuizView() {
        setTitle("Quiz Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new BorderLayout(10, 10));

        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        centerPanel.add(questionLabel);

        answerField = new JTextField();
        answerField.setFont(new Font("Arial", Font.PLAIN, 18));
        centerPanel.add(answerField);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.BOLD, 14));
        leftPanel.add(homeButton);
        bottomPanel.add(leftPanel, BorderLayout.WEST);

        JPanel centerButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rerunButton = new JButton("Rerun Quiz");
        rerunButton.setFont(new Font("Arial", Font.BOLD, 14));
        centerButtonPanel.add(rerunButton);
        bottomPanel.add(centerButtonPanel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        nextButton = new JButton("Next Question");
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        rightPanel.add(nextButton);
        bottomPanel.add(rightPanel, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void setQuestion(String question) {
        questionLabel.setText(question);
    }

    public String getAnswer() {
        return answerField.getText().trim();
    }

    public void clearAnswer() {
        answerField.setText("");
    }

    public void addHomeButtonListener(ActionListener listener) {
        homeButton.addActionListener(listener);
    }

    public void addNextButtonListener(ActionListener listener) {
        nextButton.addActionListener(listener);
    }

    public void addRerunButtonListener(ActionListener listener) {
        rerunButton.addActionListener(listener);
    }
    public static void main(String[] args) {
        QuizView quizView = new QuizView();
        quizView.setVisible(true);
    }
}

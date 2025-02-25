package Quiz;
import javax.swing.*;
import java.io.*;
public class QuizModel {
    
    private String[] questions;
    private String[] answers;
    private int currentIndex;
    private int score;
    private int wrongAnswers;

    public QuizModel() {
        loadQuestions();
        reset();
    }

    private void loadQuestions() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/questions.txt"))) {
            questions = new String[10];
            answers = new String[10];
            for (int i = 0; i < 10; i++) {
                String line = reader.readLine();
                if (line == null) throw new IOException("Unzureichende Fragenanzahl.");
                questions[i] = line.split("-", 2)[1].trim();

                line = reader.readLine();
                if (line == null) throw new IOException("Unzureichende Antwortenanzahl.");
                answers[i] = line.trim();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Laden der Fragen: " + e.getMessage());
            questions = new String[0];
            answers = new String[0];
        }
    }

    public void reset() {
        currentIndex = 0;
        score = 0;
        wrongAnswers = 0;
    }

    public String getCurrentQuestion() {
        return questions[currentIndex];
    }

    public boolean checkAnswer(String userAnswer) {
        boolean isCorrect = userAnswer.equalsIgnoreCase(answers[currentIndex]);
        if (isCorrect) score++; else wrongAnswers++;
        currentIndex++;
        return isCorrect;
    }

    public boolean hasMoreQuestions() {
        return currentIndex < questions.length && questions.length > 0;
    }

    public int getScore() { return score; }
    public int getWrongAnswers() { return wrongAnswers; }
}
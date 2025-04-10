package Quiz;
import Startmenu.StartMenuController;
import Startmenu.StartMenuModel;
import Startmenu.StartMenuView;
import java.awt.event.*;
import javax.swing.*;
public class QuizController {
    private QuizModel model;
    private QuizView view;

    public QuizController(QuizModel model, QuizView view) {
        this.model = model;
        this.view = view;

        view.addHomeButtonListener((ActionEvent e) -> {
            view.close();
            new StartMenuController(new StartMenuModel(),new StartMenuView());
        });

        view.addNextButtonListener((ActionEvent e) -> {
            nextQuestion();
        });

        view.addRerunButtonListener((ActionEvent e) -> {
            rerunQuiz();
        });

        showQuestion();
    }

    private void showQuestion() {
        if (model.hasMoreQuestions()) {
            view.setQuestion(model.getCurrentQuestion());
            view.clearAnswer();
        } else {
            showResult();
        }
    }

    private void nextQuestion() {
        if (model.hasMoreQuestions()) {
            model.checkAnswer(view.getAnswer());
            showQuestion();
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(view, "Quiz beendet!\nRichtige Antworten: " + model.getScore() +
                "\nFalsche Antworten: " + model.getWrongAnswers() +
                "\nEndpunktzahl: " + (model.getScore() - model.getWrongAnswers()));
    }

    private void goHome() {
        view.dispose();
        JOptionPane.showMessageDialog(null, "Willkommen im Home-Fenster!");
    }

    private void rerunQuiz() {
        model.reset();
        showQuestion();
    }

    public static void main(String[] args) {
        new QuizController(new QuizModel(), new QuizView());
    }
}

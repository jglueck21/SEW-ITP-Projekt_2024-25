package Startmenu;
import javax.swing.*;

import Hangman.Hangman;
import Hangman.Hangmancontroller;
import Hangman.Hangmanmodel;
import Quiz.QuizController;
import Quiz.QuizModel;
import Quiz.QuizView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenuController {
    private StartMenuModel model;
    private StartMenuView view;
    private JButton weiterButton;
    private JTextField fragenFeld, antwortfeld;

    public StartMenuController(StartMenuModel model, StartMenuView view) {
        this.model = model;
        this.view = view;

        // Event-Listener hinzufügen
        view.getManageButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openManagementWindow();
            }
        });

        view.getQuizButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.close();
                new QuizController(new QuizModel(), new QuizView());
            }
        });

        view.getGameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.close();
                new Hangmancontroller(new Hangmanmodel("null"), new Hangman());
            }
        });
    }

    private void openManagementWindow() {
        view.close();
        JFrame managementFrame = new JFrame("Verwaltung");
        managementFrame.setSize(400, 300);
        managementFrame.setLayout(new BorderLayout());
        managementFrame.add(new JLabel("Willkommen im Verwaltungsfenster", SwingConstants.CENTER), BorderLayout.CENTER);

        JButton backButton = new JButton("Zurück zur Startseite");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managementFrame.dispose();
                new StartMenuController(model, new StartMenuView());
            }
        });
        managementFrame.add(backButton, BorderLayout.SOUTH);
        managementFrame.setVisible(true);
    }

    private void openQuizWindow() {
        view.close();
        JFrame quizFrame = new JFrame("Quiz");
        quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quizFrame.setSize(500, 500);
        quizFrame.setLocationRelativeTo(null);
        quizFrame.setLayout(new BorderLayout());

        quizFrame = new JFrame("Quiz");
        quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quizFrame.setSize(500, 500);
        quizFrame.setLocationRelativeTo(null);
        quizFrame.setLayout(new BorderLayout());

        fragenFeld = new JTextField("Hier steht eine Frage");
        fragenFeld.setEditable(false);
        fragenFeld.setHorizontalAlignment(JTextField.CENTER);
        fragenFeld.setFont(new Font("Arial", Font.BOLD, 18));
        quizFrame.add(fragenFeld, BorderLayout.NORTH);

        JPanel antwortPanel = new JPanel();
        antwortPanel.setLayout(new FlowLayout());
        antwortfeld = new JTextField(20);
        antwortPanel.add(antwortfeld);
        quizFrame.add(antwortPanel, BorderLayout.CENTER);

        JPanel weiterPanel = new JPanel();
        weiterPanel.setLayout(new BorderLayout());
        weiterButton = new JButton("Weiter");
        weiterPanel.add(weiterButton, BorderLayout.EAST);
        quizFrame.add(weiterPanel, BorderLayout.SOUTH);

        quizFrame.setVisible(true);


        JButton backButton = new JButton("Zurück zur Startseite");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartMenuController(model, new StartMenuView());
            }
        });
        quizFrame.add(backButton, BorderLayout.SOUTH);
        quizFrame.setVisible(true);
    }

    private void openGameWindow() {
        view.close();
        JFrame gameFrame = new JFrame("Spiel");
        gameFrame.setSize(400, 300);
        gameFrame.setLayout(new BorderLayout());
        gameFrame.add(new JLabel("Willkommen im Spielfenster", SwingConstants.CENTER), BorderLayout.CENTER);

        JButton backButton = new JButton("Zurück zur Startseite");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.dispose();
                new StartMenuController(model, new StartMenuView());
            }
        });
        gameFrame.add(backButton, BorderLayout.SOUTH);
        gameFrame.setVisible(true);
    }
}

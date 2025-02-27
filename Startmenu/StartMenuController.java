package Startmenu;
import javax.swing.*;

import Hangman.Hangman;
import Hangman.Hangmancontroller;
import Hangman.Hangmanmodel;
import Quiz.QuizController;
import Quiz.QuizModel;
import Quiz.QuizView;
import Verwaltung.VerwaltungsController;
import Verwaltung.VerwaltungsModel;
import Verwaltung.VerwaltungsView;

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
                view.close();
                new VerwaltungsController(new VerwaltungsView(), new VerwaltungsModel());
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
                new Hangmancontroller(new Hangmanmodel(), new Hangman());
            }
        });
    }

}

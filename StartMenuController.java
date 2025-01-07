import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenuController {
    private StartMenuModel model;
    private StartMenuView view;

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
                openQuizWindow();
            }
        });

        view.getGameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGameWindow();
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
        quizFrame.setSize(400, 300);
        quizFrame.setLayout(new BorderLayout());
        quizFrame.add(new JLabel("Willkommen im Quizfenster", SwingConstants.CENTER), BorderLayout.CENTER);

        JButton backButton = new JButton("Zurück zur Startseite");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizFrame.dispose();
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

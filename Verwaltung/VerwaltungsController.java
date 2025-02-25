package Verwaltung;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class VerwaltungsController {
    private VerwaltungsView view;
    private VerwaltungsModel model;
    private static final String DIRECTORY = "src/Fragen/";

    public VerwaltungsController(VerwaltungsView view, VerwaltungsModel model) {
        this.view = view;
        this.model = model;
        ensureDirectoryExists();
        addEventListeners();
    }

    private void ensureDirectoryExists() {
        File dir = new File(DIRECTORY);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    private void addEventListeners() {
        view.getBtnLoad().addActionListener(e -> loadFile());
        view.getBtnSave().addActionListener(e -> saveFile());
        view.getBtnAdd().addActionListener(e -> addRow());
        view.getBtnDelete().addActionListener(e -> deleteRow());
        view.getBtnNewFile().addActionListener(e -> createNewFile());
    }

    private void loadFile() {
        String filename = askForFilename();
        if (filename == null || filename.isEmpty()) return;

        File file = new File(DIRECTORY + filename + ".txt");
        if (file.exists()) {
            try {
                model.ladeDatei(file);
                updateViewFromModel();
            } catch (IOException e) {
                showError("Fehler beim Laden der Datei.");
            }
        } else {
            showError("Die Datei '" + filename + ".txt' existiert nicht.");
        }
    }

    private void saveFile() {
        String filename = askForFilename();
        if (filename == null || filename.isEmpty()) return;

        try {
            model.speichereDatei(DIRECTORY + filename + ".txt"); //Hier wurde in der model klasse der parameter geändert damit es compilerbar ist
            showInfo("Datei '" + filename + ".txt' erfolgreich gespeichert.");
        } catch (IOException e) {
            showError("Fehler beim Speichern der Datei.");
        }
    }

    private void addRow() {
        if (model.getFragenListe().size() < 10) {
            model.addFrage(view.getTxtFrage().getText(), view.getTxtAntwort().getText());
            updateViewFromModel();
        } else {
            showWarning("Maximal 10 Fragen erlaubt.");
        }
    }

    private void deleteRow() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow != -1) {
            model.removeFrage(selectedRow);
            updateViewFromModel();
        } else {
            showError("Keine Zeile ausgewählt.");
        }
    }

    private void createNewFile() {
        String filename = askForFilename();
        if (filename == null || filename.isEmpty()) return;

        File newFile = new File(DIRECTORY + filename + ".txt");
        try {
            if (newFile.createNewFile()) {
                try (FileWriter writer = new FileWriter(newFile)) {
                    writer.write("");
                }
                model.ladeDatei(newFile);
                updateViewFromModel();
                showInfo("Neue Datei '" + filename + ".txt' wurde erstellt.");
            } else {
                showWarning("Die Datei '" + filename + ".txt' existiert bereits.");
            }
        } catch (IOException e) {
            showError("Fehler beim Erstellen der Datei.");
        }
    }

    private String askForFilename() {
        return JOptionPane.showInputDialog(view.getFrame(), "Bitte Dateinamen eingeben:", "Dateiname", JOptionPane.QUESTION_MESSAGE);
    }

    private void updateViewFromModel() {
        view.getTableModel().setRowCount(0);
        for (String[] frage : model.getFragenListe()) {
            view.getTableModel().addRow(frage);
        }
    }

    private void showInfo(String message) {
        JOptionPane.showMessageDialog(view.getFrame(), message, "Erfolg", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showWarning(String message) {
        JOptionPane.showMessageDialog(view.getFrame(), message, "Warnung", JOptionPane.WARNING_MESSAGE);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(view.getFrame(), message, "Fehler", JOptionPane.ERROR_MESSAGE);
    }
}

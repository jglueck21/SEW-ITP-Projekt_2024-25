package Verwaltung;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    DefaultTableModel tableModel = view.getTableModel();
    
    // Alle GUI-Daten durchgehen und ins Model übertragen
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        String frage = (String) tableModel.getValueAt(i, 0);
        String antwort = (String) tableModel.getValueAt(i, 1);

        if (frage != null && antwort != null && !frage.trim().isEmpty() && !antwort.trim().isEmpty()) {
            boolean exists = false;

            // Prüfen, ob die Frage bereits in der Liste existiert
            for (String[] f : model.getFragenListe()) {
                if (f[0].equals(frage) && f[1].equals(antwort)) {
                    exists = true;
                    break;
                }
            }

            // Nur hinzufügen, wenn sie noch nicht existiert
            if (!exists) {
                model.addFrage(frage.trim(), antwort.trim());
            }
        }
    }

    // Falls noch keine Datei existiert, den Benutzer nach einem Namen fragen
    if (model.getAktuelleDatei() == null) {
        String filename = askForFilename();
        if (filename == null || filename.isEmpty()) return;
        
        model.setAktuelleDatei(new File(DIRECTORY + filename + ".txt"));
    }

    try {
        model.speichereDatei();
        showInfo("Datei erfolgreich gespeichert.");
    } catch (IOException e) {
        showError("Fehler beim Speichern der Datei.");
    }
}

    

    private void addRow() {
        String frage = view.getTxtFrage().getText().trim();
        String antwort = view.getTxtAntwort().getText().trim();
        
    
        model.addFrage(frage, antwort); // Speichert die Frage in `fragenListe`
        updateViewFromModel(); // Aktualisiert die GUI
    
        System.out.println("DEBUG: Frage hinzugefügt -> " + frage + " | Antwort -> " + antwort); // Debug-Print
    
        view.getTxtFrage().setText(""); // Leert die Eingabefelder
        view.getTxtAntwort().setText("");
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

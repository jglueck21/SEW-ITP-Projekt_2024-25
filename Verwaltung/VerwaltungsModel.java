package Verwaltung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VerwaltungsModel {
    private List<String[]> fragenListe;
    private File aktuelleDatei;

    public VerwaltungsModel() {
        fragenListe = new ArrayList<>();
    }

    public void ladeDatei(File datei) throws IOException {
        if (datei == null || !datei.exists()) {
            throw new IOException("Datei existiert nicht oder ist null.");
        }
        fragenListe.clear();
        aktuelleDatei = datei;
        try (BufferedReader reader = new BufferedReader(new FileReader(datei))) {
            String frage;
            while ((frage = reader.readLine()) != null) {
                String antwort = reader.readLine();
                if (antwort != null) {
                    fragenListe.add(new String[] { frage, antwort });
                }
            }
        }
    }

    public void speichereDatei(String string) throws IOException {
        if (aktuelleDatei == null) {
            throw new IOException("Keine Datei geladen, Speichern nicht möglich.");
        }
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(aktuelleDatei))) {
            if (fragenListe.isEmpty()) {
                throw new IOException("Fehler: Fragenliste ist leer!"); // Debug-Fehlermeldung
            }
    
            for (int i = 0; i < fragenListe.size(); i++) {
                String frage = fragenListe.get(i)[0];
                String antwort = fragenListe.get(i)[1];
    
                System.out.println("DEBUG: Speichere -> " + (i + 1) + "- " + frage + " | " + antwort); // Debug-Print
    
                writer.write((i + 1) + "- " + frage + "\n");
                writer.write(antwort + "\n");
            }
        }
    }
    
    
    

    public List<String[]> getFragenListe() {
        return fragenListe;
    }

    public void addFrage(String frage, String antwort) throws IllegalStateException {
        if (fragenListe.size() >= 10) {
            throw new IllegalStateException("Maximale Anzahl von 10 Fragen erreicht.");
        }
        fragenListe.add(new String[] { frage.trim(), antwort.trim() });
    
        // Debug-Print
        System.out.println("Aktuelle Fragenliste:");
        for (String[] f : fragenListe) {
            System.out.println("Frage: " + f[0] + ", Antwort: " + f[1]);
        }
    }
    

    public void removeFrage(int index) {
        if (index < 0 || index >= fragenListe.size()) {
            throw new IndexOutOfBoundsException("Ungültiger Index.");
        }
        fragenListe.remove(index);
    }

    public File getAktuelleDatei() {
        return aktuelleDatei;
    }
    
    public void setAktuelleDatei(File datei) {
        this.aktuelleDatei = datei;
    }    
}

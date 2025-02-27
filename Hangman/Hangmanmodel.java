package Hangman;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Hangmanmodel {
    
    private String ratewort, falscheBuchstaben = "";
    private StringBuilder anzeige;
    
    public Hangmanmodel() {
        this.ratewort = this.zuFallsAntwort();
        this.anzeige = new StringBuilder();

        for(int i = 0; i < ratewort.length(); i++) {
            if(ratewort.charAt(i) != ' ') {
                this.anzeige.append(".");
            } else {
                this.anzeige.append("-");
            }
        }
    }

    public boolean buchstabe(char a) {
        boolean ret = false;
        for(int i = 0; i < ratewort.length(); i++) {
            char temp = this.ratewort.charAt(i);
            if(a == Character.toLowerCase(temp)) {
                this.anzeige.setCharAt(i, temp) ;
                ret = true;
            }
        }
        this.falscheBuchstaben += a;
        return ret;
    }

    private String zuFallsAntwort() {
        String[] answers = new String[10];
        try (BufferedReader reader = new BufferedReader(new FileReader("src/questions.txt"))) {

            for (int i = 0; i < 10; i++) {
                String line = reader.readLine();
                line = reader.readLine();
                if (line == null) throw new IOException("Unzureichende Antwortenanzahl.");
                answers[i] = line.trim();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Laden der Fragen: " + e.getMessage());
        }

        int random = (int) (Math.random() * 9);
        return answers[random];
    }

    public boolean fertig() {
        return this.anzeige.toString().equals(this.ratewort);
    }


    public String getFalscheBuchstaben() {
        return this.falscheBuchstaben;
    }

    public void setFalscheBuchstaben(String falscheBuchstaben) {
        this.falscheBuchstaben = falscheBuchstaben;
    }
    public void setAnzeige(StringBuilder anzeige) {
        this.anzeige = anzeige;
    }

    public String getRatewort() {
        return this.ratewort;
    }

    public void setRatewort(String ratewort) {
        this.ratewort = ratewort;
    }

    public StringBuilder getAnzeige() {
        return this.anzeige;
    }

}

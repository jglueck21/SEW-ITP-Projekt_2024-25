package Hangman;

import java.awt.*;

public class Hangmanmodel {
    
    private String ratewort;
    private StringBuilder anzeige;
    
    public Hangmanmodel(String ratewort) {
        if(ratewort != null) {
            this.ratewort = ratewort;
        }
        this.anzeige = new StringBuilder();
        for(int i = 0; i < ratewort.length(); i++) {
            this.anzeige.append("-");
        }
    }

    public boolean buchstabe(char a) {
        boolean ret = false;
        for(int i = 0; i < ratewort.length(); i++) {
            if(a == this.ratewort.charAt(i)) {
                this.anzeige.setCharAt(i, a) ;
                ret = true;
            }
        }
        return ret;
    }

    public boolean fertig() {
        if(this.anzeige.toString().equals(this.ratewort)) {
            return true;
        }else {
            return false;
        }
    }

    public void drawHangman(Graphics g, int mistakes) {
        if (mistakes == 1) g.drawArc(50, 50, 200, 100, 0, 180); // Halbkreis
        if (mistakes == 2) g.drawLine(50, 250, 150, 250); // Boden
        if (mistakes == 3) g.drawLine(100, 50, 100, 250); // Pfosten
        if (mistakes == 4) g.drawLine(100, 50, 200, 50);  // Querbalken
        if (mistakes == 5) g.drawLine(200, 50, 200, 80); // Seil
        if (mistakes == 6) g.drawOval(180, 80, 40, 40); // Kopf
        if (mistakes == 7) g.drawLine(200, 120, 200, 180); // Körper
        if (mistakes == 8) g.drawLine(200, 140, 170, 120); // Linker Arm
        if (mistakes == 9) g.drawLine(200, 140, 230, 120); // Rechter Arm
        if (mistakes == 10) g.drawLine(200, 180, 170, 220); // Linkes Bein
        if (mistakes == 11) g.drawLine(200, 180, 230, 220); // Rechtes Bein
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

    public static void main(String[] args) {
        Hangmanmodel t = new Hangmanmodel("arsch");
        System.out.println(t.getAnzeige());
        t.buchstabe('r');
        System.out.println(t.getAnzeige());
        t.buchstabe('c');
        System.out.println(t.getAnzeige());
       
        System.out.println(t.fertig());
    }

}

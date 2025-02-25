package Hangman;

public class Hangmanmodel {
    
    private String ratewort, falscheBuchstaben = "";
    private StringBuilder anzeige;
    
    public Hangmanmodel(String ratewort) {
        if(ratewort != null) {
            this.ratewort = ratewort;
        }
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
            if(a == this.ratewort.charAt(i)) {
                this.anzeige.setCharAt(i, a) ;
                ret = true;
            }
        }
        this.falscheBuchstaben += a;
        return ret;
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

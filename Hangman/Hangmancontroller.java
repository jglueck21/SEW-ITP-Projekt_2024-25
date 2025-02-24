package Hangman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hangmancontroller {
    private Hangmanmodel model;
    private Hangman frame;
    private int mistakes = 0;

    public Hangmancontroller(Hangmanmodel model, Hangman frame) {
        this.model = model;
        this.frame = frame;

        frame.getWort().setText(model.getAnzeige().toString());
        frame.getEingabeBuchstaben().addActionListener(new Wort());

    }

    private class Wort implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(model.buchstabe(frame.getEingabeBuchstaben().getText().charAt(0)) == false) {
                mistakes = mistakes+1;
                frame.getFalscheBuchstaben().setText(model.getFalscheBuchstaben());
                frame.adden(new DrawHangmanView(mistakes));
            } else {
                frame.getWort().setText(model.getAnzeige().toString());
            }

            if(model.fertig() == true) {
                frame.win();
            }
        }
        
    }

    public static void main(String[] args) {
        new Hangmancontroller(new Hangmanmodel("arsch"), new Hangman());
    }
 }

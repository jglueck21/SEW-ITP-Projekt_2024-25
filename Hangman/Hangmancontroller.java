package Hangman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Startmenu.StartMenuController;
import Startmenu.StartMenuModel;
import Startmenu.StartMenuView;

public class Hangmancontroller {
    private Hangmanmodel model;
    private Hangman frame;
    private int mistakes = 0;

    public Hangmancontroller(Hangmanmodel model, Hangman frame) {
        this.model = model;
        this.frame = frame;

        frame.getWort().setText(model.getAnzeige().toString());
        frame.getEingabeBuchstaben().addActionListener(new Wort());
        frame.getRetry().addActionListener(new Ret());
        frame.getHome().addActionListener(new Home());

    }

    private class Wort implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(model.buchstabe(frame.getEingabeBuchstaben().getText().charAt(0)) == false) {
                mistakes++;
                frame.getFalscheBuchstaben().setText(model.getFalscheBuchstaben());
                frame.adden(new DrawHangmanView(mistakes));
            } else {
                frame.getWort().setText(model.getAnzeige().toString());
            } 

            if(model.fertig() == true) {
                frame.win();
            }else if(mistakes > 12 && model.getAnzeige().toString() != model.getRatewort()) {
                frame.lose();
            }
        }
        
    }

    private class Ret implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.close();
            new Hangmancontroller(new Hangmanmodel("Super duper"), new Hangman());
        }
        
    }

    private class Home implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.close();
            new StartMenuController(new StartMenuModel(), new StartMenuView());
        }
    }


    public static void main(String[] args) {
        new Hangmancontroller(new Hangmanmodel("arsch"), new Hangman());
    }
 }

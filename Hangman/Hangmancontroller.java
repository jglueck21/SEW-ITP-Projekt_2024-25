package Hangman;

import Startmenu.StartMenuController;
import Startmenu.StartMenuModel;
import Startmenu.StartMenuView;
import java.awt.event.ActionEvent;

public class Hangmancontroller {
    private int mistakes = 0;

    @SuppressWarnings("unused")
    public Hangmancontroller(Hangmanmodel model, Hangman frame) {

        frame.getWort().setText(model.getAnzeige().toString());
        frame.addEingabe((ActionEvent e) -> {
            if(frame.getEingabeBuchstaben() == null || model.buchstabe(frame.getEingabeBuchstaben().getText().charAt(0)) == false) {
                mistakes++;
                frame.getFalscheBuchstaben().setText(model.getFalscheBuchstaben());
                frame.adden(new DrawHangmanView(mistakes));
            } else {
                frame.getWort().setText(model.getAnzeige().toString());
            } 

            if(model.fertig() == true) {
                frame.win();
            }else if(mistakes > 12 && !model.getAnzeige().toString().equals(model.getRatewort())) {
                frame.lose(model);
            }
        });

        frame.addRetry((ActionEvent e) -> {
            frame.close();
            Hangmancontroller t = new Hangmancontroller(new Hangmanmodel("Super duper"), new Hangman());
        });

        frame.addHomeButtonListener((ActionEvent e) -> {
            frame.close();
            StartMenuController t = new StartMenuController(new StartMenuModel(), new StartMenuView());
        });

    }

 }

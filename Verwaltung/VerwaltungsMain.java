package Verwaltung;

import javax.swing.SwingUtilities;

public class VerwaltungsMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VerwaltungsView view = new VerwaltungsView();
            VerwaltungsModel model = new VerwaltungsModel();
            new VerwaltungsController(view, model);
        });
    }
}

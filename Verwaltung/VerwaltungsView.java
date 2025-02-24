package Verwaltung;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VerwaltungsView {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnLoad, btnSave, btnAdd, btnDelete, btnNewFile;
    private JTextField txtFrage, txtAntwort;

    public VerwaltungsView() {
        frame = new JFrame("Fragenverwaltung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        String[] columnNames = { "Frage", "Antwort" };
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        btnLoad = new JButton("Datei laden");
        btnSave = new JButton("Speichern");
        btnAdd = new JButton("Hinzufügen");
        btnDelete = new JButton("Löschen");
        btnNewFile = new JButton("Neue Datei");

        txtFrage = new JTextField(20);
        txtAntwort = new JTextField(20);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(txtFrage);
        inputPanel.add(txtAntwort);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnLoad);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnNewFile);

        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JButton getBtnLoad() {
        return btnLoad;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }
    
    public JButton getBtnNewFile() {
        return btnNewFile;
    }

    public JTextField getTxtFrage() {
        return txtFrage;
    }

    public JTextField getTxtAntwort() {
        return txtAntwort;
    }
}

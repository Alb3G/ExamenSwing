package com.examen.views;

import com.examen.Session;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Objects;

/**
 * Ventana principal donde se muestra toda la funcionalidad de añadir usuarios
 */
public class AddUserView extends JFrame {
    private JPanel root;
    private JTextField textField1;
    private JComboBox<String> countryCombo;
    private JComboBox<String> platformCombo;
    private JButton save;
    private JButton cancelButton;
    private JTable userTable;
    private JLabel infoPlaceHolder;
    private DefaultTableModel model;

    /**
     * En el constructor ajustamos las propiedades de la ventana
     * setteamos los headers de la tabla los modelos de los comboBox
     * y la logica del metodo de añadir usuario.
     */
    public AddUserView() {
        setContentPane(root);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setCountryComboValues();
        setPlatformComboValues();

        String[] header = {"Email", "Country", "Platform"};
        model = new DefaultTableModel(header, 0);
        userTable.setModel(model);

        save.addActionListener( _ -> addUser());
    }

    /**
     * Gestionamos toda la lógica de añadir el usuario sacando los valores
     * de los inputs e insertandolos en la tabla.
     */
    private void addUser() {
        String email = textField1.getText();
        String country = (String) countryCombo.getSelectedItem();
        String platform = (String) platformCombo.getSelectedItem();
        if(email.isEmpty() || Objects.equals(country, "") || Objects.equals(platform, "")) {
            infoPlaceHolder.setText("You have some empty fields please edit them.");
        } else {
            Object[] row = {email, country, platform};
            model.addRow(row);
            Session.userEmail = email;
            OkModal modal = new OkModal();
            modal.setVisible(true);
            textField1.setText("");
            countryCombo.setSelectedItem("");
            platformCombo.setSelectedItem("");
        }
    }

    /**
     * Setteo del modelo de los paises
     */
    private void setCountryComboValues() {
        countryCombo.addItem("");
        countryCombo.addItem("Spain");
        countryCombo.addItem("Norway");
        countryCombo.addItem("Sweden");
        countryCombo.addItem("Morocco");
        countryCombo.addItem("Brasil");
    }

    /**
     * Setteo del modelo de las Plataformas
     */
    private void setPlatformComboValues() {
        platformCombo.addItem("");
        platformCombo.addItem("Desktop");
        platformCombo.addItem("Mobile");
        platformCombo.addItem("Unknown");
    }
}

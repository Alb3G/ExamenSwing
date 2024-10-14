package com.examen.views;

import com.examen.Session;

import javax.swing.*;

/**
 * Author Alberto Guzman Moreno
 * Esta clase representa la ventana modal que se mostrará al añadir un usuario nuevo
 * contiene todos los elementos mencionados en el ejercicio.
 */
public class OkModal extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel userEmail;
    private JButton buttonCancel;

    /**
     * Constructor donde seteamos todas las propiedades que tendrá la ventana modal
     * y gestionamos lo que hará el metodo onOk()
     */
    public OkModal() {
        setContentPane(contentPane);
        setSize(500, 500);
        setModal(true);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonOK);
        userEmail.setText(Session.userEmail);
        buttonOK.addActionListener(_ -> onOK());
    }

    /**
     * Método para cerrar la ventana modal y settear el email de usuario a null de nuevo.
     */
    private void onOK() {
        dispose();
        Session.userEmail = null;
    }
}

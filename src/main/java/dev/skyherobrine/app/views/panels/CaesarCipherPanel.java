package dev.skyherobrine.app.views.panels;

import dev.skyherobrine.app.controllers.CaesarCipherController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CaesarCipherPanel extends JPanel {

    private JTextField txtMessage, txtResult;
    private JSpinner spnKey;
    private JRadioButton rdbEncrypt, rdbDecrypt;
    private JButton btnProcess;

    public CaesarCipherPanel() {
        setLayout(null);

        JLabel lbMessage = new JLabel("Message:");
        lbMessage.setBounds(20, 10, 100, 20);
        add(lbMessage);

        txtMessage = new JTextField();
        txtMessage.setBounds(130, 10, 300, 20);
        add(txtMessage);

        JLabel lbKey = new JLabel("Key:");
        lbKey.setBounds(20, 70, 100, 20);
        add(lbKey);

        spnKey = new JSpinner();
        spnKey.setBounds(130, 70, 100, 20);
        add(spnKey);

        JLabel lbAction = new JLabel("Action:");
        lbAction.setBounds(20, 130, 100, 20);
        add(lbAction);

        rdbEncrypt = new JRadioButton("Encrypt");
        rdbEncrypt.setSelected(true);
        rdbEncrypt.setBounds(130, 130, 100, 20);
        rdbEncrypt.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                btnProcess.setText(rdbEncrypt.isSelected() ? "Encrypt" : "Decrypt");
            }
        });
        add(rdbEncrypt);

        rdbDecrypt = new JRadioButton("Decrypt");
        rdbDecrypt.setBounds(230, 130, 100, 20);
        add(rdbDecrypt);

        ButtonGroup bgAction = new ButtonGroup();
        bgAction.add(rdbEncrypt);
        bgAction.add(rdbDecrypt);

        JLabel lbResult = new JLabel("Result:");
        lbResult.setBounds(20, 220, 100, 20);
        add(lbResult);

        txtResult = new JTextField();
        txtResult.setBounds(130, 220, 300, 20);
        txtResult.setEditable(false);
        add(txtResult);

        btnProcess = new JButton(rdbEncrypt.isSelected() ? "Encrypt" : "Decrypt");
        btnProcess.setBounds(200, 280, 100, 20);
        btnProcess.addActionListener(new CaesarCipherController(this));
        add(btnProcess);
    }

    public JTextField getTxtMessage() {
        return txtMessage;
    }

    public JTextField getTxtResult() {
        return txtResult;
    }

    public JSpinner getSpnKey() {
        return spnKey;
    }

    public JRadioButton getRdbEncrypt() {
        return rdbEncrypt;
    }

    public JRadioButton getRdbDecrypt() {
        return rdbDecrypt;
    }

    public JButton getBtnProcess() {
        return btnProcess;
    }
}

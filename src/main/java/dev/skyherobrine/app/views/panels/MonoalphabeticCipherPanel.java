package dev.skyherobrine.app.views.panels;

import dev.skyherobrine.app.controllers.MonoalphabeticCipherController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MonoalphabeticCipherPanel extends JPanel {
    private JTextField txtMessage, txtKey, txtResult;
    private JRadioButton rdbEncrypt, rdbDecrypt;
    private JButton btnProcess;

    public MonoalphabeticCipherPanel() {
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

        txtKey = new JTextField();
        txtKey.setBounds(130, 70, 300, 20);
        add(txtKey);

        JTextField txtSample = new JTextField();
        txtSample.setText("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        txtSample.setBounds(130, 100, 300, 20);
        txtSample.setEditable(false);
        add(txtSample);

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
        btnProcess.addActionListener(new MonoalphabeticCipherController(this));
        add(btnProcess);
    }

    public JTextField getTxtMessage() {
        return txtMessage;
    }

    public JTextField getTxtResult() {
        return txtResult;
    }

    public JTextField getTxtKey() {
        return txtKey;
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

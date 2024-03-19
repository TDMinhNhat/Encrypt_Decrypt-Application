package dev.skyherobrine.app.views.panels;

import dev.skyherobrine.app.controllers.CaesarCipherController;
import dev.skyherobrine.app.controllers.PlayfairCipherController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class PlayfairCipherPanel extends JPanel {

    private JTextField txtMessage, txtResult;
    private JButton btnInputKey;
    private JRadioButton rdbEncrypt, rdbDecrypt;
    private JButton btnProcess;
    private Character[][] keyMatrix;
    public PlayfairCipherPanel() {
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

        btnInputKey = new JButton("Input Key");
        btnInputKey.setBounds(130, 70, 100, 20);
        btnInputKey.addActionListener((e) -> {
            JFrame keyFrame = new JFrame("Input Key");
            keyFrame.setSize(400, 200);
            keyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            keyFrame.setLocationRelativeTo(null);
            keyFrame.setResizable(false);
            keyFrame.setLayout(new BorderLayout());

            JPanel keyPanel = new JPanel();
            keyPanel.setLayout(new GridLayout(5, 5));
            JTextField[] txtInputKey = new JTextField[25];
            for(int i = 0; i < txtInputKey.length; i++) {
                txtInputKey[i] = new JTextField();
                keyPanel.add(txtInputKey[i]);
            }
            keyFrame.add(keyPanel, BorderLayout.CENTER);

            JPanel pnButton = new JPanel();
            pnButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            JButton btnSave = new JButton("Save");
            btnSave.addActionListener((eSave) -> {
                keyMatrix = new Character[5][5];
                for(int i = 0; i < 5; i++) {
                    for(int j = 0; j < 5; j++) {
                        if(txtInputKey[i * 5 + j].getText().length() > 1 || txtInputKey[i * 5 + j].getText().length() == 0) {
                            JOptionPane.showMessageDialog(null, "Key must be contained 1 character and not null", "Error", JOptionPane.ERROR_MESSAGE);
                            txtInputKey[i * 5 + j].requestFocus(true);
                            return;
                        }
                        keyMatrix[i][j] = txtInputKey[i * 5 + j].getText().toUpperCase().charAt(0);
                    }
                }
                keyFrame.dispose();
            });
            pnButton.add(btnSave);
            JButton btnCancel = new JButton("Cancel");
            btnCancel.addActionListener(eCancel -> {
                keyFrame.dispose();
            });
            pnButton.add(btnCancel);

            keyFrame.add(pnButton, BorderLayout.SOUTH);
            keyFrame.setVisible(true);
        });
        add(btnInputKey);

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
        btnProcess.addActionListener(new PlayfairCipherController(this));
        add(btnProcess);
    }

    public JTextField getTxtMessage() {
        return txtMessage;
    }

    public JTextField getTxtResult() {
        return txtResult;
    }

    public Character[][] getKeyMatrix() {
        return keyMatrix;
    }

    public JButton getSpnKey() {
        return btnInputKey;
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

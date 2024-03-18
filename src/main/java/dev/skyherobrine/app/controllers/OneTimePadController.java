package dev.skyherobrine.app.controllers;

import dev.skyherobrine.app.views.panels.OneTimePadPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OneTimePadController implements ActionListener {

    private OneTimePadPanel otpp;

    public OneTimePadController(OneTimePadPanel otpp) {
        this.otpp = otpp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnSource = (JButton) e.getSource();

        if(otpp.getTxtMessage().getText().length() != otpp.getTxtKey().getText().length()) {
            JOptionPane.showMessageDialog(otpp, "Message and Key have to same as length", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (btnSource.getText().equalsIgnoreCase("Encrypt")) {
            String message = otpp.getTxtMessage().getText().toUpperCase();
            String key = otpp.getTxtKey().getText().toUpperCase();
            otpp.getTxtResult().setText(encrypt(message, key));
        } else {
            String message = otpp.getTxtMessage().getText().toUpperCase();
            String key = otpp.getTxtKey().getText().toUpperCase();
            otpp.getTxtResult().setText(decrypt(message, key));
        }
    }

    private String encrypt(String message, String key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            char k = key.charAt(i);
            int cIndex = c - 65;
            int kIndex = k - 65;
            int rIndex = (cIndex + kIndex) % 26;
            char r = (char) (rIndex + 65);
            result.append(r);
        }

        return result.toString();
    }

    private String decrypt(String message, String key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            char k = key.charAt(i);
            int cIndex = c - 65;
            int kIndex = k - 65;
            int rIndex = (cIndex - kIndex + 26) % 26;
            char r = (char) (rIndex + 65);
            result.append(r);
        }

        return result.toString();
    }
}

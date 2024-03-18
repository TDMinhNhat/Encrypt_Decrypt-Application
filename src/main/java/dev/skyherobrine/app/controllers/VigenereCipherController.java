package dev.skyherobrine.app.controllers;

import dev.skyherobrine.app.views.panels.VigenereCipherPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VigenereCipherController implements ActionListener {

    private VigenereCipherPanel vcp;

    public VigenereCipherController(VigenereCipherPanel vcp) {
        this.vcp = vcp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnSource = (JButton) e.getSource();
        if(btnSource.getText().equalsIgnoreCase("Encrypt")) {
            String message = vcp.getTxtMessage().getText().toUpperCase();
            String key = vcp.getTxtKey().getText().toUpperCase();
            vcp.getTxtResult().setText(encrypt(message, key));
        } else {
            String message = vcp.getTxtMessage().getText().toUpperCase();
            String key = vcp.getTxtKey().getText().toUpperCase();
            vcp.getTxtResult().setText(decrypt(message, key));
        }
    }

    private String encrypt(String message, String key) {
        String result = "";
        int keyIndex = 0;
        for(int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                result += (char) ((c + key.charAt(keyIndex) - 2 * 'A') % 26 + 'A');
                keyIndex = ++keyIndex % key.length();
            } else {
                result += c;
            }
        }
        return result;
    }

    private String decrypt(String message, String key) {
        String result = "";
        int keyIndex = 0;
        for(int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                result += (char) ((c - key.charAt(keyIndex) + 26) % 26 + 'A');
                keyIndex = ++keyIndex % key.length();
            } else {
                result += c;
            }
        }
        return result;
    }
}

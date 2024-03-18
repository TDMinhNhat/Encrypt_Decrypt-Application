package dev.skyherobrine.app.controllers;

import dev.skyherobrine.app.views.panels.MonoalphabeticCipherPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonoalphabeticCipherController implements ActionListener {

    private MonoalphabeticCipherPanel mcp;

    public MonoalphabeticCipherController(MonoalphabeticCipherPanel mcp) {
        this.mcp = mcp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnSource = (JButton) e.getSource();
        if(btnSource.getText().equalsIgnoreCase("Encrypt")) {
            String message = mcp.getTxtMessage().getText().toUpperCase();
            String key = mcp.getTxtKey().getText().toUpperCase();
            String result = encrypt(message, key);
            mcp.getTxtResult().setText(result);
        } else {
            String message = mcp.getTxtMessage().getText().toUpperCase();
            String key = mcp.getTxtKey().getText().toUpperCase();
            String result = decrypt(message, key);
            mcp.getTxtResult().setText(result);

        }
    }

    private String encrypt(String message, String key) {
        String result = "";
        for(int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                int pos = c - 'A';
                result += key.charAt(pos);
            } else {
                result += c;
            }
        }
        return result;
    }

    private String decrypt(String message, String key) {
        String result = "";
        for(int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                int pos = key.indexOf(c);
                result += (char) ('A' + pos);
            } else {
                result += c;
            }
        }
        return result;
    }
}

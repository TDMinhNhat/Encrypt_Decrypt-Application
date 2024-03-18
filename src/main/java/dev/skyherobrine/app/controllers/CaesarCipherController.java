package dev.skyherobrine.app.controllers;

import dev.skyherobrine.app.views.panels.CaesarCipherPanel;

import javax.swing.*;
import java.awt.event.*;

public class CaesarCipherController implements ActionListener {

    private CaesarCipherPanel ccp;

    public CaesarCipherController(CaesarCipherPanel ccp) {
        this.ccp = ccp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnSource = (JButton) e.getSource();
        if(btnSource.getText().equalsIgnoreCase("Encrypt")) {
            String result = encrypt(ccp.getTxtMessage().getText().toUpperCase(),
                    Integer.parseInt(ccp.getSpnKey().getValue().toString()));

            ccp.getTxtResult().setText(result);
        } else {
            String result = decrypt(ccp.getTxtMessage().getText().toUpperCase(),
                    Integer.parseInt(ccp.getSpnKey().getValue().toString()));

            ccp.getTxtResult().setText(result);
        }
    }

    private String encrypt(String message, int key) {
        String result = "";
        for(int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + key);
                if(ch > 'Z') {
                    ch = (char) (ch - 26);
                }
            }
            result += ch;
        }
        return result;
    }

    private String decrypt(String message, int key) {
        String result = "";
        for(int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch - key);
                if(ch < 'A') {
                    ch = (char) (ch + 26);
                }
            }
            result += ch;
        }
        return result;
    }
}

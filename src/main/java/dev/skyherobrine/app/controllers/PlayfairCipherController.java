package dev.skyherobrine.app.controllers;

import dev.skyherobrine.app.views.panels.PlayfairCipherPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayfairCipherController implements ActionListener {

    private PlayfairCipherPanel pcp;

    public PlayfairCipherController(PlayfairCipherPanel pcp) {
        this.pcp = pcp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(pcp.getKeyMatrix() == null) {
            JOptionPane.showMessageDialog(pcp, "Please enter the key matrix", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JButton btnSource = (JButton) e.getSource();
        if(btnSource.getText().equalsIgnoreCase("Encrypt")) {
            String message = pcp.getTxtMessage().getText().toUpperCase().replace(" ", "");
            Character[][] keyMatrix = pcp.getKeyMatrix();
            pcp.getTxtResult().setText(encrypt(message, keyMatrix));
        } else {
            String message = pcp.getTxtMessage().getText().toUpperCase().replace(" ", "");
            Character[][] keyMatrix = pcp.getKeyMatrix();
            pcp.getTxtResult().setText(decrypt(message, keyMatrix));
        }
    }

    private String encrypt(String message, Character[][] keyMatrix) {
        String result = "";
        for(int i = 0; i < message.length(); i += 2) {
            char c1 = message.charAt(i);
            char c2 = message.charAt(i + 1);
            int r1 = 0, r2 = 0;
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(keyMatrix[j][k] == c1) {
                        r1 = j;
                        c1 = (char) k;
                    }
                    if(keyMatrix[j][k] == c2) {
                        r2 = j;
                        c2 = (char) k;
                    }
                }
            }
            if(r1 == r2) {
                result += keyMatrix[r1][(c1 + 1) % 5];
                result += keyMatrix[r2][(c2 + 1) % 5];
            } else if(c1 == c2) {
                result += keyMatrix[(r1 + 1) % 5][c1];
                result += keyMatrix[(r2 + 1) % 5][c2];
            } else {
                result += keyMatrix[r1][c2];
                result += keyMatrix[r2][c1];
            }
        }
        return result;
    }

    private String decrypt(String message, Character[][] keyMatrix) {
        String result = "";
        for(int i = 0; i < message.length(); i += 2) {
            char c1 = message.charAt(i);
            char c2 = message.charAt(i + 1);
            int r1 = 0, r2 = 0;
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(keyMatrix[j][k] == c1) {
                        r1 = j;
                        c1 = (char) k;
                    }
                    if(keyMatrix[j][k] == c2) {
                        r2 = j;
                        c2 = (char) k;
                    }
                }
            }
            if(r1 == r2) {
                result += keyMatrix[r1][(c1 + 4) % 5];
                result += keyMatrix[r2][(c2 + 4) % 5];
            } else if(c1 == c2) {
                result += keyMatrix[(r1 + 4) % 5][c1];
                result += keyMatrix[(r2 + 4) % 5][c2];
            } else {
                result += keyMatrix[r1][c2];
                result += keyMatrix[r2][c1];
            }
        }
        return result;
    }
}

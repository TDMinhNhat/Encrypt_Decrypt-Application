package dev.skyherobrine.app.controllers;

import dev.skyherobrine.app.views.panels.RailFenceCipherPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RailFenceCipherController implements ActionListener {
    private RailFenceCipherPanel rfcp;

    public RailFenceCipherController(RailFenceCipherPanel rfcp) {
        this.rfcp = rfcp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnSource = (JButton) e.getSource();
        if (btnSource.getText().equalsIgnoreCase("Encrypt")) {
            String message = rfcp.getTxtMessage().getText().toUpperCase().replace(" ", "");
            int heights = Integer.parseInt(rfcp.getSpnKey().getValue().toString());
            rfcp.getTxtResult().setText(encrypt(message, heights));
        } else {
            String message = rfcp.getTxtMessage().getText().toUpperCase().replace(" ", "");
            int heights = Integer.parseInt(rfcp.getSpnKey().getValue().toString());
            rfcp.getTxtResult().setText(decrypt(message, heights));
        }
    }

    private String encrypt(String message, int heights) {
        String result = "";

        List<List<Character>> rails = new ArrayList<>(heights);
        for (int i = 0; i < heights; i++) {
            rails.add(new ArrayList<>());
        }

        int currentRail = 0;
        boolean down = true;
        for (int i = 0; i < message.length(); i++) {
            rails.get(currentRail).add(message.charAt(i));
            if (down) {
                currentRail++;
            } else {
                currentRail--;
            }
            if (currentRail == heights - 1) {
                down = false;
            } else if (currentRail == 0) {
                down = true;
            }
        }

        for (List<Character> rail : rails) {
            for (Character ch : rail) {
                result += ch;
            }
        }

        return result;
    }

    private String decrypt(String message, int heights) {
        String result = "";

        List<List<Character>> rails = new ArrayList<>(heights);
        for (int i = 0; i < heights; i++) {
            rails.add(new ArrayList<>());
        }

        int currentRail = 0;
        boolean down = true;
        for (int i = 0; i < message.length(); i++) {
            rails.get(currentRail).add(null);
            if (down) {
                currentRail++;
            } else {
                currentRail--;
            }
            if (currentRail == heights - 1) {
                down = false;
            } else if (currentRail == 0) {
                down = true;
            }
        }

        int index = 0;
        for (int i = 0; i < heights; i++) {
            for (int j = 0; j < rails.get(i).size(); j++) {
                rails.get(i).set(j, message.charAt(index));
                index++;
            }
        }

        currentRail = 0;
        down = true;
        for (int i = 0; i < message.length(); i++) {
            result += rails.get(currentRail).get(0);
            rails.get(currentRail).remove(0);
            if (down) {
                currentRail++;
            } else {
                currentRail--;
            }
            if (currentRail == heights - 1) {
                down = false;
            } else if (currentRail == 0) {
                down = true;
            }
        }
        return result;
    }
}

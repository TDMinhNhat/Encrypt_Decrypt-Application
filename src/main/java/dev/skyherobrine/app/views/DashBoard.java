package dev.skyherobrine.app.views;

import dev.skyherobrine.app.views.panels.*;
import javax.swing.*;
import java.awt.*;

public class DashBoard extends JFrame {
    public DashBoard() {
        setLayout(new BorderLayout());

        JTabbedPane tpDB = new JTabbedPane();
        tpDB.addTab("Caesar", new CaesarCipherPanel());
        tpDB.addTab("Monoalphabetic", new MonoalphabeticCipherPanel());
        tpDB.addTab("Playfair", new PlayfairCipherPanel());
        tpDB.addTab("Vigenere", new VigenereCipherPanel());
        tpDB.addTab("OneTimePad", new OneTimePadPanel());
        tpDB.addTab("RailFence", new RailFenceCipherPanel());

        add(tpDB, BorderLayout.CENTER);
        setResizable(false);
        setTitle("DashBoard");
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 400);
    }
}

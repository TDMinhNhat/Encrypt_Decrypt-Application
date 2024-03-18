package dev.skyherobrine.app.views;

import dev.skyherobrine.app.views.panels.*;
import javax.swing.*;
import java.awt.*;

public class DashBoard extends JFrame {
    public DashBoard() {
        setLayout(new BorderLayout());

        JTabbedPane tpDB = new JTabbedPane();
        tpDB.addTab("Caesar", new CaesarCipherPanel());

        add(tpDB, BorderLayout.CENTER);
        setTitle("DashBoard");
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
    }
}

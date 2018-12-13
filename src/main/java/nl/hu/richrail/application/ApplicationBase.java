package nl.hu.richrail.application;

import javax.swing.*;
import java.awt.*;

public abstract class ApplicationBase extends JFrame {

    protected abstract String getWindowTitle();

    protected abstract Dimension getWindowSize();

    protected abstract void setupWindow();

    public void createAndShow() {
        setupWindow();

        // Configure window.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(getWindowSize());
        setPreferredSize(getWindowSize());
        setTitle(getWindowTitle());
        setResizable(false);

        // Center.
        setLocationRelativeTo(null);

        // Show.
        pack();
        setVisible(true);
    }

}

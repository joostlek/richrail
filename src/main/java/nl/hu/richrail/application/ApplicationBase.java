package nl.hu.richrail.application;

import nl.hu.richrail.persistence.StorageMethod;

import javax.swing.*;
import java.awt.*;

public abstract class ApplicationBase extends JFrame {

    protected final StorageMethod storage;

    public ApplicationBase(StorageMethod storage) {
        this.storage = storage;
    }

    protected abstract String getWindowTitle();

    protected abstract Dimension getWindowSize();

    protected abstract boolean isWindowResizable();

    protected abstract void setupWindow();

    public void createAndShow() {
        setupWindow();

        // Configure window.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(getWindowSize());
        setPreferredSize(getWindowSize());
        setTitle(getWindowTitle());
        setResizable(isWindowResizable());

        // Center.
        setLocationRelativeTo(null);

        // Show.
        pack();
        setVisible(true);
    }

}

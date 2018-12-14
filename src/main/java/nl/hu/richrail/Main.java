package nl.hu.richrail;

import nl.hu.richrail.application.ApplicationPicker;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ApplicationPicker().createAndShow());
    }

}

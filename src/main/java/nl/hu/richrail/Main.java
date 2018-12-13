package nl.hu.richrail;

import nl.hu.richrail.application.ApplicationPicker;
import nl.hu.richrail.services.TrainFacade;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ApplicationPicker().createAndShow());
    }

}

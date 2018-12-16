package nl.hu.richrail.application.gui.listeners;

import nl.hu.richrail.application.gui.items.ComponentComboItem;
import nl.hu.richrail.exceptions.TrainServiceException;
import nl.hu.richrail.services.TrainService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateWagonListener implements ActionListener {

    private static final Logger logger = Logger.getLogger(CreateWagonListener.class.getName());

    private final TrainService trainService;

    private final JLabel selectedTrain;

    private final JTextField wagonName;

    private final JComboBox<ComponentComboItem> wagonTypes;

    private final JSpinner wagonSeats;

    public CreateWagonListener(TrainService trainService, JLabel selectedTrain, JTextField wagonName,
                               JComboBox<ComponentComboItem> wagonTypes, JSpinner wagonSeats) {
        this.trainService = trainService;
        this.selectedTrain = selectedTrain;
        this.wagonName = wagonName;
        this.wagonTypes = wagonTypes;
        this.wagonSeats = wagonSeats;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Just to be safe.
        if (this.wagonTypes.getSelectedItem() == null) {
            logger.log(Level.INFO, "No wagon type was selected.");
            return;
        }

        // Get currently selected train key.
        String selectedTrainKey = selectedTrain.getText();

        // Check if not set, default is "Geen".
        if (selectedTrainKey.equalsIgnoreCase("geen")) {
            JOptionPane.showMessageDialog(null, "Je moet eerst een trein selecteren.", "Oeps!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get all properties.
        String wagonName = this.wagonName.getText();
        ComponentComboItem wagonType = (ComponentComboItem) this.wagonTypes.getSelectedItem();
        Integer wagonSeats = (Integer) this.wagonSeats.getValue();

        try {
            // Create rolling component.
            this.trainService.createComponent(selectedTrainKey, wagonName, wagonType.getValue(), wagonSeats);
        } catch (TrainServiceException e1) {
            logger.log(Level.SEVERE, e1.getMessage());
            JOptionPane.showMessageDialog(null, e1.getErrorMessage(), "Foutje!", JOptionPane.ERROR_MESSAGE);
        }
    }

}

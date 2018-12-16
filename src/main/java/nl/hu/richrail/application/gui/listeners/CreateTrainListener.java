package nl.hu.richrail.application.gui.listeners;

import nl.hu.richrail.exceptions.TrainServiceException;
import nl.hu.richrail.services.TrainService;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateTrainListener implements ActionListener {

    private static final Logger logger = Logger.getLogger(CreateTrainListener.class.getName());

    private final TrainService trainService;

    private final JTextField trainNameField;

    public CreateTrainListener(TrainService trainService, JTextField trainNameField) {
        this.trainService = trainService;
        this.trainNameField = trainNameField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String trainName = this.trainNameField.getText();

        if (trainName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Je moet een trein naam invullen.", "Oeps!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            this.trainService.createTrain(trainName);
        } catch (TrainServiceException e1) {
            logger.log(Level.SEVERE, e1.getMessage());
            JOptionPane.showMessageDialog(null, e1.getErrorMessage(), "Foutje!", JOptionPane.ERROR_MESSAGE);
        } finally {
            this.trainNameField.setText("");
        }
    }

}

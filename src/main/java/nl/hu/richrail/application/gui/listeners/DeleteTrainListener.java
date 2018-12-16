package nl.hu.richrail.application.gui.listeners;

import nl.hu.richrail.exceptions.TrainServiceException;
import nl.hu.richrail.services.TrainService;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteTrainListener implements ActionListener {

    private static final Logger logger = Logger.getLogger(CreateTrainListener.class.getName());

    private final TrainService trainService;

    private final JComboBox<String> comboAvailableTrains;

    public DeleteTrainListener(TrainService trainService, JComboBox<String> comboAvailableTrains) {
        this.trainService = trainService;
        this.comboAvailableTrains = comboAvailableTrains;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.comboAvailableTrains.getSelectedIndex() == -1) {
            return;
        }

        String selectedItem = (String) this.comboAvailableTrains.getSelectedItem();

        int value = JOptionPane.showConfirmDialog(null,
                String.format("Weet je zeker dat je de trein '%s' wilt verwijderen?", selectedItem),
                "Vraagje..", JOptionPane.YES_NO_OPTION);

        if (value == JOptionPane.YES_OPTION) {
            try {
                this.trainService.deleteTrain(selectedItem);
            } catch (TrainServiceException e1) {
                logger.log(Level.SEVERE, e1.getMessage());
                JOptionPane.showMessageDialog(null, e1.getErrorMessage(), "Foutje!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}

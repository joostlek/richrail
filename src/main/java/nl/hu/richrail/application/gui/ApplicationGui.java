package nl.hu.richrail.application.gui;

import nl.hu.richrail.application.ApplicationBase;
import nl.hu.richrail.application.gui.listeners.CreateTrainListener;
import nl.hu.richrail.persistence.StorageMethod;
import nl.hu.richrail.services.TrainService;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationGui extends ApplicationBase {

    private final ApplicationGuiForm form;

    private final TrainService trainService;

    public ApplicationGui(StorageMethod storage) {
        super(storage);
        this.trainService = new TrainService(storage.getTrainRepository());
        this.form = new ApplicationGuiForm();
    }

    @Override
    protected String getWindowTitle() {
        return "RichRail - GUI";
    }

    @Override
    protected Dimension getWindowSize() {
        return new Dimension(800, 500);
    }

    @Override
    protected boolean isWindowResizable() {
        return true;
    }

    @Override
    protected void setupWindow() {
        this.form.getButtonCreate().addActionListener(new CreateTrainListener(this.trainService, this.form.getNewTrainName()));

        setContentPane(this.form.$$$getRootComponent$$$());
    }

}

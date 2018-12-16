package nl.hu.richrail.application.gui;

import nl.hu.richrail.application.ApplicationBase;
import nl.hu.richrail.application.gui.items.ComponentComboItem;
import nl.hu.richrail.application.gui.listeners.CreateTrainListener;
import nl.hu.richrail.application.gui.listeners.CreateWagonListener;
import nl.hu.richrail.application.gui.listeners.DeleteTrainListener;
import nl.hu.richrail.domain.Train;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentType;
import nl.hu.richrail.persistence.StorageMethod;
import nl.hu.richrail.persistence.events.ComponentRepositoryEvents;
import nl.hu.richrail.persistence.events.TrainRepositoryEvents;
import nl.hu.richrail.services.TrainService;

import java.awt.Dimension;

public class ApplicationGui extends ApplicationBase {

    private final ApplicationGuiForm form;

    private final TrainRepositoryEvents trainRepository;

    private final ComponentRepositoryEvents componentRepository;

    private final TrainService trainService;

    private String selectedTrainKey;

    public ApplicationGui(StorageMethod storage) {
        super(storage);
        this.trainRepository = new TrainRepositoryEvents(storage.getTrainRepository());
        this.componentRepository = new ComponentRepositoryEvents(storage.getComponentRepository());
        this.trainService = new TrainService(this.trainRepository, this.componentRepository);
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
        // Add values to fields.
        this.form.getWagonTypes().addItem(new ComponentComboItem("Wagon", RollingComponentType.Wagon));
        this.form.getWagonTypes().addItem(new ComponentComboItem("Locomotief", RollingComponentType.Locomotive));

        // Add button listeners.
        this.form.getButtonCreate().addActionListener(new CreateTrainListener(this.trainService, this.form.getNewTrainName()));
        this.form.getButtonDelete().addActionListener(new DeleteTrainListener(this.trainService, this.form.getAvailableTrains()));
        this.form.getButtonCreateWagon().addActionListener(new CreateWagonListener(this.trainService,
                this.form.getSelectedTrain(),
                this.form.getWagonName(),
                this.form.getWagonTypes(),
                this.form.getWagonSeats()));

        // Add watches.
        this.form.getAvailableTrains().addItemListener(e -> {
            if (this.form.getAvailableTrains().getSelectedIndex() != -1) {
                String newSelectedTrain = (String) this.form.getAvailableTrains().getSelectedItem();

                if (this.selectedTrainKey == null || !this.selectedTrainKey.equals(newSelectedTrain)) {
                    this.setSelectedTrain(newSelectedTrain);
                }
            } else {
                this.setSelectedTrain(null);
            }
        });

        this.form.getWagonTypes().addItemListener(e -> {
            ComponentComboItem item = (ComponentComboItem) e.getItem();
            this.form.getWagonSeats().setEnabled(item.getValue() == RollingComponentType.Wagon);
        });

        // Add service event handlers.
        this.trainRepository.getEventManager().subscribe("save", eventType -> refreshTrains());
        this.trainRepository.getEventManager().subscribe("delete", eventType -> refreshTrains());

        // Start rendering the GUI.
        setContentPane(this.form.$$$getRootComponent$$$());

        // Load initial data.
        refreshTrains();
    }

    private void setSelectedTrain(String key) {
        this.selectedTrainKey = key;

        if (key == null) {
            this.form.getSelectedTrain().setText("Geen");
            return;
        }

        this.form.getSelectedTrain().setText(this.selectedTrainKey);
    }

    private void refreshTrains() {
        this.form.getAvailableTrains().removeAllItems();

        for (Train train : this.trainRepository.getAllTrains()) {
            this.form.getAvailableTrains().addItem(train.getKey());
        }
    }

}

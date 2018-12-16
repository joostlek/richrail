package nl.hu.richrail.application.cli;

import nl.hu.richrail.application.ApplicationBase;
import nl.hu.richrail.application.cli.listeners.ExecuteListener;
import nl.hu.richrail.application.cli.parser.RichRailCliCallback;
import nl.hu.richrail.application.cli.parser.RichRailCliProcessor;
import nl.hu.richrail.persistence.StorageMethod;
import nl.hu.richrail.persistence.events.ComponentRepositoryEvents;
import nl.hu.richrail.persistence.events.TrainRepositoryEvents;
import nl.hu.richrail.services.TrainService;
import nl.hu.richrail.utils.CliUtils;

import java.awt.*;

public class ApplicationCli extends ApplicationBase implements RichRailCliCallback {

    private final ApplicationCliForm form;

    private final TrainRepositoryEvents trainRepository;

    private final ComponentRepositoryEvents componentRepository;

    private final TrainService trainService;

    private final RichRailCliProcessor cliProcessor;

    public ApplicationCli(StorageMethod storage) {
        super(storage);
        this.form = new ApplicationCliForm();
        this.trainRepository = new TrainRepositoryEvents(storage.getTrainRepository());
        this.componentRepository = new ComponentRepositoryEvents(storage.getComponentRepository());
        this.trainService = new TrainService(this.trainRepository, this.componentRepository);
        this.cliProcessor = new RichRailCliProcessor(this.trainService, this);
    }

    @Override
    protected String getWindowTitle() {
        return "RichRail - CLI";
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
        // Add button listeners.
        ExecuteListener executeListener = new ExecuteListener(this.cliProcessor, this.form.getCommandText());

        this.form.getCommandText().addKeyListener(executeListener);
        this.form.getButtonExecute().addActionListener(executeListener);

        // Add service event handlers.
        this.trainRepository.getEventManager().subscribe("save", eventType -> updateOverview());
        this.trainRepository.getEventManager().subscribe("delete", eventType -> updateOverview());
        this.componentRepository.getEventManager().subscribe("save", eventType -> updateOverview());
        this.componentRepository.getEventManager().subscribe("update", eventType -> updateOverview());
        this.componentRepository.getEventManager().subscribe("delete", eventType -> updateOverview());

        // Start rendering the GUI.
        setContentPane(this.form.$$$getRootComponent$$$());

        // Load initial data.
        updateOverview();
    }

    @Override
    public void writeMessage(String message) {
        this.form.getTextLog().setText(this.form.getTextLog().getText() + message + "\n");
    }

    @Override
    public void updateOverview() {
        this.form.getTextOverview().setText(
                CliUtils.getComponentsString(this.componentRepository.getAllComponents()) +
                        CliUtils.getTrainsString(this.trainService.getTrainsWithComponents())
        );
    }

    @Override
    public void updateDrawing() {
        // TODO (Mike): Visualize trains.
        // this.form.getDrawPanel()
    }

}

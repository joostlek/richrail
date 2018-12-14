package nl.hu.richrail.application.cli;

import nl.hu.richrail.application.ApplicationBase;
import nl.hu.richrail.services.TrainService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ApplicationCliGui extends ApplicationBase {

    @Override
    protected String getWindowTitle() {
        return "RichRail - CLI";
    }

    @Override
    protected Dimension getWindowSize() {
        return new Dimension(400, 300);
    }

    @Override
    protected void setupWindow() {
        TrainService trainService = TrainService.getInstance();

        ApplicationCli.ExampleCliInputs();

        JPanel body = new JPanel();
        body.setLayout(new GridLayout(0, 1, 20, 20));
        body.setBorder(new EmptyBorder(20, 20, 20, 20));
        body.add(new JLabel("<html><center>CLI</center></html>"));

        // textarea with available rollingcomponents and trains
        String availableResults = trainService.getRollingComponentsString() + trainService.getTrainsString();
        JTextArea textArea = new JTextArea(availableResults);
        JScrollPane jScrollPane = new JScrollPane(textArea);
        body.add(jScrollPane);

        setContentPane(body);
    }
}

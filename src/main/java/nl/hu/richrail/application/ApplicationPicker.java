package nl.hu.richrail.application;

import nl.hu.richrail.application.cli.ApplicationCli;
import nl.hu.richrail.application.gui.ApplicationGui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ApplicationPicker extends ApplicationBase {

    @Override
    protected String getWindowTitle() {
        return "RichRail - Keuze menu";
    }

    @Override
    protected Dimension getWindowSize() {
        return new Dimension(400, 300);
    }

    @Override
    protected void setupWindow() {
        JPanel body = new JPanel();
        JButton buttonGui = new JButton("Grafische gebruikers interface");
        JButton buttonCli = new JButton("Command line interface");

        body.setLayout(new GridLayout(0, 1, 20, 20));
        body.setBorder(new EmptyBorder(20, 20, 20, 20));
        body.add(new JLabel("<html><center>Welkom in de RichRail applicatie, kies hieronder je gewenste gebruikmethode.</center></html>"));
        body.add(buttonGui);
        body.add(buttonCli);

        buttonGui.addActionListener(e -> startApplication(Applications.GUI));
        buttonCli.addActionListener(e -> startApplication(Applications.CLI));

        setContentPane(body);
    }

    private void startApplication(Applications app) {
        ApplicationBase application;

        switch (app) {
            case CLI:
                application = new ApplicationCli();
                break;

            case GUI:
                application = new ApplicationGui();
                break;

            default:
                throw new IllegalArgumentException(app.toString());
        }

        // Remove ourselves.
        dispose();

        // Open sub-window.
        application.createAndShow();
    }

}

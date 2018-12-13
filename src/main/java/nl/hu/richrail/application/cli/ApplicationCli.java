package nl.hu.richrail.application.cli;

import nl.hu.richrail.application.ApplicationBase;

import java.awt.*;

public class ApplicationCli extends ApplicationBase {

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

    }

}

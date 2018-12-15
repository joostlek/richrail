package nl.hu.richrail.application.gui;

import nl.hu.richrail.application.ApplicationBase;

import java.awt.Dimension;

public class ApplicationGui extends ApplicationBase {

    @Override
    protected String getWindowTitle() {
        return "RichRail - GUI";
    }

    @Override
    protected Dimension getWindowSize() {
        return new Dimension(800, 400);
    }

    @Override
    protected boolean isWindowResizable() {
        return true;
    }

    @Override
    protected void setupWindow() {
        ApplicationGuiForm form = new ApplicationGuiForm();

        setContentPane(form.$$$getRootComponent$$$());
    }

}

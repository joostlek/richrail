package nl.hu.richrail.application.gui;

import nl.hu.richrail.application.ApplicationBase;
import nl.hu.richrail.persistence.StorageMethod;

import java.awt.Dimension;

public class ApplicationGui extends ApplicationBase {

    public ApplicationGui(StorageMethod storage) {
        super(storage);
    }

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

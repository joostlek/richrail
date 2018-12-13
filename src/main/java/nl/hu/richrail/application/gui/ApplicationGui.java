package nl.hu.richrail.application.gui;

import nl.hu.richrail.application.ApplicationBase;

import javax.swing.*;
import java.awt.*;

public class ApplicationGui extends ApplicationBase {

    @Override
    protected String getWindowTitle() {
        return "RichRail - GUI";
    }

    @Override
    protected Dimension getWindowSize() {
        return new Dimension(400, 300);
    }

    @Override
    protected void setupWindow() {
        JButton button = new JButton();

        button.setBounds(130, 100, 100, 40);
        button.setText("Hoi");
        button.addActionListener(e -> ((JButton) e.getSource()).setText("Doei"));
    }

}

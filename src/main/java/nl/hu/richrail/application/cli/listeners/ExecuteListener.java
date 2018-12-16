package nl.hu.richrail.application.cli.listeners;

import nl.hu.richrail.application.cli.parser.RichRailCliProcessor;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ExecuteListener implements ActionListener, KeyListener {

    private final RichRailCliProcessor processor;

    private final JTextField commandText;

    public ExecuteListener(RichRailCliProcessor processor, JTextField commandText) {
        this.processor = processor;
        this.commandText = commandText;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Ignored.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            actionPerformed(null);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Ignored.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = this.commandText.getText();

        if (command == null || command.isEmpty()) {
            return;
        }

        this.processor.parse(command);
        this.commandText.setText("");
    }
}

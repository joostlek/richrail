package nl.hu.richrail;

import nl.hu.richrail.application.cli.RichRailCli;
import nl.hu.richrail.application.gui.RichRailGui;

public class Main {
    public static void main(String[] args) {
        RichRailCli.start();
        RichRailGui.start();
    }
}

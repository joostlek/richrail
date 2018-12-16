package nl.hu.richrail.application.cli.parser;

public interface RichRailCliCallback {

    void writeMessage(String message);

    void updateOverview();

    void updateDrawing();

}

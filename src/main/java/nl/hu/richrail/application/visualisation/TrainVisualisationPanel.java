package nl.hu.richrail.application.visualisation;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class TrainVisualisationPanel extends JPanel {

    private static final int TRAIN_OFFSET = 100;

    private static final int TRAIN_LENGTH = 100;

    private final MouseTracker tracker;

    private List<Train> trains;

    public TrainVisualisationPanel() {
        this.trains = new ArrayList<>();
        this.tracker = new MouseTracker(this::repaint);
        this.addMouseListener(this.tracker);
        this.addMouseMotionListener(this.tracker);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw instructions.
        g.setColor(Color.black);
        g.drawString("Linker muisknop = Rondkijken / Rechter muisknop = Reset", 10, 20);

        // Clone so it is not modified during paint.
        Point offset = (Point) this.tracker.getOffset().clone();

        for (int trainIndex = 0; trainIndex < trains.size(); trainIndex++) {
            drawTrain(g, offset, trainIndex, trains.get(trainIndex));
        }
    }

    private void drawTrain(Graphics g, Point offset, int trainIndex, Train train) {
        // Draw a train.
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(offset.x + 30, offset.y + 80 + trainIndex * TRAIN_OFFSET, 80, 40);
        g.fillRect(offset.x + 80, offset.y + 60 + trainIndex * TRAIN_OFFSET, 30, 30);
        g.drawRoundRect(offset.x + 85, offset.y + 40 + trainIndex * TRAIN_OFFSET, 20, 20, 20, 20);
        g.drawRoundRect(offset.x + 85, offset.y + trainIndex * TRAIN_OFFSET, 40, 40, 40, 40);
        g.setColor(Color.BLACK);
        g.fillRoundRect(offset.x + 35, offset.y + 120 + trainIndex * TRAIN_OFFSET, 20, 20, 20, 20);
        g.fillRoundRect(offset.x + 80, offset.y + 120 + trainIndex * TRAIN_OFFSET, 20, 20, 20, 20);
        g.drawString(train.getKey(), offset.x + 40, offset.y + 105 + trainIndex * TRAIN_OFFSET);

        // Draw the components.
        List<RollingComponent> components = train.getAllComponents();

        for (int componentIndex = 0; componentIndex < components.size(); componentIndex++) {
            drawComponent(g, offset, trainIndex, componentIndex + 1, components.get(componentIndex));
        }
    }

    private void drawComponent(Graphics g, Point offset, int trainIndex, int componentIndex, RollingComponent component) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(offset.x + 30 + componentIndex * TRAIN_LENGTH, offset.y + 80 + trainIndex * TRAIN_OFFSET, 80, 40);
        g.setColor(Color.BLACK);
        g.fillRoundRect(offset.x + 35 + componentIndex * TRAIN_LENGTH, offset.y + 120 + trainIndex * TRAIN_OFFSET, 20, 20, 20, 20);
        g.fillRoundRect(offset.x + 80 + componentIndex * TRAIN_LENGTH, offset.y + 120 + trainIndex * TRAIN_OFFSET, 20, 20, 20, 20);
        g.drawString(component.getKey(), offset.x + 40 + componentIndex * TRAIN_LENGTH, offset.y + 105 + trainIndex * TRAIN_OFFSET);
    }

}

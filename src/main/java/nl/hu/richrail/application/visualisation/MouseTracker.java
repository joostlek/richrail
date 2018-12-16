package nl.hu.richrail.application.visualisation;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseTracker implements MouseListener, MouseMotionListener {

    private final MouseTrackerCallback callback;

    private Point mouseLocation;

    private Point offset;

    MouseTracker(MouseTrackerCallback callback) {
        this.callback = callback;
        this.offset = new Point(0, 0);
    }

    public Point getOffset() {
        return offset;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Ignored.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            this.offset.setLocation(0, 0);
            this.callback.updated();
            return;
        }

        this.mouseLocation = e.getPoint();
        this.callback.updated();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Ignored.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Ignored.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Ignored.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int deltaX = e.getX() - this.mouseLocation.x;
        int deltaY = e.getY() - this.mouseLocation.y;

        this.offset.setLocation(this.offset.x + deltaX, this.offset.y + deltaY);
        this.mouseLocation = e.getPoint();
        this.callback.updated();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Ignored.
    }

}

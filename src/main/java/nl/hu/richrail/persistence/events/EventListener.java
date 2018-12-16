package nl.hu.richrail.persistence.events;

public interface EventListener {

    void notified(String eventType);

}

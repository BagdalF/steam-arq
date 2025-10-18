package notificacao;

import java.util.*;

public class EventBus {
    private final Map<EventType, List<EventListener>> listeners = new HashMap<>();

    public synchronized void register(EventType type, EventListener listener) {
        listeners.computeIfAbsent(type, k -> new ArrayList<>()).add(listener);
    }

    public synchronized void unregister(EventType type, EventListener listener) {
        List<EventListener> list = listeners.get(type);
        if (list != null) list.remove(listener);
    }

    public void publish(Event event) {
        List<EventListener> copy;
        synchronized (this) {
            copy = listeners.getOrDefault(event.getType(), Collections.emptyList());
            copy = new ArrayList<>(copy); // snapshot
        }
        for (EventListener l : copy) {
            try {
                l.onEvent(event);
            } catch (Exception ex) {
                System.err.println("Erro ao notificar listener: " + ex.getMessage());
            }
        }
    }
}

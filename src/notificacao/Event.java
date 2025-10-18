package notificacao;

import java.util.Map;

public class Event {
    private final EventType type;
    private final Map<String, Object> payload;
    private final String message;

    public Event(EventType type, Map<String, Object> payload, String message) {
        this.type = type;
        this.payload = payload;
        this.message = message;
    }

    public EventType getType() { return type; }
    public Map<String, Object> getPayload() { return payload; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        return "Event{" +
                "type=" + type +
                ", message='" + message + '\'' +
                ", payload=" + payload +
                '}';
    }
}

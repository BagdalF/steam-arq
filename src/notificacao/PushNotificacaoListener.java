package notificacao;

import java.util.Map;

public class PushNotificacaoListener implements EventListener {
    @Override
    public void onEvent(Event event) {
        // Protótipo: apenas printar. Em produção, integraria com Firebase/APNs etc.
        System.out.println("[PushNotificacao] Event: " + event.getType() + " | " + event.getMessage());
        Map<String, Object> p = event.getPayload();
        if (p != null) {
            System.out.println("  Target userId: " + p.get("userId") + " - Data: " + p);
        }
    }
}

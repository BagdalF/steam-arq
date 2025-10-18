package notificacao;

import java.util.Map;

public class EmailNotificacaoListener implements EventListener {
    private final String fromAddress;

    public EmailNotificacaoListener(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    @Override
    public void onEvent(Event event) {
        // Protótipo: apenas printar. Em produção, aqui iria a integração SMTP/service de e-mail.
        System.out.println("[EmailNotificacao] From: " + fromAddress + " | Event: " + event.getType());
        System.out.println("  Message: " + event.getMessage());
        Map<String, Object> p = event.getPayload();
        if (p != null) System.out.println("  Payload: " + p);
    }
}

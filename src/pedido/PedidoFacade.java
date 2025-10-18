package pedido;

import java.util.HashMap;
import java.util.Map;
import notificacao.Event;
import notificacao.EventBus;
import notificacao.EventType;
import usuario.UsuarioCadastrado;

public class PedidoFacade {
    private final PedidoService pedidoService;
    private final EventBus eventBus;

    public PedidoFacade(PedidoService pedidoService, EventBus eventBus) {
        this.pedidoService = pedidoService;
        this.eventBus = eventBus;
    }

    /**
     * Realiza o checkout: processa pagamento via PedidoService (que agora usa Strategy/Factory),
     * adiciona jogos à biblioteca do usuário e publica eventos no EventBus.
     *
     * @param user referência do usuário cadastrado
     * @param pedido pedido com itens preenchidos
     * @param metodo método de pagamento (ex: "pix","cartao","paypal")
     * @param referencia referência para a factory (chave Pix / número cartão / email paypal)
     * @return true se sucesso
     */
    public boolean checkout(UsuarioCadastrado user, Pedido pedido, String metodo, String referencia) {
        boolean ok = pedidoService.finalizarPagamento(pedido, metodo, referencia);

        Map<String, Object> payload = new HashMap<>();
        payload.put("orderId", pedido.getId());
        payload.put("userId", user.getId());
        payload.put("total", pedido.getCarrinho().calcularTotal());

        if (ok) {
            // adicionar jogos à biblioteca do usuário
            pedido.getCarrinho().getItens().forEach(user::gerenciarBibliotecaAdd);

            // publica evento de compra concluída
            Event event = new Event(EventType.PURCHASE_COMPLETED, payload, "Compra realizada com sucesso.");
            eventBus.publish(event);

            // evento de pagamento confirmado (opcional, redundante)
            Event payEvent = new Event(EventType.PAYMENT_CONFIRMED, payload, "Pagamento confirmado.");
            eventBus.publish(payEvent);

            return true;
        } else {
            Event failed = new Event(EventType.PAYMENT_FAILED, payload, "Falha ao processar pagamento.");
            eventBus.publish(failed);
            return false;
        }
    }
}

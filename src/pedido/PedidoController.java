package pedido;

import jogo.Jogo;

public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    public Pedido criarPedido() {
        return service.criarPedido();
    }

    public void adicionarItem(Pedido pedido, Jogo jogo) {
        service.adicionarItemAoCarrinho(pedido, jogo);
    }

    public void finalizarPagamento(Pedido pedido, Pedido.Pagamento pagamento) {
        boolean ok = service.finalizarPagamento(pedido, pagamento);
        System.out.println("Resultado do pagamento (controller): " + ok);
    }
}

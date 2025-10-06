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

    /**
     * Novo método: usa Strategy + Factory de pagamento.
     */
    public void finalizarPagamento(Pedido pedido, String metodo, String referencia) {
        boolean ok = service.finalizarPagamento(pedido, metodo, referencia);
        System.out.println("Resultado do pagamento (controller): " + ok);
    }
}

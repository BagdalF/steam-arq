package pedido;

import jogo.Jogo;

/**
 * Camada Controller responsável por orquestrar requisições relacionadas a
 * Pedido. Recebe chamadas externas (ex: interface gráfica ou API) e delega para
 * o PedidoService.
 *
 * Relação na arquitetura: - Depende de PedidoService para executar operações de
 * negócio. - Não acessa diretamente o repositório ou entidades.
 */
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

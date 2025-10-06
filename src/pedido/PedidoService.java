package pedido;

import java.util.Optional;
import jogo.Jogo;
import pagamento.PagamentoFactory;
import pagamento.PagamentoStrategy;

public class PedidoService {
    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido criarPedido() {
        Pedido p = new Pedido();
        repository.save(p);
        System.out.println("Pedido criado: " + p.getId());
        return p;
    }

    public void adicionarItemAoCarrinho(Pedido pedido, Jogo jogo) {
        pedido.getCarrinho().adicionarItem(jogo);
    }

    public double calcularTotal(Pedido pedido) {
        return pedido.getCarrinho().calcularTotal();
    }

    /**
     * Novo método com Strategy + Factory para processar pagamento.
     */
    public boolean finalizarPagamento(Pedido pedido, String metodo, String referencia) {
        double total = pedido.getCarrinho().calcularTotal();
        PagamentoStrategy pagamento = PagamentoFactory.create(metodo, referencia);

        boolean processed = pagamento.process(total);
        boolean confirmed = false;

        if (processed) {
            confirmed = pagamento.confirm();
        }

        if (confirmed) {
            pedido.confirmar();
            repository.save(pedido);
            System.out.println("Pagamento bem-sucedido via " + metodo + "!");
            System.out.println(pagamento.getReceipt());
            return true;
        }

        System.out.println("Falha ao processar pagamento.");
        return false;
    }

    public Optional<Pedido> buscar(int id) {
        return repository.findById(id);
    }
}

package pedido;

import java.util.Optional;
import jogo.Jogo;

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

    public boolean finalizarPagamento(Pedido pedido, Pedido.Pagamento pagamento) {
        pedido.setPagamento(pagamento);
        boolean ok = pagamento.processar();
        if (ok) {
            boolean conf = pagamento.confirmar();
            if (conf) {
                pedido.confirmar();
                repository.save(pedido);
                System.out.println("Pagamento e confirmação OK para pedido " + pedido.getId());
                return true;
            }
        }
        return false;
    }

    public Optional<Pedido> buscar(int id) {
        return repository.findById(id);
    }
}

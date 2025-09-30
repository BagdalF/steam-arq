import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Pedido {
    private static final AtomicInteger COUNTER = new AtomicInteger(1);

    private final int id;
    private final LocalDateTime data;
    private String status; // ex: PENDENTE, CONFIRMADO, CANCELADO
    private final Carrinho carrinho;
    private Pagamento pagamento;

    public Pedido(int id, Carrinho carrinho) {
        this.id = id;
        this.data = LocalDateTime.now();
        this.status = "PENDENTE";
        this.carrinho = carrinho;
    }

    public static int generateId() {
        return COUNTER.getAndIncrement();
    }

    public void confirmar(Pagamento pagamento) {
        this.pagamento = pagamento;
        pagamento.confirmar();
        this.status = "CONFIRMADO";
        System.out.println("Pedido " + id + " confirmado em " + data);
    }

    public void cancelar() {
        this.status = "CANCELADO";
        System.out.println("Pedido " + id + " cancelado.");
    }

    // getters
    public int getId() { return id; }
    public String getStatus() { return status; }
    public Carrinho getCarrinho() { return carrinho; }
    public Pagamento getPagamento() { return pagamento; }
}

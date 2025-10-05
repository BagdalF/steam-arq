package pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import jogo.Jogo;

public class Pedido {

    private static final AtomicInteger SEQ = new AtomicInteger(1);

    private int id;
    private LocalDateTime data;
    private String status;
    private Carrinho carrinho;
    private Pagamento pagamento;

    public Pedido() {
        this.id = SEQ.getAndIncrement();
        this.data = LocalDateTime.now();
        this.status = "CRiado";
        this.carrinho = new Carrinho();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void confirmar() {
        this.status = "CONFIRMADO";
        System.out.println("Pedido " + id + " confirmado.");
    }

    public void cancelar() {
        this.status = "CANCELADO";
        System.out.println("Pedido " + id + " cancelado.");
    }

    // Classe interna Carrinho
    public static class Carrinho {

        private final List<Jogo> itens = new ArrayList<>();

        public void adicionarItem(Jogo jogo) {
            itens.add(jogo);
            System.out.println("Item adicionado ao carrinho: " + jogo.getTitulo());
        }

        public void removerItem(Jogo jogo) {
            itens.remove(jogo);
            System.out.println("Item removido do carrinho: " + jogo.getTitulo());
        }

        public double calcularTotal() {
            return itens.stream().mapToDouble(Jogo::getPreco).sum();
        }

        public List<Jogo> getItens() {
            return new ArrayList<>(itens);
        }
    }

    // Classe interna Pagamento
    public static class Pagamento {

        private int id;
        private double valor;
        private String metodo;
        private String status;

        public Pagamento() {
        }

        public Pagamento(int id, double valor, String metodo) {
            this.id = id;
            this.valor = valor;
            this.metodo = metodo;
            this.status = "PENDENTE";
        }

        public int getId() {
            return id;
        }

        public double getValor() {
            return valor;
        }

        public String getMetodo() {
            return metodo;
        }

        public boolean processar() {
            System.out.println("Processando pagamento via " + metodo + " no valor " + valor);
            this.status = "PROCESSADO";
            return true;
        }

        public boolean confirmar() {
            if ("PROCESSADO".equals(status)) {
                this.status = "CONFIRMADO";
                System.out.println("Pagamento confirmado.");
                return true;
            }
            return false;
        }

        public String gerarRecibo() {
            return "Recibo{" + "id=" + id + ", valor=" + valor + ", metodo='" + metodo + "'}";
        }
    }
}

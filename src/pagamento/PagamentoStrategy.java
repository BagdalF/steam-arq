package pagamento;

public interface PagamentoStrategy {
    boolean process(double amount);
    boolean confirm();
    String getReceipt();
}

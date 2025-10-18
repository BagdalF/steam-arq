package pagamento;

/**
 * Estratégia de pagamento via Pix.
 */
public class PagamentoPix implements PagamentoStrategy {
    private final String chavePix;
    private double lastAmount;

    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public boolean process(double amount) {
        this.lastAmount = amount;
        System.out.println("[Pix] Enviando cobrança de R$" + amount + " para chave: " + chavePix);
        return true;
    }

    @Override
    public boolean confirm() {
        System.out.println("[Pix] Pagamento confirmado automaticamente!");
        return true;
    }

    @Override
    public String getReceipt() {
        return "Recibo (Pix) - Valor: R$" + lastAmount + ", Chave: " + chavePix;
    }
}

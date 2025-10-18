package pagamento;

/**
 * Estratégia de pagamento via PayPal.
 */
public class PagamentoPayPal implements PagamentoStrategy {
    private final String email;
    private double lastAmount;

    public PagamentoPayPal(String email) {
        this.email = email;
    }

    @Override
    public boolean process(double amount) {
        this.lastAmount = amount;
        System.out.println("[PayPal] Processando pagamento de R$" + amount + " com conta " + email);
        return true;
    }

    @Override
    public boolean confirm() {
        System.out.println("[PayPal] Pagamento confirmado pelo provedor.");
        return true;
    }

    @Override
    public String getReceipt() {
        return "Recibo (PayPal) - Valor: R$" + lastAmount + ", Conta: " + email;
    }
}

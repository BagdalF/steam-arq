package pagamento;

/**
 * Estratégia de pagamento com Cartão de Crédito.
 */
public class PagamentoCartaoCredito implements PagamentoStrategy {
    private final String cardNumber;
    private double lastAmount;

    public PagamentoCartaoCredito(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean process(double amount) {
        this.lastAmount = amount;
        System.out.println("[Cartão] Processando pagamento de R$" + amount + " com cartão " + cardNumber);
        return true;
    }

    @Override
    public boolean confirm() {
        System.out.println("[Cartão] Pagamento confirmado!");
        return true;
    }

    @Override
    public String getReceipt() {
        return "Recibo (Cartão) - Valor: R$" + lastAmount + ", Cartão: ****" + cardNumber.substring(cardNumber.length() - 4);
    }
}

package pagamento;

/**
 * Fábrica responsável por instanciar a estratégia de pagamento apropriada.
 */
public class PagamentoFactory {

    public static PagamentoStrategy create(String metodo, String referencia) {
        switch (metodo.toLowerCase()) {
            case "cartao":
                return new PagamentoCartaoCredito(referencia);
            case "pix":
                return new PagamentoPix(referencia);
            case "paypal":
                return new PagamentoPayPal(referencia);
            default:
                throw new IllegalArgumentException("Método de pagamento não suportado: " + metodo);
        }
    }
}

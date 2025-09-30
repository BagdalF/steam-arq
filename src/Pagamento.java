public class Pagamento {
    private final int id;
    private final double valor;
    private final String metodo; // ex: cartão, pix
    private String status; // PROCESSANDO, CONFIRMADO, RECUSADO

    public Pagamento(int id, double valor, String metodo) {
        this.id = id;
        this.valor = valor;
        this.metodo = metodo;
        this.status = "PROCESSANDO";
    }

    public boolean processar(SistemaPagamentoExterno sistema) {
        System.out.println("Processando pagamento id " + id + " valor R$" + valor + " via " + metodo);
        boolean sucesso = sistema.processPayment(this);
        this.status = sucesso ? "CONFIRMADO" : "RECUSADO";
        System.out.println("Pagamento " + id + ": " + status);
        return sucesso;
    }

    public void confirmar() {
        this.status = "CONFIRMADO";
        System.out.println("Pagamento " + id + " confirmado (interno).");
    }

    public void gerarRecibo() {
        System.out.println("Gerando recibo para pagamento " + id + " (R$" + valor + ")");
    }

    // getters
    public double getValor() { return valor; }
    public String getMetodo() { return metodo; }
}

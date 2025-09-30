/**
 * externo - simulação do sistema de pagamento.
 */
public class SistemaPagamentoExterno {
    public boolean processPayment(Pagamento pagamento) {
        // stub: sempre retorna true como se o serviço externo aprovasse o pagamento
        System.out.println("Sistema de Pagamento externo processando valor R$" + pagamento.getValor());
        return true;
    }
}

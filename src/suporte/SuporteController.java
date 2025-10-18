package suporte;

/**
 * Camada Controller responsável por orquestrar requisições relacionadas a
 * Suporte. Recebe chamadas externas (ex: interface gráfica ou API) e delega
 * para o SuporteService.
 *
 * Relação na arquitetura: - Depende de SuporteService para executar operações
 * de negócio. - Não acessa diretamente o repositório ou entidades.
 */
public class SuporteController {

    private final SuporteService service;

    public SuporteController(SuporteService service) {
        this.service = service;
    }

    public Suporte abrirTicket(String descricao) {
        return service.abrirTicket(descricao);
    }

    public void solicitarReembolso(Suporte ticket, double valor) {
        // Esse é o include: SolicitarReembolso -> ProcessarReembolso (Equipe de Suporte)
        service.processarReembolso(ticket, valor);
    }
}

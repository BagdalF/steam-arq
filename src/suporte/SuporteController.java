package suporte;

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

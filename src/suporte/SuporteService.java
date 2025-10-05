package suporte;

public class SuporteService {

    private final SuporteRepository repository;

    public SuporteService(SuporteRepository repository) {
        this.repository = repository;
    }

    public Suporte abrirTicket(String descricao) {
        Suporte s = new Suporte(0, descricao);
        s.abrir();
        repository.save(s);
        return s;
    }

    public void processarReembolso(Suporte ticket, double valor) {
        // Processo de reembolso (protótipo)
        System.out.println("Processando reembolso para ticket " + ticket.getId() + " valor: " + valor);
        ticket.atribuirEquipe("EquipeFinanceira");
        ticket.fechar();
        repository.save(ticket);
    }

    public void atribuir(Suporte ticket, String membro) {
        ticket.atribuirEquipe(membro);
        repository.save(ticket);
    }
}

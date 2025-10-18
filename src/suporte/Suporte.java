package suporte;

/**
 * Entidade principal que representa um ticket de suporte na plataforma. Cada
 * Suporte possui id, descrição, status e responsável.
 *
 * Relação na arquitetura: - Suporte é criado e manipulado pelo SuporteService.
 * - SuporteRepository é responsável por persistir instâncias de Suporte. -
 * SuporteController expõe operações relacionadas a Suporte para camadas
 * superiores (ex: UI).
 */
public class Suporte {

    private int id;
    private String descricao;
    private String status;
    private String responsavel;

    public Suporte() {
    }

    public Suporte(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.status = "ABERTO";
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void abrir() {
        this.status = "ABERTO";
        System.out.println("Ticket aberto: " + id);
    }

    public void fechar() {
        this.status = "FECHADO";
        System.out.println("Ticket fechado: " + id);
    }

    public void atribuirEquipe(String membro) {
        this.responsavel = membro;
        System.out.println("Atribuído a: " + membro);
    }

    @Override
    public String toString() {
        return "Suporte{" + "id=" + id + ", descricao='" + descricao + '\'' + ", status='" + status + '\'' + '}';
    }
}

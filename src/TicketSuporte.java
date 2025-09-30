public class TicketSuporte {
    private static int COUNTER = 1;
    private final int id;
    private final String descricao;
    private String status; // ABERTO, EM_PROGRESO, FECHADO
    private final UsuarioCadastrado solicitante;
    private EquipeSuporte equipeResponsavel;

    public TicketSuporte(UsuarioCadastrado solicitante, String descricao) {
        this.id = COUNTER++;
        this.solicitante = solicitante;
        this.descricao = descricao;
        this.status = "ABERTO";
    }

    public void abrir() {
        System.out.println("Ticket " + id + " aberto por " + solicitante.getNome() + ": " + descricao);
    }

    public void fechar() {
        this.status = "FECHADO";
        System.out.println("Ticket " + id + " fechado.");
    }

    public void atribuirEquipe(EquipeSuporte equipe) {
        this.equipeResponsavel = equipe;
        System.out.println("Ticket " + id + " atribuído à equipe.");
    }

    public int getId() { return id; }
}

import java.util.ArrayList;
import java.util.List;

public class EquipeSuporte {
    private final List<String> membros = new ArrayList<>();

    public EquipeSuporte(List<String> membros) {
        this.membros.addAll(membros);
    }

    public void processarReembolso(Pedido pedido) {
        System.out.println("Equipe de suporte processando reembolso para pedido " + pedido.getId());
        pedido.cancelar();
        System.out.println("Reembolso processado para pedido " + pedido.getId());
    }

    public void responderTicket(TicketSuporte ticket) {
        System.out.println("Equipe de suporte respondendo ticket " + ticket.getId());
        ticket.fechar();
    }
}
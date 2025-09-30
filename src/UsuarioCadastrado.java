import java.util.ArrayList;
import java.util.List;

public class UsuarioCadastrado extends Usuario {
    private final Biblioteca biblioteca;
    private final List<Pedido> pedidos;
    private final List<ItemVirtual> itensVirtuais;
    private final List<TicketSuporte> tickets;

    public UsuarioCadastrado(int id, String nome, String email, String senhaHash) {
        super(id, nome, email, senhaHash);
        this.biblioteca = new Biblioteca(this);
        this.pedidos = new ArrayList<>();
        this.itensVirtuais = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public Biblioteca getBiblioteca() { return biblioteca; }

    public void gerenciarBiblioteca() {
        System.out.println("Gerenciando biblioteca de " + nome);
        biblioteca.listarJogos();
    }

    public void gerenciarItemVirtual() {
        System.out.println("Gerenciando itens virtuais de " + nome);
        for (ItemVirtual it : itensVirtuais) {
            System.out.println(" - " + it.getNome() + " (R$" + it.getPreco() + ")");
        }
    }

    public void adicionarItemVirtual(ItemVirtual item) {
        itensVirtuais.add(item);
        System.out.println("Item virtual adicionado: " + item.getNome());
    }

    public Pedido criarPedido(Carrinho carrinho) {
        Pedido p = new Pedido(Pedido.generateId(), carrinho);
        pedidos.add(p);
        System.out.println("Pedido criado com id " + p.getId());
        return p;
    }

    public void abrirTicket(TicketSuporte ticket) {
        tickets.add(ticket);
        System.out.println("Ticket aberto: " + ticket.getId());
    }

    // getters for lists
    public List<Pedido> getPedidos() { return pedidos; }
    public List<ItemVirtual> getItensVirtuais() { return itensVirtuais; }
    public List<TicketSuporte> getTickets() { return tickets; }
}

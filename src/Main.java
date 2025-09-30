import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Cria catálogo e jogos
        Catalogo catalogo = new Catalogo();
        Jogo jogo1 = new Jogo(1, "Space Adventure", 79.90, "Aventura", "4GB RAM");
        Jogo jogo2 = new Jogo(2, "Racing Pro", 49.90, "Corrida", "8GB RAM");
        catalogo.adicionarJogo(jogo1);
        catalogo.adicionarJogo(jogo2);

        // Usuário não cadastrado cria conta
        UsuarioNaoCadastrado anon = new UsuarioNaoCadastrado();
        UsuarioCadastrado user = anon.criarConta(100, "Carlos", "carlos@example.com", "senha123");

        // Usuário navega catálogo e adiciona ao carrinho
        catalogo.listarJogos();
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarItem(jogo1);
        carrinho.calcularTotal();

        // Criar pedido e processar pagamento
        Pedido pedido = user.criarPedido(carrinho);
        Pagamento pagamento = new Pagamento(500, carrinho.calcularTotal(), "Cartão");
        SistemaPagamentoExterno sistemaPagamento = new SistemaPagamentoExterno();
        boolean sucesso = pagamento.processar(sistemaPagamento);
        if (sucesso) {
            pedido.confirmar(pagamento);
            pagamento.gerarRecibo();
            // adicionar jogo à biblioteca do usuário
            user.getBiblioteca().adicionarJogo(jogo1);
        }

        // Usuário abre ticket de suporte e solicita reembolso
        TicketSuporte ticket = new TicketSuporte(user, "Problema com instalação do jogo");
        user.abrirTicket(ticket);
        ticket.abrir();

        // Solicitação de reembolso: include -> processar reembolso pela equipe
        EquipeSuporte equipe = new EquipeSuporte(Arrays.asList("Ana", "Bruno"));
        equipe.processarReembolso(pedido); // processa e cancela o pedido

        // Equipe responde ticket
        equipe.responderTicket(ticket);

        // Gerenciar biblioteca - includes e extends demonstrados por métodos
        user.gerenciarBiblioteca();
    }
}

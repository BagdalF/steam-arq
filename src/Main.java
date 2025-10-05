
import item.*;
import jogo.*;
import pedido.*;
import suporte.*;
import usuario.*;

public class Main {

    public static void main(String[] args) {
        // Repositorios
        JogoRepository jogoRepo = new JogoRepository();
        ItemRepository itemRepo = new ItemRepository();
        PedidoRepository pedidoRepo = new PedidoRepository();
        SuporteRepository suporteRepo = new SuporteRepository();
        UsuarioRepository usuarioRepo = new UsuarioRepository();

        // Services
        JogoService jogoService = new JogoService(jogoRepo);
        ItemService itemService = new ItemService(itemRepo);
        PedidoService pedidoService = new PedidoService(pedidoRepo);
        SuporteService suporteService = new SuporteService(suporteRepo);
        UsuarioService usuarioService = new UsuarioService(usuarioRepo);

        // Controllers
        JogoController jogoCtrl = new JogoController(jogoService);
        ItemController itemCtrl = new ItemController(itemService);
        PedidoController pedidoCtrl = new PedidoController(pedidoService);
        SuporteController suporteCtrl = new SuporteController(suporteService);
        UsuarioController usuarioCtrl = new UsuarioController(usuarioService);

        // Cenário de demonstração (protótipo)
        // 1) criar usuário (UsuarioCadastrado)
        UsuarioCadastrado usuario = usuarioCtrl.criarConta("Alice", "alice@example.com", "senha123");

        // 2) criar jogos e itens
        Jogo j1 = jogoCtrl.criarJogo("Space Adventure", 49.90, "Aventura", "4GB RAM");
        Jogo j2 = jogoCtrl.criarJogo("Racing Pro", 29.90, "Corrida", "8GB RAM");

        // 3) adicionar ao carrinho e criar pedido
        Pedido pedido = pedidoCtrl.criarPedido();
        pedidoCtrl.adicionarItem(pedido, j1);
        pedidoCtrl.adicionarItem(pedido, j2);

        // 4) calcular total e processar pagamento
        double total = pedidoService.calcularTotal(pedido);
        System.out.println("Total do pedido: " + total);
        Pedido.Pagamento pagamento = new Pedido.Pagamento(1, total, "CartaoCredito");
        pedidoCtrl.finalizarPagamento(pedido, pagamento);

        // 5) adicionar jogos à biblioteca do usuário (simula pós-compra)
        usuario.gerenciarBibliotecaAdd(j1);
        usuario.gerenciarBibliotecaAdd(j2);

        // 6) iniciar jogo (extend)
        jogoCtrl.iniciar(j1.getId());

        // 7) abrir ticket e solicitar reembolso (include -> equipe suporte processa)
        Suporte ticket = suporteCtrl.abrirTicket("Problema ao instalar Space Adventure");
        suporteCtrl.solicitarReembolso(ticket, 49.90);

        // 8) criar item virtual e comprar
        Item item = itemCtrl.criarItem("Skin Dourada", 5.0);
        itemCtrl.comprarItem(usuario, item.getId());

        System.out.println("Demo finalizada.");
    }
}

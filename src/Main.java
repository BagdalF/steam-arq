import jogo.Jogo;
import jogo.JogoController;
import jogo.JogoRepository;
import jogo.JogoService;
import notificacao.EmailNotificacaoListener;
import notificacao.EventBus;
import notificacao.PushNotificacaoListener;
import pedido.Pedido;
import pedido.PedidoController;
import pedido.PedidoFacade;
import pedido.PedidoRepository;
import pedido.PedidoService;
import usuario.UsuarioCadastrado;
import usuario.UsuarioController;
import usuario.UsuarioRepository;
import usuario.UsuarioService;

public class Main {
    public static void main(String[] args) {
        // Repositórios e services existentes
        JogoRepository jogoRepo = new JogoRepository();
        PedidoRepository pedidoRepo = new PedidoRepository();
        UsuarioRepository usuarioRepo = new UsuarioRepository();

        JogoService jogoService = new JogoService(jogoRepo);
        PedidoService pedidoService = new PedidoService(pedidoRepo);
        UsuarioService usuarioService = new UsuarioService(usuarioRepo);

        JogoController jogoCtrl = new JogoController(jogoService);
        PedidoController pedidoCtrl = new PedidoController(pedidoService);
        UsuarioController usuarioCtrl = new UsuarioController(usuarioService);

        // EventBus e listeners
        EventBus eventBus = new EventBus();
        eventBus.register(notificacao.EventType.PURCHASE_COMPLETED, new EmailNotificacaoListener("no-reply@minha-plataforma.com"));
        eventBus.register(notificacao.EventType.PURCHASE_COMPLETED, new PushNotificacaoListener());
        eventBus.register(notificacao.EventType.PAYMENT_FAILED, new EmailNotificacaoListener("ops@minha-plataforma.com"));

        // Facade
        PedidoFacade purchaseFacade = new PedidoFacade(pedidoService, eventBus);

        // Demo
        UsuarioCadastrado usuario = usuarioCtrl.criarConta("Alice", "alice@example.com", "senha123");
        Jogo j1 = jogoCtrl.criarJogo("Space Adventure", 49.90, "Aventura", "4GB RAM");
        Jogo j2 = jogoCtrl.criarJogo("Racing Pro", 29.90, "Corrida", "8GB RAM");

        Pedido pedido = pedidoCtrl.criarPedido();
        pedidoCtrl.adicionarItem(pedido, j1);
        pedidoCtrl.adicionarItem(pedido, j2);

        // Usar o facade para checkout — isso publica eventos que os listeners irão tratar
        boolean sucesso = purchaseFacade.checkout(usuario, pedido, "pix", "alice@pix.com");
        System.out.println("Checkout succeeded? " + sucesso);
    }
}

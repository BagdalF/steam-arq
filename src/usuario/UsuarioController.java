package usuario;

public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    public UsuarioCadastrado criarConta(String nome, String email, String senha) {
        return service.criarConta(nome, email, senha);
    }

    public boolean autenticar(Usuario u, String senha) {
        return service.autenticar(u, senha);
    }

    public void atualizarPerfil(Usuario u, String novoNome, String novoEmail) {
        service.atualizarPerfil(u, novoNome, novoEmail);
    }
}

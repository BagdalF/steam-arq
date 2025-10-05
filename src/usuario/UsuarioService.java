package usuario;

public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioCadastrado criarConta(String nome, String email, String senha) {
        UsuarioCadastrado u = new UsuarioCadastrado(0, nome, email, senha);
        repository.save(u);
        System.out.println("Conta criada para " + email);
        return u;
    }

    public boolean autenticar(Usuario u, String senha) {
        return u.autenticar(senha);
    }

    public void atualizarPerfil(Usuario u, String novoNome, String novoEmail) {
        u.atualizarPerfil(novoNome, novoEmail);
        repository.save(u);
    }
}

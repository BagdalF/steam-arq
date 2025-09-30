public class UsuarioNaoCadastrado extends Usuario {

    public UsuarioNaoCadastrado() {
        super(-1, "não cadastrado", "", "");
    }

    public UsuarioCadastrado criarConta(int id, String nome, String email, String senhaHash) {
        System.out.println("Criando conta para: " + email);
        // retorna um novo UsuarioCadastrado (biblioteca vazia)
        UsuarioCadastrado novo = new UsuarioCadastrado(id, nome, email, senhaHash);
        System.out.println("Conta criada: " + novo.getEmail());
        return novo;
    }
}

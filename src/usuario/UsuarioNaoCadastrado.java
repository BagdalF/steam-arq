package usuario;

/**
 * Classe pública para Usuário Não Cadastrado. Permite criar conta (retorna um
 * UsuarioCadastrado).
 *
 * Relação na arquitetura: - Permite conversão de usuário não cadastrado para
 * cadastrado. - Manipulado por UsuarioService e UsuarioController.
 */
public class UsuarioNaoCadastrado extends Usuario {

    public UsuarioNaoCadastrado() {
        super();
    }

    /**
     * Cria uma conta de usuário cadastrado.
     *
     * @param newId id desejado (0 para repo atribuir)
     * @param nome nome do usuário
     * @param email email do usuário
     * @param senha senha em texto puro (protótipo)
     * @return UsuarioCadastrado instanciado
     */
    public UsuarioCadastrado criarConta(int newId, String nome, String email, String senha) {
        System.out.println("Criando conta para: " + email);
        UsuarioCadastrado u = new UsuarioCadastrado(newId, nome, email, senha);
        return u;
    }
}

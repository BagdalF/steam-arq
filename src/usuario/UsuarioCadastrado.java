package usuario;

import java.util.ArrayList;
import java.util.List;
import jogo.Jogo;

/**
 * Classe pública para Usuário Cadastrado. Extende Usuario e possui a composição
 * Biblioteca, que armazena os jogos do usuário.
 *
 * Relação na arquitetura: - Manipulado por UsuarioService e UsuarioController.
 * - Pode interagir com entidades Jogo (via Biblioteca).
 */
public class UsuarioCadastrado extends Usuario {

    private Biblioteca biblioteca = new Biblioteca();

    public UsuarioCadastrado() {
        super();
    }

    public UsuarioCadastrado(int id, String nome, String email, String senhaHash) {
        super(id, nome, email, senhaHash);
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void gerenciarBibliotecaAdd(Jogo jogo) {
        biblioteca.adicionarJogo(jogo);
    }

    public void gerenciarItemVirtual() {
        System.out.println("Gerenciando item virtual para usuário " + getNome());
    }

    // Classe pública estática aninhada para simplificar (pode ser extraída para arquivo separado se preferir)
    public static class Biblioteca {

        private final List<Jogo> jogos = new ArrayList<>();

        public void adicionarJogo(Jogo jogo) {
            jogos.add(jogo);
            System.out.println("Jogo adicionado à biblioteca: " + jogo.getTitulo());
        }

        public List<Jogo> listarJogos() {
            return new ArrayList<>(jogos);
        }

        public boolean possuiJogo(Jogo jogo) {
            return jogos.contains(jogo);
        }
    }
}

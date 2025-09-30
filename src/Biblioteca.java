import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final UsuarioCadastrado owner;
    private final List<Jogo> jogos = new ArrayList<>();

    public Biblioteca(UsuarioCadastrado owner) {
        this.owner = owner;
    }

    public void adicionarJogo(Jogo jogo) {
        jogos.add(jogo);
        System.out.println("Jogo '" + jogo.getTitulo() + "' adicionado à biblioteca de " + owner.getNome());
    }

    public void listarJogos() {
        System.out.println("Biblioteca de " + owner.getNome() + ":");
        if (jogos.isEmpty()) {
            System.out.println(" (vazia)");
        } else {
            for (Jogo j : jogos) {
                System.out.println(" - " + j.obterDetalhes());
            }
        }
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Catalogo {
    private final List<Jogo> jogos = new ArrayList<>();

    public void adicionarJogo(Jogo jogo) {
        jogos.add(jogo);
    }

    public List<Jogo> listarJogos() {
        System.out.println("Listando jogos do catálogo:");
        for (Jogo j : jogos) {
            System.out.println(" - " + j.obterDetalhes());
        }
        return jogos;
    }

    public List<Jogo> buscarPorTitulo(String titulo) {
        List<Jogo> encontrados = jogos.stream()
                .filter(j -> j.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("Busca por '" + titulo + "' retornou " + encontrados.size() + " resultados.");
        return encontrados;
    }
}

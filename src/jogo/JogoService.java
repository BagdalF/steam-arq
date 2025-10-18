package jogo;

import java.util.List;
import java.util.Optional;

/**
 * Camada de serviço responsável pela lógica de negócio relacionada a Jogo.
 * Interage com o JogoRepository para persistência e manipula entidades Jogo.
 *
 * Relação na arquitetura: - Recebe requisições do JogoController. - Utiliza
 * JogoRepository para persistência.
 */
public class JogoService {

    private final JogoRepository repository;

    public JogoService(JogoRepository repository) {
        this.repository = repository;
    }

    public Jogo addJogo(String titulo, double preco, String genero, String requisitos) {
        Jogo j = new Jogo(0, titulo, preco, genero, requisitos);
        return repository.save(j);
    }

    public List<Jogo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Jogo> buscarPorId(int id) {
        return repository.findById(id);
    }

    public List<Jogo> buscarPorTitulo(String titulo) {
        return repository.findByTitulo(titulo);
    }

    public boolean iniciarJogo(int id) {
        Optional<Jogo> opt = repository.findById(id);
        if (opt.isPresent()) {
            return opt.get().iniciar();
        }
        return false;
    }
}

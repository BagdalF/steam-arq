package jogo;

import java.util.List;
import java.util.Optional;

public class JogoController {

    private final JogoService service;

    public JogoController(JogoService service) {
        this.service = service;
    }

    public Jogo criarJogo(String titulo, double preco, String genero, String requisitos) {
        return service.addJogo(titulo, preco, genero, requisitos);
    }

    public List<Jogo> listarJogos() {
        return service.listarTodos();
    }

    public Optional<Jogo> buscar(int id) {
        return service.buscarPorId(id);
    }

    public void iniciar(int id) {
        boolean ok = service.iniciarJogo(id);
        System.out.println("Iniciar jogo resultado: " + ok);
    }
}

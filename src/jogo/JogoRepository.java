package jogo;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class JogoRepository {

    private final Map<Integer, Jogo> storage = new HashMap<>();
    private final AtomicInteger seq = new AtomicInteger(1);

    public Jogo save(Jogo jogo) {
        if (jogo.getId() == 0) {
            jogo.setId(seq.getAndIncrement());
        }
        storage.put(jogo.getId(), jogo);
        return jogo;
    }

    public Optional<Jogo> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Jogo> findAll() {
        return new ArrayList<>(storage.values());
    }

    public List<Jogo> findByTitulo(String titulo) {
        List<Jogo> res = new ArrayList<>();
        for (Jogo j : storage.values()) {
            if (j.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                res.add(j);
            }
        }
        return res;
    }

    public void delete(int id) {
        storage.remove(id);
    }
}

package suporte;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SuporteRepository {

    private final Map<Integer, Suporte> storage = new HashMap<>();
    private final AtomicInteger seq = new AtomicInteger(1);

    public Suporte save(Suporte s) {
        if (s.getId() == 0) {
            // reflect id in a simple way
            try {
                java.lang.reflect.Field f = Suporte.class.getDeclaredField("id");
                f.setAccessible(true);
                f.setInt(s, seq.getAndIncrement());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        storage.put(s.getId(), s);
        return s;
    }

    public Optional<Suporte> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }
}

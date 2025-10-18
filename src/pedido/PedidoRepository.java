package pedido;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Camada de persistência responsável por armazenar e recuperar instâncias de
 * Pedido. Utiliza um Map em memória como armazenamento (protótipo).
 *
 * Relação na arquitetura: - PedidoService utiliza o PedidoRepository para
 * persistir e buscar pedidos. - Não contém lógica de negócio, apenas operações
 * CRUD.
 */
public class PedidoRepository {

    private final Map<Integer, Pedido> storage = new HashMap<>();
    private final AtomicInteger seq = new AtomicInteger(1);

    public Pedido save(Pedido p) {
        if (p.getId() == 0) {
            // in our model, id is auto assigned in constructor; keep as-is
        }
        storage.put(p.getId(), p);
        return p;
    }

    public Optional<Pedido> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Pedido> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void delete(int id) {
        storage.remove(id);
    }
}

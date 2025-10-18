package item;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Camada de persistência responsável por armazenar e recuperar instâncias de
 * Item. Utiliza um Map em memória como armazenamento (protótipo).
 *
 * Relação na arquitetura: - ItemService utiliza o ItemRepository para persistir
 * e buscar itens. - Não contém lógica de negócio, apenas operações CRUD.
 */
public class ItemRepository {

    private final Map<Integer, Item> storage = new HashMap<>();
    private final AtomicInteger seq = new AtomicInteger(1);

    public Item save(Item item) {
        if (item.getId() == 0) {
            item.setId(seq.getAndIncrement());
        }
        storage.put(item.getId(), item);
        return item;
    }

    public Optional<Item> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Item> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void delete(int id) {
        storage.remove(id);
    }
}

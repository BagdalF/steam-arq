package item;

import java.util.Optional;
import usuario.UsuarioCadastrado;

public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Item createItem(String nome, double preco) {
        Item it = new Item(0, nome, preco);
        return repository.save(it);
    }

    public Optional<Item> getItem(int id) {
        return repository.findById(id);
    }

    public boolean comprarItem(UsuarioCadastrado usuario, int itemId) {
        Optional<Item> opt = repository.findById(itemId);
        if (opt.isPresent()) {
            Item item = opt.get();
            boolean ok = item.comprar();
            if (ok) {
                // Em protótipo, associamos item ao usuário como log (poderia adicionar a um inventário)
                System.out.println("Usuário " + usuario.getNome() + " comprou item: " + item.getNome());
            }
            return ok;
        }
        System.out.println("Item não encontrado: id=" + itemId);
        return false;
    }
}

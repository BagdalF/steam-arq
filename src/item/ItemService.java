package item;

import java.util.Optional;
import usuario.UsuarioCadastrado;

/**
 * Camada de serviço responsável pela lógica de negócio relacionada a Item.
 * Interage com o ItemRepository para persistência e manipula entidades Item.
 *
 * Relação na arquitetura: - Recebe requisições do ItemController. - Utiliza
 * ItemRepository para persistência. - Interage com Usuario Cadastro por
 * Associação (uso/dependência): o usuário é recebido como parâmetro em métodos
 * como comprarItem e apenas usado temporariamente.
 */
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

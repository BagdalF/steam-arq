package item;

import java.util.Optional;
import usuario.UsuarioCadastrado;

public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    public Item criarItem(String nome, double preco) {
        return service.createItem(nome, preco);
    }

    public void comprarItem(UsuarioCadastrado usuario, int itemId) {
        boolean result = service.comprarItem(usuario, itemId);
        System.out.println("Compra item (controller) resultado: " + result);
    }

    public Optional<Item> buscarItem(int id) {
        return service.getItem(id);
    }
}

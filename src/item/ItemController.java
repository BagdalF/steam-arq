package item;

import java.util.Optional;
import usuario.UsuarioCadastrado;

/**
 * Camada Controller responsável por orquestrar requisições relacionadas a Item.
 * Recebe chamadas externas (ex: interface gráfica ou API) e delega para o
 * ItemService.
 *
 * Relação na arquitetura: - Depende de ItemService para executar operações de
 * negócio. - Não acessa diretamente o repositório ou entidades.
 */
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

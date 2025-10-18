package item;

/**
 * Entidade principal que representa um item comercializável no sistema. Cada
 * Item possui um id único, nome e preço. Os métodos comprar() e vender()
 * simulam operações de negócio.
 *
 * Relação na arquitetura: - Item é persistido pelo ItemRepository. -
 * ItemService manipula instâncias de Item para lógica de negócio. -
 * ItemController expõe operações relacionadas a Item para camadas superiores
 * (ex: UI).
 */
public class Item {

    private int id;
    private String nome;
    private double preco;

    public Item() {
    }

    public Item(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    // getters / setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Métodos de negócio (protótipo)
    public boolean comprar() {
        System.out.println("Comprando item: " + nome);
        return true;
    }

    public boolean vender() {
        System.out.println("Vendendo item: " + nome);
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", nome='" + nome + '\'' + ", preco=" + preco + '}';
    }
}

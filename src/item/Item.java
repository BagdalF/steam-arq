package item;

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

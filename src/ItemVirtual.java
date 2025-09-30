public class ItemVirtual {
    private final int id;
    private final String nome;
    private final double preco;

    public ItemVirtual(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public void comprar(UsuarioCadastrado usuario) {
        System.out.println(usuario.getNome() + " comprou item virtual: " + nome);
        usuario.adicionarItemVirtual(this);
    }

    public void vender(UsuarioCadastrado usuario) {
        System.out.println(usuario.getNome() + " vendeu item virtual: " + nome);
        // stub: remover lógica omitida
    }

    // getters
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
}

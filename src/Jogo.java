public class Jogo {
    private final int id;
    private final String titulo;
    private final double preco;
    private final String genero;
    private final String requisitos;

    public Jogo(int id, String titulo, double preco, String genero, String requisitos) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
        this.genero = genero;
        this.requisitos = requisitos;
    }

    public String obterDetalhes() {
        return String.format("Jogo[id=%d, titulo=%s, preco=R$%.2f, genero=%s]", id, titulo, preco, genero);
    }

    public void iniciar() {
        System.out.println("Iniciando jogo: " + titulo + " ...");
    }

    // getters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public double getPreco() { return preco; }
}

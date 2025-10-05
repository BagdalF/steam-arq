package jogo;

public class Jogo {

    private int id;
    private String titulo;
    private double preco;
    private String genero;
    private String requisitos;

    public Jogo() {
    }

    public Jogo(int id, String titulo, double preco, String genero, String requisitos) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
        this.genero = genero;
        this.requisitos = requisitos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String obterDetalhes() {
        return "Jogo: " + titulo + " | Preço: " + preco + " | Gênero: " + genero + " | Requisitos: " + requisitos;
    }

    public boolean iniciar() {
        System.out.println("Iniciando jogo: " + titulo);
        return true;
    }

    @Override
    public String toString() {
        return "Jogo{" + "id=" + id + ", titulo='" + titulo + '\'' + ", preco=" + preco + '}';
    }
}

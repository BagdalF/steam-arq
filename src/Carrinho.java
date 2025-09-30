import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private final List<Jogo> itens = new ArrayList<>();

    public void adicionarItem(Jogo jogo) {
        itens.add(jogo);
        System.out.println("Adicionado ao carrinho: " + jogo.getTitulo());
    }

    public void removerItem(Jogo jogo) {
        if (itens.remove(jogo)) {
            System.out.println("Removido do carrinho: " + jogo.getTitulo());
        } else {
            System.out.println("Item não encontrado no carrinho: " + jogo.getTitulo());
        }
    }

    public double calcularTotal() {
        double total = itens.stream().mapToDouble(Jogo::getPreco).sum();
        System.out.printf("Total do carrinho: R$%.2f%n", total);
        return total;
    }

    public List<Jogo> getItens() {
        return itens;
    }
}

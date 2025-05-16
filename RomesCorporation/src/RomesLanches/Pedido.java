package RomesLanches;

import java.util.ArrayList;
import java.util.List;

// Exceção personalizada para pedido inválido
class PedidoInvalidoException extends Exception {
    public PedidoInvalidoException(String mensagem) {
        super(mensagem);
    }
}

// Classe para simular um pedido de lanches
public class Pedido {
    private List<Double> itens = new ArrayList<>();

    public void adicionarItem(double preco) {
        if (preco <= 0) throw new IllegalArgumentException("Preço inválido para item.");
        itens.add(preco);
    }

    public double calcularTotal() throws PedidoInvalidoException {
        if (itens.isEmpty()) throw new PedidoInvalidoException("O pedido está vazio.");
        double total = 0;
        try {
            for (double preco : itens) {
                total += preco;
            }
        } catch (ArithmeticException e) {
            System.err.println("Erro de cálculo: " + e.getMessage());
        }
        return total;
    }

    public static void main(String[] args) {
        Pedido pedido = new Pedido();

        try {
            pedido.adicionarItem(-5);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao adicionar item: " + e.getMessage());
        }

        try {
            double total = pedido.calcularTotal();
            System.out.println("Total do pedido: R$" + total);
        } catch (PedidoInvalidoException e) {
            System.err.println("Erro ao calcular pedido: " + e.getMessage());
        }
    }
}

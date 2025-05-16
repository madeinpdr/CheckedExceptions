package RomesStore;

//Exceção personalizada para estoque insuficiente
class EstoqueInsuficienteException extends Exception {
 public EstoqueInsuficienteException(String mensagem) {
     super(mensagem);
 }
}

//Classe de controle de estoque
public class Estoque {
 private int quantidade;

 public Estoque(int quantidadeInicial) {
     this.quantidade = quantidadeInicial;
 }

 public void adicionarProduto(int quantidade) {
     if (quantidade < 0) throw new IllegalArgumentException("Quantidade inválida para adicionar");
     this.quantidade += quantidade;
 }

 public void removerProduto(int quantidade) throws EstoqueInsuficienteException {
     if (quantidade < 0) throw new IllegalArgumentException("Quantidade inválida para remoção");
     if (quantidade > this.quantidade)
         throw new EstoqueInsuficienteException("Estoque insuficiente para remover " + quantidade + " unidades.");
     this.quantidade -= quantidade;
 }

 public int getQuantidade() {
     return quantidade;
 }

 public static void main(String[] args) {
     Estoque estoque = new Estoque(10);

     try {
         estoque.removerProduto(15);
     } catch (IllegalArgumentException | EstoqueInsuficienteException e) {
         System.err.println("Erro ao remover produto: " + e.getMessage());
     }

     try {
         estoque.adicionarProduto(-5);
     } catch (IllegalArgumentException e) {
         System.err.println("Erro ao adicionar produto: " + e.getMessage());
     }
 }
}

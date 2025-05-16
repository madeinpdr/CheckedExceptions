package RomesBank;

//Exceção personalizada para saldo insuficiente
class SaldoInsuficienteException extends Exception {
 public SaldoInsuficienteException(String mensagem) {
     super(mensagem);
 }
}

//Classe de conta corrente com funcionalidade de transferência
public class TransacaoBancaria {
 private double saldo;

 public TransacaoBancaria(double saldoInicial) {
     this.saldo = saldoInicial;
 }

 public void depositar(double valor) {
     if (valor < 0) throw new IllegalArgumentException("Valor de depósito inválido");
     saldo += valor;
 }

 public void transferir(double valor) throws SaldoInsuficienteException {
     if (valor <= 0) throw new IllegalArgumentException("Valor de transferência inválido");
     if (valor > saldo) throw new SaldoInsuficienteException("Saldo insuficiente para transferência.");
     saldo -= valor;
     System.out.println("Transferência de R$" + valor + " realizada com sucesso.");
 }

 public double getSaldo() {
     return saldo;
 }

 public static void main(String[] args) {
     TransacaoBancaria conta = new TransacaoBancaria(500);
     try {
         conta.transferir(600);
     } catch (IllegalArgumentException | SaldoInsuficienteException e) {
         System.err.println("Erro ao transferir: " + e.getMessage());
     }

     try {
         conta.depositar(-100);
     } catch (IllegalArgumentException e) {
         System.err.println("Erro no depósito: " + e.getMessage());
     }
 }
}

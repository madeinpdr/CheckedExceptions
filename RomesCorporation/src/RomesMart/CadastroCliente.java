package RomesMart;

//Exceção personalizada para e-mail inválido
class EmailInvalidoException extends Exception {
 public EmailInvalidoException(String mensagem) {
     super(mensagem);
 }
}

//Classe de cadastro de cliente
public class CadastroCliente {

 public void cadastrar(String nome, String email) throws EmailInvalidoException {
     if (nome == null || nome.trim().isEmpty())
         throw new IllegalArgumentException("Nome não pode ser vazio.");
     if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"))
         throw new EmailInvalidoException("Email inválido.");

     System.out.println("Cliente cadastrado com sucesso: " + nome + " (" + email + ")");
 }

 public static void main(String[] args) {
     CadastroCliente cadastro = new CadastroCliente();

     try {
         cadastro.cadastrar("João", "joaogmail.com");
     } catch (IllegalArgumentException | EmailInvalidoException e) {
         System.err.println("Erro no cadastro: " + e.getMessage());
     }

     try {
         cadastro.cadastrar("", "joao@example.com");
     } catch (IllegalArgumentException | EmailInvalidoException e) {
         System.err.println("Erro no cadastro: " + e.getMessage());
     }
 }
}

package RomesCyberSec;

import java.util.Arrays;
import java.util.List;

// Exceção personalizada para acesso negado
class AcessoNegadoException extends Exception {
    public AcessoNegadoException(String mensagem) {
        super(mensagem);
    }
}

// Classe simulando um firewall básico
public class Firewall {
    private static final List<String> IP_BLOQUEADOS = Arrays.asList("192.168.0.10", "10.0.0.5");

    public void verificarAcesso(String ip) throws AcessoNegadoException {
        if (ip == null) throw new NullPointerException("IP nulo");
        if (!ip.matches("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b")) {
            throw new IllegalArgumentException("Formato de IP inválido");
        }
        if (IP_BLOQUEADOS.contains(ip)) {
            throw new AcessoNegadoException("Acesso negado ao IP: " + ip);
        }
        System.out.println("Acesso permitido para o IP: " + ip);
    }

    public static void main(String[] args) {
        Firewall firewall = new Firewall();
        String[] testIps = { "192.168.0.10", "256.100.50.25", null, "192.168.1.1" };

        for (String ip : testIps) {
            try {
                firewall.verificarAcesso(ip);
            } catch (AcessoNegadoException | IllegalArgumentException | NullPointerException e) {
                System.err.println("Erro de acesso: " + e.getMessage());
            }
        }
    }
}

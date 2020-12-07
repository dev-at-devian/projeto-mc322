package projeto322;

import java.util.Calendar;

public class Cartao implements MetodoPagamento{

    private String numero;
    private Calendar dataExpiracao;
    private int cvv;
    private String nomeTitular;
    private String cpfTitular;

    public Cartao(String numero, Calendar dataExpiracao, int cvv, String nomeTitular, String cpfTitular) {
        this.numero = numero;
        this.dataExpiracao = dataExpiracao;
        this.cvv = cvv;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
    }

    public boolean pagar(int valor) {
        return true;
    }

    @Override
    public String toString() {
        String tmpStr = "Cartão:\n" +
                        "- Número: " + this.numero +
                        "- Nome do Titular: " + this.nomeTitular +
                        "- CPF do Titular: " + this.cpfTitular +
                        "- CVV: " + this.cvv +
                        "- Data de Expiração: " + this.dataExpiracao + "\n";
        return tmpStr;
    }

}

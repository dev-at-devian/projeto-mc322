package projetomc322.metodosdepagamento;

import java.util.Calendar;

public class Cartao implements MetodoPagamento{

    private String numero;
    private Calendar dataExpiracao;
    private int cvv;
    private String nomeTitular;
    private int cpfTitular;

    public Cartao(String numero, Calendar dataExpiracao, int cvv, String nomeTitular, int cpfTitular) {
        this.numero = numero;
        this.dataExpiracao = dataExpiracao;
        this.cvv = cvv;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
    }

    public String getNumero() {
        return numero;
    }

    public String getNumerosFinais() {
        String[] tmpStrArr = numero.split(" ");
        return tmpStrArr[tmpStrArr.length - 1];
    }

    public Calendar getDataExpiracao() {
        return dataExpiracao;
    }

    public int getCvv() {
        return cvv;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public int getCpfTitular() {
        return cpfTitular;
    }

    public boolean pagar(double valor) {
        return true;
    }

    @Override
    public String toString() {
        String tmpStr = "Cartão:\n" +
                        "- Número: " + this.numero + "\n" +
                        "- Nome do Titular: " + this.nomeTitular + "\n" +
                        "- CPF do Titular: " + this.cpfTitular + "\n" +
                        "- CVV: " + this.cvv + "\n" +
                        "- Data de Expiração: " + this.dataExpiracao + "\n";
        return tmpStr;
    }

}

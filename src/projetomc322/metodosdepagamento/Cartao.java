/* Classe Cartão implementa interface Metodo de Pagamento
 * Cartão representa um tipo de pagamento e deve conter os seguintes atributos:
 * - numero
 * - data de expiração
 * - cvv
 * - nome do titular
 * - cpf do titular
 * 
 * Métodos:
 * - getNumerosFinais()
 * - pagar(double valor)
 * */
package projetomc322.metodosdepagamento;

import java.util.Calendar;

public class Cartao implements MetodoPagamento{

    private String numero;
    private Calendar dataExpiracao;
    private int cvv;
    private String nomeTitular;
    private int cpfTitular;
    /*--------------------------------construtor--------------------------------------------------------------*/
    public Cartao(String numero, Calendar dataExpiracao, int cvv, String nomeTitular, int cpfTitular) {
        this.numero = numero;
        this.dataExpiracao = dataExpiracao;
        this.cvv = cvv;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
    }

    /*------------------------------------------getters---------------------------------------------------------*/
    public String getNumero() {
        return numero;
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

    /*Método getNumerosFinais:
     * Devolve os últimos números do cartão para identificação*/
    public String getNumerosFinais() {
        String[] tmpStrArr = numero.split(" ");
        return tmpStrArr[tmpStrArr.length - 1];
    }

    /*Método pagar:
     * Recebe como parâmetro o valor da compra a ser paga e devolve um booleano true para indicar o sucesso do pagamento*/
    public boolean pagar(double valor) {
        return true;
    }

    /*Método toString:
     * Devolve todas as informações do cartão em formato de string
     * */
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

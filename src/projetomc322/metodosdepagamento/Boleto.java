/* Classe Boleto implementa interface Metodo de Pagamento
 * Boleto representa um tipo de pagamento e deve conter os seguintes atributos:
 * - banco
 * - beneficiário
 * - pagador
 * - valor
 * - data de vencimento
 * - código de barras
 * 
 * Métodos:
 * - pagar(double valor)
 * - getters
 * - toString()
 * */
package projetomc322.metodosdepagamento;

import java.util.Calendar;

import projetomc322.auxiliares.Auxiliares;

public class Boleto implements MetodoPagamento {
    private String banco;
    private String beneficiario;
    private String pagador;
    private double valor;
    private Calendar dataVencimento;
    private int codigoBarras;

    /*--------------------------------construtor----------------------------------------------------------------------*/
    public Boleto(String banco, String beneficiario, String pagador, double valor, Calendar dataVencimento, int codigoBarras) {
        this.banco = banco;
        this.beneficiario = beneficiario;
        this.pagador = pagador;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.codigoBarras = codigoBarras;
    }

    /*----------------------------------------getters-----------------------------------------------------------------*/ 
    public String getBanco() {
        return banco;
    }
    public String getBeneficiario() {
        return beneficiario;
    }
    public String getPagador() {
        return pagador;
    }
    public double getValor() {
        return this.valor;
    }
    public Calendar getDataVencimento() {
        return dataVencimento;
    }
    public int getCodigoBarras() {
        return codigoBarras;
    }

    /*Método pagar:
     * Recebe como parâmetro o valor do boleto a ser pago e devolve um booleano true para indicar que o boleto
     * foi pago*/
    public boolean pagar(double valor) {
        return true;
    }

    /*Método toString:
     * Devolve todas as informações do boleto em formato de string
     * */
    @Override
    public String toString() {
        String tmpStr = "Boleto:\n" +
            "- Banco: " + this.banco + "\n" +
            "- Beneficiario: " + this.beneficiario + "\n" +
            "- Pagador: " + this.pagador + "\n" +
            "- Valor: " + this.valor + "\n" +
            "- Data de Vencimento: " + Auxiliares.calendarToString(this.dataVencimento) + "\n" +
            "- Código de Barras: " + this.codigoBarras + "\n";
        return tmpStr;
    }

}

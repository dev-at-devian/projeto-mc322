package projetomc322.metodosdepagamento;

import java.util.Calendar;

public class Boleto implements MetodoPagamento {
    private String banco;
    private String beneficiario;
    private String pagador;
    private double valor;
    private Calendar dataVencimento;
    private int codigoBarras;

    public Boleto(String banco, String beneficiario, String pagador, double valor, Calendar dataVencimento, int codigoBarras) {
        this.banco = banco;
        this.beneficiario = beneficiario;
        this.pagador = pagador;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.codigoBarras = codigoBarras;
    }

    public boolean pagar(double valor) {
        return true;
    }
    
    public double getValor() {
    	return this.valor;
    }

    @Override
    public String toString() {
        String tmpStr = "Boleto:\n" +
                        "- Banco: " + this.banco + "\n" +
                        "- Beneficiario: " + this.beneficiario + "\n" +
                        "- Pagador: " + this.pagador + "\n" +
                        "- Valor: " + this.valor + "\n" +
                        "- Data de Vencimento: " + this.dataVencimento + "\n" +
                        "- Código de Barras: " + this.codigoBarras + "\n";
        return tmpStr;
    }

}

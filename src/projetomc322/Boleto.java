package projetomc322;

import java.util.Calendar;

public class Boleto implements MetodoPagamento {
    private String banco;
    private String beneficiario;
    private String pagador;
    private int valor;
    private Calendar dataVencimento;
    private int codigoBarras;

    public Boleto(String banco, String beneficiario, String pagador, int valor, Calendar dataVencimento, int codigoBarras) {
        this.banco = banco;
        this.beneficiario = beneficiario;
        this.pagador = pagador;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.codigoBarras = codigoBarras;
    }

    public boolean pagar(int valor) {
        return true;
    }

    @Override
    public String toString() {
        String tmpStr = "Boleto:\n" +
                        "- Banco: " + this.banco +
                        "- Beneficiario: " + this.beneficiario +
                        "- Pagador: " + this.pagador +
                        "- Valor: " + this.valor +
                        "- Data de Vencimento: " + this.dataVencimento +
                        "- Código de Barras: " + this.codigoBarras + "\n";
        return tmpStr;
    }

}

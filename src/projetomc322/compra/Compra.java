package projetomc322.compra;

import java.util.ArrayList;
import java.util.Calendar;

import projetomc322.auxiliares.Auxiliares;
import projetomc322.loja.Loja;
import projetomc322.metodosdepagamento.MetodoPagamento;
import projetomc322.produtos.Produto;
import projetomc322.usuario.Usuario;

public class Compra {
    private CompraStatus status;
    private Calendar dataCompra;
    private double valor;
    private ArrayList<Produto> produtos;
    private Usuario comprador;
    private MetodoPagamento metodoPagamento;
    
    public Compra(Usuario usuario) {
        this.status = CompraStatus.CARRINHO;
        this.comprador = usuario;
        this.produtos = new ArrayList<Produto>();
        this.valor = 0;
        this.metodoPagamento = null;
        this.dataCompra = null;
    }

    public boolean efetuarCompra(Loja loja) {
        status = CompraStatus.EM_PROGRESSO;
        if (produtos.isEmpty()) {
            finalizarCompra();
            return true;
        } else if ((comprador == null) || (metodoPagamento == null)) {
            status = CompraStatus.CARRINHO;
            return false;
        } else {
            boolean sucesso = metodoPagamento.pagar(valor);
            if (sucesso) {
                loja.receberPagamento(true, valor);
                finalizarCompra();
                return true;
            }
        }
        status = CompraStatus.CARRINHO;
        return false;
    }

    private void calcularValor() {
        int valorTotal = 0;
        for (int i = 0; i < produtos.size(); i++) {
            Produto prod = produtos.get(i);
            valorTotal += prod.getPreco();
        }
        valor = valorTotal;
    }

    private void finalizarCompra() {
        status = CompraStatus.EFETUADA;
        dataCompra = Calendar.getInstance();
        comprador.setCarrinho(new Compra(comprador));
        comprador.getCompras().add(this);
    }

    public double getValor() {
        return valor;
    }

    public Calendar getData() {
        return this.dataCompra;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public Produto getProduto(int index) {
        return produtos.get(index);
    }
    
    public int getTamanho() {
        return produtos.size();
    }

    public MetodoPagamento getMetodoDePagamento() {
        return metodoPagamento;
    }

    public void setMetodoDePagamento(MetodoPagamento metodoPagamento) {
        if (status != CompraStatus.EFETUADA) {
            this.metodoPagamento = metodoPagamento;
        }
    }

    public void adicionarProduto(Produto produto) {
        if (status != CompraStatus.EFETUADA) {
            produtos.add(produto);
            calcularValor();
        }
    }

    public void removerProduto(Produto produto) {
        if (status != CompraStatus.EFETUADA) {
            produtos.remove(produto);
            calcularValor();
        }
    }

    @Override
    public String toString() {
        String tmpStr = "";
        switch (status) {
            case CARRINHO:
                tmpStr += "Carrinho";
                break;
            case EM_PROGRESSO:
                tmpStr += "Compra " + status.getDescricao();
                break;
            case EFETUADA:
                String dataCompraStr = dataCompra.get(Calendar.DAY_OF_MONTH) + "/" + 
                                       (dataCompra.get(Calendar.MONTH)+1) + "/" + 
                                       dataCompra.get(Calendar.YEAR);
                tmpStr += "Compra " + status.getDescricao() + " em " + dataCompraStr;
                break;
            default:
                break;
        }
        tmpStr += " de " + comprador.getPrimeiroNome() + "\n";
        tmpStr += "Valor: " + valor + "\n";
        tmpStr += "Produtos:\n";
        for (int i = 0; i < produtos.size(); i++) {
            Produto prod = produtos.get(i);
            tmpStr += " - " + Auxiliares.getResumoProduto(prod) + "\n";
        }
        return tmpStr;
    }

}

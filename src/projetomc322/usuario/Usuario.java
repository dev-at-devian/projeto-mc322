package projetomc322.usuario;

import java.util.*;

import projetomc322.compra.Compra;
import projetomc322.metodosdepagamento.Cartao;
import projetomc322.metodosdepagamento.MetodoPagamento;
import projetomc322.produtos.Produto;

public class Usuario {
    private String email;
    private String senha;
    private String nome;
    private Calendar dataNascimento;
    private int cpf;
    private Endereco endereco;
    private String telefone;
    private ArrayList<MetodoPagamento> carteira;
    private ArrayList<Compra> compras;
    private Compra carrinho;

    public Usuario(String email, String senha, String nome, Calendar dataNascimento, int cpf,
            Endereco endereco, String telefone) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.carteira = new ArrayList<MetodoPagamento>();
        this.compras = new ArrayList<Compra>();
        this.carrinho = new Compra(this);
    }


    public Usuario(String email, String senha, String nome, Calendar dataNascimento, int cpf,
            Endereco endereco, String telefone, ArrayList<MetodoPagamento> carteira,
            ArrayList<Compra> compras, Compra carrinho) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.carteira = carteira;
        this.compras = compras;
        this.carrinho = carrinho;
    }
    
    public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getNome() {
		return nome;
	}

  public String getPrimeiroNome() {
    return nome.split(" ")[0];
  }

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public int getCpf() {
		return cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

    public ArrayList<MetodoPagamento> getCarteira() {
        return this.carteira;
    }
    
    public Cartao adicionarCartão(String numero, Calendar dataExpiracao, int cvv) {
    	Cartao cartao = new Cartao(numero, dataExpiracao, cvv, this.nome, this.cpf);
    	carteira.add(cartao);
    	return cartao;
    }
    
    public void adicionarMetodoDePagamento(MetodoPagamento mp) {
      carteira.add(mp);
    }

    public void adicionarAoCarrinho(Produto produto) {
    	carrinho.adicionarProduto(produto);    
    }
    
    public void removerDoCarrinho(Produto produto) {
    	carrinho.removerProduto(produto);
    }
    
    public Compra getCarrinho(){
    	return carrinho;
    }
    
    public void setCarrinho(Compra carrinho){
    	this.carrinho = carrinho;
    }
    
    public double calcularValorCompra() {
    	return getCarrinho().getValor();
    }

	
	public ArrayList<Compra> getCompras() {
		return compras;
	}
	/*
	public void moverCarrinhoParaCompra(boolean pago) {
		if(pago) {
			this.compras = this.carrinho;
			this.carrinho = null;
		}
	}
	*/
}

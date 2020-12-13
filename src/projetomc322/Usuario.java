package projetomc322;

import java.util.*;

public class Usuario {
    private String email;
    private String senha;
    private String nome;
    private Calendar dataNascimento;
    private int cpf;
    private Endereco endereco;
    private String telefone;
    private ArrayList<MetodoPagamento> carteira;
    private ArrayList<Produto> compras;
    private ArrayList<Produto> carrinho;

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
        this.compras = new ArrayList<Produto>();
        this.carrinho = new ArrayList<Produto>();
    }


    public Usuario(String email, String senha, String nome, Calendar dataNascimento, int cpf,
            Endereco endereco, String telefone, ArrayList<MetodoPagamento> carteira,
            ArrayList<Produto> compras, ArrayList<Produto> carrinho) {
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
    
    public void adicionarAoCarrinho(Produto produto) {
    	carrinho.add(produto);    
    }
    
    public void removerDoCarrinho(Produto produto) {
    	carrinho.remove(produto);
    }
    
    public ArrayList<Produto> getCarrinho(){
    	return carrinho;
    }
    
    public double calcularValorCompra() {
    	double total = 0;
    	for(Produto produto: carrinho) {
    		total += produto.getPreco();
    	}
    	return total;
    }

	
	public ArrayList<Produto> getCompras() {
		return compras;
	}
	
	public void moverCarrinhoParaCompra(boolean pago) {
		if(pago) {
			this.compras = this.carrinho;
			this.carrinho = null;
		}
	}
}

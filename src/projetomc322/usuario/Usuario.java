/*Classe Usuario
 * Responsável por cadastrar o usuário e gerenciar suas compras e possíveis compras
 * Atributos:
 * - email
 * - senha
 * - nome
 * - dataNascimento
 * - cpf
 * - endereço
 * - telefone
 * - carteira
 * - compras
 * - carrinho
 * 
 * Métodos:
 * - geter/seters
 * - adicionarCartao(numero, dataExpiracao, cvv)
 * - adicionarMetodoDePagamento(metodoDePagamento)
 * - adicionarAoCarrinho(produto)
 * - removerDoCarrinho(produto)
 * - calcularValotCompra()
 * - getPrimeiroNome()
 * */
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
    
    /*--------------------------construtor--------------------------------*/
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
    
    /*--------------------------geters/seters-------------------------------------*/
    public String getEmail() {
		return email;
	}
    
    public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getCpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

    public ArrayList<MetodoPagamento> getCarteira() {
        return this.carteira;
    }
    
    public void setCarteira(ArrayList<MetodoPagamento> carteira) {
		this.carteira = carteira;
	}
    
    public ArrayList<Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}
	
	public Compra getCarrinho(){
    	return carrinho;
    }
    
    public void setCarrinho(Compra carrinho){
    	this.carrinho = carrinho;
    }
    
    /*Método adicionarCartão:
     * Recebe os parâmetros necessários para cadastrar um cartão, adiciona o cartão criado
     * na carteira do usuário e retorna o cartão criado 
     */
    public Cartao adicionarCartão(String numero, Calendar dataExpiracao, int cvv) {
    	Cartao cartao = new Cartao(numero, dataExpiracao, cvv, this.nome, this.cpf);
    	adicionarMetodoDePagamento(cartao);
    	return cartao;
    }
    
    /*Método adicionarMetodoDePagamento:
     * Recebe um método de pagamento e adiciona na carteira do usuário 
     */
    public void adicionarMetodoDePagamento(MetodoPagamento mp) {
      carteira.add(mp);
    }
    
    /*Método adicionarAoCarrinho:
     * Recebe um produto e adiciona o produto desejado no carrinho do usuario
     */
    public void adicionarAoCarrinho(Produto produto) {
    	carrinho.adicionarProduto(produto);    
    }
    
    /*Método removerDoCarrinho:
     * Recebe um produto e remove o produto desejado do carrinho do usuario
     */
    public void removerDoCarrinho(Produto produto) {
    	carrinho.removerProduto(produto);
    }

    /*Método calcularValorCompra:
     * Retorna o valor total dos produtos que estão no carrinho
     */
    public double calcularValorCompra() {
    	return getCarrinho().getValor();
    }
    
    /*Método getPrimeiroNome:
     * Retorna o primeiro nome do usuário
     */
	public String getPrimeiroNome() {
	    return nome.split(" ")[0];
	  }
}

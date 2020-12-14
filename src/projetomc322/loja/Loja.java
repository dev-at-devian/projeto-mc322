package projetomc322.loja;
import java.util.*;

import projetomc322.metodosdepagamento.Boleto;
import projetomc322.produtos.Produto;
import projetomc322.usuario.Usuario;

public class Loja {
    private String nome;
    private String linkAcesso;
    private String cnpj;
    private String telefone;
    private String email;
    private Calendar dataCriacao;
    private ArrayList<Usuario> usuarios;
    private Estoque estoque;
    private double caixa;
     
    public Loja(String nome, String linkAcesso, String cnpj, String telefone, String email) {
			this.nome = nome;
			this.linkAcesso = linkAcesso;
			this.cnpj = cnpj;
			this.telefone = telefone;
			this.email = email;
			this.dataCriacao = Calendar.getInstance();
			this.usuarios = new ArrayList<Usuario>();
			this.estoque = new Estoque();
			this.estoque.carregarEstoque();
			this.caixa = 0;
    }
    
    public Loja(String nome, String linkAcesso, String cnpj, String telefone, String email, Calendar dataCriacao, ArrayList<Usuario> usuarios, Estoque estoque) {
			this.nome = nome;
			this.linkAcesso = linkAcesso;
			this.cnpj = cnpj;
			this.telefone = telefone;
			this.email = email;
			this.dataCriacao = dataCriacao;
			this.usuarios = usuarios;
			this.estoque = estoque;
			this.caixa = 0;
    }
    
	public Estoque getEstoque(){
		   return estoque;
	}

	public void setEstoque(Estoque estoque) {
		   this.estoque = estoque;
	}

	public String getNome() {
		return nome;
	}

	public String getLinkAcesso() {
		return linkAcesso;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public double getCaixa() {
		return this.caixa;
	}
	
	public Produto getProdutoPorCodigo(int codigo) {
		ArrayList<Produto> prods = estoque.getProdutos();
		for (int i = 0; i < prods.size(); i++) {
			Produto prod = prods.get(i);
			if (prod.getCodigo() == codigo) {
				return prod;
			}
		}
		return null;
	}

	public void addProduto(Produto p) {
        estoque.adicionarProduto(p);
    }
    public void addUsuario(Usuario u) {
        usuarios.add(u);
    }
    
    public boolean removeProduto(Produto p) {
		    estoque.removerProduto(p);
        return false;
    }
    public boolean removeUsuario(Usuario u) {
        if(usuarios.size() >= 1) {
            usuarios.remove(u);
        }
        return false;
    }
	
	public Boleto fornecerBoleto(Usuario usuario) {
		return new Boleto("BANK", this.nome, usuario.getNome(), usuario.calcularValorCompra(), Calendar.getInstance(),123456);
	}
	
	public void receberPagamento(boolean pago, double valor) {
		if(pago) {
			this.caixa = this.caixa + valor;
		}
	}

	public Usuario obterUsuario(String email, String senha) {
		Usuario usr = checarEmail(email);
		if (!(usr == null)) {
			if (checarSenha(usr, senha)) {
				return usr;
			}
		}
		return null;
	}

	private Usuario checarEmail(String email) {
		for (int i = 0; i < usuarios.size(); i++)  {
			Usuario usr = usuarios.get(i);
			if (usr.getEmail().equals(email)) {
				return usr;
			}
		}
		return null;
	}

	private boolean checarSenha(Usuario usr, String senha) {
		if (usr.getSenha().equals(senha)) {
			return true;
		}
		return false;
	}
    
}

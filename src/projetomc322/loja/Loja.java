/*Classe Loja
 * Responsável por armazenar informaçoes da loja, gereciar os usuários ativos e o estoque
 * no estoque.
 * Atributos:
 * - nome
 * - linkAcesso
 * - cnpj
 * - telefone
 * - email
 * - dataCriacao
 * - usuarios
 * - estoque
 * - caixa
 * 
 * Métodos:
 * - geter/seters
 * - getProdutoPorCodigo(codigo)
 * - addProduto(produto)
 * - addUsuario(usuario)
 * - removeProduto(produto)
 * - removeUsuario(usuario)
 * - fornecerBoleto(usuario)
 * - receberPagamento(pago, valor)
 * - obterUsuario(email, senha)
 * - checarEmail(email)
 * - checarSenha(usr, senha)
 * */

package projetomc322.loja;
import java.util.*;

import projetomc322.interfaceusuario.Interface;
import projetomc322.metodosdepagamento.Boleto;
import projetomc322.produtos.Produto;
import projetomc322.usuario.CarregadorUsuario;
import projetomc322.usuario.*;

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
		private CarregadorUsuario carregadorUsuario;
    
    /*--------------------------construtor--------------------------------*/ 
    public Loja(String nome, String linkAcesso, String cnpj, String telefone, String email) {
			this.nome = nome;
			this.linkAcesso = linkAcesso;
			this.cnpj = cnpj;
			this.telefone = telefone;
			this.email = email;
			this.dataCriacao = Calendar.getInstance();
			this.usuarios = new ArrayList<Usuario>();
			this.estoque = new Estoque();
			this.carregadorUsuario = new CarregadorUsuario(this);
			this.estoque.carregarEstoque();
			this.caixa = 0;
    }
    
    public Loja(String nome, String linkAcesso, String cnpj, String telefone, String email, Calendar dataCriacao, ArrayList<Usuario> usuarios, Estoque estoque, CarregadorUsuario carregadorUsuario) {
			this.nome = nome;
			this.linkAcesso = linkAcesso;
			this.cnpj = cnpj;
			this.telefone = telefone;
			this.email = email;
			this.dataCriacao = dataCriacao;
			this.usuarios = usuarios;
			this.estoque = estoque;
			this.carregadorUsuario = carregadorUsuario;
			this.caixa = 0;
    }
    
    /*--------------------------geters/seters-------------------------------------*/
		public CarregadorUsuario getCarregadorUsuario() {
			return carregadorUsuario;
		}

		public void setCarregadorUsuario(CarregadorUsuario carregadorUsuario) {
			this.carregadorUsuario = carregadorUsuario;
		}

    public String getNome() {
		return nome;
	}
    
    public void setNome(String nome) {
		this.nome = nome;
	}
    
    public String getLinkAcesso() {
		return linkAcesso;
	}
    
    public void setLinkAcesso(String linkAcesso) {
		this.linkAcesso = linkAcesso;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
    
	public Estoque getEstoque(){
		   return estoque;
	}

	public void setEstoque(Estoque estoque) {
		   this.estoque = estoque;
	}

	public double getCaixa() {
		return this.caixa;
	}
	
	public void setCaixa(double caixa) {
		this.caixa = caixa;
	}
	
	/*Método getProdutoPorCodigo:
     * Recebe o codigo do produto desejado e caso o produto exista, retorna ele. 
     */
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
	
	
	/*Método addUsuario:
     * Recebe um usuário e o adiciona aos usuarios da loja. 
     */
    public void addUsuario(Usuario u) {
        usuarios.add(u);
    }
    
    /*Método removeProduto:
     * Recebe um produto e remove o produto desejado do estoque da loja. 
     */
    public boolean removeProduto(Produto p) {
		    estoque.removerProduto(p);
        return false;
    }
    
    /*Método removeUsuario:
     * Recebe um usuário e remove o usuário desejado dos usuários da loja. 
     */
    public boolean removeUsuario(Usuario u) {
        if(usuarios.size() >= 1) {
            usuarios.remove(u);
        }
        return false;
    }
	
    /*Método fornecerBoleto:
     * Recebe o usuario que necessita de um boleto e fornece um boleto com os dados necessários*/
	public Boleto fornecerBoleto(Usuario usuario) {
		return new Boleto("BANK", this.nome, usuario.getNome(), usuario.calcularValorCompra(), Calendar.getInstance(),123456);
	}
	
	/*Método receberPagamento:
	 * Recebe um booleano indicando se a compra foi paga ou não e o valor da compra para acrescentar ao
	 * caixa da loja
	 * */
	public void receberPagamento(boolean pago, double valor) {
		if(pago) {
			this.caixa = this.caixa + valor;
		}
	}
	
	/*Método obterUsuario:
	 * Recebe email e senha do usuário e retorna o usuário caso ele exista
	 * */

	public Usuario obterUsuario(String email, String senha) {
		Usuario usr = checarEmail(email);
		if (!(usr == null)) {
			if (checarSenha(usr, senha)) {
				return usr;
			}
		}
		return null;
	}
	
	public Usuario obterUsuario(String email, Usuario credenciais) {
		Usuario usr = checarEmail(email);
		if ((!(usr == null)) && (credenciais instanceof Admin)) {
			return usr;
		}
		return null;
	}
	

	public void carregarUsuarios() {
		this.carregadorUsuario.carregarUsuarios();
	}

	public void adicionarUsuario(Usuario usuario) {
		this.carregadorUsuario.adicionarUsuario(usuario);
	}

	public void atualizarUsuarios() {
		this.carregadorUsuario.atualizarUsuarios();
	}

	public void atualizarUsuarioAtual(Interface interf) {
		this.carregadorUsuario.atualizarUsuarioAtual(interf);
	}


	/*Método checarEmail:
	 * Recebe email e retorna usuário que tem o email em questão se ele existir
	 * */
	private Usuario checarEmail(String email) {
		for (int i = 0; i < usuarios.size(); i++)  {
			Usuario usr = usuarios.get(i);
			if (usr.getEmail().equals(email)) {
				return usr;
			}
		}
		return null;
	}
	
	/*Método checarSenha:
	 * Recebe usuário e senha e checa se a senha corresponde a senha cadastrada retornando true 
	 * se sim e false se não
	 * */
	private boolean checarSenha(Usuario usr, String senha) {
		if (usr.getSenha().equals(senha)) {
			return true;
		}
		return false;
	}    
}

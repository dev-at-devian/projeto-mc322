package projetomc322.usuario;

import java.util.Calendar;

import projetomc322.loja.Loja;
import projetomc322.produtos.Produto;

public class Admin extends Usuario{
	public Admin(String email, String senha, String nome, Calendar dataNascimento, int cpf,
            Endereco endereco, String telefone) {
		super(email, senha, nome, dataNascimento, cpf, endereco, telefone);
	}
	
	public void cadastrarProduto(Loja loja) {
		
	}
	
	public void editarProduto(Loja loja, Produto produto) {
		
	}
	
	public void removerProduto(Loja loja, Produto produto) {
		
	}
	
	public double visualizarCaixa(Loja loja) {
		
	}
	
	public ArrayList<Usuarios> visualizarUsuarios(Loja loja){
		
	}
	
	public void removerUsuario(Usuario usuario) {
		
	}
}

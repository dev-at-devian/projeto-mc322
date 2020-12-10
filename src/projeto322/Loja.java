import java.util.*;

public class Loja {
	private String nome;
	private String linkAcesso;
	private String cnpj;
	private String telefone;
	private String email;
	private Calendar dataCriacao;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Produto> estoque;
	
	public Loja() {
		
	}
	
	
	
	public void addProduto(Produto p) {
		estoque.add(p);
	}
	public void addUsuario(Usuario u) {
		usuarios.add(u);
	}
	
	public boolean removeProduto(Produto p) {
		if(estoque.size() >= 1) {
			estoque.remove(p);
		}
		return false;
	}
	public boolean removeUsuario(Usuario u) {
		if(usuarios.size() >= 1) {
			usuarios.remove(u);
		}
		return false;
	}
	
}

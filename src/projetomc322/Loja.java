package projetomc322;
import java.util.*;

public class Loja {
    private String nome;
    private String linkAcesso;
    private String cnpj;
    private String telefone;
    private String email;
    private Calendar dataCriacao;
    private ArrayList<Usuario> usuarios;
    private Estoque estoque;
     
    public Loja(String nome, String linkAcesso, String cnpj, String telefone, String email) {
			this.nome = nome;
			this.linkAcesso = linkAcesso;
			this.cnpj = cnpj;
			this.telefone = telefone;
			this.email = email;
			this.dataCriacao = Calendar.getInstance();
			this.usuarios = new ArrayList<Usuario>();
			this.estoque = new Estoque();
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
    }
    
		public Estoque getEstoque(){
		    return estoque;
		}

		public void setEstoque(Estoque estoque) {
		    this.estoque = estoque;
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
    
}

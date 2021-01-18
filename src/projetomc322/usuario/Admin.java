package projetomc322.usuario;

import java.util.ArrayList;
import java.util.Calendar;

import projetomc322.loja.Loja;
import projetomc322.produtos.Produto;

public class Admin extends Usuario{
	
	private Loja loja;
	
	public Admin(String email, String senha, String nome, Calendar dataNascimento, int cpf,
            Endereco endereco, String telefone, Loja loja) {
		super(email, senha, nome, dataNascimento, cpf, endereco, telefone);
		this.loja = loja;
	}
	
	/*Método addProduto:
     * Recebe um produto e adiciona ele ao estoque da loja. 
     */
	public void addProduto(Produto produto) {
        loja.getEstoque().adicionarProduto(produto);
    }
	
	/*Método editarProduto:
     * Recebe o produto antigo a ser editado e o produto com a edição
     *  remove o produto antigo e adiciona o novo ao estoque. 
     */
	public void editarProduto(Produto produto, Produto novoProduto) {
		loja.getEstoque().removerProduto(produto.getCodigo());
		loja.getEstoque().adicionarProduto(novoProduto);
	}
	
	/*Método removerProduto:
     * Recebe um produto e remove o produto desejado do estoque da loja. 
     */
	public void removerProduto(Produto produto) {
		loja.removeProduto(produto);
	}
	
	/*Método visualizar caixa:
     * Retorna o caixa da loja. 
     */
	public double visualizarCaixa() {
		return loja.getCaixa();
	}
	
	/*Método visualizar usuarios:
     * Retorna os usuarios da loja. 
     */
	public ArrayList<Usuario> visualizarUsuarios(){
		return loja.getUsuarios();
	}
	
	/*Método remover usuarios:
     * Recebe um usuário e remove da loja. 
     */
	public void removerUsuario(Usuario usuario) {
		loja.removeUsuario(usuario);
	}
}

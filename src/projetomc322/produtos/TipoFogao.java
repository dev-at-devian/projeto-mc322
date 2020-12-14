/*Enumeração TipoFogao 
 * Responsável por fornecer os tipos de fogões existentes
 * Atributo:
 * - nome
 * 
 * Método:
 * - getNome()
 * */

package projetomc322.produtos;

public enum TipoFogao {
	PISO ("piso"),
	EMBUTIDO ("embutido"),
	COOKTOP ("cooktop");
	
	private final String nome;
	
/*--------------------------------------construtor--------------------------*/
	TipoFogao(String nome) {
		this.nome = nome;
	}
/*------------------------------------geter--------------------------------*/
	public String getNome() {
		return this.nome;
	}
}

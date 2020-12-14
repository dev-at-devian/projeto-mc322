/*Enumeração Tela 
 * Responsável por fornecer os tipos de telas existentes
 * Atributo:
 * - nome
 * 
 * Método:
 * - getNome()
 * */
package projetomc322.produtos;

public enum Tela {
	LCD ("lcd"),
	LED ("led"),
	OLED ("oled"),
	QLED ("qled");
	
	private final String nome;

/*--------------------------construtor--------------------------------*/
	Tela(String nome) {
		this.nome = nome;
	}

/*--------------------------geter-------------------------------------*/
	public String getNome() {
		return this.nome;
	}
}

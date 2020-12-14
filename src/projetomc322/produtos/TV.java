/*Classe TV herda a Classe Eletrodomestico
 * TV descreve uma TV com os seguintes atributos:
 * - tela
 * - smart
 * 
 * Métodos:
 * - geters/seters
 * - toString()
 * */
package projetomc322.produtos;

import java.awt.Image;
import java.util.ArrayList;

public class TV extends Eletrodomestico{
	
	private Tela tela;
	private boolean smart;
	
/*-----------------------------construtor----------------------------------------------------------------*/
	public TV(int codigo, String descricao, ArrayList<Image> fotos, String marca, double preco, int voltagem, double altura, double largura, double comprimento, String cor, String modelo, Tela tela, boolean smart) {
		super(codigo, descricao, fotos, marca, preco, voltagem, altura, largura, comprimento, cor, modelo);
		this.tela = tela;
		this.smart = smart;
	}
	
/*---------------------------------geters/seters----------------------------------------------------------*/
	public Tela getTela() {
		return tela;
	}

	public void setTela(Tela tela) {
		this.tela = tela;
	}

	public boolean isSmart() {
		return smart;
	}

	public void setSmart(boolean smart) {
		this.smart = smart;
	}
	
/*Método toString:
* Devole as informações da TV em formato de string*/
	@Override
	public String toString() {
        String tmpStr = super.toString() +
        				"- Tela: " + this.tela + "\n" +
                        "- Smart: " + (this.smart ? "sim" : "não") + "\n";
        return tmpStr;
	}

}

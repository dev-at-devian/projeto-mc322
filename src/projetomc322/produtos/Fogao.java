/*Classe Fogão herda a Classe Eletrodomestico
 * Fogão descreve um fogão com os seguintes atributos:
 * - numeroBocas
 * - tipo
 * - forno
 * 
 * Métodos:
 * - geters/seters
 * - toString()
 * */
package projetomc322.produtos;

import java.awt.Image;
import java.util.ArrayList;

public class Fogao extends Eletrodomestico{
	private int numeroBocas;
	private TipoFogao tipo;
	private boolean forno;
	
/*-----------------------------construtor----------------------------------------------------------------*/
	public Fogao(int codigo, String descricao, ArrayList<Image> fotos, String marca, double preco, int voltagem, double altura, double largura, double comprimento, String cor, String modelo, int numeroBocas, TipoFogao tipo, boolean forno) {
		super(codigo, descricao, fotos, marca, preco, voltagem, altura, largura, comprimento, cor, modelo);
		this.numeroBocas = numeroBocas;
		this.tipo = tipo;
		this.forno = forno;
	}
/*---------------------------------geters/seters----------------------------------------------------------*/
	public int getNumeroBocas() {
		return numeroBocas;
	}

	public void setNumeroBocas(int numeroBocas) {
		this.numeroBocas = numeroBocas;
	}

	public TipoFogao getTipo() {
		return tipo;
	}

	public void setTipo(TipoFogao tipo) {
		this.tipo = tipo;
	}

	public boolean isForno() {
		return forno;
	}

	public void setForno(boolean forno) {
		this.forno = forno;
	}
	
/*Método toString:
* Devole as informações do fogão em formato de string*/
	@Override
	public String toString() {
        String tmpStr = super.toString() +
        				"- Bocas: " + this.numeroBocas + "\n" +
                        "- Tipo: " + this.tipo + "\n" +
                        "- Forno: " + (this.forno ? "sim" : "não") + "\n";
        return tmpStr;
	}

}

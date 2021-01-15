/*Classe Eletrodomestico herda a Classe Produtos
 * Eletrodomestico descreve informaçoes mais gerais de um eletrodomestico com os seguintes atributos:
 * - voltagem
 * - altura
 * - largura
 * - comprimento
 * - cor
 * - modelo
 * 
 * Métodos:
 * - geters/seters
 * - calcularVolume()
 * - toString()
 * */
package projetomc322.produtos;

import java.awt.Image;
import java.util.ArrayList;

public abstract class Eletrodomestico extends Produto{
	
	private int voltagem;
	private double altura;
	private double largura;
	private double comprimento;
	private String cor;
	private String modelo;
	
/*--------------------------construtor------------------------------------------------------------*/
	public Eletrodomestico(int codigo, String descricao, ArrayList<Image> fotos, String marca, double preco, int voltagem, double altura, double largura, double comprimento, String cor, String modelo){
		super(codigo, descricao, fotos, marca, preco);
		this.voltagem = voltagem;
		this.altura = altura;
		this.largura = largura;
		this.comprimento = comprimento;
		this.cor = cor;
		this.modelo = modelo;
	}
	
/*--------------------------geters/seters------------------------------------------------------------*/
	public void setVoltagem(int voltagem) {
		this.voltagem = voltagem;
	}
	
	public int getVoltagem() {
		return voltagem;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getAltura() {
		return altura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}
	
	public double getLargura() {
		return largura;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	
	public double getComprimento() {
		return comprimento;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getCor() {
		return cor;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}
	
	private double calcularVolume() {
		double calc = (this.altura * this.comprimento) * this.largura;
		return calc;
	}
	
/*Método toString:
* Devole as informações do computador em formato de string*/
	@Override
    public String toString() {
        String tmpStr = super.toString() +
        				"- Marca: " + this.modelo + "\n" +
                        "- Cor: " + this.cor + "\n" +
                        "- Voltagem: " + this.voltagem + "\n" +
                        "- Altura: " + this.altura + "\n" +
                        "- Largura: " + this.largura + "\n" +
                        "- Comprimento: " + this.comprimento + "\n" +
                        "- Volume: " + this.calcularVolume() + "\n";
        return tmpStr;
    }
}

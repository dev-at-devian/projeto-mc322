package projetomc322;

import java.awt.Image;
import java.util.ArrayList;

public class Eletrodomestico extends Produto{
	
	private final int voltagem;
	private final double altura;
	private final double largura;
	private final double comprimento;
	private final String cor;
	private final String modelo;
	
	public Eletrodomestico(int codigo, String descricao, ArrayList<Image> fotos, String marca, double preco, int voltagem, double altura, double largura, double comprimento, String cor, String modelo){
		super(codigo, descricao, fotos, marca, preco);
		this.voltagem = voltagem;
		this.altura = altura;
		this.largura = largura;
		this.comprimento = comprimento;
		this.cor = cor;
		this.modelo = modelo;
	}

	public int getVoltagem() {
		return voltagem;
	}

	public double getAltura() {
		return altura;
	}

	public double getLargura() {
		return largura;
	}

	public double getComprimento() {
		return comprimento;
	}

	public String getCor() {
		return cor;
	}

	public String getModelo() {
		return modelo;
	}
	
	private double calcularVolume() {
		double calc = (this.altura * this.comprimento) * this.largura;
		return calc;
	}
	
	@Override
    public String toString() {
        String tmpStr = super.toString() +
        				"- Marca: " + this.modelo +
                        "- Cor: " + this.cor +
                        "- Voltagem: " + this.voltagem +
                        "- Altura: " + this.altura +
                        "- Largura: " + this.largura +
                        "- Comprimento: " + this.comprimento + 
                        "- Volume: " + this.calcularVolume() + "\n";
        return tmpStr;
    }
	
	
}

package projetomc322.produtos;

import java.awt.Image;
import java.util.ArrayList;

public class Computador extends Eletrodomestico{
	
	private String processador;
	private String sistemaOperacional;
	private int ram;
	private int hd;
	
	public Computador(int codigo, String descricao, ArrayList<Image> fotos, String marca, double preco, int voltagem, double altura, double largura, double comprimento, String cor, String modelo, String processador, String sistemaOperacional, int ram, int hd) {
		super(codigo, descricao, fotos, marca, preco, voltagem, altura, largura, comprimento, cor, modelo);
		this.processador = processador;
		this.sistemaOperacional = sistemaOperacional;
		this.ram = ram;
		this.hd = hd;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getHd() {
		return hd;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}
	
	@Override
	public String toString() {
        String tmpStr = super.toString() +
        				"- Processador: " + this.processador + "\n" +
                        "- Sistema Operacional: " + this.sistemaOperacional + "\n" +
                        "- RAM: " + this.ram + "\n" +
                        "- HD: "+ this.hd + "\n";
        return tmpStr;
	}
}

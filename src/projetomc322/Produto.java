package projetomc322;

import java.awt.Image;
import java.util.*;

public class Produto {
	private int codigo;
    private String descricao;
    private ArrayList<Image> fotos;
    private String marca;
    private double preco;
    
    public Produto(int codigo, String descricao, ArrayList<Image> fotos, String marca, double preco) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.fotos = fotos;
		this.marca = marca;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ArrayList<Image> getFotos() {
		return fotos;
	}
	
	public Image getFoto(int index) {
		return fotos.get(index);
	}

	public void setFotos(ArrayList<Image> fotos) {
		this.fotos = fotos;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
    
	@Override
    public String toString() {
        String tmpStr = "- Codigo: " + this.codigo +
                        "- Descrição: " + this.descricao +
                        "- Fotos: " + this.fotos +
                        "- Marca: " + this.marca +
                        "- Preço: " + this.preco + "\n";
        return tmpStr;
    }

}

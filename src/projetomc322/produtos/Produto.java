/*Classe Produto
 * Produto descreve informaçoes mais gerais de um produto com os seguintes atributos:
 * - codigo
 * - descricao
 * - fotos
 * - marca
 * - preco
 * 
 * Métodos:
 * - geters/seters
 * - toString()
 * */
package projetomc322.produtos;

import java.awt.Image;
import java.util.*;

public abstract class Produto {
	private int codigo;
    private String descricao;
    private ArrayList<Image> fotos;
    private String marca;
    private double preco;

/*--------------------------------construtor----------------------------------------------------------*/
    public Produto(int codigo, String descricao, ArrayList<Image> fotos, String marca, double preco) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.fotos = fotos;
		this.marca = marca;
		this.preco = preco;
	}

/*--------------------------geters/seters------------------------------------------------------------*/
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
	
	/*Método toString:
	* Devole as informações do produto em formato de string*/
	@Override
    public String toString() {
        String tmpStr = "- Codigo: " + this.codigo + "\n" +
                        "- Descrição: " + this.descricao + "\n" +
                        "- Fotos: " + this.fotos + "\n" +
                        "- Marca: " + this.marca + "\n" +
                        "- Preço: " + this.preco + "\n";
        return tmpStr;
    }

}

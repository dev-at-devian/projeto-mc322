package projetomc322;

import java.awt.Image;
import java.util.ArrayList;

public class TV extends Eletrodomestico{
	
	private Tela tela;
	private boolean smart;
	
	public TV(int codigo, String descricao, ArrayList<Image> fotos, String marca, double preco, int voltagem, double altura, double largura, double comprimento, String cor, String modelo, Tela tela, boolean smart) {
		super(codigo, descricao, fotos, marca, preco, voltagem, altura, largura, comprimento, cor, modelo);
		this.tela = tela;
		this.smart = smart;
	}
	
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
	
	
	@Override
	public String toString() {
        String tmpStr = super.toString() +
        				"- Tela: " + this.tela +
                        "- Smart: " + (this.smart ? "sim" : "não") + "\n";
        return tmpStr;
	}

}

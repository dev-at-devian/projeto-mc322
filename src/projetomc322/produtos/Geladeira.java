package projetomc322.produtos;

import java.awt.Image;
import java.util.ArrayList;

public class Geladeira extends Eletrodomestico{
	private int numeroPortas;
	private boolean frostFree;
	private boolean freezer;
	
	public Geladeira(int codigo, String descricao, ArrayList<Image> fotos, String marca, double preco, int voltagem, double altura, double largura, double comprimento, String cor, String modelo, int numeroPortas, boolean frostFree, boolean freezer) {
		super(codigo, descricao, fotos, marca, preco, voltagem, altura, largura, comprimento, cor, modelo);
		this.numeroPortas = numeroPortas;
		this.frostFree = frostFree;
		this.freezer = freezer;
	}

	public int getNumeroPortas() {
		return numeroPortas;
	}

	public void setNumeroPortas(int numeroPortas) {
		this.numeroPortas = numeroPortas;
	}

	public boolean isFrostFree() {
		return frostFree;
	}

	public void setFrostFree(boolean frostFree) {
		this.frostFree = frostFree;
	}

	public boolean isFreezer() {
		return freezer;
	}
	
	public void setFreezer(boolean freezer) {
		this.freezer = freezer;
	}
	
	@Override
    public String toString() {
        String tmpStr = super.toString() +
        				"- Portas: " + this.numeroPortas + "\n" +
                        "- Frost Free: " + (this.frostFree ? "sim" : "não") + "\n" +
                        "- Freezer: " + (this.freezer ? "sim" : "não") + "\n";
        return tmpStr;
    }
}

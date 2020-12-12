package projetomc322;

import java.awt.Image;
import java.util.ArrayList;

public class Fogao extends Eletrodomestico{
	private int numeroBocas;
	private TipoFogao tipo;
	private boolean forno;
	
	public Fogao(int codigo, String descricao, ArrayList<Image> fotos, String marca, double preco, int voltagem, double altura, double largura, double comprimento, String cor, String modelo, int numeroBocas, TipoFogao tipo, boolean forno) {
		super(codigo, descricao, fotos, marca, preco, voltagem, altura, largura, comprimento, cor, modelo);
		this.numeroBocas = numeroBocas;
		this.tipo = tipo;
		this.forno = forno;
	}
	
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
	
	@Override
	public String toString() {
        String tmpStr = super.toString() +
        				"- Bocas: " + this.numeroBocas +
                        "- Tipo: " + this.tipo +
                        "- Forno: " + (this.forno ? "sim" : "não") + "\n";
        return tmpStr;
	}

}

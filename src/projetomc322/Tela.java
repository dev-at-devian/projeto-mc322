package projetomc322;

public enum Tela {
	LCD ("lcd"),
	LED ("led"),
	OLED ("oled"),
	QLED ("qled");
	private final String nome;
	Tela(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
}

package projetomc322;

public enum TipoFogao {
	PISO ("piso"),
	EMBUTIDO ("embutido"),
	COOKTOP ("cooktop");
	private final String nome;
	TipoFogao(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
}

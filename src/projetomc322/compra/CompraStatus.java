package projetomc322.compra;

public enum CompraStatus {
    CARRINHO("Carrinho"), EM_PROGRESSO("Em Progresso"), EFETUADA("Efetuada");

    private final String descricao;

    CompraStatus(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }

}

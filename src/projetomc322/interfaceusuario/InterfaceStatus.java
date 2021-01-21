/*Enum InterfaceStatus
 * */
package projetomc322.interfaceusuario;

public enum InterfaceStatus {
    INICIO("INICIO"),
    CADASTRO("CADASTRO"),
    CREDITOS("CREDITOS"),
    LOGIN("LOGIN"),
    PRINCIPAL("PRINCIPAL"),
    COMPRA("COMPRA"),
    COMPRAS("COMPRAS"),
    CARRINHO("CARRINHO"),
    DETALHES_PRODUTO("DETALHES"),
    PAGAMENTO("PAGAMENTO"),
    TERMINADA("TERMINADA");
    private final String nome;

    InterfaceStatus(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}

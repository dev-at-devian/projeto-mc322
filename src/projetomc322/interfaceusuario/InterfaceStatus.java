/*Enum InterfaceStatus
 * */
package projetomc322.interfaceusuario;

public enum InterfaceStatus {
    INICIO("INICIO"),
    CADASTRO("CADASTRO"),
    ADM_CADASTRO_USUARIO("CADASTRO USUARIO"),
    ADM_CADASTRO_PRODUTO("CADASTRO PRODUTO"),
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

/* Enum InterfaceStatus
 * 
 * Representa os "estados"/"menus" possíveis da Interface de
 * usuário
 *
 */
package projetomc322.interfaceusuario;

public enum InterfaceStatus {
    INICIO("INICIO"),
    CREDITOS("CREDITOS"),
    LOGIN("LOGIN"),
    PRINCIPAL("PRINCIPAL"),
    COMPRA("COMPRA"),
    PAGAMENTO("PAGAMENTO"),
    TERMINADA("TERMINADA");
    private final String nome;

    /*--------------------------construtor--------------------------------*/
    InterfaceStatus(String nome) {
        this.nome = nome;
    }


    /*----------------------------getter----------------------------------*/
    public String getNome(){
        return nome;
    }
}

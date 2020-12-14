/*Enumeração CompraStatus
 * Responsável por fornecer os tipos de status de compra existentes
 * Atributo:
 * - descricao
 * 
 * Método:
 * - getDescricao()
 * */
package projetomc322.compra;

public enum CompraStatus {
    CARRINHO("Carrinho"), EM_PROGRESSO("Em Progresso"), EFETUADA("Efetuada");

    private final String descricao;

    /*--------------------------construtor--------------------------------*/
    CompraStatus(String descricao) {
        this.descricao = descricao;
    }

    /*--------------------------geter-------------------------------------*/
    public String getDescricao(){
        return this.descricao;
    }

}

/* Interface MetodoPagamento
 *
 * Fornece os atributos e métodos necessários para um
 * objeto que represente um método de pagamento
 * 
 * Métodos:
 * - pagar(double valor) (não implementado)
 *
 */
package projetomc322.metodosdepagamento;

public interface MetodoPagamento {
    public boolean pagar(double valor);
}

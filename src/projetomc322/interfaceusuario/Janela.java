/*Classe Janela
 * Representa a Janela principal da interface gráfica e é responsável por delegar quais painéis serão exibidos
 * Atributos:
 * -interface
 * 
 * Métodos:
 * - loadPanel
 * - loadProductDetailPanel
 * */
package projetomc322.interfaceusuario;
import java.awt.*;
import javax.swing.*;
import projetomc322.*;
import projetomc322.produtos.Produto;

public class Janela extends JFrame {
    private Interface interf;

    public Janela(Interface interf) {
        super("MC322");
        this.interf = interf;
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().add(new LoginInterface(this));
        this.pack();
        this.setVisible(true);
    }

    public Interface getInterface() {
        return interf;
    }
    /*Método loadPanel:
     * Recebe um status e de acordo com status decide qual será o conteúdo a ser exibido
     */
    public void loadPanel(InterfaceStatus status) {
        this.getContentPane().removeAll();
        switch (status) {
            case LOGIN:
                this.getContentPane().add(new LoginInterface(this));
                break;
            case PRINCIPAL:
                this.getContentPane().add(new MainInterface(this));
                break;
            case CADASTRO:
                this.getContentPane().add(new CadastroInterface(this));
                break;
            case CARRINHO:
                this.getContentPane().add(new CarrinhoInterface(this));
                break;
            case PAGAMENTO:
                this.getContentPane().add(new PagamentoInterface(this));
                break;
            case COMPRAS:
                this.getContentPane().add(new ComprasInterface(this));
                break;
            default:
                break;
        }
        this.pack();
        this.setVisible(true);
    }
    
    /*Método loadProductDetail:
     * Recebe um produto a ser visualizado e cria um novo painel para detalhar o produto
     */
    public void loadProductDetailPanel(Produto product) {
        this.getContentPane().removeAll();
        this.getContentPane().add(new DetalheProdutoInterface(this, product));
        this.pack();
        this.setVisible(true);
    }
}

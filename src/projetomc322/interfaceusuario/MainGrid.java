/*Classe MainGrid
 * Representa  o painel onde são listados os produtos;
 * Atributos:
 * - parentFrame
 * - interf
 * */

package projetomc322.interfaceusuario;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import projetomc322.produtos.Produto;

public class MainGrid extends JPanel{
    private MainInterface parentFrame;
    private Interface interf;
    public MainGrid(MainInterface parentFrame) {
        this.parentFrame = parentFrame;
        this.interf = parentFrame.getParentFrame().getInterface();
        this.setLayout(new GridLayout(3, 2, 10, 10));
        this.setPreferredSize(new Dimension(800,600));
        this.setBackground(Color.RED);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        for (Produto produto : interf.getLojaAtual().getEstoque().getProdutos()) {
            this.add(new ItemFrame(this, produto));
        }
    }
    
    public MainInterface getParentFrame() {
        return this.parentFrame;
    }

}

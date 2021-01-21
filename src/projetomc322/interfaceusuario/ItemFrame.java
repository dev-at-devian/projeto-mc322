/*Classe ItemFrame
 * Responsável por exibir um produto com sua foto e nome. Permite mudar para a interface de detalhar
 * o produto quando clicado.
 * Atributos:
 * -parentFrame
 * */

package projetomc322.interfaceusuario;
import projetomc322.font.*;
import projetomc322.produtos.Produto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemFrame extends JPanel{
    private MainGrid parentPanel;
    public ItemFrame(MainGrid parentPanel, Produto product) {
        this.parentPanel = parentPanel;
        String productName = product.getMarca();
        Image productImage = product.getFoto(0);
        //this.setOpaque(false);
        //this.setLayout(new GridLayout(2,2,10,10));
        this.setPreferredSize(new Dimension(120,240));
        JLabel productLabel = new JLabel(("R$" + product.getPreco()), new ImageIcon(productImage.getScaledInstance(120, 140, java.awt.Image.SCALE_SMOOTH)), JLabel.CENTER);
        productLabel.setVerticalTextPosition(JLabel.BOTTOM);
        productLabel.setHorizontalTextPosition(JLabel.CENTER);
        productLabel.setOpaque(false);
        productLabel.setBackground(Color.WHITE);
        productLabel.setFont(FontSelector.ROBOTO_MEDIUM.getFont().deriveFont(16f));
        this.add(productLabel);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
            }
            @Override
            public void mouseExited(MouseEvent arg0) {
            }
            @Override
            public void mouseClicked(MouseEvent arg0) {
                parentPanel.getParentFrame().getParentFrame().getInterface().trocarParaDetalhesProduto(product);
            }
            @Override
            public void mousePressed(MouseEvent arg0) {
            }
            @Override
            public void mouseReleased(MouseEvent arg0) {
            }
        });
    }
}

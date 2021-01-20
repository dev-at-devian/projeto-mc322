package projetomc322.interfaceusuario;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import projetomc322.font.*;
import projetomc322.produtos.*;

public class CarrinhoItemFrame extends JPanel{
    private CarrinhoInterface parentPanel;
    private Interface interf;
    private Produto product;
    public CarrinhoItemFrame(CarrinhoInterface parentPanel, Produto product) {
        this.parentPanel = parentPanel;
        this.product = product;
        this.interf = parentPanel.getParentFrame().getInterface();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setPreferredSize(new Dimension(750,70));
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        //this.setOpaque(false);
        Font font = null;
        font = FontSelector.ROBOTO_LIGHT.getFont();

        JLabel productLabel = new JLabel(product.getMarca(), new ImageIcon(product.getFoto(0).getScaledInstance(50, 70, java.awt.Image.SCALE_SMOOTH)), JLabel.CENTER);
        productLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        productLabel.setVerticalTextPosition(JLabel.CENTER);
        productLabel.setHorizontalTextPosition(JLabel.RIGHT);

        JButton removeButton = new JButton("Remover");
        removeButton.setFont(FontSelector.ROBOTO_MEDIUM.getFont().deriveFont(16f));
        removeButton.setBackground(Color.RED);
        removeButton.setForeground(Color.WHITE);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                interf.getUsuarioAtual().getCarrinho().removerProduto(product);
                interf.getLojaAtual().atualizarUsuarios();
                interf.trocarPara(InterfaceStatus.CARRINHO);
            }
        });

        this.add(productLabel);
        this.add(removeButton);
    }

}

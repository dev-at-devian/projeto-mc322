/*Classe DetalheProdutoInterface
 * Responsável por exibir a parte mais externa de onde ficarão as informações de produto, criar
 * frame que exibirá detalhes do produto e permitir voltar para a MainInterface.
 * Atributos:
 * - parentFrame
 * - product
 * */

package projetomc322.interfaceusuario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import projetomc322.produtos.Produto;
import projetomc322.font.*;

public class DetalheProdutoInterface extends JPanel{
    private Janela parentFrame;
    private Produto product;
    public DetalheProdutoInterface(Janela parentFrame, Produto product) {
        this.parentFrame = parentFrame;
        this.product = product;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(800,600));
        this.setBackground(Color.RED);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel returnButtonPanel = new JPanel();
        JPanel mainContent = new JPanel();
        returnButtonPanel.setLayout(new BoxLayout(returnButtonPanel, BoxLayout.X_AXIS));
        returnButtonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.X_AXIS));
        mainContent.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainContent.setOpaque(false);

        JButton returnButton = new JButton("Voltar");
        returnButton.setFont(FontSelector.ROBOTO_MEDIUM.getFont().deriveFont(16f));
        returnButton.setBackground(Color.WHITE);
        returnButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                parentFrame.getInterface().trocarPara(InterfaceStatus.PRINCIPAL);
            }
        });

        returnButtonPanel.add(returnButton);

        JLabel productLabel = new JLabel(new ImageIcon(product.getFoto(0).getScaledInstance(400, 500, java.awt.Image.SCALE_SMOOTH)));
        mainContent.add(productLabel);
        mainContent.add(new DetalheProdutoFrame(this));
        this.add(returnButtonPanel);
        this.add(mainContent);
    }

    public Janela getParentFrame() {
        return this.parentFrame;
    }

    public Produto getProduct() {
        return this.product;
    }

}

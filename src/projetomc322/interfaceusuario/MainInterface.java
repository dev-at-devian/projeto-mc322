/*Classe MainInterface
 * Representa  o painel mais externo que possui uma navegação entre o carrinho e as compras;
 * Atributos:
 * -parentFrame
 * */

package projetomc322.interfaceusuario;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import projetomc322.font.FontSelector;

public class MainInterface extends JPanel{
    private Janela parentFrame;
    public MainInterface(Janela parentFrame) {
        this.parentFrame = parentFrame;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(800,600));
        this.setBackground(Color.RED);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton carrinhoButton = new JButton("Carrinho");
        carrinhoButton.setFont(FontSelector.ROBOTO_MEDIUM.getFont().deriveFont(16f));
        carrinhoButton.setBackground(Color.WHITE);
        carrinhoButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        carrinhoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                parentFrame.getInterface().trocarPara(InterfaceStatus.CARRINHO);
            }
        });

        topPanel.add(carrinhoButton);

        JButton comprasButton = new JButton("Compras");
        comprasButton.setFont(FontSelector.ROBOTO_MEDIUM.getFont().deriveFont(16f));
        comprasButton.setBackground(Color.WHITE);
        comprasButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        comprasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                parentFrame.getInterface().trocarPara(InterfaceStatus.COMPRAS);
            }
        });

        topPanel.add(comprasButton);


        this.add(topPanel);
        MainGrid mainGrid = new MainGrid(this);
        JScrollPane scrollPane = new JScrollPane(mainGrid);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane);
    }

    public Janela getParentFrame() {
        return this.parentFrame;
    }

}

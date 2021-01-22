/*Classe ComprasInterface
 * Responsável por exibir a parte mais externa da janela onde serão listadas as compras anteriores. 
 * Cria o botão para retornar para a MainInterface.
 * Atributos:
 * - parentFrame
 * - interf
 * */

package projetomc322.interfaceusuario;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import projetomc322.font.FontSelector;

public class ComprasInterface extends JPanel {
    private Janela parentFrame;
    private Interface interf;
    public ComprasInterface(Janela parentFrame) {
        this.parentFrame = parentFrame;
        this.interf = parentFrame.getInterface();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(800,600));
        this.setBackground(Color.RED);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton returnButton = new JButton("Voltar");
        returnButton.setFont(FontSelector.ROBOTO_MEDIUM.getFont().deriveFont(16f));
        returnButton.setBackground(Color.WHITE);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                parentFrame.getInterface().trocarPara(InterfaceStatus.PRINCIPAL);
            }
        });

        topPanel.add(returnButton);

        
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.setPreferredSize(new Dimension(800,100));
        titlePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        titlePanel.setOpaque(false);

        JLabel titleLabel = new JLabel("Compras");
        titleLabel.setFont(FontSelector.ROBOTO_MEDIUM.getFont().deriveFont(24f));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        titlePanel.add(returnButton);
        titlePanel.add(titleLabel);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setPreferredSize(new Dimension(800,100));
        detailsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        detailsPanel.setOpaque(false);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(titlePanel, BorderLayout.NORTH);

        ComprasList carrinhoList = new ComprasList(this);
        JScrollPane scrollPane = new JScrollPane(carrinhoList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(detailsPanel, BorderLayout.SOUTH);
    }
    public Janela getParentFrame() {
        return this.parentFrame;
    }
}

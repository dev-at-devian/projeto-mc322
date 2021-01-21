/*Classe CarrinhoInterface
 * Responsável por exibir a parte mais externa da janela onde serão listados os produtos
 * do carrinho. Cria o botão para retornar para a MainInterface e o botão de finalizar compra.
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

public class CarrinhoInterface extends JPanel {
    private Janela parentFrame;
    private Interface interf;
    public CarrinhoInterface(Janela parentFrame) {
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

        JLabel titleLabel = new JLabel("Carrinho");
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

        JLabel totalPrice = new JLabel("Total: R$" + interf.getUsuarioAtual().getCarrinho().getValor());
        totalPrice.setFont(FontSelector.ROBOTO_MEDIUM.getFont().deriveFont(16f));
        totalPrice.setForeground(Color.WHITE);

        JButton finishButton = new JButton("Efetuar compra");
        finishButton.setFont(FontSelector.ROBOTO_LIGHT.getFont().deriveFont(24f));
        finishButton.setBackground(Color.WHITE);
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                interf.trocarPara(InterfaceStatus.PAGAMENTO);
            }
        });

        detailsPanel.add(totalPrice);
        detailsPanel.add(finishButton);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(titlePanel, BorderLayout.NORTH);

        CarrinhoList carrinhoList = new CarrinhoList(this);
        JScrollPane scrollPane = new JScrollPane(carrinhoList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(detailsPanel, BorderLayout.SOUTH);
    }
    public Janela getParentFrame() {
        return this.parentFrame;
    }
    public void lol(){
        System.out.println("lol");
    }
}

package projetomc322.interfaceusuario;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import projetomc322.font.*;
import projetomc322.produtos.*;
import projetomc322.compra.*;
import projetomc322.auxiliares.*;

public class ComprasList extends JPanel{
    private ComprasInterface parentPanel;
    private Interface interf;
    public ComprasList(ComprasInterface parentPanel) {
        this.parentPanel = parentPanel;
        this.interf = parentPanel.getParentFrame().getInterface();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        //this.setOpaque(false);
        Font font = null;
        font = FontSelector.ROBOTO_LIGHT.getFont();

        for (Compra compra : interf.getUsuarioAtual().getCompras()) {
            this.add(new JLabel("Compra efetuada em " + Auxiliares.calendarToString(compra.getDataCompra())));
            this.add(new JLabel("Método de pagamento: " + compra.getMetodoPagamento()));
            this.add(new JLabel("Total R$:" + compra.getValor()));
            for (Produto produto : compra.getProdutos()) {
                this.add(new ComprasItemFrame(parentPanel, produto));            
            }
        }        

    }

}

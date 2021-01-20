package projetomc322.interfaceusuario;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import projetomc322.font.*;
import projetomc322.produtos.*;

public class CarrinhoList extends JPanel{
    private CarrinhoInterface parentPanel;
    private Interface interf;
    public CarrinhoList(CarrinhoInterface parentPanel) {
        this.parentPanel = parentPanel;
        this.interf = parentPanel.getParentFrame().getInterface();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        //this.setOpaque(false);
        Font font = null;
        font = FontSelector.ROBOTO_LIGHT.getFont();

        for (Produto product : interf.getUsuarioAtual().getCarrinho().getProdutos()) {
            this.add(new CarrinhoItemFrame(parentPanel, product));            
        }        

    }

}

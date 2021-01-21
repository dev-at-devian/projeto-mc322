/*Classe PagamentoFrame
 * Responsável pela criação e estilizaçãp dos inputs e do botão. Cria três opções de métodos de pagamento
 *  diferentes: boleto, novo cartão e método já salvo
 * Atributos:
 * -parentFrame
 * -interf
 * */

package projetomc322.interfaceusuario;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import projetomc322.auxiliares.Auxiliares;
import projetomc322.font.*;
import projetomc322.metodosdepagamento.*;
import projetomc322.usuario.Estado;

public class PagamentoFrame extends JPanel{
    private PagamentoInterface parentPanel;
    private Interface interf;
    public PagamentoFrame(PagamentoInterface parentPanel) {
        this.parentPanel = parentPanel;
        this.interf = parentPanel.getParentFrame().getInterface();
        //this.setOpaque(false);
        Font font = null;
        try {
            font = FontSelector.ROBOTO_LIGHT.getFont();
        } catch(Exception e){
            e.printStackTrace();
        }

        this.setBorder(new EmptyBorder(5, 5, 5, 5));

        this.setPreferredSize(new Dimension(700,400));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Método de Pagamento");
        titleLabel.setFont(font.deriveFont(30f));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(titleLabel);

        JPanel partContainer = new JPanel();
        //partContainer.setPreferredSize(new Dimension(700,400));
        partContainer.setLayout(new BoxLayout(partContainer, BoxLayout.X_AXIS));
        
        JPanel firstPart = new JPanel();
        firstPart.setPreferredSize(new Dimension(300,400));
        firstPart.setLayout(new BoxLayout(firstPart, BoxLayout.Y_AXIS));

        JPanel secondPart = new JPanel();
        secondPart.setPreferredSize(new Dimension(300,400));
        secondPart.setLayout(new BoxLayout(secondPart, BoxLayout.Y_AXIS));

        JLabel l_cartao = new JLabel("Cartão");
        l_cartao.setFont(font.deriveFont(24f));
        l_cartao.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstPart.add(l_cartao);

        JLabel l_nome = new JLabel("Nome do Titular");
        l_nome.setFont(font.deriveFont(20f));
        l_nome.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstPart.add(l_nome);
        
        JTextField nome = new JTextField();
        nome.setFont(font.deriveFont(20f));
        nome.setColumns(10);
        firstPart.add(nome);
        
        JLabel l_cpf = new JLabel("CPF do titular");
        l_cpf.setFont(font.deriveFont(20f));
        l_cpf.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstPart.add(l_cpf);
        
        JTextField cpf = new JTextField();
        cpf.setFont(font.deriveFont(20f));
        cpf.setColumns(10);
        firstPart.add(cpf);
        
        JLabel l_numero = new JLabel("Número");
        l_numero.setFont(font.deriveFont(20f));
        l_numero.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstPart.add(l_numero);
        
        JTextField numero = new JTextField();
        numero.setFont(font.deriveFont(20f));
        numero.setColumns(10);
        firstPart.add(numero);
        
        JLabel l_dataExpiracao = new JLabel("Data de Expiração");
        l_dataExpiracao.setFont(font.deriveFont(20f));
        l_dataExpiracao.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstPart.add(l_dataExpiracao);

        GregorianCalendar data = new GregorianCalendar(); 
        JFormattedTextField dataExpiracao = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.MEDIUM));
        dataExpiracao.setText(data.get(Calendar.DAY_OF_MONTH)+"/"+(data.get(Calendar.MONTH)+1)+"/"+(data.get(Calendar.YEAR)));
        dataExpiracao.setFont(font.deriveFont(20f));
        firstPart.add(dataExpiracao);
        
        JLabel l_cvv = new JLabel("CVV");
        l_cvv.setFont(font.deriveFont(20f));
        l_cvv.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstPart.add(l_cvv);
        
        JTextField cvv = new JTextField();
        cvv.setFont(font.deriveFont(20f));
        cvv.setColumns(10);
        firstPart.add(cvv);

        JButton pagar = new JButton("Pagar com cartão");
        pagar.setFont(font.deriveFont(24f));
        pagar.setBackground(Color.WHITE);
        pagar.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstPart.add(pagar);

        pagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String numeroStr = numero.getText();
                Calendar dataExpiracaoCalendar = Auxiliares.stringToCalendar(dataExpiracao.getText());
                int cvvInt = Integer.valueOf(cvv.getText());
                String nomeTitular = nome.getText();
                int cpfTitular = Integer.valueOf(cpf.getText());
                Cartao cartao = new Cartao(numeroStr, dataExpiracaoCalendar, cvvInt, nomeTitular, cpfTitular);
                interf.getUsuarioAtual().adicionarMetodoDePagamento(cartao);
                interf.getUsuarioAtual().getCarrinho().setMetodoDePagamento(cartao);
                interf.getUsuarioAtual().getCarrinho().efetuarCompra(interf.getLojaAtual());
                interf.getLojaAtual().atualizarUsuarios();
                interf.trocarPara(InterfaceStatus.COMPRAS);
            }
        });

        JLabel l_salvo = new JLabel("Métodos Salvos");
        l_salvo.setFont(font.deriveFont(24f));
        l_salvo.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondPart.add(l_salvo);

        JComboBox salvo = new JComboBox<MetodoPagamento>();
        for (MetodoPagamento metodoPagamento : interf.getUsuarioAtual().getCarteira()) {
            salvo.addItem(metodoPagamento);
        }
        salvo.setFont(font.deriveFont(20f));
        secondPart.add(salvo);

        JButton salvoBtn = new JButton("Pagar");
        salvoBtn.setFont(font.deriveFont(24f));
        salvoBtn.setBackground(Color.WHITE);
        salvoBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondPart.add(salvoBtn);

        salvoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MetodoPagamento metodoPagamento = (MetodoPagamento) salvo.getSelectedItem();
                interf.getUsuarioAtual().getCarrinho().setMetodoDePagamento(metodoPagamento);
                interf.getUsuarioAtual().getCarrinho().efetuarCompra(interf.getLojaAtual());
                interf.getLojaAtual().atualizarUsuarios();
                interf.trocarPara(InterfaceStatus.COMPRAS);
            }
        });


        JLabel l_boleto = new JLabel("Boleto");
        l_boleto.setFont(font.deriveFont(24f));
        l_boleto.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondPart.add(l_boleto);

        JButton boleto = new JButton("Emitir Boleto");
        boleto.setFont(font.deriveFont(24f));
        boleto.setBackground(Color.WHITE);
        boleto.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondPart.add(boleto);

        boleto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Boleto boleto = interf.getLojaAtual().fornecerBoleto(interf.getUsuarioAtual());
                interf.getUsuarioAtual().adicionarMetodoDePagamento(boleto);
                interf.getUsuarioAtual().getCarrinho().setMetodoDePagamento(boleto);
                interf.getUsuarioAtual().getCarrinho().efetuarCompra(interf.getLojaAtual());
                interf.getLojaAtual().atualizarUsuarioAtual(interf);
                interf.getLojaAtual().atualizarUsuarios();
                interf.trocarPara(InterfaceStatus.COMPRAS);
            }
        });

        partContainer.add(firstPart);
        partContainer.add(secondPart);
        this.add(partContainer);

        JLabel lblErro = new JLabel("Email/senha incorretos!");
        lblErro.setFont(font.deriveFont(12f));
        lblErro.setForeground(Color.RED);
        lblErro.setVisible(false);
        this.add(lblErro);

    }

}

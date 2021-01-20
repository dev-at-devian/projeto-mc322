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
import projetomc322.usuario.Endereco;
import projetomc322.usuario.Estado;
import projetomc322.usuario.UsuarioComum;

public class CadastroFrame extends JPanel{
    private CadastroInterface parentPanel;
    private Interface interf;
    public CadastroFrame(CadastroInterface parentPanel) {
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

        JLabel titleLabel = new JLabel("Cadastro");
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

        JLabel l_nome = new JLabel("Nome");
        l_nome.setFont(font.deriveFont(20f));
        l_nome.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstPart.add(l_nome);
        
        JTextField nome = new JTextField();
        nome.setFont(font.deriveFont(20f));
        nome.setColumns(10);
        firstPart.add(nome);
        
        JLabel l_email = new JLabel("Email");
        l_email.setFont(font.deriveFont(20f));
        l_email.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstPart.add(l_email);
        
        JTextField email = new JTextField();
        email.setFont(font.deriveFont(20f));
        email.setColumns(10);
        firstPart.add(email);
        
        JLabel l_senha = new JLabel("Senha");
        l_senha.setFont(font.deriveFont(20f));
        l_senha.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstPart.add(l_senha);
        
        JPasswordField senha = new JPasswordField();
        senha.setFont(font.deriveFont(20f));
        senha.setColumns(10);
        firstPart.add(senha);
        
        JLabel l_dataNascimento = new JLabel("Data de Nascimento");
        l_dataNascimento.setFont(font.deriveFont(20f));
        l_dataNascimento.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstPart.add(l_dataNascimento);

        GregorianCalendar data = new GregorianCalendar(); 
        JFormattedTextField dataNascimento = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.MEDIUM));
        dataNascimento.setText(data.get(Calendar.DAY_OF_MONTH)+"/"+(data.get(Calendar.MONTH)+1)+"/"+(data.get(Calendar.YEAR)));
        dataNascimento.setFont(font.deriveFont(20f));
        firstPart.add(dataNascimento);
        
        JLabel l_cpf = new JLabel("CPF");
        l_cpf.setFont(font.deriveFont(20f));
        l_cpf.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstPart.add(l_cpf);
        
        JTextField cpf = new JTextField();
        cpf.setFont(font.deriveFont(20f));
        cpf.setColumns(10);
        firstPart.add(cpf);
        
        JLabel l_telefone = new JLabel("Telefone");
        l_telefone.setFont(font.deriveFont(20f));
        l_telefone.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstPart.add(l_telefone);
        
        JTextField telefone = new JTextField();
        telefone.setFont(font.deriveFont(20f));
        telefone.setColumns(10);
        firstPart.add(telefone);


        JLabel l_cep = new JLabel("CEP");
        l_cep.setFont(font.deriveFont(20f));
        l_cep.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondPart.add(l_cep);

        JTextField cep = new JTextField();
        cep.setFont(font.deriveFont(20f));
        cep.setColumns(10);
        secondPart.add(cep);

        JLabel l_estado = new JLabel("Estado");
        l_estado.setFont(font.deriveFont(20f));
        l_estado.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondPart.add(l_estado);

        JComboBox estado = new JComboBox(Estado.values());
        estado.setFont(font.deriveFont(20f));
        secondPart.add(estado);

        JLabel l_cidade = new JLabel("Cidade");
        l_cidade.setFont(font.deriveFont(20f));
        l_cidade.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondPart.add(l_cidade);

        JTextField cidade = new JTextField();
        cidade.setFont(font.deriveFont(20f));
        cidade.setColumns(10);
        secondPart.add(cidade);

        JLabel l_logradouro = new JLabel("Logradouro");
        l_logradouro.setFont(font.deriveFont(20f));
        l_logradouro.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondPart.add(l_logradouro);

        JTextField logradouro = new JTextField();
        logradouro.setFont(font.deriveFont(20f));
        logradouro.setColumns(10);
        secondPart.add(logradouro);

        JLabel l_numero = new JLabel("Numero");
        l_numero.setFont(font.deriveFont(20f));
        l_numero.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondPart.add(l_numero);

        JTextField numero = new JTextField();
        numero.setFont(font.deriveFont(20f));
        numero.setColumns(10);
        secondPart.add(numero);

        JLabel l_bairro = new JLabel("Bairro");
        l_bairro.setFont(font.deriveFont(20f));
        l_bairro.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondPart.add(l_bairro);

        JTextField bairro = new JTextField();
        bairro.setFont(font.deriveFont(20f));
        bairro.setColumns(10);
        secondPart.add(bairro);

        partContainer.add(firstPart);
        partContainer.add(secondPart);
        this.add(partContainer);

        JLabel lblErro = new JLabel("Email/senha incorretos!");
        lblErro.setFont(font.deriveFont(12f));
        lblErro.setForeground(Color.RED);
        lblErro.setVisible(false);
        this.add(lblErro);

        JButton signUpButton = new JButton("Cadastrar");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String emailStr = email.getText();
                String senhaStr = String.valueOf(senha.getPassword());
                String nomeStr = nome.getText();
                Calendar dataNascimentoCalendar = Auxiliares.stringToCalendar(dataNascimento.getText());
                int cpfInt = Integer.valueOf(cpf.getText());
                Endereco enderecoEnd = new Endereco();
                enderecoEnd.setCep(Integer.valueOf(cep.getText()));
                enderecoEnd.setNumero(Integer.valueOf(numero.getText()));
                enderecoEnd.setBairro(bairro.getText());
                enderecoEnd.setEstado((Estado)estado.getSelectedItem());
                enderecoEnd.setCidade(cidade.getText());
                enderecoEnd.setLogradouro(logradouro.getText());
                String telefoneStr = telefone.getText();
                UsuarioComum usr = new UsuarioComum(emailStr, senhaStr, nomeStr, dataNascimentoCalendar, cpfInt, enderecoEnd, telefoneStr);
                interf.getLojaAtual().adicionarUsuario(usr);
                interf.trocarPara(InterfaceStatus.LOGIN);
            }
        });
        this.add(signUpButton);
    }

}

package projetomc322.interfaceusuario;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import projetomc322.font.*;

public class LoginFrame extends JPanel{
    private LoginInterface parentPanel;
    public LoginFrame(LoginInterface parentPanel) {
        this.parentPanel = parentPanel;
        //this.setOpaque(false);
        Font font = null;
        try {
            font = FontSelector.ROBOTO_LIGHT.getFont();
        } catch(Exception e){
            e.printStackTrace();
        }

        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setPreferredSize(new Dimension(400,200));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(font.deriveFont(24f));
        lblEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        //lblEmail.setForeground(Color.WHITE);
        this.add(lblEmail);
          
        JTextField txtEmail = new JTextField();
        txtEmail.setFont(font.deriveFont(24f));
        this.add(txtEmail);
        txtEmail.setColumns(20);
              
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(font.deriveFont(24f));
        lblSenha.setAlignmentX(Component.CENTER_ALIGNMENT);
        //lblSenha.setForeground(Color.WHITE);
        this.add(lblSenha);

        JPasswordField pwdSenha = new JPasswordField();
        pwdSenha.setFont(font.deriveFont(24f));
        pwdSenha.setColumns(20);
        this.add(pwdSenha);
        
        JLabel lblErro = new JLabel("Email/senha incorretos!");
        lblErro.setFont(font.deriveFont(12f));
        lblErro.setForeground(Color.RED);
        lblErro.setVisible(false);
        this.add(lblErro);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setFont(font.deriveFont(24f));
        btnEntrar.setBackground(Color.WHITE);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setFont(font.deriveFont(24f));
        btnCadastrar.setBackground(Color.WHITE);

        btnEntrar.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            String emailStr = txtEmail.getText();
            String passwordStr = String.valueOf(pwdSenha.getPassword());
            boolean success = parentPanel.getParentFrame().getInterface().handleLogin(emailStr, passwordStr);
            if (!success) {
                lblErro.setVisible(true);
            } else {
                lblErro.setVisible(false);
                parentPanel.getParentFrame().getInterface().trocarPara(InterfaceStatus.PRINCIPAL);
            }
          }
        });

        btnCadastrar.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            parentPanel.getParentFrame().getInterface().trocarPara(InterfaceStatus.CADASTRO);
          }
        });


        //this.add(btnEntrar);

        JPanel btns = new JPanel();
        btns.setLayout(new FlowLayout());
        btns.add(btnEntrar);
        btns.add(btnCadastrar);
        this.add(btns);
    }

}

package InterfaceGrafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import projetomc322.interfaceusuario.Interface;
import projetomc322.interfaceusuario.InterfaceStatus;
import projetomc322.usuario.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField pwdSenha;
	private Interface interf;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Login(Interface interf) {
		this.interf = interf;
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(42, 63, 70, 15);
		contentPane.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(42, 122, 70, 15);
		contentPane.add(lblSenha);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(110, 61, 277, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(110, 120, 277, 19);
		contentPane.add(pwdSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleLogin();
				
			}
		});
		btnEntrar.setBounds(166, 193, 117, 25);
		contentPane.add(btnEntrar);
	}
	
	private void handleLogin() {
		System.out.println("OI");
		Usuario usr = interf.getLojaAtual().obterUsuario(txtEmail.getText(), pwdSenha.getText());
    	if (!(usr == null)) {
            interf.setUsuarioAtual(usr);
            interf.trocarPara(InterfaceStatus.CREDITOS);
            interf.printListaDeComandos(InterfaceStatus.PRINCIPAL);
            interf.trocarPara(InterfaceStatus.PRINCIPAL);
            close();
        }else {
        	JOptionPane.showMessageDialog(null, "Email/senha incorretos!");
        }
	}
	
	private void close() {
		this.setVisible(false);
	}
}

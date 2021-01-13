package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class CadastroUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JLabel l_email;
	private JTextField email;
	private JLabel l_senha;
	private JTextField senha;
	private JLabel l_dataNascimento;
	private JLabel l_cpf;
	private JTextField cpf;
	private JButton next;
	private JLabel l_telefone;
	private JTextField telefone;
	private JFormattedTextField dataNascimento;
	private GregorianCalendar data = new GregorianCalendar();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public CadastroUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l_nome = new JLabel("Nome");
		l_nome.setBounds(32, 14, 70, 15);
		contentPane.add(l_nome);
		
		nome = new JTextField();
		nome.setBounds(32, 27, 363, 19);
		contentPane.add(nome);
		nome.setColumns(10);
		
		l_email = new JLabel("Email");
		l_email.setBounds(32, 49, 70, 15);
		contentPane.add(l_email);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(32, 62, 363, 19);
		contentPane.add(email);
		
		l_senha = new JLabel("Senha");
		l_senha.setBounds(32, 85, 70, 15);
		contentPane.add(l_senha);
		
		senha = new JTextField();
		senha.setColumns(10);
		senha.setBounds(32, 98, 363, 19);
		contentPane.add(senha);
		
		l_dataNascimento = new JLabel("Data de Nascimento");
		l_dataNascimento.setBounds(32, 123, 166, 15);
		contentPane.add(l_dataNascimento);
		dataNascimento = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.MEDIUM));
		dataNascimento.setText(data.get(Calendar.DAY_OF_MONTH)+"/"+(data.get(Calendar.MONTH)+1)+"/"+(data.get(Calendar.YEAR)));
		dataNascimento.setBounds(32, 141, 363, 19);
		contentPane.add(dataNascimento);
		
		l_cpf = new JLabel("CPF");
		l_cpf.setBounds(32, 159, 166, 15);
		contentPane.add(l_cpf);
		
		cpf = new JTextField();
		cpf.setColumns(10);
		cpf.setBounds(32, 172, 363, 19);
		contentPane.add(cpf);
		
		next = new JButton("Next");
		next.setBounds(278, 238, 117, 20);
		contentPane.add(next);
		
		l_telefone = new JLabel("Telefone");
		l_telefone.setBounds(32, 194, 166, 15);
		contentPane.add(l_telefone);
		
		telefone = new JTextField();
		telefone.setColumns(10);
		telefone.setBounds(32, 207, 363, 19);
		contentPane.add(telefone);
	}
	
	protected JButton getNext() {
		return next;
	}

	public String getNome() {
		return nome.getText();
	}

	public String getEmail() {
		return email.getText();
	}

	public String getSenha() {
		return senha.getText();
	}

	public int getCpf() {
		return Integer.parseInt(cpf.getText());
	}

	public String getTelefone() {
		return telefone.getText();
	}

	public Calendar getDataNascimento() {
		return data;
	}
}

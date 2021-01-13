package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import projetomc322.usuario.Estado;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class CadastroEndereco extends JFrame {

	private JPanel contentPane;
	private JTextField cep;
	private JTextField cidade;
	private JTextField logradouro;
	private JTextField numero;
	private JButton finalizar; 
	private JComboBox estado;
	private JLabel l_bairro;
	private JTextField bairro;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CadastroEndereco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l_cep = new JLabel("CEP");
		l_cep.setBounds(12, 0, 70, 15);
		contentPane.add(l_cep);
		
		cep = new JTextField();
		cep.setBounds(12, 16, 384, 19);
		contentPane.add(cep);
		cep.setColumns(10);
		
		JLabel l_estado = new JLabel("Estado");
		l_estado.setBounds(12, 39, 70, 15);
		contentPane.add(l_estado);
		
		estado = new JComboBox(Estado.values());
		estado.setBounds(12, 56, 384, 24);
		contentPane.add(estado);
		
		JLabel l_cidade = new JLabel("Cidade");
		l_cidade.setBounds(12, 81, 70, 15);
		contentPane.add(l_cidade);
		
		cidade = new JTextField();
		cidade.setColumns(10);
		cidade.setBounds(12, 97, 384, 19);
		contentPane.add(cidade);
		
		JLabel l_logradouro = new JLabel("Logradouro");
		l_logradouro.setBounds(12, 151, 222, 15);
		contentPane.add(l_logradouro);
		
		logradouro = new JTextField();
		logradouro.setColumns(10);
		logradouro.setBounds(12, 167, 384, 19);
		contentPane.add(logradouro);
		
		JLabel l_numero = new JLabel("Numero");
		l_numero.setBounds(12, 191, 222, 15);
		contentPane.add(l_numero);
		
		numero = new JTextField();
		numero.setColumns(10);
		numero.setBounds(12, 207, 384, 19);
		contentPane.add(numero);
		
		finalizar = new JButton("Finalizar");
		finalizar.setBounds(296, 238, 117, 25);
		contentPane.add(finalizar);
		
		l_bairro = new JLabel("Bairro");
		l_bairro.setBounds(12, 120, 70, 15);
		contentPane.add(l_bairro);
		
		bairro = new JTextField();
		bairro.setColumns(10);
		bairro.setBounds(12, 136, 384, 19);
		contentPane.add(bairro);
	}
	
	protected JButton getFinalizar() {
		return finalizar;
	}


	public int getCep() {
		return Integer.parseInt(cep.getText());
	}

	public String getCidade() {
		return cidade.getText();
	}

	public String getLogradouro() {
		return logradouro.getText();
	}

	public int getNumero() {
		return Integer.parseInt(numero.getText());
	}
	
	public Estado getEstado() {
		return (Estado) estado.getSelectedItem();
	}
	
	public String getBairro() {
		return bairro.getText();
	}

}

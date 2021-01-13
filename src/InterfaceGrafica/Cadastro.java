package InterfaceGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import projetomc322.interfaceusuario.Interface;
import projetomc322.interfaceusuario.InterfaceStatus;
import projetomc322.usuario.Endereco;
import projetomc322.usuario.UsuarioComum;

public class Cadastro implements ActionListener{
	
	private JButton finalizar;
	private JButton next;
	private CadastroUsuario frameUsuario = new CadastroUsuario();
	private CadastroEndereco frameEndereco = new CadastroEndereco();
	private Interface interf;
	
	
	public Cadastro(Interface interf) {
		this.interf = interf;
	}
	public void janela() {
		next = frameUsuario.getNext();
		next.addActionListener(this);
		frameUsuario.setVisible(true);
		finalizar = frameEndereco.getFinalizar();
		finalizar.addActionListener(this);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == next) {
			frameUsuario.setVisible(false);
			frameEndereco.setVisible(true);
		}else {
			frameEndereco.setVisible(false);
			try {
				Endereco end = new Endereco(this.frameEndereco.getCep(), this.frameEndereco.getEstado(),
						this.frameEndereco.getCidade(), this.frameEndereco.getBairro(), 
						this.frameEndereco.getLogradouro(), this.frameEndereco.getNumero());
				UsuarioComum user = new UsuarioComum(this.frameUsuario.getEmail(), this.frameUsuario.getSenha(),
						this.frameUsuario.getNome(), this.frameUsuario.getDataNascimento(), this.frameUsuario.getCpf(),
				end, this.frameUsuario.getTelefone());
				interf.getLojaAtual().addUsuario(user);
				interf.trocarPara(InterfaceStatus.LOGIN);
				
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Dados inválidos, preencha novamente");
				janela();
			}
		}
	}


	public CadastroUsuario getFrameUsuario() {
		return frameUsuario;
	}

	public CadastroEndereco getFrameEndereco() {
		return frameEndereco;
	}
}

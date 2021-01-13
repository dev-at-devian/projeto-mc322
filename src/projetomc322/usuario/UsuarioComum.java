package projetomc322.usuario;

import java.util.Calendar;

public class UsuarioComum extends Usuario{
	public UsuarioComum(String email, String senha, String nome, Calendar dataNascimento, int cpf,
            Endereco endereco, String telefone) {
		super(email, senha, nome, dataNascimento, cpf, endereco, telefone);
	}

}

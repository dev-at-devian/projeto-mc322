/* Classe Endereço
 * Responsável por fornecer o endereço de um usuario:
 * - cep
 * - estado
 * - cidade
 * - bairro
 * - logradouro
 * - número
 * 
 * Métodos:
 * - geters/seters
 * - toString()
 * */

package projetomc322.usuario;

public class Endereco {
    private int cep;
    private Estado estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private int numero;
    
/*-----------------construtor---------------------------------------------------------*/
    public Endereco() {
    	
    }
    
    public Endereco(int cep, Estado estado, String cidade, String bairro, String lougradouro, int numero) {
    	this.cep = cep;
    	this.estado = estado;
    	this.cidade = cidade;
    	this.bairro = bairro;
    	this.logradouro = lougradouro;
    	this.numero = numero;
    }
    
/*-----------------------------------geters/seters---------------------------------------------*/
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
/*Método toString:
* Devolve todas as informações do boleto em formato de string
* */
	@Override
	public String toString() {
		 String tmpStr = "Endereço: \n" +
				 		 "- Cep: " + this.cep + "\n" +
				 		 "- Logradouro: " + this.logradouro + "\n" +
				 		 "- Numero: " + this.numero + "\n" +
				 		 "- Bairro: " + this.bairro + "\n" +
				 		 "- Cidade: " + this.cidade + "\n" +
				 		 "- Estado: " + this.estado.getDescricao() + "-" + this.estado.getSigla() + "\n";
		 return tmpStr;
	
	}
}

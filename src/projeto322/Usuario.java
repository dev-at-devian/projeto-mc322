package projeto322;

import java.util.*;

public class Usuario {
    private String email;
    private String senha;
    private String nome;
    private Calendar dataNascimento;
    private int cpf;
    private Endereco endereco;
    private String telefone;
    private ArrayList<MetodoPagamento> carteira;
    private ArrayList<Produto> compras;
    private ArrayList<Produto> carrinho;

    public Usuario(String email, String senha, String nome, Calendar dataNascimento, int cpf,
            Endereco endereco, String telefone) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.carteira = new ArrayList<MetodoPagamento>();
        this.compras = new ArrayList<Produto>();
        this.carrinho = new ArrayList<Produto>();
    }


    public Usuario(String email, String senha, String nome, Calendar dataNascimento, int cpf,
            Endereco endereco, String telefone, ArrayList<MetodoPagamento> carteira,
            ArrayList<Produto> compras, ArrayList<Produto> carrinho) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.carteira = carteira;
        this.compras = compras;
        this.carrinho = carrinho;
    }

    public ArrayList<MetodoPagamento> getCarteira() {
        return this.carteira;
    }

}

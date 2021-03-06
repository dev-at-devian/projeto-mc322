package projetomc322;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.xml.transform.TransformerException;

import projetomc322.interfaceusuario.Interface;
import projetomc322.loja.Loja;
import projetomc322.metodosdepagamento.Cartao;
import projetomc322.usuario.CarregadorUsuario;
import projetomc322.usuario.*;

public class Main {
    public static void main(String[] args) {
    	System.setProperty("awt.useSystemAAFontSettings","on");
    	System.setProperty("swing.aatext", "true");
    	Scanner scan = new Scanner (System.in);
        Loja loja = new Loja("Loja Teste", "http://www.example.com", "95.056.338/0001-71", "(12) 34567-8910", "teste@gmail.com");
        loja.carregarUsuarios();
        //UsuarioComum usuario = new UsuarioComum("teste@gmail.com", "senha", "Teste da Silva", Calendar.getInstance(), 1234567, new Endereco(), "(19) 91234-5678");
        //usuario.getCarrinho().adicionarProduto(loja.getEstoque().getProdutos().get(0));
        //usuario.getCarrinho().adicionarProduto(loja.getEstoque().getProdutos().get(1));
        //usuario.getCarrinho().adicionarProduto(loja.getEstoque().getProdutos().get(2));
        //usuario.getCarrinho().adicionarProduto(loja.getEstoque().getProdutos().get(3));
        //usuario.adicionarMetodoDePagamento(new Cartao("123", Calendar.getInstance(), 123, "teste", 456));
        //loja.addUsuario(usuario);
        Interface interf = new Interface(loja);
        interf.iniciar();
        
    }
}

package projetomc322;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.transform.TransformerException;

public class Main {
    public static void main(String[] args) {

        Loja loja = new Loja("Loja Teste", "http://www.example.com", "95.056.338/0001-71", "(12) 34567-8910", "teste@gmail.com");
        Cartao cartao = new Cartao("1234 5678 9101 1121", Calendar.getInstance(), 999, "Teste da Silva", "123.456.789-10");
        Boleto boleto = new Boleto("BANK", "Loja", "Teste da Silva", 12403, Calendar.getInstance(), 1345678);

        Usuario usuario = new Usuario("teste@gmail.com", "senha", "Teste da Silva", Calendar.getInstance(), 1234567, new Endereco(), "(19) 91234-5678");

        usuario.getCarteira().add(cartao);
        usuario.getCarteira().add(boleto);

        System.out.println(usuario.getCarteira());

        System.out.println("Teste!");
        loja.getEstoque().carregarEstoque();
        System.out.println(loja.getEstoque().getProdutos());
        
        //ArrayList<Image> fotos = new ArrayList<Image>();
        //estoque.adicionarProduto(new Produto(1, "produto", fotos, "abc", 123.45));
        //estoque.adicionarProduto(new Eletrodomestico(2, "eletrodomestico", fotos, "def", 6789.10, 110, 1, 2, 3, "Azul", "ABC-123"));
        //loja.getEstoque().adicionarProduto(new Computador(3, "computador", fotos, "ghi", 11121.31, 220, 4, 5, 6, "Rosa", "COMPUTER", "Intel Core i7-7000", "Arch Linux", 16, 2000));
        //loja.getEstoque().adicionarProduto(new Fogao(4, "fogao", fotos, "jkl", 415.16, 110, 7, 8, 9, "Roxo", "FOGO444", 2, TipoFogao.PISO, true));
        //loja.getEstoque().adicionarProduto(new Geladeira(5, "geladeira", fotos, "mno", 1718.19, 220, 10, 11, 12, "Preto", "HAJD71", 2, true, false));
        //loja.getEstoque().adicionarProduto(new TV(6, "tv", fotos, "pqr", 2021.22, 110, 13, 14, 15, "Branco", "SmartABC", Tela.OLED, true));
        //loja.getEstoque().carregarEstoque();
        //System.out.println(loja.getEstoque().getProdutos());


    }
}

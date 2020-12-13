package projetomc322;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.xml.transform.TransformerException;

public class Main {
    public static void main(String[] args) {
    	Scanner scan = new Scanner (System.in);
        Loja loja = new Loja("Loja Teste", "http://www.example.com", "95.056.338/0001-71", "(12) 34567-8910", "teste@gmail.com");
        Usuario usuario = new Usuario("teste@gmail.com", "senha", "Teste da Silva", Calendar.getInstance(), 1234567, new Endereco(), "(19) 91234-5678");

        //System.out.println(usuario.getCarteira());

        System.out.println("Teste!");
        loja.getEstoque().carregarEstoque();
        
        System.out.println(loja.getEstoque().getProdutos());
        System.out.println("Digite o código do produto desejado");
        Produto desejado = loja.getEstoque().findProduto(scan.nextInt());
        usuario.adicionarAoCarrinho(desejado);
        
        System.out.println("Carrinho: \n" + usuario.getCarrinho());
        System.out.println("Valor: R$ " + usuario.calcularValorCompra());
        
        System.out.println("Deseja finalizar a compra? \n 1- Sim \n 2- Não");
        int respostaFinalizar = scan.nextInt();
        
        if(respostaFinalizar == 1) {
        	
        	System.out.println("Método de pagamento: \n 1- Boleto \n 2- Cartão");
        	int respostaMetodo = scan.nextInt();
        	
        	if(respostaMetodo == 1) {
        		Boleto boleto = loja.fornecerBoleto(usuario);
        		boleto.toString();
        		System.out.println("Pagar? \n 1- Sim \n 2- Não");
        	 
        		if(scan.nextInt() == 1) {
        			boolean pago = boleto.pagar(boleto.getValor());
        			loja.receberPagamento(pago, boleto.getValor());
        			usuario.moverCarrinhoParaCompra(pago);
        			System.out.println("Compra feita com sucesso!");
        			System.out.println("Caixa da loja: R$ " + loja.getCaixa());
        		}else {
        			//voltar produtos para o estoque
        			System.exit(0);
        		}
        		
        	}else {
        		System.out.println("Novo cartão: \n");
        		
        		System.out.println("Número do cartão: \n");
        		String numeroCartao = scan.nextLine();
        		scan.nextLine();
        		
        		System.out.println("Número cvv: \n");
        		int cvv = scan.nextInt();
        		scan.nextLine();
        		Cartao cartao = usuario.adicionarCartão(numeroCartao, Calendar.getInstance() , cvv);
        		
        		System.out.println("Pagar? \n 1- Sim \n 2- Não");
        		
        		if(scan.nextInt() == 1) {
        			boolean pagoCartao = cartao.pagar(usuario.calcularValorCompra());
        			loja.receberPagamento(pagoCartao, usuario.calcularValorCompra());
        			usuario.moverCarrinhoParaCompra(pagoCartao);
        			System.out.println("Compra feita com sucesso!");
        			System.out.println("Caixa da loja: R$ " + loja.getCaixa());
        		}else {
        			//voltar produtos para o estoque
        			System.exit(0);
        		}        		
        	}
        }else {
        	//voltar produtos para o estoque
        	System.exit(0);
        }
        
        
        
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

package projeto322;

import java.util.Calendar;

public class Main {
    public static void main(String[] args)  {

        Cartao cartao = new Cartao("1234 5678 9101 1121", Calendar.getInstance(), 999, "Teste da Silva", "123.456.789-10");
        Boleto boleto = new Boleto("BANK", "Loja", "Teste da Silva", 12403, Calendar.getInstance(), 1345678);

        Usuario usuario = new Usuario("teste@gmail.com", "senha", "Teste da Silva", Calendar.getInstance(), 1234567, new Endereco(), "(19) 91234-5678");

        usuario.getCarteira().add(cartao);
        usuario.getCarteira().add(boleto);

        System.out.println(usuario.getCarteira());

        System.out.println("Teste!");
    }
}

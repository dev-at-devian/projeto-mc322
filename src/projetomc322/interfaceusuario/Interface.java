package projetomc322.interfaceusuario;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import projetomc322.auxiliares.Auxiliares;
import projetomc322.compra.Compra;
import projetomc322.loja.Loja;
import projetomc322.metodosdepagamento.Boleto;
import projetomc322.metodosdepagamento.Cartao;
import projetomc322.metodosdepagamento.MetodoPagamento;
import projetomc322.produtos.Eletrodomestico;
import projetomc322.produtos.Produto;
import projetomc322.usuario.*;
import java.util.ArrayList;

public class Interface {
    private InterfaceStatus status;
    private Usuario usuarioAtual;
    private Scanner scan;
    private Loja lojaAtual;
    private Janela janela;


    public Interface(Loja loja) {
        lojaAtual = loja;
        usuarioAtual = null;
        janela = new Janela(this);
        status = InterfaceStatus.INICIO;
        scan = new Scanner(System.in);
    }

    public Loja getLojaAtual() {
    	return lojaAtual;
    }
    
    public InterfaceStatus getStatus() {
    	return status;
    }
    
    public Usuario getUsuarioAtual() {
    	return usuarioAtual;
    }
    
    public void setUsuarioAtual(Usuario user) {
    	usuarioAtual = user;
    }
    
    public void iniciar() {
        status = InterfaceStatus.INICIO;
        trocarPara(InterfaceStatus.LOGIN);
        //status = InterfaceStatus.TERMINADA;
        //scan.close();
    }


    public void trocarPara(InterfaceStatus st) {
        InterfaceStatus ultimoStatus = status;
        status = st;
        if ((usuarioAtual == null) || (usuarioAtual instanceof UsuarioComum)) {
            janela.loadPanel(st);
        } else {
            switch (st) {
                case INICIO: 
                    iniciar();
                    status = ultimoStatus;
                    break;
                case CREDITOS:
                    creditos();
                    status = ultimoStatus;
                    break;
                case CADASTRO:
                    cadastro();
                    status = ultimoStatus;
                    break;
                case LOGIN:
                    login();
                    status = ultimoStatus;
                    break;
                case PRINCIPAL:
                    principal();
                    status = ultimoStatus;
                    break;
                case COMPRA:
                    compra();
                    status = ultimoStatus;
                    break;
                case PAGAMENTO:
                    pagamento();
                    status = ultimoStatus;
                    break;
                default:
                    status = ultimoStatus;
                    break;
            }
        }
    }
    
    public void trocarParaDetalhesProduto(Produto produto) {
        status = InterfaceStatus.DETALHES_PRODUTO;
        janela.loadProductDetailPanel(produto);
    }

    private void creditos() {
        System.out.println("███╗░░░███╗░█████╗░██████╗░██████╗░██████╗░\n████╗░████║██╔══██╗╚════██╗╚════██╗╚════██╗\n██╔████╔██║██║░░╚═╝░█████╔╝░░███╔═╝░░███╔═╝\n██║╚██╔╝██║██║░░██╗░╚═══██╗██╔══╝░░██╔══╝░░\n██║░╚═╝░██║╚█████╔╝██████╔╝███████╗███████╗\n╚═╝░░░░░╚═╝░╚════╝░╚═════╝░╚══════╝╚══════╝");
        System.out.println("LOJAS MC322");
    }

    private void login() {
    	janela.loadPanel(status);
    }

    private void principal() {
        int codigo = 0;
        while (true) {
            printPromptDeComando();
            String[] comando = scan.nextLine().split(" ");
            switch (comando[0]) {
                case "ajuda":
                    printListaDeComandos(InterfaceStatus.PRINCIPAL);
                    break;
                case "produtos":
                    printListaDeProdutos();
                    break;
                case "produto":
                    codigo = Integer.parseInt(comando[1]);
                    System.out.println(lojaAtual.getProdutoPorCodigo(codigo));
                    break;
                case "pesquisar":
                    String texto = comando[1];
                    printListaDeProdutos(texto);
                    break;
                case "carrinho":
                    System.out.println(usuarioAtual.getCarrinho());
                    break;
                case "comprar":
                    printListaDeComandos(InterfaceStatus.COMPRA);
                    trocarPara(InterfaceStatus.COMPRA);
                    break;
                case "compras":
                    ArrayList<Compra> cmps = usuarioAtual.getCompras();
                    for (int i = 0; i < cmps.size(); i++) {
                        System.out.println(cmps.get(i));
                    }
                    break;
                case "adicionar":
                    codigo = Integer.parseInt(comando[1]);
                    Produto prod = lojaAtual.getProdutoPorCodigo(codigo);
                    if (prod != null) {
                        usuarioAtual.getCarrinho().adicionarProduto(prod);
                    }
                    break;
                case "cancelar":
                    break;
                case "sair":
                    usuarioAtual = null;
                    return;
                default:
                    break;
            }
        }
    }

    private void compra() {
        int indice;
        ArrayList<MetodoPagamento> carteira;
        String argumento1;
        while (true) {
            printPromptDeComando();
            String[] comando = scan.nextLine().split(" ");
            switch (comando[0]) {
                case "ajuda":
                    printListaDeComandos(InterfaceStatus.COMPRA);
                    break;
                case "adicionar":
                    argumento1 = comando[1];
                    if (argumento1.equals("pagamento")) {
                        trocarPara(InterfaceStatus.PAGAMENTO);
                    }
                    break;
                case "carrinho":
                    System.out.println(usuarioAtual.getCarrinho());
                    break;
                case "pagamento":
                    carteira = usuarioAtual.getCarteira();
                    for (int i = 0; i < carteira.size(); i++) {
                        MetodoPagamento mp = carteira.get(i);
                        System.out.println(Integer.toString(i+1) + ". " + mp);
                    }
                    break;
                case "pagar":
                    carteira = usuarioAtual.getCarteira();
                    if (comando.length > 1) {
                        indice = Integer.parseInt(comando[2]) - 1;
                    } else {
                        trocarPara(InterfaceStatus.PAGAMENTO);
                        indice = carteira.size() - 1;
                    }
                    usuarioAtual.getCarrinho().setMetodoDePagamento(carteira.get(indice));
                    System.out.println("Efetuando compra...");
                    if (usuarioAtual.getCarrinho().efetuarCompra(lojaAtual)) {
                        System.out.println("Compra efetuada com sucesso!");
                        System.out.println("Caixa da loja: R$ " + lojaAtual.getCaixa());
                        return;
                    } else {
                        System.out.println("ERRO: Compra não efetuada!");
                    }
                    break;
                case "resumo":
                    Compra carrinho = usuarioAtual.getCarrinho();
                    MetodoPagamento mp = carrinho.getMetodoDePagamento();
                    System.out.println("Resumo da compra:");
                    System.out.println("Valor: R$ " + usuarioAtual.calcularValorCompra());
                    System.out.println("Produtos:");
                    for (int i = 0; i < (carrinho.getTamanho() < 3 ? carrinho.getTamanho() : 3) ; i++) {
                        Produto produto = carrinho.getProduto(i);
                        System.out.println(" - " + Auxiliares.getResumoProduto(produto));
                    }
                    if (carrinho.getTamanho() > 3) {
                        System.out.println("...e mais " + (carrinho.getTamanho() - 3) + " produtos");
                    }
                    break;
                case "cancelar":
                    return;
                case "sair":
                    return;
                default:
                    break;
            }
            
        }
    }

    private void pagamento() {
        while (true) {
            System.out.println("Metodos de pagamento disponiveis:");
            System.out.println("1. Cartao");
            System.out.println("2. Boleto");
            printPromptComMensagem("Metodo");
            String metodo = scan.nextLine();
            if (metodo.equals("cartao") || metodo.equals("Cartao") || metodo.equals("1")) {
                printPromptComMensagem("Numero");
                String numero = scan.nextLine();

                printPromptComMensagem("Data de expiracao");
                String[] dataExpiracaoStr = scan.nextLine().split("/");
                int mesExpiracao = Integer.parseInt(dataExpiracaoStr[0]);
                int anoExpiracao = 2000 + Integer.parseInt(dataExpiracaoStr[1]);
                Calendar dataExpiracao = new GregorianCalendar(anoExpiracao, mesExpiracao - 1, 1);

                printPromptComMensagem("CVV");
                int cvv = Integer.parseInt(scan.nextLine());

                printPromptComMensagem("Nome do titular");
                String nomeTitular = scan.nextLine();

                printPromptComMensagem("CPF do titular (sem pontuacao ou espacos)");
                int cpfTitular = Integer.parseInt(scan.nextLine());

                Cartao cartao = new Cartao(numero, dataExpiracao, cvv, nomeTitular, cpfTitular);
                usuarioAtual.adicionarMetodoDePagamento(cartao);
                return;

            } else if (metodo.equals("boleto") || metodo.equals("Boleto") || metodo.equals("2")) {
                Boleto boleto = lojaAtual.fornecerBoleto(usuarioAtual);
                usuarioAtual.adicionarMetodoDePagamento(boleto);
                return;
            }
        }
    }

    private void cadastro() {
        //Cadastro captura = new Cadastro(this);
        //captura.janela();
    }
    
    public void printListaDeComandos(InterfaceStatus stat) {
        System.out.println("Comandos:");
        System.out.println(" - ajuda : Apresenta a lista de comandos");
        System.out.println(" - cancelar (em qualquer contexto) : Retorna ao menu principal");

        if (stat == InterfaceStatus.PRINCIPAL) {
            System.out.println(" - adicionar (codigo) : Adiciona o produto com o codigo digitado ao carrinho");
            System.out.println(" - carrinho : Apresenta os produtos presentes no carrinho");
            System.out.println(" - comprar : Inicia o processo de compra dos produtos no carrinho");
            System.out.println(" - compras : Apresenta as compras efetuadas pelo usuario atual");
            System.out.println(" - pesquisar (texto) : Lista os produtos contendo o nome digitado");
            System.out.println(" - produtos : Lista os produtos e seus codigos");
            System.out.println(" - produto (codigo) : Apresenta detalhes do produto com o codigo digitado");
        } else if (stat == InterfaceStatus.COMPRA) {
            System.out.println(" - adicionar pagamento : Inicia o menu de adicao de metodo de pagamento");
            System.out.println(" - carrinho : Apresenta os produtos presentes no carrinho");
            System.out.println(" - pagamento : Lista os metodos de pagamento salvos para o usuario atual");
            System.out.println(" - pagar com (numero) : Finaliza a compra com o metodo de pagamento salvo com o indice digitado");
            System.out.println(" - pagar : Inicia o menu de adicao de metodo de pagamento e em seguida finaliza a compra");
            System.out.println(" - resumo : Apresenta um resumo da compra atual");
        }
    }

    private void printListaDeProdutos() {
        ArrayList<Produto> estoque = lojaAtual.getEstoque().getProdutos();
        for (int i = 0; i < estoque.size(); i++) {
            Produto produto = estoque.get(i);
            System.out.println(Auxiliares.getResumoProduto(produto));
        }
    }

    private void printListaDeProdutos(String nome) {
        ArrayList<Produto> estoque = lojaAtual.getEstoque().getProdutos();
        for (int i = 0; i < estoque.size(); i++) {
            Produto produto = estoque.get(i);
            if (produto.getMarca().toLowerCase().contains(nome) ||
                produto.getDescricao().toLowerCase().contains(nome) ||
               ((Eletrodomestico)produto).getModelo().toLowerCase().contains(nome)) {
                System.out.println(Auxiliares.getResumoProduto(produto));
            }
        }
    }


    private void printPromptComMensagem(String mensagem) {
        printPromptDeComando();
        System.out.print(mensagem + ": ");
    }
    
    private void printPromptDeComando() {
        if (usuarioAtual == null) {
            System.out.print("(" + status.getNome() + ")" + "> ");
        } else {
            if (status != InterfaceStatus.PRINCIPAL) {
                System.out.print("(" + usuarioAtual.getPrimeiroNome() + " - " + status.getNome() + ")" + "> ");
            } else {
                System.out.print("(" + usuarioAtual.getPrimeiroNome() + ")" + "> ");
            }
        }
    }

    public boolean handleLogin(String email, String password) {
        Usuario usr = this.lojaAtual.obterUsuario(email, password);
        if (!(usr == null)) {
            this.setUsuarioAtual(usr);
            return true;
        } else {
            return false;
        }
    }


}

/*Classe Estoque
 * Responsável por armazenar detalhes do estoque e gerenciar os produtos, adicionando e removendo.
 * Atributos
 * - docBuilder
 * - arquivoUsuarios
 * - produtos
 * - arquivoUsuariosPath
 * 
 * Métodos:
 * - geters/seters
 * - removerProduto(produto) e removerProduto(codigo)
 * - adicionarProduto(produto)
 * - adicionarEletrodomestico(produto, novoUsuario)
 * - adicionarComputador(produto, novoUsuario)
 * - adicionarFogao(produto, novoUsuario)
 * - adicionarGeladeira(produto, novoUsuario)
 * - adicionarTV(produto, novoUsuario)
 * - carregarEstoque()
 * - findProduto(codigo)
 * */

package projetomc322.usuario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import projetomc322.auxiliares.Auxiliares;
import projetomc322.compra.Compra;
import projetomc322.compra.CompraStatus;
import projetomc322.interfaceusuario.Interface;
import projetomc322.metodosdepagamento.*;
import projetomc322.produtos.Computador;
import projetomc322.produtos.Eletrodomestico;
import projetomc322.produtos.Fogao;
import projetomc322.produtos.Geladeira;
import projetomc322.produtos.Produto;
import projetomc322.produtos.TV;
import projetomc322.produtos.Tela;
import projetomc322.produtos.TipoFogao;
import projetomc322.loja.*;

public class CarregadorUsuario {
    private DocumentBuilder docBuilder;
    private Document arquivoUsuarios;
    private ArrayList<Produto> produtos;
    private String arquivoUsuariosPath;
    private Loja loja;

    /*--------------------------construtor--------------------------------*/
    public CarregadorUsuario(Loja loja) {
        this.loja = loja;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(false);
        try {
            this.docBuilder = dbf.newDocumentBuilder();
        } catch(Exception e){
            e.printStackTrace();
        }
        this.arquivoUsuariosPath = "src/projetomc322/usuario/usuarios.xml";
        this.produtos = new ArrayList<Produto>();
    }

    /*--------------------------getters/setters-------------------------------------*/
    public DocumentBuilder getDocBuilder() {
        return docBuilder;
    }

    public void setDocBuilder(DocumentBuilder docBuilder) {
        this.docBuilder = docBuilder;
    }

    public Document getArquivoEstoque() {
        return arquivoUsuarios;
    }

    public void setArquivoEstoque(Document arquivoUsuarios) {
        this.arquivoUsuarios = arquivoUsuarios;
    }

    public String getArquivoEstoquePath() {
        return arquivoUsuariosPath;
    }

    public void setArquivoEstoquePath(String arquivoUsuariosPath) {
        this.arquivoUsuariosPath = arquivoUsuariosPath;
    }

    public ArrayList<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    /*Método removerProduto:
     * Recebe o produto a ser removido e extrai o código dela para remove-lo do estoque. 
     */
    public void removerUsuario(Usuario usuario) {
        removerUsuario(usuario.getEmail());
    }

    /*Método removerProduto:
     * Recebe o código do produto a ser removido e remove o produto desejado do arquivo. 
     */

    public void removerUsuario(String email) {
        NodeList emailNodeList = arquivoUsuarios.getElementsByTagName("email");
        for (int i = 0; i < emailNodeList.getLength(); i++) {
            Element emailElement = (Element) emailNodeList.item(i);
            if ((emailElement.getFirstChild().getNodeValue()).equals(email)) {
                emailElement.getParentNode().getParentNode().removeChild(emailElement.getParentNode());
                Auxiliares.writeXML(arquivoUsuarios, arquivoUsuariosPath);
            }
        }
    }

    /*Método adicionarProduto:
     * Recebe o produto a ser adicionado e verifica qual o tipo de produto ele é para adicionar estoque. 
     * Dependendo do tipo específico de produto, realiza operações adicionais por meio de métodos privados
     * especializados no tipo (por exemplo, adicionarGeladeira para produtos do tipo Geladeira)
     */
    public void adicionarUsuario(Usuario usuario){
        String email = usuario.getEmail();
        String senha = usuario.getSenha();
        String nome = usuario.getNome();
        Calendar dataNascimento = usuario.getDataNascimento();
        int cpf = usuario.getCpf();
        Endereco endereco = usuario.getEndereco();
        String telefone = usuario.getTelefone();
        ArrayList<MetodoPagamento> carteira = usuario.getCarteira();
        ArrayList<Compra> compras = usuario.getCompras();
        Compra carrinho = usuario.getCarrinho();

        Element novoUsuario = arquivoUsuarios.createElement("usuario");

        Element statusElement = arquivoUsuarios.createElement("status");
        statusElement.setTextContent(usuario instanceof Admin ? "admin" : "usuario");
        novoUsuario.appendChild(statusElement);

        Element emailElement = arquivoUsuarios.createElement("email");
        emailElement.setTextContent(email);
        novoUsuario.appendChild(emailElement);

        Element senhaElement = arquivoUsuarios.createElement("senha");
        senhaElement.setTextContent(senha);
        novoUsuario.appendChild(senhaElement);

        Element nomeElement = arquivoUsuarios.createElement("nome");
        nomeElement.setTextContent(nome);
        novoUsuario.appendChild(nomeElement);

        Element nascimentoElement = arquivoUsuarios.createElement("nascimento");
        nascimentoElement.setTextContent(Auxiliares.calendarToString(dataNascimento));
        novoUsuario.appendChild(nascimentoElement);

        Element cpfElement = arquivoUsuarios.createElement("cpf");
        cpfElement.setTextContent(Integer.toString(cpf));
        novoUsuario.appendChild(cpfElement);

        Element enderecoElement = arquivoUsuarios.createElement("endereco");

        Element cepElement = arquivoUsuarios.createElement("cep");
        cepElement.setTextContent(Integer.toString(endereco.getCep()));
        enderecoElement.appendChild(cepElement);

        Element estadoElement = arquivoUsuarios.createElement("estado");
        estadoElement.setTextContent(endereco.getEstado().getSigla());
        enderecoElement.appendChild(estadoElement);

        Element cidadeElement = arquivoUsuarios.createElement("cidade");
        cidadeElement.setTextContent(endereco.getCidade());
        enderecoElement.appendChild(cidadeElement);

        Element bairroElement = arquivoUsuarios.createElement("bairro");
        bairroElement.setTextContent(endereco.getBairro());
        enderecoElement.appendChild(bairroElement);

        Element logradouroElement = arquivoUsuarios.createElement("logradouro");
        logradouroElement.setTextContent(endereco.getLogradouro());
        enderecoElement.appendChild(logradouroElement);

        Element numeroElement = arquivoUsuarios.createElement("numero");
        numeroElement.setTextContent(Integer.toString(endereco.getNumero()));
        enderecoElement.appendChild(numeroElement);

        novoUsuario.appendChild(enderecoElement);

        Element telefoneElement = arquivoUsuarios.createElement("telefone");
        telefoneElement.setTextContent(telefone);
        novoUsuario.appendChild(telefoneElement);

        Element carteiraElement = arquivoUsuarios.createElement("carteira");

        for (MetodoPagamento metodoPagamento : carteira) {
            if (metodoPagamento instanceof Cartao) {
                Cartao cartao = (Cartao) metodoPagamento;                

                Element cartaoElement = arquivoUsuarios.createElement("cartao");

                Element numeroCartaoElement = arquivoUsuarios.createElement("numero");
                numeroCartaoElement.setTextContent(cartao.getNumero());
                cartaoElement.appendChild(numeroCartaoElement);

                Element expiracaoElement = arquivoUsuarios.createElement("expiracao");
                expiracaoElement.setTextContent(Auxiliares.calendarToString(cartao.getDataExpiracao()));
                cartaoElement.appendChild(expiracaoElement);

                Element cvvElement = arquivoUsuarios.createElement("cvv");
                cvvElement.setTextContent(Integer.toString(cartao.getCvv()));
                cartaoElement.appendChild(cvvElement);

                Element titularElement = arquivoUsuarios.createElement("titular");
                titularElement.setTextContent(cartao.getNomeTitular());
                cartaoElement.appendChild(titularElement);

                Element cpfTitularElement = arquivoUsuarios.createElement("cpf");
                cpfTitularElement.setTextContent(Integer.toString(cartao.getCpfTitular()));
                cartaoElement.appendChild(cpfTitularElement);

                carteiraElement.appendChild(cartaoElement);

            } else if (metodoPagamento instanceof Boleto) {
                Boleto boleto = (Boleto) metodoPagamento;                

                Element boletoElement = arquivoUsuarios.createElement("boleto");

                Element bancoElement = arquivoUsuarios.createElement("banco");
                bancoElement.setTextContent(boleto.getBanco());
                boletoElement.appendChild(bancoElement);

                Element beneficiarioElement = arquivoUsuarios.createElement("beneficiario");
                beneficiarioElement.setTextContent(boleto.getBeneficiario());
                boletoElement.appendChild(beneficiarioElement);

                Element pagadorElement = arquivoUsuarios.createElement("pagador");
                pagadorElement.setTextContent(boleto.getPagador());
                boletoElement.appendChild(pagadorElement);

                Element valorElement = arquivoUsuarios.createElement("valor");
                valorElement.setTextContent(Double.toString(boleto.getValor()));
                boletoElement.appendChild(valorElement);

                Element vencimentoElement = arquivoUsuarios.createElement("vencimento");
                vencimentoElement.setTextContent(Auxiliares.calendarToString(boleto.getDataVencimento()));
                boletoElement.appendChild(vencimentoElement);

                Element codigoElement = arquivoUsuarios.createElement("codigo");
                codigoElement.setTextContent(Integer.toString(boleto.getCodigoBarras()));
                boletoElement.appendChild(codigoElement);

                carteiraElement.appendChild(boletoElement);
            }
        }

        novoUsuario.appendChild(carteiraElement);

        Element carrinhoElement = arquivoUsuarios.createElement("carrinho");
        for (Produto produto : carrinho.getProdutos()) {
            Element produtoElement = arquivoUsuarios.createElement("codigo");
            produtoElement.setTextContent(Integer.toString(produto.getCodigo()));
            carrinhoElement.appendChild(produtoElement);
        }
        novoUsuario.appendChild(carrinhoElement);

        Element comprasElement = arquivoUsuarios.createElement("compras");
        for (Compra compra : compras) {
            Element compraElement = arquivoUsuarios.createElement("compra");
            Element compraDataElement = arquivoUsuarios.createElement("data");
            compraDataElement.setTextContent(Auxiliares.calendarToString(compra.getDataCompra()));
            Element compraMetodoElement = arquivoUsuarios.createElement("metodo");
            compraMetodoElement.setTextContent(String.valueOf(compra.getComprador().getCarteira().indexOf(compra.getMetodoPagamento())));
            compraElement.appendChild(compraMetodoElement);
            compraElement.appendChild(compraDataElement);
            for (Produto produto : compra.getProdutos()) {
                Element produtoElement = arquivoUsuarios.createElement("codigo");
                produtoElement.setTextContent(Integer.toString(produto.getCodigo()));
                compraElement.appendChild(produtoElement);
            }
            comprasElement.appendChild(compraElement);
        }
        novoUsuario.appendChild(comprasElement);

        arquivoUsuarios.getDocumentElement().appendChild(novoUsuario);
        Auxiliares.writeXML(arquivoUsuarios, arquivoUsuariosPath);

    }


    /*Método carregarEstoque():
     * Carrega um arquivo XML contendo os produtos do estoque, gera objetos para 
     * cada um, e os adiciona à ArrayList de produtos.
     */
    public void carregarUsuarios() {
        try {
            arquivoUsuarios = docBuilder.parse(new File(arquivoUsuariosPath));
            Auxiliares.removerEspacosXML(arquivoUsuarios);
        } catch(Exception e){
            e.printStackTrace();
        }

        loja.setUsuarios(new ArrayList<Usuario>());

        arquivoUsuarios.getDocumentElement().normalize();
        NodeList usuariosNodeList = arquivoUsuarios.getElementsByTagName("usuario");
        for (int i = 0; i < usuariosNodeList.getLength(); i++) {
            Element usuario = (Element) usuariosNodeList.item(i);

            // Propriedades de Produto

            String email = Auxiliares.getTagNodeValue(usuario, "email");
            String senha = Auxiliares.getTagNodeValue(usuario, "senha");
            String nome = Auxiliares.getTagNodeValue(usuario, "nome");
            Calendar dataNascimento = Auxiliares.stringToCalendar(Auxiliares.getTagNodeValue(usuario, "nascimento"));
            int cpf = Integer.valueOf(Auxiliares.getTagNodeValue(usuario, "cpf"));
            String telefone = Auxiliares.getTagNodeValue(usuario, "telefone");

            Element enderecoElement = (Element) usuario.getElementsByTagName("endereco").item(0);

            Endereco endereco = new Endereco();
            endereco.setCep(Integer.valueOf(Auxiliares.getTagNodeValue(enderecoElement, "cep")));
            endereco.setEstado(Estado.getEstadoPorSigla(Auxiliares.getTagNodeValue(enderecoElement, "estado")));
            endereco.setCidade(Auxiliares.getTagNodeValue(enderecoElement, "cidade"));
            endereco.setBairro(Auxiliares.getTagNodeValue(enderecoElement, "bairro"));
            endereco.setLogradouro(Auxiliares.getTagNodeValue(enderecoElement, "logradouro"));
            endereco.setNumero(Integer.valueOf(Auxiliares.getTagNodeValue(enderecoElement, "numero")));

            Compra carrinho = new Compra();
            Element carrinhoElement = (Element) usuario.getElementsByTagName("carrinho").item(0);
            NodeList carrinhoElementProdutos = carrinhoElement.getElementsByTagName("codigo");
            for (int j = 0; j < carrinhoElementProdutos.getLength(); j++) {
                Element prodElement = (Element) carrinhoElementProdutos.item(j);
                Produto prod = loja.getProdutoPorCodigo(Integer.valueOf(prodElement.getFirstChild().getNodeValue()));
                carrinho.adicionarProduto(prod);
            }

            Element carteiraElement = (Element) usuario.getElementsByTagName("carteira").item(0);
            ArrayList<MetodoPagamento> metodosPagamento = new ArrayList<MetodoPagamento>();
            NodeList cartoesElementNodeList = carteiraElement.getElementsByTagName("cartao");
            for (int j = 0; j < cartoesElementNodeList.getLength() ; j++) {
                Element cartaoElement = (Element) cartoesElementNodeList.item(j);
                String numero = Auxiliares.getTagNodeValue(cartaoElement, "numero");
                Calendar expiracao = Auxiliares.stringToCalendar(Auxiliares.getTagNodeValue(cartaoElement, "expiracao"));
                int cvv = Integer.valueOf(Auxiliares.getTagNodeValue(cartaoElement, "cvv"));
                String titular = Auxiliares.getTagNodeValue(cartaoElement, "titular");
                int cpfTitular = Integer.valueOf(Auxiliares.getTagNodeValue(cartaoElement, "cpf"));
                Cartao cartao = new Cartao(numero, expiracao, cvv, titular, cpfTitular);
                metodosPagamento.add(cartao);
            }
            NodeList boletoElementNodeList = carteiraElement.getElementsByTagName("boleto");
            for (int j = 0; j < boletoElementNodeList.getLength() ; j++) {
                Element boletoElement = (Element) boletoElementNodeList.item(j);
                String banco = Auxiliares.getTagNodeValue(boletoElement, "banco");
                String beneficiario = Auxiliares.getTagNodeValue(boletoElement, "beneficiario");
                String pagador = Auxiliares.getTagNodeValue(boletoElement, "pagador");
                double valor = Double.valueOf(Auxiliares.getTagNodeValue(boletoElement, "valor"));
                Calendar vencimento = Auxiliares.stringToCalendar(Auxiliares.getTagNodeValue(boletoElement, "vencimento"));
                int codigo = Integer.valueOf(Auxiliares.getTagNodeValue(boletoElement, "codigo"));
                Boleto boleto = new Boleto(banco, beneficiario, pagador, valor, vencimento, codigo);
                metodosPagamento.add(boleto);
            }

            Element comprasElement = (Element) usuario.getElementsByTagName("compras").item(0);
            ArrayList<Compra> compras = new ArrayList<Compra>();
            NodeList comprasElementNodeList = comprasElement.getElementsByTagName("compra");
            for (int j = 0; j < comprasElementNodeList.getLength(); j++) {
                Compra compra = new Compra();
                Element compraElement = (Element) comprasElementNodeList.item(j);
                MetodoPagamento compraMetodo = metodosPagamento.get(Integer.valueOf(Auxiliares.getTagNodeValue(compraElement, "metodo")));
                Calendar dataCompra = Auxiliares.stringToCalendar(Auxiliares.getTagNodeValue(compraElement, "data"));
                compra.setMetodoPagamento(compraMetodo);
                compra.setDataCompra(dataCompra);
                NodeList compraElementProdutos = compraElement.getElementsByTagName("codigo");
                ArrayList<Produto> compraProdutos = new ArrayList<Produto>();
                for (int k = 0; k < compraElementProdutos.getLength(); k++) {
                    Element prodElement = (Element) compraElementProdutos.item(k);
                    Produto prod = loja.getProdutoPorCodigo(Integer.valueOf(prodElement.getFirstChild().getNodeValue()));
                    compra.adicionarProduto(prod);
                }
                compra.setStatus(CompraStatus.EFETUADA);
                compras.add(compra);
            } 


            String status = Auxiliares.getTagNodeValue(usuario, "status");
            if (status.equals("admin")) {
                Admin adm = new Admin(email, senha, nome, dataNascimento, cpf, endereco, telefone, loja);
                adm.setCarteira(metodosPagamento);
                carrinho.setComprador(adm);
                adm.setCarrinho(carrinho);
                for (Compra compra : compras) {
                    compra.setComprador(adm);
                }
                adm.setCompras(compras);
                loja.addUsuario(adm);
            } else {
                UsuarioComum usr = new UsuarioComum(email, senha, nome, dataNascimento, cpf, endereco, telefone);
                usr.setCarteira(metodosPagamento);
                carrinho.setComprador(usr);
                usr.setCarrinho(carrinho);
                for (Compra compra : compras) {
                    compra.setComprador(usr);
                }
                usr.setCompras(compras);
                loja.addUsuario(usr);
            }
        }

        

    }

    public void atualizarUsuarios() {
        for (Usuario usuario : loja.getUsuarios()) {
            removerUsuario(usuario);
            adicionarUsuario(usuario);
        }
    }

    public void atualizarUsuarioAtual(Interface interf) {
        Usuario oldUsuario = null;
        for (Usuario usuario : loja.getUsuarios()) {
            if (usuario.getEmail().equals(interf.getUsuarioAtual().getEmail())) {
                oldUsuario = usuario;
            }
        }
        loja.getUsuarios().remove(oldUsuario);
        loja.getUsuarios().add(interf.getUsuarioAtual());
    }


    /*Método findProduto:
     * Recebe o código de um produto e retorna o produto desejado
     */
    public Produto findProduto(int codigo) {
        int i = 0;
        Produto desejado = null;
        for(i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            if(p.getCodigo() == codigo) {
                desejado = p;
            }
        }
        return desejado;
    }


}

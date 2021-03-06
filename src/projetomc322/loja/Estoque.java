/*Classe Estoque
 * Responsável por armazenar detalhes do estoque e gerenciar os produtos, adicionando e removendo.
 * Atributos
 * - docBuilder
 * - arquivoEstoque
 * - produtos
 * - arquivoEstoquePath
 * 
 * Métodos:
 * - geters/seters
 * - removerProduto(produto) e removerProduto(codigo)
 * - adicionarProduto(produto)
 * - adicionarEletrodomestico(produto, novoProduto)
 * - adicionarComputador(produto, novoProduto)
 * - adicionarFogao(produto, novoProduto)
 * - adicionarGeladeira(produto, novoProduto)
 * - adicionarTV(produto, novoProduto)
 * - carregarEstoque()
 * - findProduto(codigo)
 * */

package projetomc322.loja;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
import projetomc322.produtos.Computador;
import projetomc322.produtos.Eletrodomestico;
import projetomc322.produtos.Fogao;
import projetomc322.produtos.Geladeira;
import projetomc322.produtos.Produto;
import projetomc322.produtos.TV;
import projetomc322.produtos.Tela;
import projetomc322.produtos.TipoFogao;

public class Estoque {
    private DocumentBuilder docBuilder;
    private Document arquivoEstoque;
    private ArrayList<Produto> produtos;
    private String arquivoEstoquePath;

    /*--------------------------construtor--------------------------------*/
    public Estoque() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(false);
        try {
            this.docBuilder = dbf.newDocumentBuilder();
        } catch(Exception e){
            e.printStackTrace();
        }
        this.arquivoEstoquePath = "src/projetomc322/produtos/produtos.xml";
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
        return arquivoEstoque;
    }

    public void setArquivoEstoque(Document arquivoEstoque) {
        this.arquivoEstoque = arquivoEstoque;
    }

    public String getArquivoEstoquePath() {
        return arquivoEstoquePath;
    }

    public void setArquivoEstoquePath(String arquivoEstoquePath) {
        this.arquivoEstoquePath = arquivoEstoquePath;
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
    public void removerProduto(Produto produto) {
        removerProduto(produto.getCodigo());
    }

    /*Método removerProduto:
     * Recebe o código do produto a ser removido e remove o produto desejado do arquivo. 
     */
    public void removerProduto(int codigo) {
        NodeList codigoNodeList = arquivoEstoque.getElementsByTagName("codigo");
        for (int i = 0; i < codigoNodeList.getLength(); i++) {
            Element codigoElement = (Element) codigoNodeList.item(i);
            if (Integer.parseInt(codigoElement.getFirstChild().getNodeValue()) == codigo) {
                codigoElement.getParentNode().getParentNode().removeChild(codigoElement.getParentNode());
                Auxiliares.writeXML(arquivoEstoque, arquivoEstoquePath);
            }
        }
    }

    /*Método adicionarProduto:
     * Recebe o produto a ser adicionado e verifica qual o tipo de produto ele é para adicionar estoque. 
     * Dependendo do tipo específico de produto, realiza operações adicionais por meio de métodos privados
     * especializados no tipo (por exemplo, adicionarGeladeira para produtos do tipo Geladeira)
     */
    public void adicionarProduto(Produto produto){
        int codigo = produto.getCodigo();
        String descricao = produto.getDescricao();
        String marca = produto.getMarca();
        double preco = produto.getPreco();

        Element novoProduto = arquivoEstoque.createElement("produto");

        Element codigoElement = arquivoEstoque.createElement("codigo");
        codigoElement.setTextContent(Integer.toString(codigo));
        novoProduto.appendChild(codigoElement);

        Element descricaoElement = arquivoEstoque.createElement("descricao");
        descricaoElement.setTextContent(descricao);
        novoProduto.appendChild(descricaoElement);

        Element marcaElement = arquivoEstoque.createElement("marca");
        marcaElement.setTextContent(marca);
        novoProduto.appendChild(marcaElement);

        Element precoElement = arquivoEstoque.createElement("preco");
        precoElement.setTextContent(Double.toString(preco));
        novoProduto.appendChild(precoElement);

        Element fotosElement = arquivoEstoque.createElement("fotos");
        novoProduto.appendChild(fotosElement);


        arquivoEstoque.getDocumentElement().appendChild(novoProduto);


        if (produto instanceof Eletrodomestico) {
            adicionarEletrodomestico(produto, novoProduto);        
        } else {
            Element tipoElement = arquivoEstoque.createElement("tipo");
            tipoElement.setTextContent("Produto");
            novoProduto.appendChild(tipoElement);
            Auxiliares.writeXML(arquivoEstoque, arquivoEstoquePath);
            carregarEstoque();
        }

    }

    /*Método adicionarEletrodomestico:
     * Extensão de adicionarProduto para produtos do tipo Eletrodomestico
     */
    private void adicionarEletrodomestico(Produto produto, Element novoProduto) {
        Eletrodomestico eletrodomestico = (Eletrodomestico) produto;
        int voltagem = eletrodomestico.getVoltagem();
        double altura = eletrodomestico.getAltura();
        double largura = eletrodomestico.getLargura();
        double comprimento = eletrodomestico.getComprimento();
        String cor = eletrodomestico.getCor();
        String modelo = eletrodomestico.getModelo();

        Element voltagemElement = arquivoEstoque.createElement("voltagem");
        voltagemElement.setTextContent(Integer.toString(voltagem));
        novoProduto.appendChild(voltagemElement);

        Element alturaElement = arquivoEstoque.createElement("altura");
        alturaElement.setTextContent(Double.toString(altura));
        novoProduto.appendChild(alturaElement);

        Element larguraElement = arquivoEstoque.createElement("largura");
        larguraElement.setTextContent(Double.toString(largura));
        novoProduto.appendChild(larguraElement);

        Element comprimentoElement = arquivoEstoque.createElement("comprimento");
        comprimentoElement.setTextContent(Double.toString(comprimento));
        novoProduto.appendChild(comprimentoElement);

        Element corElement = arquivoEstoque.createElement("cor");
        corElement.setTextContent(cor);
        novoProduto.appendChild(corElement);

        Element modeloElement = arquivoEstoque.createElement("modelo");
        modeloElement.setTextContent(modelo);
        novoProduto.appendChild(modeloElement);

        if (produto instanceof Computador) {
            adicionarComputador(produto, novoProduto);        
        } else if (produto instanceof Fogao) {
            adicionarFogao(produto, novoProduto);        
        } else if (produto instanceof Geladeira) {
            adicionarGeladeira(produto, novoProduto);        
        } else if (produto instanceof TV) {
            adicionarTV(produto, novoProduto);        
        } else {
            Element tipoElement = arquivoEstoque.createElement("tipo");
            tipoElement.setTextContent("Eletrodomestico");
            novoProduto.appendChild(tipoElement);
            Auxiliares.writeXML(arquivoEstoque, arquivoEstoquePath);
            carregarEstoque();
        }


    }

    /*Método adicionarComputador:
     * Extensão de adicionarProduto para produtos do tipo Computador
     */
    private void adicionarComputador(Produto produto, Element novoProduto) {
        Computador computador = (Computador) produto;
        String processador = computador.getProcessador();
        String sistemaOperacional = computador.getSistemaOperacional();
        int ram = computador.getRam();
        int hd = computador.getHd();

        Element processadorElement = arquivoEstoque.createElement("processador");
        processadorElement.setTextContent(processador);
        novoProduto.appendChild(processadorElement);

        Element sistemaElement = arquivoEstoque.createElement("sistema");
        sistemaElement.setTextContent(sistemaOperacional);
        novoProduto.appendChild(sistemaElement);

        Element ramElement = arquivoEstoque.createElement("ram");
        ramElement.setTextContent(Integer.toString(ram));
        novoProduto.appendChild(ramElement);

        Element hdElement = arquivoEstoque.createElement("hd");
        hdElement.setTextContent(Integer.toString(hd));
        novoProduto.appendChild(hdElement);

        Element tipoElement = arquivoEstoque.createElement("tipo");
        tipoElement.setTextContent("Computador");
        novoProduto.appendChild(tipoElement);

        Auxiliares.writeXML(arquivoEstoque, arquivoEstoquePath);
        carregarEstoque();

    }

    /*Método adicionarFogao:
     * Extensão de adicionarProduto para produtos do tipo Fogao
     */
    private void adicionarFogao(Produto produto, Element novoProduto) {
        Fogao fogao = (Fogao) produto;
        int numeroBocas = fogao.getNumeroBocas();
        String tipoFogaoStr = fogao.getTipo().getNome();
        String fornoStr = fogao.isForno() ? "sim" : "não";

        Element bocasElement = arquivoEstoque.createElement("bocas");
        bocasElement.setTextContent(Integer.toString(numeroBocas));
        novoProduto.appendChild(bocasElement);

        Element tipoFogaoElement = arquivoEstoque.createElement("fogao");
        tipoFogaoElement.setTextContent(tipoFogaoStr);
        novoProduto.appendChild(tipoFogaoElement);

        Element fornoElement = arquivoEstoque.createElement("forno");
        fornoElement.setTextContent(fornoStr);
        novoProduto.appendChild(fornoElement);

        Element tipoElement = arquivoEstoque.createElement("tipo");
        tipoElement.setTextContent("Fogão");
        novoProduto.appendChild(tipoElement);

        Auxiliares.writeXML(arquivoEstoque, arquivoEstoquePath);
        carregarEstoque();

    }

    /*Método adicionarGeladeira:
     * Extensão de adicionarProduto para produtos do tipo Geladeira
     */
    private void adicionarGeladeira(Produto produto, Element novoProduto) {
        Geladeira geladeira = (Geladeira) produto;
        int numeroPortas = geladeira.getNumeroPortas();
        String frostFreeStr = geladeira.isFrostFree() ? "sim" : "não";
        String freezerStr = geladeira.isFreezer() ? "sim" : "não";

        Element portasElement = arquivoEstoque.createElement("portas");
        portasElement.setTextContent(Integer.toString(numeroPortas));
        novoProduto.appendChild(portasElement);

        Element frostFreeElement = arquivoEstoque.createElement("frostfree");
        frostFreeElement.setTextContent(frostFreeStr);
        novoProduto.appendChild(frostFreeElement);

        Element freezerElement = arquivoEstoque.createElement("freezer");
        freezerElement.setTextContent(freezerStr);
        novoProduto.appendChild(freezerElement);

        Element tipoElement = arquivoEstoque.createElement("tipo");
        tipoElement.setTextContent("Geladeira");
        novoProduto.appendChild(tipoElement);

        Auxiliares.writeXML(arquivoEstoque, arquivoEstoquePath);
        carregarEstoque();
    }

    /*Método adicionarTV:
     * Extensão de adicionarProduto para produtos do tipo TV
     */
    private void adicionarTV(Produto produto, Element novoProduto) {
        TV tv = (TV) produto;
        String telaStr = tv.getTela().getNome();
        String smartStr = tv.isSmart() ? "sim" : "não";

        Element telaElement = arquivoEstoque.createElement("tela");
        telaElement.setTextContent(telaStr);
        novoProduto.appendChild(telaElement);

        Element smartElement = arquivoEstoque.createElement("smart");
        smartElement.setTextContent(smartStr);
        novoProduto.appendChild(smartElement);

        Element tipoElement = arquivoEstoque.createElement("tipo");
        tipoElement.setTextContent("TV");
        novoProduto.appendChild(tipoElement);

        Auxiliares.writeXML(arquivoEstoque, arquivoEstoquePath);
        carregarEstoque();
    }



    /*Método carregarEstoque():
     * Carrega um arquivo XML contendo os produtos do estoque, gera objetos para 
     * cada um, e os adiciona à ArrayList de produtos.
     */
    public void carregarEstoque() {
        try {
            arquivoEstoque = docBuilder.parse(new File(arquivoEstoquePath));
            Auxiliares.removerEspacosXML(arquivoEstoque);
        } catch(Exception e){
            e.printStackTrace();
        }

        arquivoEstoque.getDocumentElement().normalize();
        NodeList produtosNodeList = arquivoEstoque.getElementsByTagName("produto");
        for (int i = 0; i < produtosNodeList.getLength(); i++) {
            Element produto = (Element) produtosNodeList.item(i);

            // Propriedades de Produto

            int codigo = Integer.parseInt(Auxiliares.getTagNodeValue(produto, "codigo"));

            String descricao = Auxiliares.getTagNodeValue(produto, "descricao");

            String marca = Auxiliares.getTagNodeValue(produto, "marca");

            double preco = Double.parseDouble(Auxiliares.getTagNodeValue(produto, "preco"));

            ArrayList<Image> fotos = new ArrayList<Image>();

            NodeList fotosNodeList = ((Element) produto.getElementsByTagName("fotos").item(0))
                .getElementsByTagName("foto");

            for (int j = 0; j < fotosNodeList.getLength(); j++) {
                Element fotoElement = (Element) fotosNodeList.item(j);
                String fotoPath = fotoElement.getFirstChild().getNodeValue();
                Image foto = new ImageIcon(fotoPath).getImage();
                fotos.add(foto);
            }

            // Propriedades de Eletrodomestico

            int voltagem = Integer.parseInt(Auxiliares.getTagNodeValue(produto, "voltagem"));

            double altura = Double.parseDouble(Auxiliares.getTagNodeValue(produto, "altura"));
            double largura = Double.parseDouble(Auxiliares.getTagNodeValue(produto, "largura"));
            double comprimento = Double.parseDouble(Auxiliares.getTagNodeValue(produto, "comprimento"));

            String cor = Auxiliares.getTagNodeValue(produto, "cor");

            String modelo = Auxiliares.getTagNodeValue(produto, "modelo");

            // Determinação de tipo

            String tipo = Auxiliares.getTagNodeValue(produto, "tipo");

            switch (tipo) {
                case "Computador":
                    String processador = Auxiliares.getTagNodeValue(produto, "processador");
                    String sistemaOperacional = Auxiliares.getTagNodeValue(produto, "sistema");
                    int ram = Integer.parseInt(Auxiliares.getTagNodeValue(produto, "ram"));
                    int hd = Integer.parseInt(Auxiliares.getTagNodeValue(produto, "hd"));
                    produtos.add(new Computador(codigo, descricao, fotos, marca, preco, voltagem, altura, 
                                largura, comprimento, cor, modelo, processador, sistemaOperacional, ram, hd));
                    break;
                case "Fogão":
                    int numeroBocas = Integer.parseInt(Auxiliares.getTagNodeValue(produto, "bocas"));
                    String tipoFogaoStr = Auxiliares.getTagNodeValue(produto, "fogao");
                    TipoFogao tipoFogao = TipoFogao.PISO;
                    switch (tipoFogaoStr) {
                        case "piso":
                            tipoFogao = TipoFogao.PISO;
                            break;
                        case "embutido":
                            tipoFogao = TipoFogao.EMBUTIDO;
                            break;
                        case "cooktop":
                            tipoFogao = TipoFogao.COOKTOP;
                            break;
                        default:
                            break;
                    }
                    boolean forno = Auxiliares.getTagNodeValue(produto, "forno").equals("sim");
                    produtos.add(new Fogao(codigo, descricao, fotos, marca, preco, voltagem, altura, 
                                largura, comprimento, cor, modelo, numeroBocas, tipoFogao, forno));
                    break;
                case "Geladeira":
                    int numeroPortas = Integer.parseInt(Auxiliares.getTagNodeValue(produto, "portas"));
                    boolean frostFree = Auxiliares.getTagNodeValue(produto, "frostfree").equals("sim");
                    boolean freezer = Auxiliares.getTagNodeValue(produto, "freezer").equals("sim");
                    produtos.add(new Geladeira(codigo, descricao, fotos, marca, preco, voltagem, altura, 
                                largura, comprimento, cor, modelo, numeroPortas, frostFree, freezer));
                    break;
                case "TV":
                    String telaStr = Auxiliares.getTagNodeValue(produto, "tela");
                    Tela tela = Tela.LCD;
                    switch (telaStr) {
                        case "lcd":
                            tela = Tela.LCD;
                            break;
                        case "led":
                            tela = Tela.LED;
                            break;
                        case "oled":
                            tela = Tela.OLED;
                            break;
                        case "qled":
                            tela = Tela.QLED;
                            break;
                        default:
                            break;
                    }
                    boolean smart = Auxiliares.getTagNodeValue(produto, "smart").equals("sim");
                    produtos.add(new TV(codigo, descricao, fotos, marca, preco, voltagem, altura, largura, comprimento, cor, modelo, tela, smart));
                    break;
                default:
                    break;
            }
        }

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

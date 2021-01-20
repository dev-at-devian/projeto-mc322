/* Classe Auxiliares
 *
 * Contém métodos que englobam pedaços de código que não pertencem
 * a uma classe específica, mas que são repetidos o suficiente ao 
 * longo do projeto para beneficiarem de uma método.
 *
 * Métodos:
 * getTagNodeValue(Element element, String tag)
 * writeXML(Document doc, String docPath)
 * removerEspacosXML(Document doc)
 * getResumoProduto(Produto produto)
 *
 *
 */
package projetomc322.auxiliares;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import projetomc322.produtos.Eletrodomestico;
import projetomc322.produtos.Produto;

public class Auxiliares {
    
    /* Método getTagNodeValue
     *
     * Retorna o valor do texto contido dentro da tag XML contida dentro do
     * Element element.
     *
     */
    
    public static String getTagNodeValue(Element element, String tag) {
    
    	return ((Element) element.getElementsByTagName(tag).item(0))
    		.getFirstChild().getNodeValue();
    }
    
    /* Método writeXML
     *
     * Escreve o conteúdo do documento doc para o arquivo contido no caminho
     * docPath
     *
     */
    
    public static void writeXML(Document doc, String docPath) {
    	TransformerFactory transformerFactory = TransformerFactory.newInstance();
    	Transformer transformer;
    	try {
    		transformer = transformerFactory.newTransformer();
    		DOMSource source = new DOMSource(doc);
    		FileWriter writer = new FileWriter(new File(docPath));
    		StreamResult result = new StreamResult(writer);
    		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
    		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    		transformer.transform(source, result);
    	} catch (TransformerConfigurationException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	} catch (TransformerException e) {
    		e.printStackTrace();
    	}
    }
    
    /* Método removerEspacosXML
     * 
     * Remove os espaços de um documento doc representando um arquivo XML
     *
     */
    
    public static void removerEspacosXML(Document doc) {
    	XPathFactory xfact = XPathFactory.newInstance();
    	XPath xpath = xfact.newXPath();
    	NodeList nodesVazios;
    	try {
    		nodesVazios = (NodeList) xpath.evaluate("//text()[normalize-space(.) = '']", doc, XPathConstants.NODESET);
    		for (int i = 0; i < nodesVazios.getLength(); i++) {
    			Node node = nodesVazios.item(i);
    			node.getParentNode().removeChild(node);
    		}
    	} catch (XPathExpressionException e) {
    		e.printStackTrace();
    	}
    
    }
    
    /* Método getResumoProduto
     *
     * Retorna uma representação em string do produto passado como argumento
     * que é menor que a retornada por toString (1 linha contendo codigo, marca,
     * modelo e preço)
     *
     */
    
    public static String getResumoProduto(Produto produto) {
        String tmpStr = "";
        tmpStr += (produto.getCodigo() + " - " + produto.getMarca());
        if (produto instanceof Eletrodomestico) {
            Eletrodomestico eletrodomestico = (Eletrodomestico) produto;
            tmpStr += (" " + eletrodomestico.getModelo());
        }
        tmpStr += (" (R$ " + produto.getPreco() + ")");
        return tmpStr;
    }
    
    public static String calendarToString(Calendar calendar) {
        return (calendar.get(Calendar.DAY_OF_MONTH) + "/" +
							 (calendar.get(Calendar.MONTH))+1) + "/" +
							 (calendar.get(Calendar.YEAR));
    }

		public static Calendar stringToCalendar(String string) {
        String[] tmpStrArr = string.split("/");
				return new GregorianCalendar(Integer.valueOf(tmpStrArr[0]),
																		 Integer.valueOf(tmpStrArr[1]),
																		 Integer.valueOf(tmpStrArr[2]));
		}

}

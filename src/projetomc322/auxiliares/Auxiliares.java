package projetomc322.auxiliares;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    public static String getTagNodeValue(Element element, String tag) {

        return ((Element) element.getElementsByTagName(tag).item(0))
                                            .getFirstChild().getNodeValue();
    }
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


}

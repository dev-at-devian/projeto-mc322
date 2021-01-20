package projetomc322.interfaceusuario;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import projetomc322.font.FontSelector;
import projetomc322.produtos.*;

public class DetalheProdutoFrame extends JPanel{
    private DetalheProdutoInterface parentFrame;
    private Interface interf;
    private Produto product;
    public DetalheProdutoFrame(DetalheProdutoInterface parentFrame) {
        this.parentFrame = parentFrame;
        this.interf = parentFrame.getParentFrame().getInterface();
        this.product = parentFrame.getProduct();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(400,600));
        this.setBackground(Color.BLUE);
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);

        ArrayList<JLabel> labels = new ArrayList<JLabel>();

        JLabel codigo = new JLabel("Código: "+String.valueOf(product.getCodigo()));
        JLabel descricao = new JLabel("<html>Descrição: "+product.getDescricao()+"</html>");
        JPanel fotos = new JPanel();
        JLabel marca = new JLabel("Marca: "+product.getMarca());
        JLabel preco = new JLabel("Preço: R$"+String.valueOf(product.getPreco()));

        labels.add(codigo);
        labels.add(descricao);
        labels.add(marca);
        labels.add(preco);

        if (product instanceof Eletrodomestico) {
            Eletrodomestico eletrodomestico = (Eletrodomestico) product;
            JLabel voltagem = new JLabel("Voltagem: "+String.valueOf(eletrodomestico.getVoltagem()));
            JLabel altura = new JLabel("Altura: "+String.valueOf(eletrodomestico.getAltura()));
            JLabel largura = new JLabel("Largura: "+String.valueOf(eletrodomestico.getLargura()));
            JLabel comprimento = new JLabel("Comprimento: "+String.valueOf(eletrodomestico.getComprimento()));
            JLabel cor = new JLabel("Cor: "+eletrodomestico.getCor());
            JLabel modelo = new JLabel("Modelo: "+eletrodomestico.getModelo());

            labels.add(voltagem);
            labels.add(altura);
            labels.add(largura);
            labels.add(comprimento);
            labels.add(cor);
            labels.add(modelo);
            
            if (product instanceof Computador) {
                Computador computador = (Computador) product;
                JLabel processador = new JLabel("Processador: "+computador.getProcessador());
                JLabel sistemaOperacional = new JLabel("Sistema Operacional: "+computador.getSistemaOperacional());
                JLabel ram = new JLabel("RAM: "+String.valueOf(computador.getRam()));
                JLabel hd = new JLabel("Armazenamento: "+String.valueOf(computador.getHd()));

                labels.add(processador);
                labels.add(sistemaOperacional);
                labels.add(ram);
                labels.add(hd);
            } else if (product instanceof Fogao) {
                Fogao fogao = (Fogao) product;
                JLabel numeroBocas = new JLabel("Número de bocas: "+String.valueOf(fogao.getNumeroBocas()));
                JLabel tipo = new JLabel("Tipo: "+fogao.getTipo().getNome());
                JLabel forno = new JLabel("Forno: "+(fogao.isForno() ? "Sim" : "Não"));


                labels.add(numeroBocas);
                labels.add(tipo);
                labels.add(forno);
            } else if (product instanceof Geladeira) {
                Geladeira geladeira = (Geladeira) product;
                JLabel numeroPortas = new JLabel("Número de portas: "+String.valueOf(geladeira.getNumeroPortas()));
                JLabel frostFree = new JLabel("Frost free: "+(geladeira.isFrostFree() ? "Sim" : "Não"));
                JLabel freezer = new JLabel("Freezer: "+(geladeira.isFreezer() ? "Sim" : "Não"));

                labels.add(numeroPortas);
                labels.add(frostFree);
                labels.add(freezer);
            } else if (product instanceof TV) {
                TV tv = (TV) product;
                JLabel tela = new JLabel("Tela: "+tv.getTela().getNome());
                JLabel smart = new JLabel("Smart: "+(tv.isSmart() ? "Sim" : "Não"));

                labels.add(tela);
                labels.add(smart);
            }

        }

        for (JLabel label : labels) {
            label.setFont(FontSelector.ROBOTO_MEDIUM.getFont().deriveFont(16f));
            label.setForeground(Color.WHITE);
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.add(label);
        }

        fotos.setLayout(new BoxLayout(fotos, BoxLayout.X_AXIS));
        fotos.setAlignmentX(Component.LEFT_ALIGNMENT);
        fotos.setOpaque(false);

        for (Image foto : product.getFotos()) {
            JLabel fotoLabel = new JLabel(new ImageIcon(foto.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
            fotoLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
            fotos.add(fotoLabel);
        }

        this.add(fotos);

        JButton carrinhoButton = new JButton("Adicionar ao carrinho");
        carrinhoButton.setFont(FontSelector.ROBOTO_LIGHT.getFont().deriveFont(24f));
        carrinhoButton.setBackground(Color.WHITE);
        carrinhoButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        carrinhoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                interf.getUsuarioAtual().getCarrinho().adicionarProduto(parentFrame.getProduct());
                interf.getLojaAtual().atualizarUsuarios();
                interf.trocarPara(InterfaceStatus.CARRINHO);
            }
        });

        this.add(carrinhoButton);

    }
    public void lol() {
        System.out.println("lol");
    }
}

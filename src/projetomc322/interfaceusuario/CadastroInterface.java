/*Classe CadastroInterface
 * Representa  o painel onde são exibidos os inputs e botão de cadastro;
 * Atributos:
 * -parentFrame
 * */
package projetomc322.interfaceusuario;
import java.awt.*;
import javax.swing.*;

public class CadastroInterface extends JPanel {
    private Janela parentFrame;
    public CadastroInterface(Janela parentFrame) {
        this.parentFrame = parentFrame;
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        this.setPreferredSize(new Dimension(800,600));
        this.setBackground(Color.RED);
        this.add(new CadastroFrame(this), gbc);
    }
    public Janela getParentFrame() {
        return this.parentFrame;
    }
    public void lol(){
        System.out.println("lol");
    }
}

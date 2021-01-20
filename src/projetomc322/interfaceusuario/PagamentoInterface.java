package projetomc322.interfaceusuario;
import java.awt.*;
import javax.swing.*;

public class PagamentoInterface extends JPanel {
    private Janela parentFrame;
    public PagamentoInterface(Janela parentFrame) {
        this.parentFrame = parentFrame;
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        this.setPreferredSize(new Dimension(800,600));
        this.setBackground(Color.RED);
        this.add(new PagamentoFrame(this), gbc);
    }
    public Janela getParentFrame() {
        return this.parentFrame;
    }
    public void lol(){
        System.out.println("lol");
    }
}

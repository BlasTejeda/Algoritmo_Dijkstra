import javax.swing.JFrame;

public class vista extends JFrame{
    protected controlador cont;

    public vista(controlador cont){
        this.cont = cont;

        this.setUndecorated(true);
        this.setSize(1100, 700);
        this.setLocationRelativeTo(this);
        this.setLayout(null);
        this.setVisible(true);
    }
}

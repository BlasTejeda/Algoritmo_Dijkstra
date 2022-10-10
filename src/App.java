import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {
        Runnable runApplication = new Runnable() {
            public void run() {
                controlador login = new controlador();
                login.getClass();
            }
        };
        SwingUtilities.invokeLater(runApplication); 
    }
}

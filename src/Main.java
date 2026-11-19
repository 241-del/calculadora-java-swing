import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Swing debe iniciarse en su propio hilo (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> new CalculadoraGUI().setVisible(true));
    }
}

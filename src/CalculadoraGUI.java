import javax.swing.*;
import java.awt.*;

/** Interfaz gráfica. Hereda de JFrame (una ventana de Swing). */
public class CalculadoraGUI extends JFrame {

    private final Calculadora calc = new Calculadora(); // lógica
    private final JTextField pantalla = new JTextField("0");

    private double primerNumero = 0;
    private String operadorPendiente = null;
    private boolean nuevoNumero = true; // true = el próximo dígito borra la pantalla

    public CalculadoraGUI() {
        super("Calculadora Java Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        // Pantalla
        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setFont(new Font("Arial", Font.BOLD, 30));
        add(pantalla, BorderLayout.NORTH);

        // Panel de botones: 5 filas x 4 columnas
        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] botones = {
            "C", "DEL", "^", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "%", "="
        };
        for (String texto : botones) {
            JButton b = new JButton(texto);
            b.setFont(new Font("Arial", Font.BOLD, 20));
            b.addActionListener(e -> manejar(e.getActionCommand())); // evento del clic
            panel.add(b);
        }
        add(panel, BorderLayout.CENTER);

        setSize(360, 460);
        setLocationRelativeTo(null); // centrar en pantalla
    }

    /** Decide qué hacer según el botón presionado. */
    private void manejar(String cmd) {
        try {
            if (cmd.matches("[0-9]"))      agregarDigito(cmd);
            else if (cmd.equals("."))      agregarPunto();
            else if (cmd.equals("C"))      limpiar();
            else if (cmd.equals("DEL"))    borrar();
            else if (cmd.equals("="))      igual();
            else if (calc.esOperador(cmd)) operador(cmd);
        } catch (ArithmeticException ex) {
            pantalla.setText(ex.getMessage());
            reiniciarEstado();
        }
    }

    private void agregarDigito(String d) {
        if (nuevoNumero || pantalla.getText().equals("0")) {
            pantalla.setText(d);
            nuevoNumero = false;
        } else {
            pantalla.setText(pantalla.getText() + d);
        }
    }

    private void agregarPunto() {
        if (nuevoNumero) {
            pantalla.setText("0.");
            nuevoNumero = false;
        } else if (!pantalla.getText().contains(".")) {
            pantalla.setText(pantalla.getText() + ".");
        }
    }

    private void operador(String op) {
        // Si ya había una operación pendiente (ej: 2 + 3 +), se resuelve primero
        if (operadorPendiente != null && !nuevoNumero) igual();
        primerNumero = Double.parseDouble(pantalla.getText());
        operadorPendiente = op;
        nuevoNumero = true;
    }

    private void igual() {
        if (operadorPendiente == null) return;
        double segundo = Double.parseDouble(pantalla.getText());
        double resultado = calc.ejecutar(operadorPendiente, primerNumero, segundo);
        pantalla.setText(formatear(resultado));
        operadorPendiente = null;
        nuevoNumero = true;
    }

    private void borrar() {
        String t = pantalla.getText();
        if (nuevoNumero || t.length() <= 1) {
            pantalla.setText("0");
            nuevoNumero = true;
        } else {
            pantalla.setText(t.substring(0, t.length() - 1));
        }
    }

    private void limpiar() {
        pantalla.setText("0");
        reiniciarEstado();
    }

    private void reiniciarEstado() {
        primerNumero = 0;
        operadorPendiente = null;
        nuevoNumero = true;
    }

    /** Muestra 8 en vez de 8.0 cuando el resultado es entero. */
    private String formatear(double n) {
        if (n == Math.rint(n) && Math.abs(n) < 1e15) return String.valueOf((long) n);
        return String.valueOf(n);
    }
}

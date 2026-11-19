import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Lógica de la calculadora (sin interfaz gráfica).
 * Guarda todas las operaciones en un mapa: símbolo -> objeto Operacion.
 */
public class Calculadora {

    private final Map<String, Operacion> operaciones = new LinkedHashMap<>();

    public Calculadora() {
        // Todas se guardan como tipo "Operacion" (polimorfismo)
        registrar(new Suma());
        registrar(new Resta());
        registrar(new Multiplicacion());
        registrar(new Division());
        registrar(new Potencia()); // extra 1
        registrar(new Modulo());   // extra 2
    }

    private void registrar(Operacion op) {
        operaciones.put(op.getSimbolo(), op);
    }

    public boolean esOperador(String simbolo) {
        return operaciones.containsKey(simbolo);
    }

    /**
     * POLIMORFISMO: no sabemos si "op" es Suma, Resta, Potencia...
     * pero al llamar op.calcular() Java ejecuta la versión correcta.
     */
    public double ejecutar(String simbolo, double a, double b) {
        Operacion op = operaciones.get(simbolo);
        if (op == null) {
            throw new IllegalArgumentException("Operación desconocida: " + simbolo);
        }
        return op.calcular(a, b);
    }
}

/** FUNCIÓN EXTRA 1: potencia (a elevado a b). Ejemplo: 2 ^ 3 = 8 */
public class Potencia extends Operacion {
    public Potencia() { super("^", "Potencia"); }

    @Override
    public double calcular(double a, double b) { return Math.pow(a, b); }
}

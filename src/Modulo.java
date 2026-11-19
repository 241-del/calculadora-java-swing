/** FUNCIÓN EXTRA 2: módulo (residuo de la división). Ejemplo: 10 % 3 = 1 */
public class Modulo extends Operacion {
    public Modulo() { super("%", "Módulo"); }

    @Override
    public double calcular(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede calcular el módulo entre cero");
        }
        return a % b;
    }
}

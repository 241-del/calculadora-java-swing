/** Herencia: Suma "es una" Operacion. */
public class Suma extends Operacion {
    public Suma() { super("+", "Suma"); }

    @Override // Sobrescribe el método abstracto del padre
    public double calcular(double a, double b) { return a + b; }
}

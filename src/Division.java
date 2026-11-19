public class Division extends Operacion {
    public Division() { super("/", "División"); }

    @Override
    public double calcular(double a, double b) {
        if (b == 0) {
            // Se lanza una excepción para que la interfaz muestre el error
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return a / b;
    }
}

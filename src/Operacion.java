/**
 * Clase abstracta: es la "clase padre" de todas las operaciones.
 * Define QUÉ debe poder hacer una operación, pero no CÓMO (eso lo decide cada hija).
 */
public abstract class Operacion {

    // Atributos privados (encapsulamiento): solo se leen con getters
    private final String simbolo;
    private final String nombre;

    public Operacion(String simbolo, String nombre) {
        this.simbolo = simbolo;
        this.nombre = nombre;
    }

    public String getSimbolo() { return simbolo; }
    public String getNombre()  { return nombre; }

    /** Método abstracto: cada clase hija DEBE implementarlo (base del polimorfismo). */
    public abstract double calcular(double a, double b);
}

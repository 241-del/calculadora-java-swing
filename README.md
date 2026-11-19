# Calculadora Java Swing

Calculadora con interfaz gráfica (Java Swing) hecha con Programación Orientada a Objetos.

## Funciones
- Básicas: suma (+), resta (-), multiplicación (*), división (/)
- Extra 1: potencia (^)  → 2 ^ 3 = 8
- Extra 2: módulo (%)    → 10 % 3 = 1
- Botones C (limpiar) y DEL (borrar último dígito), números decimales, manejo de división entre cero

## POO
- **Clases:** Operacion, Suma, Resta, Multiplicacion, Division, Potencia, Modulo, Calculadora, CalculadoraGUI, Main
- **Herencia:** cada operación `extends Operacion`; `CalculadoraGUI extends JFrame`
- **Polimorfismo:** `Calculadora.ejecutar()` llama `op.calcular()` sin saber qué operación concreta es
- **Abstracción / encapsulamiento:** clase abstracta `Operacion` con atributos privados

## Ejecutar
```
cd src
javac *.java
java Main
```

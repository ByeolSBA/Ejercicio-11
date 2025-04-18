import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // Método recursivo con condición de parada para evitar StackOverflowError
    static void metodoRecursivo(int n) {
        if (n < 10000) { // Condición de parada para evitar la recursión infinita
            metodoRecursivo(n + 1);
        }
    }

    public static void main(String[] args) {

        // Evitar IOException: Verificar si el archivo existe antes de abrirlo
        File archivo = new File("archivo_no_existente.txt");
        if (archivo.exists()) {
            try {
                FileReader file = new FileReader(archivo);
            } catch (IOException e) {
                System.out.println("¡Excepción capturada! Archivo no encontrado: " + e);
            }
        } else {
            System.out.println("¡Archivo no encontrado! No se puede abrir.");
        }

        // Evitar ArithmeticException: Comprobar que no se divida por cero
        int divisor = 0;
        if (divisor != 0) {
            try {
                int resultado = 10 / divisor;
            } catch (ArithmeticException e) {
                System.out.println("¡Excepción capturada! División por cero: " + e);
            }
        } else {
            System.out.println("¡No se puede dividir por cero!");
        }

        // Evitar OutOfMemoryError: Limitar la cantidad de memoria usada
        try {
            List<int[]> lista = new ArrayList<>();
            for (int i = 0; i < 100; i++) {  // Reducido a 100 elementos
                lista.add(new int[1000]);  // Reducido el tamaño del arreglo
            }
        } catch (OutOfMemoryError e) {
            System.out.println("¡Error crítico! Memoria insuficiente: " + e);
        }

        // Evitar StackOverflowError: Limitar la recursión
        try {
            metodoRecursivo(0);
        } catch (StackOverflowError e) {
            System.out.println("¡Error crítico! Desbordamiento de pila: " + e);
        }
    }
}


/*
 función hash: método de la multiplicación
 Las claves son cadenas de caracteres, primero se transforma
 a valor entero. A continuación se aplica el método de multiplicación
*/
import java.io.*;

public class DispersionHash {
    static final int M = 1024;
    static final double R = 0.618034;

    /** Convierte los primeros 10 caracteres de la clave en un número */
    static long transformaClave(String clave) {
        long d = 0;
        for (int j = 0; j < Math.min(clave.length(), 10); j++) {
            d = d * 27 + (int) clave.charAt(j);
        }
        // Asegurarse de que no sea negativo
        if (d < 0) d = -d;
        return d;
    }

    /** Aplica el método de la multiplicación para dispersar x en [0..M-1] */
    static int dispersion(long x) {
        double t = R * x - Math.floor(R * x);  // parte decimal de R*x
        return (int) (M * t);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in)
        );
        for (int k = 1; k <= 10; k++) {
            System.out.print("Clave a dispersar: ");
            String clave = entrada.readLine();
            long valorEntero = transformaClave(clave);
            int hash = dispersion(valorEntero);
            System.out.printf("Dispersión de '%s' → %d%n", clave, hash);
        }
    }
}


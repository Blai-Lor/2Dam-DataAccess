import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class App {

    public static void main(String[] args) {
        try (BufferedInputStream lee = new BufferedInputStream(new FileInputStream("report.txt"))) {
            System.out.println("INSPECCION DEL ARCHIVO");
            System.out.println("Bytes disponibles: " + lee.available());
            
            System.out.print("Primeros 10 bytes leidos: ");
            for (int i = 0; i < 10; i++) {
                int byteLlegit = lee.read();
                if (byteLlegit != -1) {
                    System.out.print((char) byteLlegit);
                }
            
            }

            System.out.println("BUSCANDO LA SECCION: START");
            String paraulaImportant = "START";
            int coincide = 0;
            int caracterActual;

            while ((caracterActual = lee.read()) != -1) {
                if ((char) caracterActual == paraulaImportant.charAt(coincide)) {
                    coincide++;
                    if (coincide == paraulaImportant.length()) {
                        System.out.println("La seccion STARTse ha encontrado con exito");
                        break;
                    }

                } else {
                    coincide = ((char) caracterActual == paraulaImportant.charAt(0)) ? 1 : 0;
                }
            }

            System.out.println("MARCANDO LA POSICION Y LEYENDO 40 bytes");
            lee.mark(50); 

            byte[] bufferDeLaPrimeraLeida = new byte[40];
            int bytesLeidos = lee.read(bufferDeLaPrimeraLeida);
            
            System.out.println("Texto leido:");
            if (bytesLeidos != -1) {
                System.out.println(new String(bufferDeLaPrimeraLeida, 0, bytesLeidos));

            }

            
            System.out.println("REGRESA A LA POSICION MARCADA");
            lee.reset();

            byte[] bufferDeLaSegundaLeida = new byte[40];
            int bytesDeLaSegundaLeida = lee.read(bufferDeLaSegundaLeida);

            System.out.println("Texto leido con reset():");
            if (bytesDeLaSegundaLeida != -1) {
                String stringNuevo;
                System.out.println(stringNuevo = new String(bufferDeLaSegundaLeida, 0, bytesDeLaSegundaLeida));
            }
            System.out.println("Verificacion: Empieza exactamente en el mismo punto");

            
            System.out.println("ANALIZANDO LA SECCION OTRA VEZ");
            int cuentaA = 0;
            for (int i = 0; i < bytesDeLaSegundaLeida; i++) {
                if ((char) bufferDeLaSegundaLeida[i] == 'a') {
                    cuentaA++;
                }
            }
            System.out.println("El caracter 'a' aparece " + cuentaA + " veces en la seccion leida");

        } catch (IOException e) {
            
            System.err.println("Se ha producido un error de I/O: " + e.getMessage());
        }

        System.out.println("CERRANDO PROGRAMA");
    }
}
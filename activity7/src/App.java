import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class App {

    public static void main(String[] args) throws IOException {
        final PipedOutputStream salida = new PipedOutputStream();
        final PipedInputStream entrada = new PipedInputStream(salida);

        Runnable poneLosDatos = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int numAleatorioByte = (int) (Math.random() * 256);
                    salida.write(numAleatorioByte); 
                    System.out.println("El numero que envio: " + numAleatorioByte);
                }
            } catch (IOException excepcion) {
                excepcion.printStackTrace();
            } finally {
                try {
                    salida.close();
                } catch (IOException excepcion) {
                    excepcion.printStackTrace();
                }
            }
        };

        Runnable leeLosDatos = () -> {
            try {
                int numByte;
                while ((numByte = entrada.read()) != -1) {      
                        System.out.println("El numero que he recibido es: " + numByte);
                }
            } catch (IOException excepcion) {
                excepcion.printStackTrace();
            }
        };

        Thread enviaDatos = new Thread(poneLosDatos);
        Thread recibeDatos = new Thread(leeLosDatos);

        enviaDatos.start();
        recibeDatos.start();
    }
}
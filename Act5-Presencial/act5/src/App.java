import java.io.RandomAccessFile;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        RandomAccessFile file = new RandomAccessFile("messages.txt", "rw");

        String[] mensajes = {
            "Hello from Java",
            "Random access is useful",
            "Data Access exercise",
            "CIDE DAM student project",
            "Fixed length message board"
        };

        file.seek(0);
        for (int i = 0; i < mensajes.length; i++) {
            String msg = mensajes[i];
            while (msg.length() < 40) {
                msg = msg + " ";
            }
            file.write(msg.getBytes("ASCII"));
        }

        long tamanoArchivo = file.length();
        long mensajesToales = tamanoArchivo / 40;
        System.out.println("Todos los mensajes en el archivo: " + mensajesToales);

        System.out.print("\nIntroduce el numero de mensaje para leer (0 a " + (mensajesToales - 1) + "): ");
        int leerMensaje = sc.nextInt();
        sc.nextLine();

        if (leerMensaje >= 0 && leerMensaje < mensajesToales) {
            file.seek(leerMensaje * 40);

            byte[] elTexto = new byte[40];
            file.readFully(elTexto);

            String mensajeLeido = new String(elTexto, "ASCII").trim();
            System.out.println("Mensaje " + leerMensaje + ": " + mensajeLeido);
        } else {
            System.out.println("El numero de mensaje es incorrecto");
        }

        System.out.print("\nIntroduce el numero de mensaje a modificar (0 a " + (mensajesToales - 1) + "): ");
        int mensajeCambiado = sc.nextInt();
        sc.nextLine();

        if (mensajeCambiado >= 0 && mensajeCambiado < mensajesToales) {
            System.out.print("Introduce el nuevo texto: ");
            String nuevoTexto = sc.nextLine();
            if (nuevoTexto.length() > 40) {
                nuevoTexto = nuevoTexto.substring(0, 40);
            }
            while (nuevoTexto.length() < 40) {
                nuevoTexto = nuevoTexto + " ";
            }

            file.seek(mensajeCambiado * 40);
            file.write(nuevoTexto.getBytes("ASCII"));

            file.seek(mensajeCambiado * 40);
            byte[] cambio = new byte[40];
            file.readFully(cambio);

            String textoActualizado = new String(cambio, "ASCII").trim();
            System.out.println("Mensaje actualizado: " + textoActualizado);
        } else {
            System.out.println("El numero de mensaje es incorrecto");
        }

        System.out.println("\nTamano final del archivo: " + file.length() + " bytes.");

        file.close();
        sc.close();
    }
}

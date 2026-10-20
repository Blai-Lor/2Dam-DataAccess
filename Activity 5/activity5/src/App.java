import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String txt = sc.nextLine();
        String nombreTxt = "written.txt";

        try (RandomAccessFile archivo = new RandomAccessFile(nombreTxt, "rw")) {
            byte[] bytesDelTexto = txt.getBytes();
            archivo.write(bytesDelTexto);
            System.out.println("El texto se ha guardado en " + nombreTxt);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

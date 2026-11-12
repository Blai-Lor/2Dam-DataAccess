import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java Main origen destino");
            return;
        }

        String origen = args[0];
        String destino = args[1];
        int[] mapa = generarMapa(12345L);
        int[] mapaInverso = new int[256];

        for (int i = 0; i < 256; i++) {
            mapaInverso[mapa[i] & 0xFF] = i;
        }

        try (ScrambledInputStream in = new ScrambledInputStream(new FileInputStream(origen), mapaInverso);
            FileOutputStream out = new FileOutputStream(destino)) {
            byte[] buffer = new byte[1024];
            int bytesLeidos;

            while ((bytesLeidos = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesLeidos);
            }
            System.out.println("El fichero se ha descifrado.");
        } catch (IOException e) {
            System.out.println("Error leyendo o escribiendo el archivo: " + e.getMessage());
        }
    }

    private static int[] generarMapa(long semilla) {
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = i;
        }

        Random rnd = new Random(semilla);
        for (int i = 0; i < 256; i++) {
            int j = rnd.nextInt(256);
            int aux = map[i];
            map[i] = map[j];
            map[j] = aux;
        }

        return map;
    }
}
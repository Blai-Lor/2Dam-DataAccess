import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScrambleFile {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: java Main <archivo_origen> <archivo_destino>");
            System.exit(1);
        }

        String sourceFile = args[0];
        String destinationFile = args[1];
        int[] randomMap = generateRandomMap();

        try (
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destinationFile);
            ScrambledOutputStream sos = new ScrambledOutputStream(fos, randomMap)
        ) {
            int leeByte;
            while ((leeByte = fis.read()) != -1) {
                sos.write(leeByte);
            }
            System.out.println("Archivo procesado correctamente");
        } catch (IOException e) {
            System.err.println("Error de E/S");
        }

        
    }

    private static int[] generateRandomMap() {
        List<Integer> byteValues = new ArrayList<>(256);
        for (int i = 0; i < 256; i++) {
            byteValues.add(i);
        }
        
        Collections.shuffle(byteValues);
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = byteValues.get(i);
        }
        return map;
    }
}
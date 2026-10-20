import java.io.File;
import java.io.IOException;
import java.util.Date;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Falta la ruta");
            return;
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("La ruta " + file.getPath() + " no existe");
            return;
        }

        System.out.println("Ruta original: " + file.getPath());
        System.out.println("Ruta absoluto: " + file.getAbsolutePath());
        System.out.println("Ruta canonica: " + file.getCanonicalPath());
        System.out.println("Nombre: " + file.getName());
        System.out.println("Directorio padre: " + file.getParent());

        if (file.isFile()) {
            System.out.println("Tipo: fichero");
            System.out.println("Tamaño (bytes): " + file.length());
            System.out.println("Esta oculto: " + file.isHidden());
            System.out.println("Ultima modificacion: " + new Date(file.lastModified()));
        } else if (file.isDirectory()) {
            System.out.println("Tipo: directorio");
        }
    }
}
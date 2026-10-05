import java.io.File;
import java.io.IOException;
import java.util.Date;

public class App {

    public static void main(String[] args) throws IOException {

        File file = new File("data", "students.txt");
        System.out.println("La ruta original: " + file.getPath());
        System.out.println("La ruta absoluta: " + file.getAbsolutePath());

        File absoluta = file.getAbsoluteFile();
        System.out.println("Ruta absoluta: " + absoluta);
        System.out.println("Ruta canonico: " + file.getCanonicalPath());
        System.out.println("Nombre: " + file.getName());
        System.out.println("Directorio padre: " + file.getParent());

        System.out.println("Es absoluta: " + file.isAbsolute());
        System.out.println("Existe: " + file.exists());
        System.out.println("Es fichero: " + file.isFile());
        System.out.println("Es directorio: " + file.isDirectory());
        System.out.println("Tamaño en bytes: " + file.length());

        System.out.println("Ultima modificacion: " + new Date(file.lastModified()));


        File relativo = new File("data/../data/./students.txt");
        System.out.println("getPath(): " + relativo.getPath());
        System.out.println("getAbsolutePath(): " + relativo.getAbsolutePath());
        System.out.println("getCanonicalPath(): " + relativo.getCanonicalPath());
    }
}

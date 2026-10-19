import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        File workspace = new File("workspace");
        if (!workspace.exists()) {
            workspace.mkdir();
            System.out.println("El directorio 'workspace' creado");
        }

        File notas = new File(workspace, "notes.txt");
        File data = new File(workspace, "data.txt");
        File imagen = new File(workspace, "image.jpg");

        if (!notas.exists()) {
            notas.createNewFile();
            System.out.println("Archivo notes.txt creado");
        }
        if (!data.exists()) {
            data.createNewFile();
            System.out.println("Archivo data.txt creado");
        }
        if (!imagen.exists()) {
            imagen.createNewFile();
            System.out.println("Archivo image.jpg creado");
        }
        System.out.println("Archivos creados correctamente");

        System.out.println("Archivos .txt");
        String[] archivosTxt = workspace.list((dir, name) -> name.endsWith(".txt"));
        if (archivosTxt != null) {
            for (String nombre : archivosTxt) {
                System.out.println(nombre);
            }
        }

        File students = new File(workspace, "students.txt");
        if (data.renameTo(students)) {
            System.out.println("Archivo data.txt renombrado a students.txt");
        } else {
            System.out.println("Error al renombrar data.txt");
        }

        if (imagen.delete()) {
            System.out.println("Archivo image.jpg eliminado");
        } else {
            System.out.println("Error al eliminar image.jpg");
        }

        if (notas.delete()) {
            System.out.println("Archivo notes.txt eliminado");
        } else {
            System.out.println("Error al eliminar notes.txt");
        }

        System.out.println("Contenido final del directorio:");
        String[] elArchivoFinal = workspace.list();
        if (elArchivoFinal != null) {
            for (String nombre : elArchivoFinal) {
                System.out.println(nombre);
            }
        }
    }
}

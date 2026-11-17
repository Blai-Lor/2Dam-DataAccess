import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LeeEmpleados {
    final static String FILENAME = "employees.dat";
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(FILENAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            @SuppressWarnings("unchecked")
            ArrayList<Employee> empleados = (ArrayList<Employee>) ois.readObject();
            int suma = 0;
            System.out.println("Empleados leidos del fichero:");
            for (Employee e : empleados) {
                System.out.println("- " + e.getName() + ", " + e.getAge() + " años");
                suma += e.getAge();
            }

            if (empleados.size() > 0) {
                double media = (double) suma / empleados.size();
                System.out.println("Edad media: " + media);
            }

        } catch (ClassNotFoundException cnfe) {
            System.err.println("No se encuentra la clase: " + cnfe.getMessage());
        } catch (IOException ioe) {
            System.err.println("Error de E/S: " + ioe.getMessage());
        }
    }
}

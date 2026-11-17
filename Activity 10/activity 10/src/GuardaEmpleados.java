import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GuardaEmpleados {
    final static String FILENAME = "employees.dat";
    public static void main(String[] args) {

        ArrayList<Employee> empleados = new ArrayList<>();
        empleados.add(new Employee("Andrés Palomino", 19));
        empleados.add(new Employee("Xisco Cardona", 43));
        empleados.add(new Employee("Fran Rodriguez", 27));

        try (FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(empleados);
            System.out.println("Empleados guardados en " + FILENAME);

        } catch (IOException ioe) {
            System.err.println("Error de E/S: " + ioe.getMessage());
        }
    }
}
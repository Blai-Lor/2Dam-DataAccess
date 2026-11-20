import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestVehicle {
    final static String FILENAME = "vehicle.dat";
    public static void main(String[] args) {
        SerVehicle coche = new SerVehicle("Toyota Corolla", 2022);

        try (FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(coche);
            System.out.println("Vehiculo guardado en " + FILENAME);

        } catch (IOException ioe) {
            System.err.println("Error de E/S al guardar: " + ioe.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            SerVehicle leido = (SerVehicle) ois.readObject();
            System.out.println("Vehiculo leido del fichero:");
            System.out.println("Marca: " + leido.getBrand());
            System.out.println("Anyo: " + leido.getYear());

        } catch (ClassNotFoundException cnfe) {
            System.err.println("No se encuentra en esta clase " + cnfe.getMessage());
        } catch (IOException ioe) {
            System.err.println("Error de E/S al leer");
        }
    }
}

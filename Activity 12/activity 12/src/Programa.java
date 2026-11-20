import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Programa {
    final static String FILENAME = "bankaccount.dat";
    public static void main(String[] args) {
        CuentaDelBanco cuenta = new CuentaDelBanco("Blai Ferrer", 12345, 1523.75);

        System.out.println("Serializando");
        try (FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(cuenta);
            System.out.println("Cuenta guardada en " + FILENAME);

        } catch (IOException ioe) {
            System.err.println("Error de E/S al guardar");
        }

        System.out.println("\nDeserializando");
        try (FileInputStream fis = new FileInputStream(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            CuentaDelBanco lee = (CuentaDelBanco) ois.readObject();

            System.out.println("\nDatos de la cuenta restaurada:");
            System.out.println("Titular: " + lee.getTitularCuenta());
            System.out.println("Numero de cuenta: " + lee.getNumCuenta());
            System.out.println("Saldo: " + lee.getBalance());

        } catch (ClassNotFoundException cnfe) {
            System.err.println("Esta clase no esta " + cnfe.getMessage());
        } catch (IOException ioe) {
            System.err.println("Error de E/S al leer");
        }
    }
}
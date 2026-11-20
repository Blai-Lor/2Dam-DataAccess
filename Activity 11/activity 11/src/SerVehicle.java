import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerVehicle extends Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    public SerVehicle(String brand, int year) {
        super(brand, year);
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeUTF(getBrand());
        oos.writeInt(getYear());
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        String brand = ois.readUTF();
        int year = ois.readInt();
        setBrand(brand);
        setYear(year);
    }
}
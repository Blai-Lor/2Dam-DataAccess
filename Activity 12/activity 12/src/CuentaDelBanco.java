import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class CuentaDelBanco implements Externalizable {
    private static final long serialVersionUID = 1L;
    private String titularCuenta;
    private int numCuenta;
    private double balance;

    public CuentaDelBanco() {
        System.out.println("Constructor sin argumentos llamado");
    }

    public CuentaDelBanco(String titularCuenta, int numCuenta, double balance) {
        this.titularCuenta = titularCuenta;
        this.numCuenta = numCuenta;
        this.balance = balance;
    }

    public String getTitularCuenta() {
        return titularCuenta;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("[writeExternal] llamado");
        out.writeUTF(titularCuenta);
        out.writeInt(numCuenta);
        out.writeDouble(balance);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("[readExternal] llamado");
        titularCuenta = in.readUTF();
        numCuenta = in.readInt();
        balance = in.readDouble();
    }
}
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ScrambledOutputStream extends FilterOutputStream {

    private int[] map;

    public ScrambledOutputStream(OutputStream out, int[] map) {
        super(out);

        if (map == null) {
            throw new NullPointerException("map is null");
        }

        if (map.length != 256) {
            throw new IllegalArgumentException("map.length != 256");
        }

        this.map = map;
    }

    @Override
    public void write(int buffer) throws IOException {
        out.write(map[buffer]);
    }

    //Mira que el array no sea null, valida el desplazamiento y lo largo para que no pase del array
    //Si la longitud es 0, no hace nada y los escribe uno a uno

    @Override
    public void write(byte[] buffer, int desplaza, int largo) throws IOException {
        if (buffer == null) {
            throw new NullPointerException("buffer is null");
        }
        if ((desplaza < 0) || (desplaza > buffer.length) || (largo < 0) ||
            ((desplaza + largo) > buffer.length) || ((desplaza + largo) < 0)) {
            throw new IndexOutOfBoundsException();
        } else if (largo == 0) {
            return;
        }

        for (int i = 0; i < largo; i++) {
            write(buffer[desplaza + i]);
        }
    }
}
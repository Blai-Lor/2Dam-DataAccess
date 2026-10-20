import java.io.RandomAccessFile;

public class App {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("lipsum8.txt", "r");

        file.seek(98);

        byte[] word = new byte[12];
        file.readFully(word);

        System.out.println(new String(word));

        file.close();
    }
}

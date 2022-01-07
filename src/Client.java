import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("192.168.1.13", 3636);
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            while(true) {
                outputStream.writeUTF(scanner.nextLine());
                outputStream.flush();
                System.out.println(inputStream.readUTF());

            }


            //socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
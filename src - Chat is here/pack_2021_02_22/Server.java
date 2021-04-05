package pack_2021_02_22;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {

    ArrayList<MyConnection> connections = new ArrayList<>();
    HashMap<String, String> nicknames = new HashMap<>();

    static final String FILE_NAME = "users.txt";
    static final String DEVIDER = " ~!~ ";

    public static void main(String[] args) {
        new Server().serverStart();
    }

    public void serverStart() {
        initNicknames();
        try (ServerSocket server = new ServerSocket(5555);) {
            System.out.println("Сервер ожидает подключения");
            while (true) {
                Socket socket = server.accept();
                System.out.println("К нам подключился: " + socket.getInetAddress());
                MyConnection connection = new MyConnection(socket, this);
                new Thread(connection).start();
                connections.add(connection);
//                System.out.println(connections.size());
            }
        } catch (IOException e) {
            System.out.println("Проблемы с сервером");
        }
    }

    private void initNicknames() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_NAME)))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] items = line.split(DEVIDER);
                nicknames.put(items[0], items[1]);
            }
        } catch (IOException e) {

        }
    }

    public void messageReceived(String messageFromClient) {

        for (MyConnection connection : connections) {
            try {
                connection.sendMessage(messageFromClient);
            }catch(IOException e){
//                System.err.println("Вай-вай, ошибка при рассылке сообщений!!!");
            }
        }
        System.out.println(messageFromClient);
    }
}

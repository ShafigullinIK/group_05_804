package pack_2021_02_22;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class MyConnection implements Runnable {

//  Нужен метод у сервера,
//  который будет рассылать сообщения всем клиентам.
//  У сервера должен быть отдельный поток на каждого клиента.


    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private Server server;

    private String nickname = "Аноним";


    public MyConnection(Socket socket, Server server) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {

        }
        this.server = server;
        init(socket.getInetAddress().toString());
    }

    public void init(String ip) {
        HashMap<String, String> nicknames = server.nicknames;
        if (nicknames.containsKey(ip)) {
            nickname = nicknames.get(ip);
            return;
        } else {
            try {
                writer.write("Представьтесь пожалуйста :)");
                writer.newLine();
                writer.flush();
                String newNickname = reader.readLine();
                while (nicknames.containsValue(newNickname)) {
                    writer.write("Вы все врете! такой у нас есть :-p");
                    writer.newLine();
                    writer.flush();
                    newNickname = reader.readLine();
                }
                nicknames.put(ip, newNickname);
                writeToFile(ip, newNickname);
                nickname = newNickname;
                writer.write("Приятного общения в нашем уютном чатике :)");
                writer.newLine();
                writer.flush();
            } catch (IOException e) {

            }
        }
    }

    private void writeToFile(String ip, String newNickname) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(server.FILE_NAME), true))) {
            writer.write(ip + server.DEVIDER + newNickname);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {

        }
    }

    public void sendMessage(String message) throws IOException {
        writer.write(message);
        writer.newLine();
        writer.flush();
    }


    @Override
    public void run() {
        try {
            String message = reader.readLine();
            while (message != null && !"exit".equals(message)) {
                server.messageReceived(nickname + ": " + message);
                message = reader.readLine();
            }
        } catch (IOException e) {

        }
    }
}

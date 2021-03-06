package pack_2021_02_22;

import java.io.*;
import java.net.Socket;

public class Client {

//    static String name = "Товарищь преподаватель";

    public static void main(String[] args) {
        try (Socket socket = new Socket("192.168.43.180", 5555);) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Клиент запущен, потоки ввода вывода созданы");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        String message = reader.readLine();
                        while (!"exit".equals(message)) {
                            System.out.println(message);
                            message = reader.readLine();
                        }
                    } catch (IOException e) {

                    }
                }
            });
            t.setDaemon(true);
            t.start();
            String myMessage = consoleReader.readLine();
            while (!"exit".equals(myMessage)) {
                writer.write(myMessage);
                writer.newLine();
                writer.flush();
//                System.out.println("Введите сообщение: ");
                myMessage = consoleReader.readLine();
            }
            System.out.println("Цикл завершён");
            writer.close();
            System.out.println("writer завершён");
            reader.close();
            System.out.println("reader завершён");
        }catch (IOException e) {
            System.out.println("Не удается подключиться к серверу :(");
        }
        System.out.println("Main завершается");
    }
}

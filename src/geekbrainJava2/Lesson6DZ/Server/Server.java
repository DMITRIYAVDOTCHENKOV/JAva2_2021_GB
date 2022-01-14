package geekbrainJava2.Lesson6DZ.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int DEFAULT_PORT = 8189;

    public static void main(String[] args) throws IOException {
        int port = DEFAULT_PORT;
        if (args.length != 0) {
            port = Integer.parseInt(args[0]);
        }
        new Server().start(port);
    }

    public void start(int port) throws IOException {
        ServerSocket socket = null;
        Socket clientSocket = null;
        Thread inputThread = null;
        try {
            socket = new ServerSocket(port);
            System.out.println("Сервер запущен.");
            clientSocket = socket.accept();
            System.out.println("Клиент подключился.");
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            inputThread = runInputThread(in);
            runOutputLoop(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputThread != null) inputThread.interrupt();
            if (clientSocket != null) clientSocket.close();
            if (socket != null) socket.close();
        }
    }

    private void runOutputLoop(DataOutputStream out) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.next();
            out.writeUTF(message);
            if (message.equals("/end")) {
                break;
            }
        }
    }

    private Thread runInputThread(DataInputStream in) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = in.readUTF();
                    System.out.println("From client: " + message);
                    if (message.equals("/end")) {
                        System.exit(0);
                    }
                } catch (IOException e) {
                    System.out.println("Connection was closed");
                    break;
                }
            }
        });
        thread.start();
        return thread;
    }
}




//        Socket socket = null;
//        try (ServerSocket serverSocket = new ServerSocket(8189)) {
//            System.out.println("Сервер запущен, ожидаем подключения...");
//            socket = serverSocket.accept();
//            System.out.println("Клиент подключился");
//            DataInputStream in = new DataInputStream(socket.getInputStream());
//            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//            while (true) {
//                String str = in.readUTF();
//                if (str.equals("/end")) {
//                    break;
//                }
//                out.writeUTF("Эхо: " + str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//        ServerSocket serv = null;
//        Socket sock = null;
//        try {
//            serv = new ServerSocket(8189);
//            System.out.println("Сервер запущен, ожидаем подключения...");
//            sock = serv.accept();
//            System.out.println("Клиент подключился");
//            new Client(sock, "Сервер");
//            while(true){
//                if(sock.isClosed()){
//                    break;
//                }
//            }
//            serv.close();
//            System.exit(0);
//        } catch (IOException e) {
//            System.out.println("Ошибка инициализации сервера");
//        } finally {
//            try {
//                serv.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//        new ChatServer();
//    }

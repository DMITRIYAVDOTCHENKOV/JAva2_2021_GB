package geekbrainJava2.Lesson6DZ.CLient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;



public class EchoClient extends JFrame {

}

//    private final String SERVER_ADDR = "localhost";
//    private final int SERVER_PORT = 8189;
//
//    private JTextField msgInputField;
//    private JTextArea chatArea;
//
//    private Socket socket;
//    private DataInputStream in;
//    private DataOutputStream out;
//
//    public void EchoClient() {
//        try {
//            openConnection();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        prepareGUI();
//    }
//
//    public void openConnection() throws IOException {
//        socket = new Socket(SERVER_ADDR, SERVER_PORT);
//        in = new DataInputStream(socket.getInputStream());
//        out = new DataOutputStream(socket.getOutputStream());
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    while (true) {
//                        String strFromServer = in.readUTF();
//                        if (strFromServer.equalsIgnoreCase("/end")) {
//                            break;
//                        }
//                        chatArea.append(strFromServer);
//                        chatArea.append("\n");
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//
//    public void closeConnection() {
//        try {
//            in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void sendMessage() {
//        if (!msgInputField.getText().trim().isEmpty()) {
//            try {
//                out.writeUTF(msgInputField.getText());
//                msgInputField.setText("");
//                msgInputField.grabFocus();
//            } catch (IOException e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Ошибка отправки сообщения");
//            }
//        }
//    }
//
//    public void prepareGUI() {
//        // Параметры окна
//        setBounds(600, 300, 500, 500);
//        setTitle("Клиент");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        // Текстовое поле для вывода сообщений
//        chatArea = new JTextArea();
//        chatArea.setEditable(false);
//        chatArea.setLineWrap(true);
//        add(new JScrollPane(chatArea), BorderLayout.CENTER);
//
//        // Нижняя панель с полем для ввода сообщений и кнопкой отправки сообщений
//        JPanel bottomPanel = new JPanel(new BorderLayout());
//        JButton btnSendMsg = new JButton("Отправить");
//        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
//        msgInputField = new JTextField();
//        add(bottomPanel, BorderLayout.SOUTH);
//        bottomPanel.add(msgInputField, BorderLayout.CENTER);
//        btnSendMsg.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                sendMessage();
//            }
//        });
//        msgInputField.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                sendMessage();
//            }
//        });
//
//        // Настраиваем действие на закрытие окна
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
//                try {
//                    out.writeUTF("/end");
//                    closeConnection();
//                } catch (IOException exc) {
//                    exc.printStackTrace();
//                }
//            }
//        });
//
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new EchoClient();
//            }
//        });
//    }
//}













//    private Scanner in;
//    private Scanner input;
//    private PrintWriter out;
//    private Thread threadIn;
//    private Thread threadOut;
//    public Client(Socket sock, String name) {
//        try {
//            in = new Scanner(sock.getInputStream());
//            input = new Scanner(System.in);
//            out = new PrintWriter(sock.getOutputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        threadOut = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    if (input.hasNext()) {
//                        String q = input.next();
//                        sendMsg(name+": "+q);
//                        if (q.equalsIgnoreCase("close")) break;
//                    }
//                }
//                close(sock);
//
//            }
//        });
//        threadOut.start();
//        threadIn = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    if (in.hasNext()) {
//                        String w = in.nextLine();
//                        System.out.println(w);
//                        if (w.contains("close")) break;
//                    }
//                }
//                close(sock);
//            }
//        });
//        threadIn.start();
//    }
//
//    private void sendMsg(String w) {
//        out.println(w);
//        out.flush();
//    }
//    private void close(Socket sock){
//        threadIn.interrupt();
//        threadOut.interrupt();
//        try {
//            sock.close();
//        } catch (Exception e) {}
//
//    }
//}
//

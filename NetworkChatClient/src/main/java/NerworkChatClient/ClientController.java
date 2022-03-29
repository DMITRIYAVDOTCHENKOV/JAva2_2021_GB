package NerworkChatClient;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ru.avdotchenkov.client.model.Network;

import java.io.IOException;
import java.util.function.Consumer;

public class ClientController {

    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;
    @FXML
    private Button sendButton;
    @FXML
    public ListView<String> userList;

    private Network network;
    private ClientChat application;

    public void sendMessage() {
        String massege = textField.getText();
        appendMessageToChat(massege);

        try {
            network.sendMessage(massege);
        } catch (IOException e) {
            application.showErrorDialog("Ошибка передачи данный по сети");
        }
    }

    private void appendMessageToChat(String massege) {
        if (!massege.isEmpty()) {
            textArea.appendText(massege);
            textArea.appendText(System.lineSeparator());
            textField.clear();
        }
    }

    public void setNetwork(Network network) {
        this.network = network;

        network.waitMessages(new Consumer<String>() {
            @Override
            public void accept(String message) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        appendMessageToChat(message);

                    }
                });
            }
        });
    }

    public void setApplication(ClientChat application) {
        this.application = application;
    }
}
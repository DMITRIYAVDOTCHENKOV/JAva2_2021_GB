package ru.avdotchenkov.client.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ru.avdotchenkov.client.ClientChat;
import ru.avdotchenkov.client.dialogs.Dialogs;
import ru.avdotchenkov.client.model.Network;
import ru.avdotchenkov.client.model.ReadCommandListener;
import ru.avdotchenkov.clientserver.Command;
import ru.avdotchenkov.clientserver.CommandType;
import ru.avdotchenkov.clientserver.commands.AuthOkCommandData;
import ru.avdotchenkov.clientserver.commands.ErrorCommandData;

import java.io.IOException;

public class AuthController {


    @FXML
    private final TextField loginField;
    @FXML
    private final PasswordField passwordField;
    @FXML
    private final Button authButton;

    private ReadCommandListener readMessageListener;

    public AuthController(TextField loginField, PasswordField passwordField, Button authButton) {
        this.loginField = loginField;
        this.passwordField = passwordField;
        this.authButton = authButton;
    }

    @FXML
    public void executeAuth(ActionEvent actionEvent) {
        String login = loginField.getText();
        String password = passwordField.getText();
        if (login == null || login.isBlank() || password == null || password.isBlank()) {
            Dialogs.AuthError.EMPTY_CREDENTIALS.show();
            return;
        }

        if (!connectToServer()) {
            Dialogs.NetworkError.SERVER_CONNECT.show();
        }

        try {
            Network.getInstance().sendAuthMessage(login, password);
        } catch (IOException e) {
            Dialogs.NetworkError.SEND_MESSAGE.show();
            e.printStackTrace();
        }
    }

    private boolean connectToServer() {
        Network network = Network.getInstance();
        return network.isConnected() || network.connect();
    }

    public void initializeMessageHandler() {
        readMessageListener = getNetwork().addReadMessageListener(new ReadCommandListener() {
            @Override
            public void processReceivedCommand(Command command) {
                if (command.getType() == CommandType.AUTH_OK) {
                    AuthOkCommandData data = (AuthOkCommandData) command.getData();
                    String username = data.getUsername();
                    Platform.runLater(() -> ClientChat.INSTANCE.switchToMainChatWindow(username));
                } else if (command.getType() == CommandType.ERROR){
                    ErrorCommandData data = (ErrorCommandData) command.getData();
                    Platform.runLater(() -> {
                        Dialogs.AuthError.INVALID_CREDENTIALS.show(data.getErrorMessage());
                    });
                }
            }
        });
    }

    public void close() {
        getNetwork().removeReadMessageListener(readMessageListener);
    }

    private Network getNetwork() {
        return Network.getInstance();
    }
}

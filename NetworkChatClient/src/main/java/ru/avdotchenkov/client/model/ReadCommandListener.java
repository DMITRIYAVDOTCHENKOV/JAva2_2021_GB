package ru.avdotchenkov.client.model;

import ru.avdotchenkov.clientserver.Command;

public interface ReadCommandListener {

    void processReceivedCommand(Command command);

}
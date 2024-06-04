package ru.gb.library_online.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;
import ru.gb.library_online.model.Book;

@MessagingGateway(defaultRequestChannel = "textInputChanel")
public interface FileGetawayInterface {
    void writeToFile(@Header(FileHeaders.FILENAME) String fileName, Book book);
}

package com.mr486.tdc.serveur;

import com.mr486.tdc.serveur.model.ChatServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TdcMainsrvApplication {

  public static final ChatServer chatServer = new ChatServer(8887);

  public static void main(String[] args) {

    SpringApplication.run(TdcMainsrvApplication.class, args);
    chatServer.start();

  }

}

package com.mr486.tdc.serveur;

import com.mr486.tdc.serveur.model.ChatServer;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class TdcMainsrvApplication {
  private static Long reunionActiveId;


  public static void main(String[] args) {

    SpringApplication.run(TdcMainsrvApplication.class, args);

  }

  public static Long idPartieActive(){
    return reunionActiveId;
  }

}

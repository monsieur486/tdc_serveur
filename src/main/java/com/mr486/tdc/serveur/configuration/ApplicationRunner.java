package com.mr486.tdc.serveur.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationRunner implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    log.info("Tentative de lancement du serveur websocket...");
  }
}

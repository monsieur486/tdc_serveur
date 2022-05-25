package com.mr486.tdc.serveur.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

import static com.mr486.tdc.serveur.TdcMainsrvApplication.chatServer;


@Controller
public class WebCagnottesController {

  @GetMapping(value = { "/cagnottes" })
  public String getHomePage(Model model)
  {
    Map<String, Object> map = new HashMap<>();
    map.put("message", "C'est l'été");
    map.put("age", 34);
    chatServer.sendToAll(200,map.toString());
    return "cagnottes";
  }

}

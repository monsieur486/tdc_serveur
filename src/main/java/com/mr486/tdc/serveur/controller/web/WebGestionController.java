package com.mr486.tdc.serveur.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebGestionController {

  @GetMapping(value = { "/gestion" })
  public String getHomePage(Model model)
  {
    return "gestion";
  }

}

package com.mr486.tdc.serveur.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CagnottesController {

  @GetMapping(value = { "/cagnottes" })
  public String getHomePage(Model model)
  {
    return "cagnottes";
  }

}

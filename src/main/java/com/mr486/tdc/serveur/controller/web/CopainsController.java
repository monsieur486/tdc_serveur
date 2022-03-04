package com.mr486.tdc.serveur.controller.web;

import com.mr486.tdc.serveur.model.Copain;
import com.mr486.tdc.serveur.service.CopainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import static com.mr486.tdc.serveur.TdcMainsrvApplication.chatServer;

@Controller
public class CopainsController {

  @Autowired
  private CopainServiceImpl contactService;

  @GetMapping(value = { "/copains" })
  public String getHomePage(Model model)
  {
    List<Copain> copains = contactService.toutLesCopains();
    Long nombreCopains = contactService.count();
    model.addAttribute("copains", copains);
    model.addAttribute("nombreCopains", nombreCopains);
    return "copains";
  }

}

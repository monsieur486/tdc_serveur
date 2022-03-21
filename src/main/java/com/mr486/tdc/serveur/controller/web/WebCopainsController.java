package com.mr486.tdc.serveur.controller.web;

import com.mr486.tdc.serveur.model.Copain;
import com.mr486.tdc.serveur.service.CopainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class WebCopainsController {

  @Autowired
  private CopainService contactService;

  @GetMapping(value = { "/copains" })
  public String getHomePage(
    Model model,
    @RequestParam(value = "page", defaultValue = "1") int page,
    @RequestParam(value = "lignes", defaultValue = "5") int lignes)
  {
    if(lignes <=0){
      lignes =1;
    }

    if(page<=0){
      page=1;
    }

    List<Copain> copains = contactService.toutLesCopains(page, lignes);
    Long nombreCopains = contactService.compte();
    double rapportPages = (nombreCopains/lignes);
    int pages = (int) rapportPages;
    model.addAttribute("copains", copains);
    model.addAttribute("pageCourante", page);
    model.addAttribute("pagesMax", pages);
    model.addAttribute("lignes", lignes);
    model.addAttribute("nombreCopains", nombreCopains);
    return "copains";
  }

}

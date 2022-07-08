package guru.springframework.sfgpetclinic.controllers.vets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetsController{

  @RequestMapping({"vets"})
  public String listVets(Model model) {
    return "vets/index";
  }
}

package comgroupid.demoartifact.Controlador;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String Inicio(Model model){
        List<String> lista = new LinkedList<String>();
        lista.add("Valor 1");
        lista.add("Valor 2");
        lista.add("Valor 3");
        lista.add("Valor 4");
        lista.add("Valor 5");
        lista.add("Valor 6");
        model.addAttribute("mensaje","Mensaje desde model");
        model.addAttribute("lista", lista);
        return "home";
    }
}
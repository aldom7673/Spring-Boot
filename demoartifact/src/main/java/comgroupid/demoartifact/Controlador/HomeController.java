package comgroupid.demoartifact.Controlador;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import comgroupid.demoartifact.Modelo.Modelo;

@Controller
public class HomeController {

    @GetMapping("/")
    public String Inicio(Model model){
        model.addAttribute("mensaje","Mensaje desde model");

        List<String> lista = new LinkedList<String>();
        lista.add("Valor 1");
        lista.add("Valor 2");
        lista.add("Valor 3");
        lista.add("Valor 4");
        lista.add("Valor 5");
        lista.add("Valor 6");
        model.addAttribute("lista", lista);

        Modelo modelo = new Modelo(1, "Aldo");
        model.addAttribute("modelo", modelo);
        return "home";
    }
}
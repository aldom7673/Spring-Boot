package comgroupid.demoartifact.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/requestMapping")
public class EjemploRequestMapping {
    
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String Index(){
        return "reqMapping";
    }

    @GetMapping("/enviarGet/{valor}")
    public String RecibirGet(@PathVariable("valor") String valor, Model model){
        model.addAttribute("valor", valor);
        return "reqMapping";
    }

    @GetMapping("/requestParam")
    public String RecibirParam(@RequestParam("valor") String valor, Model model){
        model.addAttribute("valor", valor + " con RequestParam");
        return "reqMapping";
    }

    @PostMapping("/enviarPost")
    public String RecibirPost(@RequestParam("valor") String valor, @RequestParam("valor2") String valor2, Model model){
        model.addAttribute("valor", "Valor con post: " + valor + " y " + valor2);
        return "reqMapping";
    }
}
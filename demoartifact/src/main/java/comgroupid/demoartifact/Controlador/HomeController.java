package comgroupid.demoartifact.Controlador;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comgroupid.demoartifact.Modelo.Modelo;
import comgroupid.demoartifact.Service.IDependenciaService;

@Controller
public class HomeController {
    @Autowired
    private IDependenciaService serviceDependencia;

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

        Modelo modelo = new Modelo(1, "Aldo", new Date());
        model.addAttribute("modelo", modelo);
        return "home";
    }

    @GetMapping("/listaAutowired")
    public String InicioAutowired(Model model){
        model.addAttribute("mensaje","Mensaje desde model");
        
        Modelo modelo = new Modelo();
        model.addAttribute("modelo", modelo);

        List<Modelo> lista = serviceDependencia.obtenerModelos();
        model.addAttribute("modelos", lista);
        return "home";
    }

    @PostMapping("/buscarModelo")
    public String obtenerModelo(@RequestParam("idModelo") int idModelo, Model model){
        model.addAttribute("mensaje","Mensaje desde model");
        
        Modelo modelo = serviceDependencia.buscarPorId(idModelo);
        model.addAttribute("modelo", modelo);

        List<Modelo> lista = serviceDependencia.obtenerModelos();
        model.addAttribute("modelos", lista);
        return "home";
    }
}
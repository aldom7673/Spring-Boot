package comgroupid.demoartifact.Controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comgroupid.demoartifact.Modelo.Modelo;
import comgroupid.demoartifact.Service.IDependenciaService;

@Controller
@RequestMapping(value="/databinding")
public class DataBinding {
    @Autowired
    private IDependenciaService serviceDependencia;
    
    @GetMapping("")
    public String index(Model model, Modelo modelo){
        List<Modelo> lista = serviceDependencia.obtenerModelos();
        model.addAttribute("modelos", lista);
        model.addAttribute("modelo", modelo);
        return "dataBinding";
    }

    @PostMapping("/crear")
    public String crearModelo(@RequestParam("id") int idModelo, @RequestParam("nombre") String nombre, @RequestParam("fecha") Date fecha, Model model){
        System.out.println(idModelo + " " + nombre);
        Modelo modelo = new Modelo(idModelo, nombre, fecha);
        model.addAttribute("modelo", modelo);
        serviceDependencia.GuardarModelo(modelo);
        List<Modelo> lista = serviceDependencia.obtenerModelos();
        model.addAttribute("modelos", lista);
        return "redirect:/databinding";
    }

    @PostMapping("/crearConBinding")
    public String crearModeloBinding(Modelo modelo, BindingResult result, Model model){
        if(result.hasErrors()){
            for(ObjectError error : result.getAllErrors()){
                System.out.println("Ocurrio el error:" + error.getDefaultMessage());
            }
            List<Modelo> lista = serviceDependencia.obtenerModelos();
            model.addAttribute("modelo", modelo);
            model.addAttribute("modelos", lista);
            return "dataBinding";
        }

        System.out.println("Modelo: " + modelo);
        model.addAttribute("modelo", modelo);
        serviceDependencia.GuardarModelo(modelo);
        List<Modelo> lista = serviceDependencia.obtenerModelos();
        model.addAttribute("modelos", lista);        
        return "redirect:/databinding";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
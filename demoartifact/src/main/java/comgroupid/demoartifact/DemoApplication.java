package comgroupid.demoartifact;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import comgroupid.demoartifact.Modelo.Genero;
import comgroupid.demoartifact.Modelo.TipoUsuario;
import comgroupid.demoartifact.Modelo.Usuario;
import comgroupid.demoartifact.Repository.GeneroRepository;
import comgroupid.demoartifact.Repository.TipoUsuarioRepository;
import comgroupid.demoartifact.Repository.UsuarioRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private TipoUsuarioRepository repositoryTipoUsuario;
	@Autowired
	private UsuarioRepository repositoryUsuario;
	@Autowired
	private GeneroRepository repositoryGenero;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ejemplos JPA");
		System.out.println(repositoryTipoUsuario);
		//Guardar();
		//BuscarPorId();
		//Modificar();
		//EliminarPorId();
		ObtenerUsuarios();
		CrearUsuario();
		ObtenerUsuarios();
	}
	
	private void CrearUsuario(){
		Optional<TipoUsuario> tipoUsuario = repositoryTipoUsuario.findById(3);
		Optional<Genero> genero = repositoryGenero.findById(1);
		Usuario usuario = new Usuario("Aldo2", "Mendoza2", "Morales2", "correo", "contra", tipoUsuario.get(), genero.get(),true);
		repositoryUsuario.save(usuario);
	}

	private void ObtenerUsuarios(){
		List<Usuario> usuarios = repositoryUsuario.findAll();
		for(Usuario u : usuarios){
			System.out.println(u);
		}
	}

	private void Guardar(){
		TipoUsuario tipoUsuario = new TipoUsuario("Segundo tipo usuario", "Descripcion 2", true);
		repositoryTipoUsuario.save(tipoUsuario);
		System.out.println(tipoUsuario);
	}
	
	private void BuscarPorId(){
		Optional<TipoUsuario> tipoUsuario = repositoryTipoUsuario.findById(3);
		if( tipoUsuario.isPresent() )
			System.out.println(tipoUsuario.get());
		else
			System.out.println("Entidad no encontrada");
	}

	private void Modificar(){
		Optional<TipoUsuario> optional = repositoryTipoUsuario.findById(3);
		if( optional.isPresent() ){
			TipoUsuario tipoUsuario = optional.get();
			tipoUsuario.setEstado(false);
			tipoUsuario.setDescripcion("descripcion modificada");
			tipoUsuario.setTipoUsuario("tipo de usuario modificado");
			repositoryTipoUsuario.save(tipoUsuario);
		}
		else
			System.out.println("Entidad no encontrada");
	}

	private void EliminarPorId(){
		repositoryTipoUsuario.deleteById(2);		
	}
}
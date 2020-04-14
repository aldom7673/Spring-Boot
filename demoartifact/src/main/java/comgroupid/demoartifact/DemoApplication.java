package comgroupid.demoartifact;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import comgroupid.demoartifact.Modelo.TipoUsuario;
import comgroupid.demoartifact.Repository.TipoUsuarioRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private TipoUsuarioRepository repositoryTipoUsuario;
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
		EliminarPorId();
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
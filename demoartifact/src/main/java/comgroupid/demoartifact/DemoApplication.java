package comgroupid.demoartifact;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import comgroupid.demoartifact.Modelo.Genero;
import comgroupid.demoartifact.Modelo.Rol;
import comgroupid.demoartifact.Modelo.TipoUsuario;
import comgroupid.demoartifact.Modelo.Usuario;
import comgroupid.demoartifact.Repository.GeneroRepository;
import comgroupid.demoartifact.Repository.TipoUsuarioRepository;
import comgroupid.demoartifact.Repository.UsuarioRepository;
import comgroupid.demoartifact.Repository.RolRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private TipoUsuarioRepository repositoryTipoUsuario;
	@Autowired
	private UsuarioRepository repositoryUsuario;
	@Autowired
	private GeneroRepository repositoryGenero;
	@Autowired
	private RolRepository repositoryRol;	
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
		//ObtenerUsuarios();
		//CrearUsuario();
		//CrearRoles();
		//ObtenerRoles();
		//AsignarRoles(1);
		ObtenerUsuariosActivos();
	}
	
	private void ObtenerUsuariosActivos(){
		List<Usuario> usuarios = repositoryUsuario.findByEstado(true);
		System.out.println(usuarios.size());
	}

	private void AsignarRoles(Integer idUsuario){
		Optional<Usuario> optional = repositoryUsuario.findById(idUsuario);
		Usuario usuario = optional.get();
		List<Rol> roles = new LinkedList<Rol>();
		Rol rol = new Rol();
		rol.setIdRol(1);
		roles.add(rol);
		repositoryUsuario.save(usuario);
	}

	private void CrearRoles(){
		List<Rol> roles = new LinkedList<Rol>();
		roles.add(new Rol("Administrador", true));
		roles.add(new Rol("Capturista", true));
		roles.add(new Rol("Almacenista", true));
		repositoryRol.saveAll(roles);
	}

	private void ObtenerRoles(){
		List<Rol> roles = repositoryRol.findAll();
		for(Rol r : roles){
			System.out.println(r);
		}
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
package comgroupid.demoartifact.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import comgroupid.demoartifact.Modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
    List<Usuario> findByEstado(boolean estado);
}
package umusic.com.UMusica.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import umusic.com.UMusica.entidades.Cliente;

/**
 *
 * @author julian
 */
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
    
}

package umusic.com.UMusica.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umusic.com.UMusica.entidades.Cliente;

/**
 *
 * @author julian
 */
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
    
    //JPQL: Se hace la consulta sobre la clase
    
    @Query("SELECT COUNT(*) FROM Cliente AS c WHERE c.username= :username AND c.password=:password")
    Integer findByUserNameAndPassword(@Param("username") String username, @Param("password") String password);

    @Query("SELECT c FROM Cliente AS c WHERE c.username=:username AND c.password=:password")
    Cliente findByUserAndPassword(@Param("username") String username,
            @Param("password") String password);
}


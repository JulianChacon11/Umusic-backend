package umusic.com.UMusica.controladores;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umusic.com.UMusica.entidades.Cliente;
import umusic.com.UMusica.entidades.LoginDTO;
import umusic.com.UMusica.servicios.IClienteService;
/**
 *
 * @author julian chacon
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/clientes")
public class ControladorCliente {
    
    @Autowired
    private IClienteService clienteService;
   
    @PostMapping("/loginclient")
    public int login(@RequestBody LoginDTO cliente){
        int responseLogin = clienteService.login(cliente);
        return responseLogin;
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginCliente (@RequestBody LoginDTO cliente){
        return clienteService.ingresar(cliente);
    }
    
    @GetMapping("/main")
    public String inicio(Model model) {
        var clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "index";
    }

    @GetMapping()
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id") Long id) {
        return clienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.guardarCliente(cliente), HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente) {
        return clienteService.findById(cliente.getId())
                .map(c -> ResponseEntity.ok(clienteService.guardarCliente(cliente)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> eliminarCliente(Long id) {
        return clienteService.findById(id)
                .map(c -> {
                    clienteService.eliminarCliente(id);
                    return ResponseEntity.ok(c);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
} 





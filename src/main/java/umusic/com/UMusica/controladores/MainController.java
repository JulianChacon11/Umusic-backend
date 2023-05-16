/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umusic.com.UMusica.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import umusic.com.UMusica.servicios.IClienteService;

/**
 *
 * @author julia
 */

@Controller
public class MainController {
    
    @Autowired
    private IClienteService clienteService;
    
    
    @GetMapping("/main")
    public String inicio(Model model) {
        var clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "index2";
    }
}

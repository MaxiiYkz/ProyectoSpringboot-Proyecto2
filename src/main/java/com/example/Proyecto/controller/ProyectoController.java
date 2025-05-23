package com.example.Proyecto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Proyecto.model.Usuario;
import com.example.Proyecto.services.UsuarioService;

@RestController
@RequestMapping("/api/v0/Usuario")
public class ProyectoController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public List<Usuario> obtenerUsuarios(){
        return usuarioService.obtenerUsuario();
    }

    @PostMapping
        public Usuario guardar(@RequestBody Usuario usu){
            return usuarioService.guardarUsuario(usu);
    }

    @GetMapping("{idUsuario}")
    public Usuario buscarUsuario(@PathVariable int idUsuario){
        return usuarioService.getUsuarioId(idUsuario);
    }

    @PutMapping("{idUsuario}")
    public Usuario actualizarUsuario(@PathVariable int idUsuario, @RequestBody Usuario usu) {
        usu.setIdUsuario(idUsuario);
        return usuarioService.actualizarUsuario(usu);   
    }

    @DeleteMapping("{idUsuario}")
        public String eliminarUsuario(@PathVariable int idUsuario){
            return usuarioService.eliminarUsuario(idUsuario);
        }

    @PutMapping("/{idUsuario}/estado")
    public ResponseEntity<Usuario> cambiarEstado(@PathVariable int idUsuario, @RequestParam boolean estado) {
        Usuario usuarioActualizado = usuarioService.cambiarEstado(idUsuario, estado);
        if (usuarioActualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(usuarioActualizado);
    }
    
}

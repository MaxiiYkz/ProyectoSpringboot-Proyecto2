package com.example.Proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Proyecto.model.Usuario;
import com.example.Proyecto.repository.RepositorioUsuario;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class UsuarioService {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public List<Usuario> obtenerUsuario(){
        return repositorioUsuario.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario){
        return repositorioUsuario.save(usuario);
    }

    public Usuario getUsuarioId(int idUsuario){
        return repositorioUsuario.findById(idUsuario).orElse(null);
    }

    public Usuario actualizarUsuario(Usuario usuario){
        return repositorioUsuario.save(usuario);
    }

    public String eliminarUsuario(int idUsuario){
        repositorioUsuario.deleteById(idUsuario);
        return "Usuario eliminado";
    }

    public Usuario cambiarEstado(int idUsuario, boolean estado) {
        
        Usuario usuario = repositorioUsuario.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setActivo(estado);

        return repositorioUsuario.save(usuario);    
    }
}

package com.example.Proyecto.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public List<Usuario> obtenerUsuario() {
        return repositorioUsuario.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public Usuario getUsuarioId(int idUsuario) {
        return repositorioUsuario.findById(idUsuario).orElse(null);
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public long contarUsuarios() {
        return repositorioUsuario.count();
    }

    public String obtenerMensajeCantidadUsuarios() {
        long total = contarUsuarios();
        return "Hay en total " + total + " usuarios.";
    }

    public Map<String, Object> obtenerEstadisticas() {
        Map<String, Object> estadisticas = new HashMap<>();
        estadisticas.put("Total de Usuarios", repositorioUsuario.count());
        estadisticas.put("Usuarios Activos", repositorioUsuario.findByActivoTrue().size());
        estadisticas.put("Usuarios Inactivos", repositorioUsuario.findByActivoFalse().size());
        return estadisticas;
    }

    //eliminar logicamente
    public String eliminarUsuario(int idUsuario) {
    Optional<Usuario> optionalUsuario = repositorioUsuario.findById(idUsuario);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setEliminado(true);
            usuario.setActivo(false);  // <- Aquí marcamos que ya no está activo
            repositorioUsuario.save(usuario);
            return "Usuario eliminado lógicamente y marcado como inactivo";
        } 
        else {
            return "Usuario no encontrado";
        }
    }
}

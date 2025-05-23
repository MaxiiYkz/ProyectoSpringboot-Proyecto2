/* package com.example.Proyecto.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Proyecto.model.Usuario;

@Repository
public class ClienteRepository {

    private List<Usuario> listarUsuario = new ArrayList<>();

    public List<Usuario> obtenerUsuario(){
        return listarUsuario;
    }

    public Usuario guardarUsuario(Usuario usu){
        listarUsuario.add(usu);
        return usu;
    }

    public Usuario actualizar(Usuario usu){
        int idUsuario = 0;
        int idPosition = 0;

        for (int i = 0; i < listarUsuario.size(); i++){
            if(listarUsuario.get(i).getIdUsuario() == usu.getIdUsuario()){
                idUsuario = usu.getIdUsuario();
                idPosition = 1;
            }
        }

        Usuario usu1 = new Usuario();
        usu1.setIdUsuario(idUsuario);
        usu1.setRun(usu.getRun());
        usu1.setUsuario(usu.getUsuario());
        usu1.setContraseña(usu.getContraseña());
        usu1.setCorreo(usu.getCorreo());
        usu1.setTelefono(usu.getTelefono());

        listarUsuario.set(idPosition, usu1);
        return usu;
    }

    public Usuario buscarUsuario(int idUsuario){
        for (Usuario usuario : listarUsuario){
            if (usuario.getIdUsuario() == idUsuario){
                return usuario;
            }
        }
        return null;
    }

    public void eliminarUsuario(int idUsuario){
        Usuario usu = buscarUsuario(idUsuario);
        if (usu != null){
            listarUsuario.remove(idUsuario);
        }
    }

} */

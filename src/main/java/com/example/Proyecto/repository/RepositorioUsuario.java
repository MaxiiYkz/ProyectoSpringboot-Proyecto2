package com.example.Proyecto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Proyecto.model.Usuario;



@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findById(int idUsuario);
    long count(); 
    long countByEstado(boolean estado                  );

    List<Usuario> findByActivoFalse(); //Para listar inactivos
    List<Usuario> findByActivoTrue();

}

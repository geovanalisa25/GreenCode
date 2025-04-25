package com.itb.tcc.mif3an.greencode.repository;


import com.itb.tcc.mif3an.greencode.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

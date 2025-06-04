package com.itb.tcc.mif3an.greencode.model.services;


import com.itb.tcc.mif3an.greencode.exceptions.NotFound;
import com.itb.tcc.mif3an.greencode.model.entity.Usuario;
import com.itb.tcc.mif3an.greencode.model.repository.UsuarioRepository;
import com.itb.tcc.mif3an.greencode.model.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario findByEmail(String email) {
        try {
            return this.usuarioRepository.findByEmail(email).get();
        } catch (Exception e) {
            throw new NotFound("Usuário não encontrado com o email " + email);
        }
    }
    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}


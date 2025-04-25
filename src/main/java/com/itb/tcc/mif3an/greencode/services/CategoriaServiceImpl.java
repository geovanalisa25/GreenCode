package com.itb.tcc.mif3an.greencode.services;

import com.itb.tcc.mif3an.greencode.exception.BadRequest;
import com.itb.tcc.mif3an.greencode.model.entity.Categoria;
import com.itb.tcc.mif3an.greencode.repository.CategoriaRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
CategoriaServiceImpl implements CategoriaService {
private final CategoriaRepository categoriaRepository;

public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
    this.categoriaRepository = categoriaRepository;
}

    @Override
    public Categoria save(Categoria categoria) {
    categoria.setCodStatus(true);
    if (!categoria.validarCategoria()){
        throw new BadRequest(categoria.getMensagemErro());
    }
    return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}

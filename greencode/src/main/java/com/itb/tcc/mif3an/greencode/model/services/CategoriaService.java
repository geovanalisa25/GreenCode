package com.itb.tcc.mif3an.greencode.model.services;

import com.itb.tcc.mif3an.greencode.model.entity.Categoria;

import java.util.List;

public interface CategoriaService {

    public Categoria save(Categoria categoria);
    public List<Categoria> findAll();
}

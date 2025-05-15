package com.itb.tcc.mif3an.greencode.model.services;

import com.itb.tcc.mif3an.greencode.model.entity.Material;

import java.util.List;

public interface MaterialService {

    public Material save(Material material);
    public List<Material> findAll();
    public Material findById(Long id);
}

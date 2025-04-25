package com.itb.tcc.mif3an.greencode.services;

import com.itb.tcc.mif3an.greencode.model.entity.Material;

import java.util.List;

public interface MaterialService {

    Material save(Material material);
    List<Material> findAll();
}

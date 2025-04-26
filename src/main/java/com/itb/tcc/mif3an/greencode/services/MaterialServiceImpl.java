package com.itb.tcc.mif3an.greencode.services;


import com.itb.tcc.mif3an.greencode.exception.BadRequest;
import com.itb.tcc.mif3an.greencode.model.entity.Categoria;
import com.itb.tcc.mif3an.greencode.model.entity.Material;
import com.itb.tcc.mif3an.greencode.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }



    @Override
    public List<Material> findAll() {
        return materialRepository.findAll();

    }

@Override
    public Material save(Material material) {
        material.setCodStatus(true);
        if (! material.validarMaterial()) {
            throw new BadRequest(material.getMensagemErro());

        }
        return materialRepository.save(material);
    }



    }


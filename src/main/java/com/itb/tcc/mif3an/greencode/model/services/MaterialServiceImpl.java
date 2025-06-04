package com.itb.tcc.mif3an.greencode.model.services;


import com.itb.tcc.mif3an.greencode.exceptions.BadRequest;
import com.itb.tcc.mif3an.greencode.exceptions.NotFound;
import com.itb.tcc.mif3an.greencode.model.entity.Material;
import com.itb.tcc.mif3an.greencode.model.repository.MaterialRepository;
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
    public Material findById(Long id) {
        try {
            Material material = materialRepository.findById(id).get();
            return material;
        }catch (Exception e) {
            throw new NotFound("Material não encontrado" + id);
        }
    }



@Override
    public Material save(Material material) {
        material.setCodStatus(true);
        if (! material.validarMaterial()) {
            throw new BadRequest(material.getMensagemErro());

        }

        if (material.getCategoria() == null) {
            throw new BadRequest(" A categoria é obrigatório!");
        }


        return materialRepository.save(material);
    }



    }


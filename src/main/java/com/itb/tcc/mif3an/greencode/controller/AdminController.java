package com.itb.tcc.mif3an.greencode.controller;



import com.itb.tcc.mif3an.greencode.model.entity.Material;
import com.itb.tcc.mif3an.greencode.services.MaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/admin")
public class AdminController {

    private final MaterialService materialService;

    public AdminController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/material")
    public ResponseEntity<List<Material>> listarMateriais(){
        return ResponseEntity.ok().body(materialService.findAll());
    }

}

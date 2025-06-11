package com.itb.tcc.mif3an.greencode.controller;



import com.itb.tcc.mif3an.greencode.model.entity.Categoria;
import com.itb.tcc.mif3an.greencode.model.entity.Material;
import com.itb.tcc.mif3an.greencode.model.entity.services.CategoriaService;
import com.itb.tcc.mif3an.greencode.model.entity.services.MaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/admin")
public class AdminController {

    private final MaterialService materialService;
    private final CategoriaService categoriaService;

    public AdminController(MaterialService materialService, CategoriaService categoriaService) {
        this.materialService = materialService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/material")
    public ResponseEntity<List<Material>> listarMateriais(){
        return ResponseEntity.ok().body(materialService.findAll());
    }

    @PostMapping("/material")
    public ResponseEntity<Material> salvarMaterial(@RequestBody Material material){

        return null;
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> listarCategorias(){
        return ResponseEntity.ok().body(categoriaService.findAll());
    }

    @PostMapping("/categoria")
    public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria){

        return null;
    }



}

package com.itb.tcc.mif3an.greencode.controller;



import com.itb.tcc.mif3an.greencode.exceptions.BadRequest;
import com.itb.tcc.mif3an.greencode.model.entity.Categoria;
import com.itb.tcc.mif3an.greencode.model.entity.Material;
import com.itb.tcc.mif3an.greencode.model.services.CategoriaService;
import com.itb.tcc.mif3an.greencode.model.services.MaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping ("/api/v1/admin")
public class AdminController {

    private final CategoriaService categoriaService;
    private final MaterialService materialService;


    public AdminController(CategoriaService categoriaService, MaterialService materialService) {
        this.categoriaService = categoriaService;
        this.materialService = materialService;
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return ResponseEntity.ok().body(categoriaService.findAll());
    }
    @PostMapping("/categoria")
    public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/admin/categorias").toUriString());
        return ResponseEntity.created(uri).body (categoriaService.save(categoria));
    }

        @GetMapping("/material")
        public ResponseEntity<List<Material>> listarMateriais(){
            return ResponseEntity.ok().body(materialService.findAll());
        }

    @PostMapping("/material")
    public ResponseEntity<Material> saveMaterial(@RequestBody Material material) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/admin/material").toUriString());
        return ResponseEntity.created(uri).body (materialService.save(material));
    }


    @GetMapping("/material/{id}")
    public ResponseEntity<Material> findAllById
            (@PathVariable(value = "id") String id) {
        try{        Long idLong = Long.parseLong(id);
            return ResponseEntity.ok().body(materialService.findById(idLong));
        } catch (NumberFormatException e) {
            throw new BadRequest("'"+id+"' não é um número inteiro válido. Por favor, forneça um valor inteiro.");    }
    }




}

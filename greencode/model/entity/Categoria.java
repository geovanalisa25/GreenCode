package com.itb.tcc.mif3an.greencode.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categoria")
@Data
@NoArgsConstructor

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String nome;
    @Column(nullable = false,columnDefinition = "VARCHAR(MAX)")
    private String descricao;
    private boolean codStatus;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Material> material = new ArrayList<>();

    @Transient
    @JsonIgnore

    private String  mensagemErro = " ";
    @Transient
    @JsonIgnore
    private boolean isValid  = true;


    public boolean validarCategoria() {

        return isValid;


    }
}

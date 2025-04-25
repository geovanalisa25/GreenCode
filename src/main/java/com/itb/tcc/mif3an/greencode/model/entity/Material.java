package com.itb.tcc.mif3an.greencode.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Material")
@Data


public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String nome;
    @Column(nullable = false,length = 30)
    private String tipoMaterial;
    @Column(nullable = true,columnDefinition = "VARCHAR(MAX)")
    private String descricao;
    @Column(nullable = false)
    private int quantidade;
    @Column(nullable = false)
    private LocalDate dataCadastro;
    @Column(nullable = false)
    private LocalDate dataDisponibilidade;
    private boolean codStatus;

@OneToMany (mappedBy = "material", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JsonIgnore
private List<AgendamentoMaterial> agendamentoMaterial = new ArrayList<>();



    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "categoria_id", referencedColumnName = "id", nullable = false)
    private Categoria categoria;


    @Transient
    @JsonIgnore

    private String  mensagemErro = " ";
    @Transient
    @JsonIgnore
    private boolean isValid  = true;


    public boolean validarMaterial() {

        return isValid;


    }

}

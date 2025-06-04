package com.itb.tcc.mif3an.greencode.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name =  "Agendamento_Material")
@Data
@NoArgsConstructor
public class AgendamentoMaterial {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int quantidade;
    @Column(nullable = false,columnDefinition = "")
    private String descricao;
    @Column(nullable = false, length = 5)
    private String unidade;

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "agendamento_id",  referencedColumnName = "id", nullable = false)
    private Agendamento agendamento;


    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "material_id",  referencedColumnName = "id", nullable = false)
    private Material material;


}

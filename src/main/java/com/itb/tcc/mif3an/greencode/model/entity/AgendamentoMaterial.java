package com.itb.tcc.mif3an.greencode.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name =  "Agendamento_Material")
@Data
public class AgendamentoMaterial {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "agendamento_id",  referencedColumnName = "id", nullable = false)
    private Agendamento agendamento;


    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "material_id",  referencedColumnName = "id", nullable = false)
    private Material material;


}

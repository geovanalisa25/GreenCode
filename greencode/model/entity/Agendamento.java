package com.itb.tcc.mif3an.greencode.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Agendamento")
@Data
@NoArgsConstructor

public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate dataDoacao;
    @Column(nullable = false, length = 35)
    private String status;
    @Column(nullable = true)
    private LocalDate dataColeta;
    private boolean codStatus;

     @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     @JoinColumn (name = "usuario_id", referencedColumnName = "id", nullable = false)
     private Doador doador;

    @OneToMany (mappedBy = "agendamento", cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
   private List<AgendamentoMaterial> agendamentoMaterial = new ArrayList<>();


    @Transient
    @JsonIgnore
    private String  mensagemErro = " ";

    @Transient
    @JsonIgnore
    private boolean isValid  = true;


    public boolean validarAgendamento() {

        return isValid;


    }
}

package com.itb.tcc.mif3an.greencode.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Endereco")
@Data
@NoArgsConstructor


public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String rua;
    @Column(nullable = false,length = 10)
    private String numero;
    @Column(nullable = false,length = 100)
    private String cidade;
    @Column(nullable = false,length = 2)
    private String uf;
    @Column(nullable = false,length = 10)
    private String bairro;
    private String cep;
    private boolean codStatus;


    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @Transient
    @JsonIgnore

    private String  mensagemErro = " ";
    @Transient
    @JsonIgnore
    private boolean isValid  = true;


    public boolean validarEndereco() {

        return isValid;


    }


}

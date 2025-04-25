package com.itb.tcc.mif3an.greencode.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Usuario")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name = "role", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include =  JsonTypeInfo.As.PROPERTY, property = "role")
@JsonSubTypes( {
       @JsonSubTypes.Type(value = Coletor.class, name = "COLETOR"),
        @JsonSubTypes.Type(value = Doador.class, name = "DOADOR"),
        @JsonSubTypes.Type(value = Admin.class, name = "ADMIN")
}
)

@EnableJpaAuditing
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String nome;
    @Column(nullable = false,length = 100 )
    private String email;
    @Column(nullable = false,length = 255)
    private String password;
    @Column(nullable = false,length = 20)
    private String telefone;
    private boolean codStatus;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Endereco> enderecos = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Role role;

    @Transient
    @JsonIgnore

    private String  mensagemErro = " ";
    @Transient
    @JsonIgnore
    private boolean isValid  = true;


    public boolean validarUsuario() {

        return isValid;


    }



}

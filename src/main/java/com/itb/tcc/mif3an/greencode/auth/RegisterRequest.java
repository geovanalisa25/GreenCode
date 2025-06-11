package com.itb.tcc.mif3an.greencode.auth;

import com.itb.tcc.mif3an.greencode.model.entity.Role;
import lombok.Data;

@Data
public class RegisterRequest {

    private String nome;
    private String email;
    private String password;
    private String cpf;
    private Role role;

    public RegisterRequest() {


    }

    public RegisterRequest(Role role, String password, String email, String nome, String cpf) {
        this.role = role;
        this.password = password;
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
    }
}



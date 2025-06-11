package com.itb.tcc.mif3an.greencode.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value = "DOADOR")
public class Doador extends Usuario {

@OneToMany(mappedBy = "doador", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
@JsonIgnore
private List<Agendamento> agendamentos = new ArrayList<>();


}

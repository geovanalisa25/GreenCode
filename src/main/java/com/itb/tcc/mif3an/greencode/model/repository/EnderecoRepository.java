package com.itb.tcc.mif3an.greencode.model.repository;


import com.itb.tcc.mif3an.greencode.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}

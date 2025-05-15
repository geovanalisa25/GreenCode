package com.itb.tcc.mif3an.greencode.model.repository;

import com.itb.tcc.mif3an.greencode.model.entity.Coletor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColetorRepository extends JpaRepository<Coletor, Long> {
}

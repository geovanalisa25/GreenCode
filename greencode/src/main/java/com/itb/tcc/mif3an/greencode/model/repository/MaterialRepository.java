package com.itb.tcc.mif3an.greencode.model.repository;


import com.itb.tcc.mif3an.greencode.model.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
}

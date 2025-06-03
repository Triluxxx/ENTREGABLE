package com.project.lab_clinico.repository;

import com.project.lab_clinico.entity.OrdenParametroEntity;
import com.project.lab_clinico.entity.OrdenesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenParametroRepository extends JpaRepository<OrdenParametroEntity, Long> {
    List<OrdenParametroEntity> findByOrden(OrdenesEntity orden);
}

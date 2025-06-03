package com.project.lab_clinico.repository;

import com.project.lab_clinico.entity.UnidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadRepository extends JpaRepository<UnidadEntity, Integer> {
}

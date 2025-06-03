package com.project.lab_clinico.repository;

import com.project.lab_clinico.entity.ValorParametroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValorParametroRepository extends JpaRepository<ValorParametroEntity, Long> {
}

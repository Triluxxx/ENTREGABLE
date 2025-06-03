package com.project.lab_clinico.repository;

import com.project.lab_clinico.entity.LaboratoristaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LaboratoristaRepository extends JpaRepository<LaboratoristaEntity, Long> {
    Optional<LaboratoristaEntity> findByCorreo(String correo);
}

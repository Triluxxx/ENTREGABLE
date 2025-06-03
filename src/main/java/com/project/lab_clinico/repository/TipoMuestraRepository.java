package com.project.lab_clinico.repository;

import com.project.lab_clinico.entity.TipoMuestraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TipoMuestraRepository extends JpaRepository<TipoMuestraEntity, Long> {
    Optional<TipoMuestraEntity> findByNombre(String nombre);
}

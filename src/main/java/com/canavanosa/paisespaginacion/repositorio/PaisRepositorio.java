package com.canavanosa.paisespaginacion.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canavanosa.paisespaginacion.entidad.Pais;

@Repository
public interface PaisRepositorio extends JpaRepository<Pais, Long> {

}

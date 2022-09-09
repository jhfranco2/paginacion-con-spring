package com.canavanosa.paisespaginacion.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canavanosa.paisespaginacion.entidad.Pais;
import com.canavanosa.paisespaginacion.repositorio.PaisRepositorio;

@Service
@Transactional
public class PaisServicio {

	@Autowired
	PaisRepositorio paisRepositorio;
	
	public Page<Pais> paginas(Pageable pageable){
		return paisRepositorio.findAll(pageable);
	}
	
}

package com.canavanosa.paisespaginacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.canavanosa.paisespaginacion.entidad.Pais;
import com.canavanosa.paisespaginacion.servicio.PaisServicio;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class PaisControlador {

	@Autowired
	PaisServicio  paisServicio;
	@GetMapping("/paises")
	public ResponseEntity<Page<Pais>> paginas(
			
			@RequestParam(defaultValue = "0")int page,
			@RequestParam(defaultValue = "10")int size,
			@RequestParam(defaultValue = "nombre")String order,
			@RequestParam(defaultValue = "true") boolean asc
			){
		Page<Pais> paises = paisServicio.paginas(
				PageRequest.of(page, size,Sort.by(order)));
		if(!asc)
			     paises = paisServicio.paginas(
					PageRequest.of(page, size,Sort.by(order).descending()));
		return new ResponseEntity<Page<Pais>>(paises,HttpStatus.OK);
				
	}
		


}

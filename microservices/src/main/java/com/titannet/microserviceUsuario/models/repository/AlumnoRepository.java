package com.titannet.microserviceUsuario.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.titannet.microservivios.commons.alumnos.entity.Alumno;





public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Long> {

	@Query ("select a from Alumno a where upper(a.nombre) like upper(concat('%',?1, '%')) or upper(a.apellido) like upper(concat('%',?1,'%'))")
	public List<Alumno> findByNombreOrApellido (String term);		
		
}

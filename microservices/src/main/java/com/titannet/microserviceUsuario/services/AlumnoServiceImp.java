package com.titannet.microserviceUsuario.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titannet.microserviceUsuario.clients.CursoFeignClient;
import com.titannet.microserviceUsuario.models.repository.AlumnoRepository;
import com.titannet.microservivios.commons.alumnos.entity.Alumno;
import com.titannet.microservivios.commons.services.CommonServiceImp;

@Service
public class AlumnoServiceImp extends CommonServiceImp<Alumno, AlumnoRepository> implements AlumnoService {

	@Autowired
	private CursoFeignClient clientCurso;
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Alumno> findByNombreOrApellido(String term) {		
		return repository.findByNombreOrApellido(term);
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<Alumno> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public void eliminarCursoAlumnoPorId(Long id) {
		clientCurso.eliminarCursoAlumnoPorId(id);
		
	}

	@Override
	@Transactional
	public void deleteById(Long id) {		
		super.deleteById(id);
		this.eliminarCursoAlumnoPorId(id);
	}
	

}

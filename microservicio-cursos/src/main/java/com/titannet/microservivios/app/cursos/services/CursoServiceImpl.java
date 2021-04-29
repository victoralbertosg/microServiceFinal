package com.titannet.microservivios.app.cursos.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.titannet.microservivios.app.cursos.clients.AlumnoFeignClient;
import com.titannet.microservivios.app.cursos.clients.RespuestaFeingClient;
import com.titannet.microservivios.app.cursos.models.entity.Curso;
import com.titannet.microservivios.app.cursos.models.repository.CursoRepository;
import com.titannet.microservivios.commons.alumnos.entity.Alumno;
import com.titannet.microservivios.commons.services.CommonServiceImp;


@Service
public class CursoServiceImpl extends CommonServiceImp<Curso, CursoRepository> implements CursoService {

	@Autowired
	public RespuestaFeingClient client;
	
	@Autowired
	public AlumnoFeignClient clientAlumno;
	
	@Override
	@Transactional(readOnly=true)
	public Curso findCursoByAlumno(Long id) {
		// TODO Auto-generated method stub
		return repository.findCursoByAlumno(id);
	}

	@Override
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId) {		
		return client.obtenerExamenesIdsConRespuestasAlumno(alumnoId);
	}

	@Override
	public Iterable<Alumno> obtenerAlumnosPorCurso(Iterable<Long> ids) {		
		return clientAlumno.obtenerAlumnosPorCurso(ids);
	}

}

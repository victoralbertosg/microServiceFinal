package com.titannet.microservivios.app.cursos.services;



import org.springframework.web.bind.annotation.RequestParam;

import com.titannet.microservivios.app.cursos.models.entity.Curso;
import com.titannet.microservivios.commons.alumnos.entity.Alumno;
import com.titannet.microservivios.commons.services.CommonService;

public interface CursoService extends CommonService<Curso> {
	public Curso findCursoByAlumno(Long id);
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId );
	public Iterable<Alumno> obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids);
	public void eliminarCursoAlumnoPorId (Long id);
	
}

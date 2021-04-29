package com.titannet.microservivios.app.cursos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.titannet.microservivios.commons.alumnos.entity.Alumno;

@FeignClient(name="microservicio-usuarios")
public interface AlumnoFeignClient {
@GetMapping("/alumnos-por-curso")
public Iterable<Alumno> obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids);
}

package com.titannet.microservicios.app.respuestas.services;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titannet.microservicios.app.respuestas.clients.ExamenFeignClient;
import com.titannet.microservicios.app.respuestas.model.repository.RespuestaRepository;
import com.titannet.microservicios.app.respuestas.models.entity.Respuesta;
import com.titannet.microservivios.commons.examenes.entity.Examen;
import com.titannet.microservivios.commons.examenes.entity.Pregunta;

@Service
public class RespuestaServiceImp implements RespuestaService {

	
	@Autowired
	private RespuestaRepository repository;
	
	@Autowired
	private ExamenFeignClient examenClient;
	
	@Override
	@Transactional
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {		
		return repository.saveAll(respuestas);
	}

	@Override
	//@Transactional(readOnly=true)
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId) {
		Examen examen=examenClient.obtenerExamenPorId(examenId);
		List<Pregunta> preguntas=examen.getPreguntas();
		List<Long> preguntaIds=preguntas.stream().map(p->p.getId()).collect(Collectors.toList());
		List<Respuesta> respuestas=(List<Respuesta>) repository.findRespuestaByAlumnoByPreguntasIds(alumnoId, preguntaIds);
		respuestas=respuestas.stream().map(r->{
			preguntas.forEach(p->{
				if (p.getId()==r.getPreguntaId()) {
					r.setPregunta(p);
				}
			});
			return r;
		}).collect(Collectors.toList());
		//return repository.findRespuestaByAlumnoByExamen(alumnoId, examenId);
		return respuestas;
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId) {
		
		//return repository.findExamenesIdsConRespuestasByAlumno(alumnoId);
		return null;
	}
	
		
		
	

}

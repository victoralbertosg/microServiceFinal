package com.titannet.microservivios.commons.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//E generico de entidad
public interface CommonService<E> {
	
	public Page<E> findAll(Pageable pageable);

	public Iterable<E> findAll();
	public Optional<E>findById(Long id);
	public E save(E entity);
	public void deleteById(Long id);
}

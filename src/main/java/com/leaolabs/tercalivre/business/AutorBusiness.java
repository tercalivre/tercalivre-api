package com.leaolabs.tercalivre.business;

import java.util.List;
import java.util.Optional;

import com.leaolabs.tercalivre.model.Autor;

public interface AutorBusiness {
	
	List<Autor> findAll();
	
	Optional<Autor> create(Autor autor);
	
	Optional<Autor> findById(Long id);

}

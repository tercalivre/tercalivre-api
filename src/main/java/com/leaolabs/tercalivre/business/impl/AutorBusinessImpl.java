package com.leaolabs.tercalivre.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leaolabs.tercalivre.business.AutorBusiness;
import com.leaolabs.tercalivre.commons.exception.EntityNotFoundException;
import com.leaolabs.tercalivre.model.Autor;
import com.leaolabs.tercalivre.repository.AutorRepository;

@Service
public class AutorBusinessImpl implements AutorBusiness {

	private AutorRepository autorRepository;

	@Autowired
	public AutorBusinessImpl(final AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@Override
	public Optional<Autor> create(final Autor autor) {
		return Optional.of(this.autorRepository.save(autor));
	}

	@Override
	public List<Autor> findAll() {
		List<Autor> autores = this.autorRepository.findAll();
		if (autores.isEmpty()) {
			throw new EntityNotFoundException("Autores");
		}
		return this.autorRepository.findAll();
	}

	@Override
	public Optional<Autor> findById(final Long id) {
		return this.autorRepository.findById(id);
	}
}

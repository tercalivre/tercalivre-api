package com.leaolabs.tercalivre.v1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leaolabs.tercalivre.business.AutorBusiness;
import com.leaolabs.tercalivre.commons.controller.BaseController;
import com.leaolabs.tercalivre.commons.controller.ResponseMeta;
import com.leaolabs.tercalivre.commons.exception.EntityNotFoundException;
import com.leaolabs.tercalivre.model.Autor;
import com.leaolabs.tercalivre.v1.dtos.AutorDto;
import com.leaolabs.tercalivre.v1.mapper.AutorMapper;

@RestController
@RequestMapping("/v1/tercalivre/autores")
public class AutorController extends BaseController {

	private final AutorBusiness autorBusiness;
	private final AutorMapper autorMapper;

	@Autowired
	public AutorController(final AutorBusiness autorBusiness, final AutorMapper autorMapper) {
		super(Autor.class);
		this.autorBusiness = autorBusiness;
		this.autorMapper = autorMapper;
	}

	@GetMapping(value = "")
	@ResponseBody
	public ResponseEntity<ResponseMeta> getAll() {
		List<Autor> autores = this.autorBusiness.findAll();
		return super.buildResponse(HttpStatus.OK, Optional.of(this.autorMapper.serialize(autores)));
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<ResponseMeta> getById(@PathVariable final Long id) {
		final Optional<Autor> autor = this.autorBusiness.findById(id);

		return super.buildResponse(HttpStatus.OK,
				Optional.of(this.autorMapper.serialize(autor.orElseThrow(() -> new EntityNotFoundException("Autor")))));
	}

	@ResponseBody
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseMeta> post(@RequestBody final AutorDto autorDto) {
		Optional<Autor> optionalAutor = this.autorBusiness.create(this.autorMapper.deserialize(autorDto));

		return super.buildResponse(HttpStatus.CREATED, Optional
				.of(this.autorMapper.serialize(optionalAutor.orElseThrow(() -> new EntityNotFoundException("Autor")))));
	}
}
package com.leaolabs.tercalivre.v1.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.leaolabs.tercalivre.model.Autor;
import com.leaolabs.tercalivre.v1.dtos.AutorDto;

@Component
public class AutorMapper {

	public AutorDto serialize(final Autor autor) {
		if (Optional.ofNullable(autor).isEmpty()) {
			return new AutorDto();
		}

		return AutorDto.builder()
				.id(autor.getId())
				.biografia(autor.getBiografia())
				.nome(autor.getNome())
				.dataCriacao(autor.getDataCriacao())
				.dataAtualizacao(autor.getDataAtualizacao()).build();
	}

	public List<AutorDto> serialize(final List<Autor> autores) {
		return Optional.ofNullable(autores)
				.map(atuoresList -> autores.stream().map(this::serialize).collect(Collectors.toList())).orElse(null);
	}

	public Autor deserialize(final AutorDto autorDto) {
		if (Optional.ofNullable(autorDto).isEmpty()) {
			return new Autor();
		}

		return Autor.builder()
				.id(autorDto.getId())
				.biografia(autorDto.getBiografia())
				.nome(autorDto.getNome())
				.dataCriacao(autorDto.getDataCriacao())
				.dataAtualizacao(autorDto.getDataAtualizacao()).build();
	}

	public List<Autor> deserialize(final List<AutorDto> autoresDto) {
		return Optional.ofNullable(autoresDto)
				.map(autor -> autor.stream().map(this::deserialize).collect(Collectors.toList())).orElse(null);
	}

}
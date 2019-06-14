package com.leaolabs.tercalivre.v1.dtos;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class AutorDto implements Serializable {

	private static final long serialVersionUID = -47412198001912923L;

	@NotBlank
	private Long id;

	@NotBlank
	private String nome;

	private Date dataNascimento;

	private String biografia;

	@NotBlank
	private ZonedDateTime dataCriacao;

	@NotBlank
	private ZonedDateTime dataAtualizacao;
}
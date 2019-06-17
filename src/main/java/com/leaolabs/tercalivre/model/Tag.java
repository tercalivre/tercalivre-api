package com.leaolabs.tercalivre.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tags")
public class Tag implements Serializable {
    private static final long serialVersionUID = -2359349200482694766L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Column(name = "data_criacao")
    private ZonedDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private ZonedDateTime dataAtualizacao;

    @PrePersist
    protected void prePersist() {
        dataCriacao = dataAtualizacao = ZonedDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        dataAtualizacao = ZonedDateTime.now();
    }
}
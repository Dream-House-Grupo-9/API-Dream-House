package com.sptech.dreamhouse.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ImagensComplementares {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @Column(length = 50 * 1024 * 1024) // 50 Mb
    private byte[] foto;

    @ManyToOne
    private Anuncio anuncio;
}

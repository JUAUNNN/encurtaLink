package com.utilitarios.encurtadorDeLinks.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.Instant;

@Entity
@Table(name = "encurtador")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urlLong;
    private String urlEncurtada;

    @CreationTimestamp
    private Instant urlCriarTempo;

    public Link(){

    }

    public Link(Long id, Instant urlCriarTempo, String urlEncurtada, String urlLong) {
        this.id = id;
        this.urlCriarTempo = urlCriarTempo;
        this.urlEncurtada = urlEncurtada;
        this.urlLong = urlLong;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getUrlCriarTempo() {
        return urlCriarTempo;
    }

    public void setUrlCriarTempo(Instant urlCriarTempo) {
        this.urlCriarTempo = urlCriarTempo;
    }

    public String getUrlEncurtada() {
        return urlEncurtada;
    }

    public void setUrlEncurtada(String urlEncurtada) {
        this.urlEncurtada = urlEncurtada;
    }

    public String getUrlLong() {
        return urlLong;
    }

    public void setUrlLong(String urlLong) {
        this.urlLong = urlLong;
    }
}

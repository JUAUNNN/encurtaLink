package com.utilitarios.encurtadorDeLinks.model;

import java.time.Instant;

public class ResponseLink {

    private Long id;
    private String urlLong;
    private String urlEncurtada;
    private Instant urlCriarTempo;

    public ResponseLink(Long id, String urlLong, String urlEncurtada, Instant urlCriarTempo) {
        this.id = id;
        this.urlLong = urlLong;
        this.urlEncurtada = urlEncurtada;
        this.urlCriarTempo = urlCriarTempo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlLong() {
        return urlLong;
    }

    public void setUrlLong(String urlLong) {
        this.urlLong = urlLong;
    }

    public String getUrlEncurtada() {
        return urlEncurtada;
    }

    public void setUrlEncurtada(String urlEncurtada) {
        this.urlEncurtada = urlEncurtada;
    }

    public Instant getUrlCriarTempo() {
        return urlCriarTempo;
    }

    public void setUrlCriarTempo(Instant urlCriarTempo) {
        this.urlCriarTempo = urlCriarTempo;
    }
}

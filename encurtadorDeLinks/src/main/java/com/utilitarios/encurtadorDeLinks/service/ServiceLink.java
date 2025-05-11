package com.utilitarios.encurtadorDeLinks.service;


import com.utilitarios.encurtadorDeLinks.model.Link;
import com.utilitarios.encurtadorDeLinks.repository.RepositoryLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class ServiceLink {

    @Autowired
    private RepositoryLink repositoryLink;

    public String criarUrlAleatoria() {
        return UUID.randomUUID().toString().substring(5, 10);
    }

    public Link encurtarUrl(String urlOriginal) {
        Link link = new Link();
        link.setUrlLong(urlOriginal);
        link.setUrlEncurtada(criarUrlAleatoria());
        link.setUrlCriarTempo(Instant.now());

        return repositoryLink.save(link);
    }

    public Link getUrlOriginal(String urlEncurtada) {
        try{
            return repositoryLink.findByUrlEncurtada(urlEncurtada);
        } catch (Exception e) {
            throw new RuntimeException("Url não existe no banco de dados", e);
        }
    }


}

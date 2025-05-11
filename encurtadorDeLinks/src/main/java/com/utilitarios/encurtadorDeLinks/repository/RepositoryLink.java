package com.utilitarios.encurtadorDeLinks.repository;

import com.utilitarios.encurtadorDeLinks.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryLink extends JpaRepository<Link, Long> {

    Link findByUrlEncurtada(String urlEncurtada);

}

package br.com.acme.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.domain.model.condominio.Condominio;

public interface CondominioRepository extends JpaRepository<Condominio, Long> {

}

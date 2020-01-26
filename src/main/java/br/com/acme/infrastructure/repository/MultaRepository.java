package br.com.acme.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.domain.model.multas.Multa;

public interface MultaRepository extends JpaRepository<Multa, Long> {

}

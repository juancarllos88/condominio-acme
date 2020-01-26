package br.com.acme.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.domain.model.aviso.Aviso;

public interface AvisoRepository extends JpaRepository<Aviso, Long> {

}

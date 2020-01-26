package br.com.acme.infrastructure.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.acme.domain.model.unidade.Unidade;

public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
	
	@Query("SELECT u FROM Unidade u WHERE u.multas IS EMPTY")
	Page<Unidade> findByMultasIsNull(Pageable page);

	@Query("SELECT u FROM Unidade u WHERE u.multas IS NOT EMPTY")
	Page<Unidade> findByMultasIsNotNull(Pageable page);

}

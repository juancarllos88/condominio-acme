package br.com.acme.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.domain.model.unidade.Unidade;
import br.com.acme.infrastructure.repository.CondominioRepository;
import br.com.acme.infrastructure.repository.UnidadeRepository;

@Service
public class UnidadeService {

	@Autowired
	private UnidadeRepository unidadeRepository;

	@Autowired
	private CondominioRepository condominioRepository;

	@Transactional
	public Unidade salvar(Unidade unidade) {
		analisarUnidade(unidade);
		if (unidade.getMultas() != null) {
			unidade.getMultas().forEach(m -> m.setUnidade(unidade));
		}
		return unidadeRepository.save(unidade);
	}

	private void analisarUnidade(Unidade unidade) {
		if (unidade.getCondominio() != null) {
			condominioRepository.findById(unidade.getCondominio().getId())
					.orElseThrow(() -> new RuntimeException("Condominio não encontrado"));
		}
	}
	
	@Transactional(readOnly = true)
	public Page<Unidade> listarTodos(Pageable page) {
		return unidadeRepository.findAll(page);

	}
	
	@Transactional(readOnly = true)
	public Page<Unidade> listarComMultas(Pageable page) {
		return unidadeRepository.findByMultasIsNotNull(page);

	}

	
	@Transactional(readOnly = true)
	public Page<Unidade> listarSemMultas(Pageable page) {
		return unidadeRepository.findByMultasIsNull(page);

	}

}

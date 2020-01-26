package br.com.acme.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.domain.model.multas.Multa;
import br.com.acme.infrastructure.repository.MultaRepository;
import br.com.acme.infrastructure.repository.UnidadeRepository;

@Service
public class MultaService {

	@Autowired
	private MultaRepository multaRepository;

	@Autowired
	private UnidadeRepository unidadeRepository;

	@Transactional
	public Multa salvar(Multa multa) {
		analisarMulta(multa);
		return multaRepository.save(multa);
	}

	private void analisarMulta(Multa multa) {
		if (multa.getUnidade() != null) {
			unidadeRepository.findById(multa.getUnidade().getId())
					.orElseThrow(() -> new RuntimeException("Unidade não encontrada"));
		}
	}

}

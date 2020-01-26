package br.com.acme.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.domain.model.aviso.Aviso;
import br.com.acme.infrastructure.repository.AvisoRepository;
import br.com.acme.infrastructure.repository.UnidadeRepository;

@Service
public class AvisoService {

	@Autowired
	private AvisoRepository avisoRepository;

	@Autowired
	private UnidadeRepository unidadeRepository;

	@Transactional
	public Aviso salvar(Aviso aviso) {
		analisarAviso(aviso);
		return avisoRepository.save(aviso);
	}

	private void analisarAviso(Aviso aviso) {
		if (aviso.getUnidade() != null) {
			unidadeRepository.findById(aviso.getUnidade().getId())
					.orElseThrow(() -> new RuntimeException("Unidade não encontrada"));
		}
	}

}

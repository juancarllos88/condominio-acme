package br.com.acme.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.application.service.UnidadeService;
import br.com.acme.domain.model.unidade.Unidade;
import br.com.acme.infrastructure.service.ConverterServiceImpl;
import br.com.acme.infrastructure.service.ResponseServiceImpl;
import br.com.acme.presentation.dto.ResponseTO;
import br.com.acme.presentation.dto.unidade.UnidadeRequestTO;
import br.com.acme.presentation.dto.unidade.UnidadeResponseTO;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

	@Autowired
	private ResponseServiceImpl responseService;

	@Autowired
	private UnidadeService unidadeService;
	
	@Autowired
	private ConverterServiceImpl converterService;

	@PostMapping
	public ResponseEntity<ResponseTO<UnidadeResponseTO>> salvar(@Valid @RequestBody UnidadeRequestTO unidadeRequestTO) {
		Unidade unidade = converterService.converter(unidadeRequestTO, Unidade.class);
		Unidade unidadeSalva = unidadeService.salvar(unidade);
		UnidadeResponseTO unidadeResponseTO = converterService.converter(unidadeSalva, UnidadeResponseTO.class);
		return responseService.create(unidadeResponseTO);
	}
	
	@GetMapping
	public ResponseEntity<ResponseTO<Page<UnidadeResponseTO>>> buscar(Pageable page) {
		Page<Unidade> unidades = unidadeService.listarTodos(page);
		Page<UnidadeResponseTO> unidadeResponseTO = converterService.converter(unidades, UnidadeResponseTO.class);
		return responseService.create(unidadeResponseTO);
	}
	
	@GetMapping("/com-multas")
	public ResponseEntity<ResponseTO<Page<UnidadeResponseTO>>> buscarComMultas(Pageable page) {
		Page<Unidade> unidades = unidadeService.listarComMultas(page);
		Page<UnidadeResponseTO> unidadeResponseTO = converterService.converter(unidades, UnidadeResponseTO.class);
		return responseService.create(unidadeResponseTO);
	}
	
	@GetMapping("/sem-multas")
	public ResponseEntity<ResponseTO<Page<UnidadeResponseTO>>> buscarSemMultas(Pageable page) {
		Page<Unidade> unidades = unidadeService.listarSemMultas(page);
		Page<UnidadeResponseTO> unidadeResponseTO = converterService.converter(unidades, UnidadeResponseTO.class);
		return responseService.create(unidadeResponseTO);
	}
	

}

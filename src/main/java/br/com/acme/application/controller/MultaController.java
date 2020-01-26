package br.com.acme.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.application.service.MultaService;
import br.com.acme.domain.model.multas.Multa;
import br.com.acme.infrastructure.service.ConverterServiceImpl;
import br.com.acme.infrastructure.service.ResponseServiceImpl;
import br.com.acme.presentation.builder.HateoasBuilder;
import br.com.acme.presentation.dto.ResponseTO;
import br.com.acme.presentation.dto.multa.MultaRequestTO;
import br.com.acme.presentation.dto.multa.MultaResponseTO;

@RestController
@RequestMapping("/multas")
public class MultaController {

	@Autowired
	private ResponseServiceImpl responseService;

	@Autowired
	private MultaService multaService;

	@Autowired
	private ConverterServiceImpl converterService;

	@PostMapping
	public ResponseEntity<ResponseTO<MultaResponseTO>> salvar(@Valid @RequestBody MultaRequestTO multaRequestTO) {
		Multa multa = converterService.converter(multaRequestTO, Multa.class);
		Multa multaSalva = multaService.salvar(multa);
		MultaResponseTO multaResponseTO = converterService.converter(multaSalva, MultaResponseTO.class);
		HateoasBuilder.build(multaResponseTO, MultaController.class);
		return responseService.create(multaResponseTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseTO<MultaResponseTO>> buscar(@PathVariable Long id) {
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseTO<MultaResponseTO>> deletar(@PathVariable Long id) {
		return null;
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseTO<MultaResponseTO>> alterar(@PathVariable Long id) {
		return null;
	}

}

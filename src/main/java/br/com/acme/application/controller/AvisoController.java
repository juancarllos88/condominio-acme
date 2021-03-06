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

import br.com.acme.application.service.AvisoService;
import br.com.acme.domain.model.aviso.Aviso;
import br.com.acme.infrastructure.service.ConverterServiceImpl;
import br.com.acme.infrastructure.service.ResponseServiceImpl;
import br.com.acme.presentation.builder.HateoasBuilder;
import br.com.acme.presentation.dto.ResponseTO;
import br.com.acme.presentation.dto.aviso.AvisoRequestTO;
import br.com.acme.presentation.dto.aviso.AvisoResponseTO;

@RestController
@RequestMapping("/avisos")
public class AvisoController {

	@Autowired
	private ResponseServiceImpl responseService;

	@Autowired
	private AvisoService avisoService;

	@Autowired
	private ConverterServiceImpl converterService;

	@PostMapping
	public ResponseEntity<ResponseTO<AvisoResponseTO>> salvar(@Valid @RequestBody AvisoRequestTO avisoRequestTO) {
		Aviso aviso = converterService.converter(avisoRequestTO, Aviso.class);
		Aviso avisoSalva = avisoService.salvar(aviso);
		AvisoResponseTO avisoResponseTO = converterService.converter(avisoSalva, AvisoResponseTO.class);
		HateoasBuilder.build(avisoResponseTO, AvisoController.class);
		return responseService.create(avisoResponseTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseTO<AvisoResponseTO>> buscar(@PathVariable Long id) {
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseTO<AvisoResponseTO>> deletar(@PathVariable Long id) {
		return null;
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseTO<AvisoResponseTO>> alterar(@PathVariable Long id) {
		return null;
	}

}

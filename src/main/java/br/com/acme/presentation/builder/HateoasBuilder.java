package br.com.acme.presentation.builder;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.acme.application.controller.AvisoController;
import br.com.acme.application.controller.MultaController;
import br.com.acme.presentation.dto.aviso.AvisoResponseTO;
import br.com.acme.presentation.dto.multa.MultaResponseTO;

public class HateoasBuilder {

	private static final String HTTP_GET = "GET";
	private static final String HTTP_PUT = "PUT";
	private static final String HTTP_DELETE = "DELETE";

	public static void build(MultaResponseTO multaResponseTO, Class<MultaController> multaController) {
		multaResponseTO.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(multaController).buscar(multaResponseTO.getId()))
						.withRel("Realiza a pequisa").withType(HTTP_GET));
		multaResponseTO.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(multaController).alterar(multaResponseTO.getId()))
						.withRel("Realiza a alteração").withType(HTTP_PUT));
		multaResponseTO.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(multaController).deletar(multaResponseTO.getId()))
						.withRel("Realiza a deleção").withType(HTTP_DELETE));

	}

	public static void build(AvisoResponseTO avisoResponseTO, Class<AvisoController> avisoController) {
		avisoResponseTO.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(avisoController).buscar(avisoResponseTO.getId()))
						.withRel("Realiza a pequisa").withType(HTTP_GET));
		avisoResponseTO.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(avisoController).alterar(avisoResponseTO.getId()))
						.withRel("Realiza a alteração").withType(HTTP_PUT));
		avisoResponseTO.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(avisoController).deletar(avisoResponseTO.getId()))
						.withRel("Realiza a deleção").withType(HTTP_DELETE));

	}

}

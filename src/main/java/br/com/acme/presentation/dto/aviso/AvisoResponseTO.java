package br.com.acme.presentation.dto.aviso;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvisoResponseTO extends RepresentationModel<AvisoResponseTO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String descricao;
	

}

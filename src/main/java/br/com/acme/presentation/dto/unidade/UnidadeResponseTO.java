package br.com.acme.presentation.dto.unidade;

import java.io.Serializable;
import java.util.List;

import br.com.acme.presentation.dto.multa.MultaResponseTO;
import br.com.acme.presentation.dto.responsavel.ResponsavelResponseTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadeResponseTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String numero;

	private String bloco;

	private List<MultaResponseTO> multas;

	private ResponsavelResponseTO responsavel;

}

package br.com.acme.presentation.dto.unidade;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.acme.presentation.dto.multa.MultaRequestTO;
import br.com.acme.presentation.dto.responsavel.ResponsavelRequestTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadeRequestTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private String numero;
	@NotNull
	private String bloco;

	private List<MultaRequestTO> multas;

	@NotNull
	private ResponsavelRequestTO responsavel;
	@NotNull
	private Long condominioId;
}

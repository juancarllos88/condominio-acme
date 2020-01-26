/**
 * 
 */
package br.com.acme.domain.model.unidade;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.acme.domain.model.aviso.Aviso;
import br.com.acme.domain.model.condominio.Condominio;
import br.com.acme.domain.model.multas.Multa;
import br.com.acme.domain.model.responsavel.Responsavel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author carlosfilho
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_unidade")
public class Unidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String numero;

	private String bloco;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_responsavel")
	private Responsavel responsavel;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "unidade" , fetch = FetchType.LAZY)
	private Set<Multa> multas;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "unidade", fetch = FetchType.LAZY)
	private Set<Aviso> avisos;

	@ManyToOne
	@JoinColumn(name = "id_condominio")
	Condominio condominio;

}

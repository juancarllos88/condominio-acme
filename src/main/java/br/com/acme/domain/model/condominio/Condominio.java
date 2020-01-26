/**
 * 
 */
package br.com.acme.domain.model.condominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.acme.domain.model.unidade.Unidade;
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
@Table(name = "tb_condominio")
public class Condominio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="nome")
	private String nome;
	@Column(name="email")
	private String email;
	@Column(name="telefone")
	private String telefone;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "condominio", fetch = FetchType.LAZY)
	List<Unidade> unidades;
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "condominio")
	private Set<Multa> multas;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "condominio")
	private Set<Aviso> avisos;*/


}

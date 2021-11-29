package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * 
 * @author Eduardo Mateus Da Costa
 * @since 30/10/2021
 * @version 1.3
 * @see lombok.Data
 */

@org.hibernate.annotations.Table(comment = "Tabela de medicos", appliesTo = "medico")
@Entity
@Data
public class Medico implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "VARCHAR(30)")
	private String crmmed;
	
	@OneToOne
	@JoinColumn(columnDefinition = "NUMERIC(11, 0)", nullable = false, unique = true)
	private Usuario cpfusu;
	
}

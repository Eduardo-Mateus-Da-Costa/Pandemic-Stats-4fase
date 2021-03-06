package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

/**
 * 
 * @author Eduardo Mateus Da Costa
 * @since 30/10/2021
 * @version 1.2
 * @see lombok.Data
 */

@SequenceGenerator(name = "seq_paciente_comorbidade", sequenceName = "seq_paciente_comorbidade", allocationSize = 1, initialValue = 1)
@org.hibernate.annotations.Table(comment = "Tabela de vinculação paciente comorbidades", appliesTo = "paciente_comorbidade")
@Entity
@Data
public class PacienteComorbidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente_comorbidade")
	@Column(columnDefinition = "NUMERIC(10, 0)", insertable=false)
	private long codpaccom;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(columnDefinition = "NUMERIC(10, 0)")
	private Paciente codpac;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(10, 0)", nullable = false)
	private Comorbidade codcom;
}

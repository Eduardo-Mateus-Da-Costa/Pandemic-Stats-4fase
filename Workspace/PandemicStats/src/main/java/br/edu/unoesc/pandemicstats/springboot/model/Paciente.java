package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

/**
 * 
 * @author Eduardo Mateus Da Costa
 * @since 30/10/2021
 * @version 1.8
 * @see lombok.Data
 */

@SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente", allocationSize = 1, initialValue = 1)
@org.hibernate.annotations.Table(comment = "Tabela de pacientes", appliesTo = "paciente")
@Entity
@Data
public class Paciente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente")
	@Column(columnDefinition = "NUMERIC(10, 0)", insertable = false)
	private long codpac;
	
	@OneToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(columnDefinition = "NUMERIC(11, 0)", nullable = false, unique = true)
	private Usuario cpfusu;
	
	@Column(columnDefinition = "NUMERIC(5, 2)", nullable = false)
	private double pespac;
	
	@Column(columnDefinition = "CHAR(1) CHECK(GRURISPAC IN ('S', 'N'))", nullable = false)
	private char grurispac;
	
	@Column(columnDefinition = "VARCHAR(20) CHECK(SITPAC IN ('INTERNADO', 'ISOLAMENTO', 'BEM'))", nullable = false)
	private String sitpac;
}

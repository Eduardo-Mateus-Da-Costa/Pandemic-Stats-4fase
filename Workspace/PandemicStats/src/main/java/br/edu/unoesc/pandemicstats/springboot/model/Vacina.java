package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 
 * @author Eduardo Mateus Da Costa
 * @since 30/10/2021
 * @version 1.6
 * @see lombok.Data
 */

@SequenceGenerator(name = "seq_vacina", sequenceName = "seq_vacina", allocationSize = 1, initialValue = 1)
@org.hibernate.annotations.Table(comment = "Tabela de vacinas", appliesTo = "vacina")
@Entity
@Data
public class Vacina implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vacina")
	@Column(columnDefinition = "NUMERIC(10, 0)", insertable=false)
	private long codvac;
	
	@Column(columnDefinition = "DATE", nullable = false)
	@ColumnDefault(value="CURRENT_DATE")
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date datvac;
	
	@Column(columnDefinition = "INT4", nullable = false)
	private int dosvac;
	
	@Column(columnDefinition = "VARCHAR(30)", nullable = true)
	private String fabvac;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(10, 0)")
	private Paciente codpac;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "VARCHAR(30)", nullable = true)
	private Medico crmmed;
}

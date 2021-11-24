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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 
 * @author Eduardo Mateus Da Costa
 * @since 30/10/2021
 * @version 1.4
 * @see lombok.Data
 */

@SequenceGenerator(name = "seq_teste_covid", sequenceName = "seq_teste_covid", allocationSize = 1, initialValue = 1)
@org.hibernate.annotations.Table(comment = "Tabela de testes de covid", appliesTo = "teste_covid")
@Entity
@Data
public class TesteCovid implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_teste_covid")
	@Column(columnDefinition = "NUMERIC(10, 0)", insertable=false)
	private long codtes;
	
	@Column(columnDefinition = "DATE", nullable = false)
	@JsonFormat(pattern="yyyy-mm-dd")
	@ColumnDefault(value="CURRENT_DATE")
	private Date dattes;
	
	@Column(columnDefinition = "CHAR(1) CHECK(COVPACTES IN('P', 'N'))", nullable = false)
	private char covpactes;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(columnDefinition = "NUMERIC(10, 0)")
	private Paciente codpac;
}

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

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@org.hibernate.annotations.Table(comment = "Tabela de testes de covid", appliesTo = "test_covid")
@Entity
@Data
public class Test_covid implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(10, 0)")
	private int codtes;
	
	@Column(columnDefinition = "DATE", nullable = false)
	@JsonFormat(pattern="yyyy-mm-dd")
	@ColumnDefault(value="CURRENT_TIMESTAMP")
	private Date dattes;
	
	@Column(columnDefinition = "CHAR(1) CHECK(COVPACTES IN('P', 'N'))", nullable = false)
	private char covpactes;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(10, 0)")
	private Paciente codpac;
}

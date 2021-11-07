package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

import lombok.Data;

@org.hibernate.annotations.Table(comment = "Tabela de solicitações", appliesTo = "solicitacao")
@Entity
@Data
public class Solicitacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "NUMERIC(10, 0)")
	private int codsol;
	
	@Column(columnDefinition = "VARCHAR(300)", nullable = false)
	private String dessol;
	
	@Column(nullable = false)
	@ColumnDefault(value="FALSE")
	private boolean anasol;
	
	@Column(columnDefinition = "DATE", nullable = false)
	@ColumnDefault(value="CURRENT_TIMESTAMP")
	private Date datsol;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(11, 0)", nullable = false)
	private Usuario cpfusu;

}

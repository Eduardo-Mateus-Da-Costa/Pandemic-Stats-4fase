package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@org.hibernate.annotations.Table(comment = "Tabela de empresas", appliesTo = "empresa")
@Entity
@Data
public class Empresa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "NUMERIC(14, 0)")
	private int cnpjemp;
	
	@Column(columnDefinition = "VARCHAR(100)", nullable = false)
	private String nomemp;
	
	@Column(columnDefinition = "VARCHAR(100)", nullable = true)
	private String nomfanemp;
	
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String telemp1;
	
	@Column(columnDefinition = "VARCHAR(20)", nullable = true)
	private String telemp2;
	
	@Column(columnDefinition = "VARCHAR(30)", nullable = false, unique = true)
	private String emaemp;
	
	@Column(columnDefinition = "VARCHAR(60)", nullable = false)
	private String ramemp;
	
	@Column(columnDefinition = "DATE", nullable = false)
	@JsonFormat(pattern="yyyy-mm-dd")
	@ColumnDefault(value="CURRENT_TIMESTAMP")
	private Date valemp;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(11, 0)", nullable = false)
	private Usuario cpfusu;
}

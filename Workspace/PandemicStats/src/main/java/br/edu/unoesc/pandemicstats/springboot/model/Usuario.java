package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @author Eduardo Mateus Da Costa
 * @since 30/10/2021
 * @version 2.5
 * 
 */

@org.hibernate.annotations.Table(comment = "Tabela de usuarios", appliesTo = "usuario")
@Entity
@Data
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "NUMERIC(11, 0)")
	private long cpfusu;
	
	@Column(columnDefinition = "VARCHAR(100)", nullable = false)
	private String nomusu;
	
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String senusu;
	
	@Column(columnDefinition = "DATE", nullable = false)
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date datnasusu;	
	
	@Column(columnDefinition = "CHAR(1) CHECK( SEXUSU IN('M','F'))", nullable = false)
	private char sexusu;
	
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String telusu;
	
	@Column(columnDefinition = "VARCHAR(30)", nullable = false, unique = true)
	private String emausu;
	
	@Column(columnDefinition = "NUMERIC(8,0)", nullable=false)
	private long cep;
	
	@Column(columnDefinition = "VARCHAR(60)", nullable=false)
	private String rua;
	
	@Column(columnDefinition = "VARCHAR(10)", nullable=false)
	private String num;
	
	@Column(columnDefinition = "DATE", insertable=false, nullable=false)
	@ColumnDefault(value="CURRENT_DATE")
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date valusu;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(14, 0)", nullable = true)
	private Empresa cnpjemp;
	
	@OneToOne
	@JoinColumn(columnDefinition = "NUMERIC(10,0", nullable=false)
	private Cidade codcid;
}

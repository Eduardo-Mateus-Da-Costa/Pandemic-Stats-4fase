package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@org.hibernate.annotations.Table(comment = "Tabela de Endereços", appliesTo = "endereco")
@Entity
@Data
public class Endereco implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(10, 0)", insertable = false)
	private long codend;
	
	@Column(columnDefinition = "NUMERIC(8, 0)", nullable = false)
	private long cep;
	
	@Column(columnDefinition = "VARCHAR(60)", nullable = false)
	private String rua;
	
	@Column(columnDefinition = "VARCHAR(10)", nullable = false)
	private String num;
	
	@OneToOne
	@JoinColumn(columnDefinition = "NUMERIC(11, 0)", nullable = true)
	private Usuario cpfusu;
	
	@OneToOne
	@JoinColumn(columnDefinition = "NUMERIC(14, 0)", nullable = true)
	private Empresa cnpjemp;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(6, 0)")
	private Cidade codcid;
}

package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;

@Entity
@Data
public class Estado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(2, 0)")
	private int codest;
	
	@Column(columnDefinition = "VARCHAR(60)", nullable = false)
	private String nomest;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(2, 0)")
	private Pais codpai;
}

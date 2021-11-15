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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@org.hibernate.annotations.Table(comment = "Tabela de vinculação monitoramento pacientes", appliesTo = "monitoramento_paciente")
@Entity
@Data
public class MonitoramentoPaciente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(10, 0)", insertable = false)
	private long codmon;
	
	@Column(columnDefinition = "DATE", nullable = false)
	@ColumnDefault(value="CURRENT_DATE")
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date datmon;
	
	@Column(columnDefinition = "CHAR(1) CHECK(INTSIN IN('P', 'M', 'C', 'S'))", nullable = false)
	private char intsin;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(columnDefinition = "NUMERIC(10, 0)")
	private Paciente codpac;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(10, 0)")
	private Sintoma codsin;
}
